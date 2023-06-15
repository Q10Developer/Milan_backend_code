package com.app.user.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.app.user.constants.ResponseKeysValue;
import com.app.user.constants.URLConstants;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.OldVehicleInspectionRequestDTO;
import com.app.user.dto.response.GenericResponseDTO;
import com.app.user.entity.OldVehicleInspectionEntity;
import com.app.user.repository.OldVehicleInspectionRepository;



@Service
public class IOldVehicleInspectionServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IVehicleInspectionServiceImpl.class);
	
	@Autowired
	private OldVehicleInspectionRepository oldVehicleInspectionRepository;
	        
	
	public ServiceResponseDTO startOldVehicleInspection(OldVehicleInspectionRequestDTO oldVehicleInspectionRequestDTO) {
		LOGGER.info("Start Vehicle Inspection in IOldVehicleInspectionServiceImpl and startOLdVehicleInspection method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (oldVehicleInspectionRequestDTO  != null) {
			OldVehicleInspectionEntity entity = new OldVehicleInspectionEntity();
			try {
				if (null != oldVehicleInspectionRequestDTO.getSrNo()) {
					LOGGER.info("Need to do Updation (OldVehicleInspection exist)");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_OLD_VEHICLE_INSPECTION_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_OLD_VEHICLE_INSPECTION_ALREADY_EXIST_DESC, null);
				}                              
				oldVehicleInspectionRequestDTO.setOldVehicleInspectionStatus(URLConstants.DRAFT);
				BeanUtils.copyProperties(oldVehicleInspectionRequestDTO, entity);
				entity = oldVehicleInspectionRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getSrNo().toString()));
				LOGGER.info("Client data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IOldVehicleInspectionServiceImpl calss in method startOldVehicleInspection with Exception {}",
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
	
	public ServiceResponseDTO updateOldVehicleInspection(Long srNo,
			OldVehicleInspectionRequestDTO oldVehicleInspectionRequestDTO) {
		LOGGER.info("Update Vehicle Inspection in IOldVehicleInspectionServiceImpl and updateOldVehicleInspection method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (oldVehicleInspectionRequestDTO != null && oldVehicleInspectionRequestDTO.getOdometerReading() != null) {
			try {
				Optional<OldVehicleInspectionEntity> entity = oldVehicleInspectionRepository.findById(srNo);
				if (entity.isPresent()) {
					OldVehicleInspectionEntity oldVehicleInspectionEntity = entity.get();
					oldVehicleInspectionEntity
							.setOdometerReading(oldVehicleInspectionRequestDTO.getOdometerReading());
					oldVehicleInspectionEntity = oldVehicleInspectionRepository.save(oldVehicleInspectionEntity);
					response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
					response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
					response.setResult(oldVehicleInspectionEntity);
					LOGGER.info("Client data saved Successfully");
				} else {
					response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
					response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
				}
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IOldVehicleInspectionServiceImpl calss in method updateOldVehicleInspection with Exception {}",
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

	public ServiceResponseDTO getAllOldVehicleInspection(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllOldVehcileInspection process start in IOldVehicleInspectionServiceImpl and getAllOldVehcileInspection method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<OldVehicleInspectionEntity> oldVehicleInspectionDetails = oldVehicleInspectionRepository.findAll(pageable);
		if (oldVehicleInspectionDetails.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, oldVehicleInspectionDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	
	}
	
/*	public ServiceResponseDTO getOldVehicleInspectionByRegistrationNo(String re) {
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
}

	*/
	
	
	

	
	
	
}
	
