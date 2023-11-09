package com.app.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.app.user.constants.ResponseKeysValue;
import com.app.user.constants.URLConstants;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.VehicleInspectionDetailsRequestDTO;
import com.app.user.dto.request.VehicleInspectionRequestDTO;
import com.app.user.dto.response.GenericResponseDTO;
import com.app.user.entity.ClientVehicleEntity;
import com.app.user.entity.VehicleInspectionDetailsEntity;
import com.app.user.entity.VehicleInspectionEntity;
import com.app.user.repository.VehicleInspectionDetailsRepository;
import com.app.user.repository.VehicleInspectionRepository;
import com.app.user.utilities.CalculationUtils;
import com.app.user.utilities.Utils;

@Service
public class IVehicleInspectionServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IVehicleInspectionServiceImpl.class);

	@Autowired
	private VehicleInspectionRepository vehicleInspectionRepository;

	@Autowired
	private VehicleInspectionDetailsRepository vehicleInspectionDetailsRepository;

	

	public ServiceResponseDTO startVehicleInspection(VehicleInspectionRequestDTO vehicleInspectionRequestDTO) {
		LOGGER.info("Start Vehicle Inspection in IVehicleInspectionServiceImpl and startVehicleInspection method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleInspectionRequestDTO != null) {
			VehicleInspectionEntity entity = new VehicleInspectionEntity();
			try {
				if (!StringUtils.isEmpty(vehicleInspectionRequestDTO.getInspectionId())) {
					LOGGER.info("Need to do Updation (Inspection exist)");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_INSPECTION_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VEHICLE_INSPECTION_ALREADY_EXIST_DESC, null);
				}
				vehicleInspectionRequestDTO.setInspectionStatus(URLConstants.DRAFT);
				BeanUtils.copyProperties(vehicleInspectionRequestDTO, entity);
				entity = vehicleInspectionRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getInspectionId()));
				LOGGER.info("Client data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IVehicleInspectionServiceImpl calss in method startVehicleInspection with Exception {}",
						ex.getMessage());
				response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
				response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
				response.setResult(ex.getMessage());
			}
		} else {
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		return response;
	}

	public ServiceResponseDTO updateVehicleInspection(String inspectionId,
			VehicleInspectionRequestDTO vehicleInspectionRequestDTO) {
		LOGGER.info("Update Vehicle Inspection in IVehicleInspectionServiceImpl and updateVehicleInspection method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleInspectionRequestDTO != null && vehicleInspectionRequestDTO.getVehicleOdometerReading() != null) {
			try {
				Optional<VehicleInspectionEntity> entity = vehicleInspectionRepository.findById(inspectionId);
				if (entity.isPresent()) {
					VehicleInspectionEntity vehicleInspectionEntity = entity.get();
					vehicleInspectionEntity
							.setVehicleOdometerReading(vehicleInspectionRequestDTO.getVehicleOdometerReading());
					vehicleInspectionEntity.setDriverName(vehicleInspectionRequestDTO.getDriverName());
					vehicleInspectionEntity.setDriverMobileNo(vehicleInspectionRequestDTO.getDriverMobileNo());
					vehicleInspectionEntity
							.setMaintanaceManagerName(vehicleInspectionRequestDTO.getMaintanaceManagerName());
					vehicleInspectionEntity
							.setMaintanaceManagerMobileNo(vehicleInspectionRequestDTO.getMaintanaceManagerMobileNo());
					vehicleInspectionEntity.setMilanTireServiceAndSolutionName(
							vehicleInspectionRequestDTO.getMilanTireServiceAndSolutionName());
					vehicleInspectionEntity.setMilanTireServiceAndSolutionMobileNo(
							vehicleInspectionRequestDTO.getMilanTireServiceAndSolutionMobileNo());
					vehicleInspectionEntity = vehicleInspectionRepository.save(vehicleInspectionEntity);
					response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
					response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
					response.setResult(vehicleInspectionEntity);
					LOGGER.info("Client data saved Successfully");
				} else {
					response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
					response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
				}
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IVehicleInspectionServiceImpl calss in method startVehicleInspection with Exception {}",
						ex.getMessage());
				response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
				response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
				response.setResult(ex.getMessage());
			}
		} else {
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		return response;
	}

	
	public ServiceResponseDTO getAllVehicleInspection(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllVehicleInspection process start in VehicleInspectionServiceImpl and getAllVehcileInspection method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleInspectionEntity> vehicleInspectionDetails = vehicleInspectionRepository.findAll(pageable);
		if (vehicleInspectionDetails.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200,vehicleInspectionDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}

	}
		
		
	public ServiceResponseDTO getVehicleInspectionById(String inspectionId) {
		LOGGER.info(
				"getVehcileInspectionById process start in IVehicleInspectionServiceImpl and getVehcileInspectionById method Executing ");
		Optional<VehicleInspectionEntity> vehicleoInspectionDetail = vehicleInspectionRepository.findById(inspectionId);
		if (!vehicleoInspectionDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleoInspectionDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	
	public ServiceResponseDTO getVehicleInspectionByClientId(Long clientId) {
		LOGGER.info(
				"getVehcileInspectionByClientId process start in IVehicleInspectionServiceImpl and getVehcileInspectionByClientId method Executing ");
		List<VehicleInspectionEntity> vehicleoInspectionDetail = vehicleInspectionRepository.findByClientId(clientId);
		if (!vehicleoInspectionDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleoInspectionDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}
	
	
	

	
	public ServiceResponseDTO getVehicleInspectionByClientIdUserId(Long userId) {
	    LOGGER.info("getVehcileInspectionByClientIdUserId process start in IVehicleInspectionServiceImpl and getVehcileInspectionByClientId UserId method Executing");
	    
	    List<VehicleInspectionEntity> vehicleoInspectionDetail = vehicleInspectionRepository.findByClientIdUserId(userId);
	    
	    List<VehicleInspectionEntity> activeInspections = vehicleoInspectionDetail.stream()
	        .filter(inspection -> inspection.getActiveStatus() == 1) // Assuming 1 represents an active status, change this value as needed
	        .collect(Collectors.toList());
	    
	    if (!activeInspections.isEmpty()) {
	        return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
	            ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, activeInspections);
	    } else {
	        return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND, null);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public ServiceResponseDTO getVehicleLastInspectionDate(Long clientId,String vehicleRegNumber) {
		LOGGER.info(
				"getVehicleLastInspectionDate process start in IVehicleInspectionServiceImpl and getVehicleLastInspectionDate method Executing ");
		List<VehicleInspectionEntity> vehicleoInspectionDetail = vehicleInspectionRepository.findByLastInspectionDate(clientId,vehicleRegNumber);
		if (!vehicleoInspectionDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleoInspectionDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}
	
	

	
	public ServiceResponseDTO getVehicleRegNumber(String vehicleRegNumber) {
		LOGGER.info(
				"getVehcileRegNumber process start in IVehicleInspectionServiceImpl and getVehicleRegNumber method Executing ");
		List<VehicleInspectionEntity> vehicleoInspectionDetail = vehicleInspectionRepository.findByVehicleRegNumber(vehicleRegNumber);
		if (!vehicleoInspectionDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleoInspectionDetail);
		}else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_VEHICLE_REG_NUMBER_FOUND,null);
	}
	}
	
	
	
	public ServiceResponseDTO enableDisableInspection( VehicleInspectionRequestDTO vehicleInspectionRequestDTO ,String inspectionId
			) {
		LOGGER.info(" master data in IMasterServiceImpl and enableDisableInspection method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if ( vehicleInspectionRequestDTO!= null) {
			Optional<VehicleInspectionEntity> vehicleInspectionEntity = vehicleInspectionRepository.findById(inspectionId);
			if (vehicleInspectionEntity.isEmpty()) {
				LOGGER.info("Invalid   vehicleInspection for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_INSPECTION_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_INSPECTION_DOESNT_EXIST_DESC, null);

			}
			VehicleInspectionEntity	 entity = vehicleInspectionEntity.get();
			entity.setActiveStatus(vehicleInspectionRequestDTO.getActiveStatus());
			try {
				entity = vehicleInspectionRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getInspectionId().toString()));
				LOGGER.info("  VehicleInspection data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IVehicleInspectionServiceImpl calss in method  enableDisableInspection with Exception {}",
						ex.getMessage());
				response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
				response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
				response.setResult(ex.getMessage());
			}
		} else {
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		return response;
	}
	
	
	
	

	
	public ServiceResponseDTO getTopTenIssueClientIdAndVehicleId(Long clientId, Long vehicleId) {
	    LOGGER.info("getTopTenIssueClientIdAndVehicleId process start in IVehicleInspectionServiceImpl and getTopTenIssueClientIdAndVehicleId method Executing ");
	    List<VehicleInspectionDetailsEntity> vehicleInspectionDetail = vehicleInspectionRepository.findByTopTenIssueClientIdAndVehicleId(clientId, vehicleId);
	    if (vehicleInspectionDetail.size() > 10) {
	        vehicleInspectionDetail = vehicleInspectionDetail.subList(0, 10);
	    }

	    if (!vehicleInspectionDetail.isEmpty()) {
	        return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
	                ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleInspectionDetail);
	    } else {
	        return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
	                null);
	    }
	}

	
	
	@Transactional
	public ServiceResponseDTO saveVehicleInspectionDetails(String inspectionId, int inspectionStatus,
			List<VehicleInspectionDetailsRequestDTO> vehicleInspectionDetails) {
		LOGGER.info(
				"Save Vehicle Inspection Details in IVehicleInspectionServiceImpl and saveVehicleInspectionDetails method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (!CollectionUtils.isEmpty(vehicleInspectionDetails)) {
			Optional<VehicleInspectionEntity> vehicleInspectionEntityOptional = vehicleInspectionRepository
					.findById(inspectionId);
			if (vehicleInspectionEntityOptional.isPresent()) {
				try {
					List<VehicleInspectionDetailsEntity> vehicleDetailsList = new ArrayList<>();
					for (VehicleInspectionDetailsRequestDTO requestDTO : vehicleInspectionDetails) {
						VehicleInspectionDetailsEntity entity = new VehicleInspectionDetailsEntity();
						/*
						 * Analysis and Calculation will happen when status is submitted
						 */
						analysisCalculations(vehicleInspectionEntityOptional.get(), requestDTO, inspectionStatus);
						BeanUtils.copyProperties(requestDTO, entity);
						vehicleDetailsList.add(entity);
					}
					Iterable<VehicleInspectionDetailsEntity> savedEntity = vehicleInspectionDetailsRepository
							.saveAll(vehicleDetailsList);
					VehicleInspectionEntity vehicleInspectionEntityObj = vehicleInspectionEntityOptional.get();
					vehicleInspectionEntityObj.setInspectionStatus(inspectionStatus);
					vehicleInspectionRepository.save(vehicleInspectionEntityObj);
					String idString = StreamSupport.stream(savedEntity.spliterator(), false)
							.map(VehicleInspectionDetailsEntity::getRowId).map(String::valueOf)
							.collect(Collectors.joining(","));
					response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
					response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
					response.setResult(new GenericResponseDTO(idString));
					LOGGER.info("Vehicle Inspection saved Successfully");
				} catch (Exception ex) {
					LOGGER.error(
							"Exception occurred in IVehicleInspectionServiceImpl class in method saveVehicleInspectionDetails with Exception {}",
							ex.getMessage());
					response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
					response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
					response.setResult(ex.getMessage());
				}
			} else {
				response.setStatusCode(ResponseKeysValue.FAILURE_INCORRECT_INSPECTION_CODE_400);
				response.setStatusDescription(ResponseKeysValue.FAILURE_INCORRECT_INSPECTION_DESCRIPTION_400);
			}
		} else {
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		return response;
	}
	
	
	
	
	

	public ServiceResponseDTO getVehicleInspectionByInspectionId(String inspectionId) {
		LOGGER.info(
				"getVehicleInspectionByInspectionId process start in IVehicleInspectionServiceImpl and getVehicleInspectionByInspectionId method Executing ");
		List<VehicleInspectionDetailsEntity> vehicleInspectionDetails = vehicleInspectionDetailsRepository.findByInspectionId(inspectionId);
		if (!vehicleInspectionDetails.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleInspectionDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}
	
	
	
	
	public ServiceResponseDTO getTireDetailsByInspectionIdClientId(Long clientId,Long clientServiceLocationId) {
		LOGGER.info(
				"getTireDetailsByInspectionIdClientId process start in IVehicleInspectionServiceImpl and getTireDetailsByInspectionIdClientId method Executing ");
		List<VehicleInspectionDetailsEntity> vehicleoInspectionDetail =vehicleInspectionRepository.findByInspectionIdClientId(clientId,clientServiceLocationId);
		if (!vehicleoInspectionDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleoInspectionDetail);
		}else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_VEHICLE_REG_NUMBER_FOUND,null);
	}
	}
	
	
	
	
	
	
	public ServiceResponseDTO getInspectionDoneByClientIdAndLocationId(Long clientId, Long clientServiceLocationId) {
	    LOGGER.info("getInspectionDoneByClientIdAndLocationId process start in IVehicleInspectionServiceImpl and getInspectionDoneByClientIdAndLocationId method Executing ");
	    List<VehicleInspectionEntity> vehicleEntity = vehicleInspectionRepository.findInspectionByClientIdAndServiceLocationId(clientId,clientServiceLocationId );
	    

	    if (!vehicleEntity.isEmpty()) {
	        return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
	                ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleEntity);
	    } else {
	        return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
	                null);
	    }
	}
	
	
	


	private void analysisCalculations(VehicleInspectionEntity vehicleInspectionEntity,
			VehicleInspectionDetailsRequestDTO requestDTO, int inspectionStatus)  {
		ServiceResponseDTO response = null; 
	   double finalTireLife=0.0;
		double mileagePerMm = 0.0;
		double projectedMileage = 0.0;
		double rtd = 0.0;
		double currentTireLife = 0.0;
		String pressureAnalysis = null;
		String pressureAnalysisColorCode = null;
		String leastTireThicknessAllowedAnalysis = null;
		String wearAnalysis = null;
		if (inspectionStatus == URLConstants.SUBMITTED) {
			/*
			 * Other Calculations
			 */
			pressureAnalysis = CalculationUtils.calculatePressureAnalysis(requestDTO.getObsPressure(),
					requestDTO.getRecoPressure());
			pressureAnalysisColorCode = CalculationUtils.calculatePressureAnalysisColorCode(pressureAnalysis);
		
			wearAnalysis = CalculationUtils.calculateWearAnalysis(requestDTO.getObservationCategoryLabel(),
					requestDTO.getLstMm(), requestDTO.getCtMm(), requestDTO.getRstMm());
			
			rtd = Arrays.stream(new double[] { requestDTO.getRstMm(), requestDTO.getCtMm(), requestDTO.getLstMm() })
					.min().getAsDouble();

			
			leastTireThicknessAllowedAnalysis = CalculationUtils.calculateThicknessAnalysis(rtd,
					requestDTO.getLeastTireThicknessAllowed());

			if(vehicleInspectionEntity.getVehicleOdometerReading()!=null && requestDTO.getOdometerReadingWhenFitted()!=null  
					&&  vehicleInspectionEntity.getVehicleOdometerReading() > requestDTO.getOdometerReadingWhenFitted() && vehicleInspectionEntity.getVehicleOdometerReading()!=0
					&& requestDTO.getOdometerReadingWhenFitted()!=0 && requestDTO.getTireRemovalDate()== null && requestDTO.getOdometerReadingWhenRemoved() == null  )
			{
			currentTireLife = CalculationUtils.calculateCurrentTireLife(vehicleInspectionEntity, requestDTO);
			}
			
			 /* Calculations for Projected Mileage and Mileage Per MM
			 */
			 
		     if(requestDTO.getOdometerReadingWhenRemoved() !=null && requestDTO.getOdometerReadingWhenFitted()!= null && requestDTO.getOdometerReadingWhenRemoved() > requestDTO.getOdometerReadingWhenFitted() && requestDTO.getOdometerReadingWhenRemoved()!=0 && requestDTO.getOdometerReadingWhenFitted()!=0  )
		     {
		    	 finalTireLife = CalculationUtils.calculateFinalTireLife(requestDTO);
		     }
			
			if (rtd >= URLConstants.RTD_MIN_VALUE
					&& !Utils.compareDates(vehicleInspectionEntity.getInspectionDateTime(),
							requestDTO.getTireOriginalFitmentDate())) {
				try {
					
					if(currentTireLife!= 0.0 )
					{
					mileagePerMm = CalculationUtils.calculateMileagePerMM( currentTireLife, rtd,requestDTO);
					
					}
					if(requestDTO.getTireRemovalDate()== null && requestDTO.getOdometerReadingWhenRemoved() == null && mileagePerMm != 0.0 )
					{
					projectedMileage = CalculationUtils.calculateProjectedMileagePerMM(requestDTO, mileagePerMm);
					}
					
				} catch (ArithmeticException aex) {
					LOGGER.error(
							
							"ArithmeticException occurred while doing computation of mileagePerMm and  : {}",
							aex.getMessage());
					
					response = new ServiceResponseDTO(ResponseKeysValue.FAILURE_ARITHMETIC_EXCEPTION_400,
							ResponseKeysValue.FAILURE_ARITHMETIC_EXCEPTION_DESCRIPTION_400, aex.getMessage());
					
}
				
			}
		}
		requestDTO.setCurrentTireLife(currentTireLife);
		requestDTO.setPressureAnalysis(pressureAnalysis);
		requestDTO.setPressureColorCode(pressureAnalysisColorCode);
		requestDTO.setLeastTireThicknessAllowedAnalysis(leastTireThicknessAllowedAnalysis);
		requestDTO.setWearAnalysis(wearAnalysis);
		requestDTO.setRtd(rtd);
		requestDTO.setFinalTireLife(finalTireLife);
		requestDTO.setMileagePerMm(mileagePerMm);
		requestDTO.setProjectedMileage(projectedMileage);
		
		
		
		
	}
	
	
}
