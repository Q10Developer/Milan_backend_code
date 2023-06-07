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
import com.app.user.dto.request.VehicleInspectionRequestDTO;
import com.app.user.dto.response.GenericResponseDTO;
import com.app.user.entity.VehicleInspectionEntity;
import com.app.user.repository.VehicleInspectionRepository;

@Service
public class IVehicleInspectionServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IVehicleInspectionServiceImpl.class);

	@Autowired
	private VehicleInspectionRepository vehicleInspectionRepository;

	public ServiceResponseDTO startVehicleInspection(VehicleInspectionRequestDTO vehicleInspectionRequestDTO) {
		LOGGER.info("Start Vehicle Inspection in IVehicleInspectionServiceImpl and startVehicleInspection method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleInspectionRequestDTO != null) {
			VehicleInspectionEntity entity = new VehicleInspectionEntity();
			try {
				if (null != vehicleInspectionRequestDTO.getInspectionId()) {
					LOGGER.info("Need to do Updation (Inspection exist)");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_INSPECTION_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VEHICLE_INSPECTION_ALREADY_EXIST_DESC, null);
				}
				vehicleInspectionRequestDTO.setInspectionStatus(URLConstants.DRAFT);
				BeanUtils.copyProperties(vehicleInspectionRequestDTO, entity);
				entity = vehicleInspectionRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getInspectionId().toString()));
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

	public ServiceResponseDTO getAllVehcileInspection(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllVehcileInspection process start in IVehicleInspectionServiceImpl and getAllVehcileInspection method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleInspectionEntity> vehicleInspectionDetails = vehicleInspectionRepository.findAll(pageable);
		if (vehicleInspectionDetails.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleInspectionDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getVehcileInspectionById(Long inspectionId) {
		LOGGER.info(
				"getVehcileInspectionById process start in IVehicleInspectionServiceImpl and getVehcileInspectionById method Executing ");
		Optional<VehicleInspectionEntity> clientDetail = vehicleInspectionRepository.findById(inspectionId);
		if (!clientDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, clientDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

}
