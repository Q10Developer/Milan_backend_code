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
import com.app.user.dto.request.OldVehicleInspectionDetailsRequestDTO;
import com.app.user.dto.request.OldVehicleInspectionRequestDTO;
import com.app.user.dto.request.VehicleInspectionDetailsRequestDTO;
import com.app.user.dto.response.GenericResponseDTO;
import com.app.user.entity.OldVehicleInspectionDetailsEntity;
import com.app.user.entity.OldVehicleInspectionEntity;
import com.app.user.entity.VehicleInspectionDetailsEntity;
import com.app.user.entity.VehicleInspectionEntity;
import com.app.user.repository.OldVehicleInspectionDetailsRepository;
import com.app.user.repository.OldVehicleInspectionRepository;



@Service
public class IOldVehicleInspectionServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IVehicleInspectionServiceImpl.class);
	
	@Autowired
	private OldVehicleInspectionRepository oldVehicleInspectionRepository;
	        
	@Autowired
	private  OldVehicleInspectionDetailsRepository 	oldVehicleInspectionDetailsRepository;
	
	public ServiceResponseDTO startOldVehicleInspection(OldVehicleInspectionRequestDTO oldVehicleInspectionRequestDTO) {
		LOGGER.info("Start Vehicle Inspection in IOldVehicleInspectionServiceImpl and startOLdVehicleInspection method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (oldVehicleInspectionRequestDTO  != null) {
			OldVehicleInspectionEntity entity = new OldVehicleInspectionEntity();
			try {
				if (null != oldVehicleInspectionRequestDTO.getNo()) {
					LOGGER.info("Need to do Updation (OldVehicleInspection exist)");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_OLD_VEHICLE_INSPECTION_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_OLD_VEHICLE_INSPECTION_ALREADY_EXIST_DESC, null);
				}                              
				oldVehicleInspectionRequestDTO.setOldVehicleInspectionStatus(URLConstants.DRAFT);
				BeanUtils.copyProperties(oldVehicleInspectionRequestDTO, entity);
				entity = oldVehicleInspectionRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getNo().toString()));
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
	
	public ServiceResponseDTO updateOldVehicleInspection(Long registrationNo,
			OldVehicleInspectionRequestDTO oldVehicleInspectionRequestDTO) {
		LOGGER.info("Update Vehicle Inspection in IOldVehicleInspectionServiceImpl and updateOldVehicleInspection method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (oldVehicleInspectionRequestDTO != null && oldVehicleInspectionRequestDTO.getOdometerReading() != null) {
			try {
				Optional<OldVehicleInspectionEntity> entity = oldVehicleInspectionRepository.findById(registrationNo);
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
	
	
	public ServiceResponseDTO getOldVehicleInspectionByRegistratioNo(	Long registrationNo) {
		LOGGER.info(
				"getOldVehcileInspectionByRegistratioNo process start in IoldVehicleInspectionServiceImpl and getOldVehcileInspectionByRegistratioNo  method Executing ");
		Optional<OldVehicleInspectionEntity> oldVehicleoInspectionDetail = oldVehicleInspectionRepository.findById(registrationNo);
		if (! oldVehicleoInspectionDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, oldVehicleoInspectionDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}
	
	@Transactional
	public ServiceResponseDTO saveOldVehicleInspectionDetails(Long registrationNo , int oldVehicleInspectionStatus,
			List<OldVehicleInspectionDetailsRequestDTO> oldVehicleInspectionDetails) {
		LOGGER.info(
				"Save Old Vehicle Inspection Details in IOldVehicleInspectionServiceImpl and saveOldVehicleInspectionDetails method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (!CollectionUtils.isEmpty(oldVehicleInspectionDetails)) {
			Optional<OldVehicleInspectionEntity> oldVehicleInspectionEntity = oldVehicleInspectionRepository
					.findById(registrationNo);
			if (oldVehicleInspectionEntity.isPresent()
					&& oldVehicleInspectionEntity.get().getOldVehicleInspectionStatus() == URLConstants.DRAFT) {
				try {
					List<OldVehicleInspectionDetailsEntity> oldVehicleDetailsList = new ArrayList<>();
					for (OldVehicleInspectionDetailsRequestDTO requestDTO : oldVehicleInspectionDetails) {
						OldVehicleInspectionDetailsEntity entity = new OldVehicleInspectionDetailsEntity();
						BeanUtils.copyProperties(requestDTO, entity);
						oldVehicleDetailsList.add(entity);
					}
					Iterable<OldVehicleInspectionDetailsEntity> savedEntity = oldVehicleInspectionDetailsRepository
							.saveAll(oldVehicleDetailsList);
					OldVehicleInspectionEntity oldVehicleInspectionEntityObj = oldVehicleInspectionEntity.get();
					oldVehicleInspectionEntityObj.setOldVehicleInspectionStatus(oldVehicleInspectionStatus);
					oldVehicleInspectionRepository.save(oldVehicleInspectionEntityObj);
					String idString = StreamSupport.stream(savedEntity.spliterator(), false)
							.map(OldVehicleInspectionDetailsEntity::getRowId).map(String::valueOf)
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


		
	
	
	public ServiceResponseDTO getVehicleInspectionByRegistratioNo(Long registratioNo) {
		LOGGER.info(
				"getOldVehicleInspectionByRegistratioNo process start in IOldVehicleInspectionServiceImpl and getOldVehicleInspectionByInspectionId method Executing ");
		List<OldVehicleInspectionDetailsEntity> oldVehicleInspectionDetails = oldVehicleInspectionDetailsRepository
				.findByRegistrationNo(registratioNo);
		if (!oldVehicleInspectionDetails.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, oldVehicleInspectionDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}
	
	
	
	
	
	
	
	
	
}
	
