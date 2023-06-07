create table vehicle_inspection
(
inspection_id VARCHAR(10) NOT NULL PRIMARY KEY,
client_id BIGINT NOT NULL,
inspection_date DATETIME NOT NULL,
vehicle_reg_number VARCHAR(30) NOT NULL,
vehicle_odometer_reading BIGINT NOT NULL
);
alter table vehicle_inspection ADD COLUMN inspection_status INT NOT NULL default 1;
alter table vehicle_inspection ADD COLUMN vehicle_id BIGINT NOT NULL;
alter table vehicle_inspection ADD COLUMN configured_vehicle VARCHAR(255) NOT NULL;
alter table vehicle_inspection ADD COLUMN client_information VARCHAR(500) NOT NULL after client_id;
alter table vehicle_inspection RENAME COLUMN inspection_date to inspection_date_time;
alter table vehicle_inspection ADD COLUMN no_of_tires INT NOT NULL after configured_vehicle;
alter table vehicle_inspection ADD COLUMN no_of_stepneys INT NOT NULL after no_of_tires;
alter table vehicle_inspection DROP COLUMN IF EXISTS created_date;
alter table vehicle_inspection DROP COLUMN IF EXISTS modified_date;
alter table vehicle_inspection ADD COLUMN created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;
alter table vehicle_inspection ADD COLUMN modified_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

create table vehicle_inspection_details
(
row_id BIGINT NOT NULL auto_increment primary key,
inspection_id VARCHAR(20) NOT NULL,
tire_position VARCHAR(10) NOT NULL,
tire_type BIGINT NOT NULL,
tire_type_label VARCHAR(50) NOT NULL,
tire_make BIGINT NOT NULL,
tire_make_label  VARCHAR(50) NOT NULL,
tire_original_fitment_date DATE NOT NULL,
tire_serial_no VARCHAR(100) NOT NULL,
otd_projected_mileage decimal(8,2) NOT NULL,
least_tire_thickness_allowed int(5) NOT NULL,
odometer_reading_when_fitted BIGINT NOT NULL,
tire_pattern VARCHAR(10) NOT NULL,
tire_removal_date DATE NOT NULL,
odometer_reading_when_removed BIGINT NOT NULL,
reco_pressure INT NOT NULL,
obs_pressure INT NOT NULL,
otd_mm INT NOT NULL,
lst_mm INT NOT NULL,
ct_mm INT NOT NULL,
rst_mm INT NOT NULL,
observation_category BIGINT NOT NULL,
observation_category_label VARCHAR(50) NOT NULL,
observation BIGINT NOT NULL,
observation_label VARCHAR(50) NOT NULL,
recommendation BIGINT NOT NULL,
recommendation_label VARCHAR(50) NOT NULL,
created_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
modified_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

alter table vehicle_configuration_master DROP COLUMN IF EXISTS configured_vehicle;
ALTER TABLE vehicle_configuration_master
ADD configured_vehicle VARCHAR(255) GENERATED ALWAYS AS (
    UPPER(REPLACE(CONCAT(vehicle_manufacturer_label, '-', LEFT(vehicle_model_label, 3), '-', vehicle_type_label), ' ', ''))
) AFTER vehicle_type_label;