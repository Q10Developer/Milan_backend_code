package com.app.user.utilities;

import org.apache.commons.lang3.StringUtils;

import com.app.user.constants.CalculationConstants;
import com.app.user.dto.request.VehicleInspectionDetailsRequestDTO;
import com.app.user.entity.VehicleInspectionEntity;

public class CalculationUtils {

	private CalculationUtils() {

	}

	
	public static Double calculateFinalTireLife(VehicleInspectionDetailsRequestDTO requestDTO)
	{
		return(requestDTO.getOdometerReadingWhenRemoved()-(requestDTO.getOdometerReadingWhenFitted()));
	}
	
	
	public static Double calculateCurrentTireLife(VehicleInspectionEntity vehicleInspectionEntity,
			VehicleInspectionDetailsRequestDTO requestDTO) {
		return (vehicleInspectionEntity.getVehicleOdometerReading() - (requestDTO.getOdometerReadingWhenFitted()));
	}


	
	public static Double calculateMileagePerMM(double currentTireLife ,double rtd,VehicleInspectionDetailsRequestDTO requestDTO)
	{  
	   return(currentTireLife) / ((requestDTO.getOtdMm() != null ? requestDTO.getOtdMm() : 0.0) - rtd) ;
	}
	
	
	public static Double calculateProjectedMileagePerMM(VehicleInspectionDetailsRequestDTO requestDTO, double mileagePerMm) {
	    return((mileagePerMm) * (requestDTO.getOtdMm() - (requestDTO.getLeastTireThicknessAllowed())));
	}

	
	

	public static String calculatePressureAnalysis(Double obsPressure, Double recoPressure) {
		double pressurePercentage = (obsPressure / recoPressure) * 100;
		if (pressurePercentage > 95 && pressurePercentage < 105) {
			return CalculationConstants.PRESSURE_OK;
		} else if (pressurePercentage > 90 && pressurePercentage <= 95) {
			return CalculationConstants.UNDER_INFLATION;
		} else if (pressurePercentage <= 90) {
			return CalculationConstants.EXTREME_UNDERINFLATION;
		} else if (pressurePercentage >= 105 && pressurePercentage < 110) {
			return CalculationConstants.OVER_INFLATION;
		} else if (pressurePercentage >= 110) {
			return CalculationConstants.EXTREME_OVERINFLATION;
		}
		return null;
	}

	public static String calculatePressureAnalysisColorCode(String pressureAnalysis) {
		if (!StringUtils.isEmpty(pressureAnalysis)) {
			if (pressureAnalysis.equals(CalculationConstants.PRESSURE_OK)) {
				return CalculationConstants.COLOR_GREEN;
			} else if (pressureAnalysis.equals(CalculationConstants.UNDER_INFLATION)) {
				return CalculationConstants.COLOR_YELLOW;
			} else if (pressureAnalysis.equals(CalculationConstants.EXTREME_UNDERINFLATION)) {
				return CalculationConstants.COLOR_RED;
			} else if (pressureAnalysis.equals(CalculationConstants.OVER_INFLATION)) {
				return CalculationConstants.COLOR_YELLOW;
			} else if (pressureAnalysis.equals(CalculationConstants.EXTREME_OVERINFLATION)) {
				return CalculationConstants.COLOR_RED;
			}
		}
		return null;
	}

	public static String calculateThicknessAnalysis(Double rtd, int leastTireThicknessAllowed) {
		if (rtd != null && leastTireThicknessAllowed == 3) {
			double redThreshold = leastTireThicknessAllowed * 1;
			double yellowThreshold = leastTireThicknessAllowed * 2;
			if (rtd <= redThreshold) {
				return CalculationConstants.COLOR_RED;
			} else if (rtd <= yellowThreshold) {
				return CalculationConstants.COLOR_YELLOW;
			} else {
				return CalculationConstants.COLOR_GREEN;
			}
		}     
		return null;
	}

	public static String calculateWearAnalysis(String observationCategoryLabel, Double lstMm, Double ctMm,
			Double rstMm) {
		if (!CalculationConstants.NORMAL.equalsIgnoreCase(observationCategoryLabel) && lstMm != null && ctMm != null
				&& rstMm != null) {
			if (lstMm < ctMm && ctMm < rstMm) {
				return CalculationConstants.LEFT_SLIDE_SLOPE;
			} else if (lstMm > ctMm && ctMm > rstMm) {
				return CalculationConstants.RIGHT_SLIDE_SLOPE;
			} else if (lstMm > ctMm && ctMm < rstMm) {
				return CalculationConstants.CENTER_WEAR;
			}
		}
		return null;
	}
}
