package com.app.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
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
import com.app.user.entity.VehicleInspectionDetailsEntity;
import com.app.user.entity.VehicleInspectionEntity;
import com.app.user.repository.VehicleInspectionDetailsRepository;
import com.app.user.repository.VehicleInspectionRepository;

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

	@Transactional
	public ServiceResponseDTO saveVehicleInspectionDetails(String inspectionId, int inspectionStatus,
			List<VehicleInspectionDetailsRequestDTO> vehicleInspectionDetails) {
		LOGGER.info(
				"Save Vehicle Inspection Details in IVehicleInspectionServiceImpl and saveVehicleInspectionDetails method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (!CollectionUtils.isEmpty(vehicleInspectionDetails)) {
			Optional<VehicleInspectionEntity> vehicleInspectionEntity = vehicleInspectionRepository
					.findById(inspectionId);
			if (vehicleInspectionEntity.isPresent()
					&& vehicleInspectionEntity.get().getInspectionStatus() == URLConstants.DRAFT) {
				try {
					List<VehicleInspectionDetailsEntity> vehicleDetailsList = new ArrayList<>();
					for (VehicleInspectionDetailsRequestDTO requestDTO : vehicleInspectionDetails) {
						VehicleInspectionDetailsEntity entity = new VehicleInspectionDetailsEntity();
						BeanUtils.copyProperties(requestDTO, entity);
						vehicleDetailsList.add(entity);
					}
					Iterable<VehicleInspectionDetailsEntity> savedEntity = vehicleInspectionDetailsRepository
							.saveAll(vehicleDetailsList);
					VehicleInspectionEntity vehicleInspectionEntityObj = vehicleInspectionEntity.get();
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
		List<VehicleInspectionDetailsEntity> vehicleInspectionDetails = vehicleInspectionDetailsRepository
				.findByInspectionId(inspectionId);
		if (!vehicleInspectionDetails.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleInspectionDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

}
