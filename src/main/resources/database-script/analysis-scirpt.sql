DROP PROCEDURE IF EXISTS create_pivoted_inspection_view;
DELIMITER //

CREATE PROCEDURE create_pivoted_inspection_view()
BEGIN
  DECLARE tire_positions VARCHAR(4000);
  DECLARE pivot_query VARCHAR(8000);
  -- Get distinct tire positions
  SET @tire_positions = (
    SELECT GROUP_CONCAT(DISTINCT CONCAT('MAX(CASE WHEN tire_position = ''', tire_position, ''' THEN tire_position END) AS tire_position_', REPLACE(tire_position, ' ', '_')))
    FROM vehicle_inspection_details
  );
  -- Construct dynamic pivot query
  SET @pivot_query = CONCAT('CREATE OR REPLACE VIEW pivoted_inspection_data AS
    SELECT inspection_id, ', @tire_positions, ',
    MAX(tire_type) AS tire_type, MAX(tire_type_label) AS tire_type_label, MAX(tire_make) AS tire_make, MAX(tire_make_label) AS tire_make_label,
    MAX(tire_original_fitment_date) AS tire_original_fitment_date, MAX(tire_serial_no) AS tire_serial_no, MAX(otd_projected_mileage) AS otd_projected_mileage,
    MAX(least_tire_thickness_allowed) AS least_tire_thickness_allowed, MAX(odometer_reading_when_fitted) AS odometer_reading_when_fitted,
    MAX(tire_pattern) AS tire_pattern, MAX(tire_removal_date) AS tire_removal_date, MAX(odometer_reading_when_removed) AS odometer_reading_when_removed,
    MAX(reco_pressure) AS reco_pressure, MAX(obs_pressure) AS obs_pressure, MAX(otd_mm) AS otd_mm, MAX(lst_mm) AS lst_mm, MAX(ct_mm) AS ct_mm, MAX(rst_mm) AS rst_mm,
    MAX(observation_category) AS observation_category, MAX(observation_category_label) AS observation_category_label, MAX(observation) AS observation,
    MAX(observation_label) AS observation_label, MAX(recommendation) AS recommendation, MAX(recommendation_label) AS recommendation_label,
    MAX(tire_image_url) AS tire_image_url, MAX(created_date) AS created_date, MAX(modified_date) AS modified_date, 
	MAX(pressure_analysis) AS pressure_analysis, MAX(least_tire_thickness_allowed_analysis) AS least_tire_thickness_allowed_analysis , MAX(wear_analysis) AS wear_analysis
    FROM vehicle_inspection_details GROUP BY inspection_id');
  -- Execute the pivot query
  PREPARE stmt FROM @pivot_query;
  EXECUTE stmt;
  DEALLOCATE PREPARE stmt;
END //

ALTER TABLE vehicle_inspection_details ADD COLUMN tire_image_url VARCHAR(250) NULL AFTER recommendation_label;

ALTER TABLE vehicle_inspection_details
ADD pressure_analysis ENUM('PRESSURE OK', 'UNDER INFLATION', 'EXTREME UNDERINFLATION', 'OVER INFLATION', 'EXTREME OVERINFLATION')
GENERATED ALWAYS AS (
    CASE
        WHEN (tire_type_label IS NOT NULL) AND ((((obs_pressure/reco_pressure)*100) > 95) AND (((obs_pressure/reco_pressure)*100) < 105)) THEN 'PRESSURE OK'
        WHEN (tire_type_label IS NOT NULL) AND ((((obs_pressure/reco_pressure)*100) > 90) AND (((obs_pressure/reco_pressure)*100) < 95)) THEN 'UNDER INFLATION'
        WHEN (tire_type_label IS NOT NULL) AND ((((obs_pressure/reco_pressure)*100) < 90)) THEN 'EXTREME UNDERINFLATION'
        WHEN (tire_type_label IS NOT NULL) AND ((((obs_pressure/reco_pressure)*100) > 105) AND (((obs_pressure/reco_pressure)*100) < 110)) THEN 'OVER INFLATION'
        WHEN (tire_type_label IS NOT NULL) AND ((((obs_pressure/reco_pressure)*100) > 110)) THEN 'EXTREME OVERINFLATION'
    END
) VIRTUAL;


ALTER TABLE vehicle_inspection_details
ADD least_tire_thickness_allowed_analysis ENUM('RED', 'YELLOW', 'GREEN')
GENERATED ALWAYS AS (
    CASE
        WHEN rst_mm < (least_tire_thickness_allowed * 1.25) THEN 'RED'
        WHEN rst_mm < (least_tire_thickness_allowed * 1.5) THEN 'YELLOW'
        WHEN rst_mm > (least_tire_thickness_allowed * 1.5) THEN 'GREEN'
    END
) VIRTUAL;

ALTER TABLE vehicle_inspection_details
ADD wear_analysis ENUM('LEFT SLIDE SLOPE', 'RIGHT SLIDE SLOPE', 'CENTER WEAR')
GENERATED ALWAYS AS (
    CASE
        WHEN (observation_category_label!='Normal') AND (lst_mm < ct_mm) AND (ct_mm < rst_mm) THEN 'LEFT SLIDE SLOPE'
        WHEN (observation_category_label!='Normal') AND (lst_mm > ct_mm) AND (ct_mm > rst_mm) THEN 'RIGHT SLIDE SLOPE'
        WHEN (observation_category_label!='Normal') AND (lst_mm > ct_mm) AND (ct_mm < rst_mm) THEN 'CENTER WEAR'
    END
) VIRTUAL;