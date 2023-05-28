package com.app.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
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
import com.app.user.dto.request.ClientMasterRequestDTO;
import com.app.user.dto.request.DropDownMasterDTO;
import com.app.user.dto.request.MasterDataRequestDTO;
import com.app.user.dto.request.ObservationCategoryRequestDTO;
import com.app.user.dto.request.ObservationRequestDTO;
import com.app.user.dto.request.TireConfigurationRequestDTO;
import com.app.user.dto.request.TireMakeRequestDTO;
import com.app.user.dto.request.TyreRequestDTO;
import com.app.user.dto.request.VehicleManufacturerRequestDTO;
import com.app.user.dto.request.VehicleModelRequestDTO;
import com.app.user.dto.request.VehicleRequestDTO;
import com.app.user.dto.request.VehicleSubTypeRequestDTO;
import com.app.user.dto.request.VehicleTypeRequestDTO;
import com.app.user.dto.request.VehicleUsageRequestDTO;
import com.app.user.dto.response.GenericResponseDTO;
import com.app.user.entity.ClientMasterEntity;
import com.app.user.entity.DropDownEntity;
import com.app.user.entity.MasterDataListEntity;
import com.app.user.entity.ObservationCategoryEntity;
import com.app.user.entity.ObservationEntity;
import com.app.user.entity.TireConfigurationEntity;
import com.app.user.entity.TireMakeEntity;
import com.app.user.entity.TyreMasterEntity;
import com.app.user.entity.VehicleManufacturerEntity;
import com.app.user.entity.VehicleMasterEntity;
import com.app.user.entity.VehicleModelEntity;
import com.app.user.entity.VehicleSubTypeEntity;
import com.app.user.entity.VehicleTypeEntity;
import com.app.user.entity.VehicleUsageEntity;
import com.app.user.repository.ClientMasterRepository;
import com.app.user.repository.DropDownMasterRepository;
import com.app.user.repository.MasterDataListRepository;
import com.app.user.repository.ObservatioRepository;
import com.app.user.repository.ObservationCategoryRepository;
import com.app.user.repository.TireConfigurationRepository;
import com.app.user.repository.TireMakeRepository;
import com.app.user.repository.TyreRepository;
import com.app.user.repository.VehicleManufacturerRepository;
import com.app.user.repository.VehicleModelRepository;
import com.app.user.repository.VehicleRepository;
import com.app.user.repository.VehicleSubTypeRepository;
import com.app.user.repository.VehicleTypeRepository;
import com.app.user.repository.VehicleUsageRepository;

@Service
public class IMasterServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IMasterServiceImpl.class);

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ClientMasterRepository clientMasterRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private TyreRepository tyreRepository;

	@Autowired
	private MasterDataListRepository masterDataListRepository;

	@Autowired
	private DropDownMasterRepository dropDownMasterRepository;

	@Autowired
	private ObservatioRepository observationRepository;

	@Autowired
	private VehicleManufacturerRepository vehicleManufacturerRepository;

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	@Autowired
	private VehicleUsageRepository vehicleUsageRepository;

	@Autowired
	private VehicleSubTypeRepository vehicleSubTypeRepository;

	@Autowired
	private TireMakeRepository tireMakeRepository;

	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	@Autowired
	private ObservationCategoryRepository observationCategoryRepository;

	@Autowired
	private TireConfigurationRepository tireConfigurationRepository;

	public ServiceResponseDTO saveClientMasterData(ClientMasterRequestDTO clientMasterRequestDTO) {
		LOGGER.info("client master data in IMasterServiceImpl and saveClientMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (clientMasterRequestDTO != null) {
			ClientMasterEntity entity = new ClientMasterEntity();
			try {
				if (null != clientMasterRequestDTO.getClientId()) {
					LOGGER.info("Need to do Updation (Client exist)");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_CLIENT_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_CLIENT_ALREADY_EXIST_DESC, null);
				}
				clientMasterRequestDTO.setClientActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(clientMasterRequestDTO, entity);
				entity = clientMasterRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getClientId()));
				LOGGER.info("Client data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveClientMasterData with Exception {}",
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

	public ServiceResponseDTO updateClientMasterData(ClientMasterRequestDTO clientMasterRequestDTO, Long clientId) {
		LOGGER.info("client master data in IMasterServiceImpl and updateClientMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (clientMasterRequestDTO != null) {
			Optional<ClientMasterEntity> clientMasterEntity = clientMasterRepository.findById(clientId);
			if (clientMasterEntity.isEmpty()) {
				LOGGER.info("Invalid client for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_CLIENT_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_CLIENT_DOESNT_EXIST_DESC, null);
			}
			ClientMasterEntity entity = new ClientMasterEntity();
			clientMasterRequestDTO.setClientId(clientId);
			clientMasterRequestDTO.setClientActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(clientMasterRequestDTO, entity);
			try {
				entity = clientMasterRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info("Client data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateClientMasterData with Exception {}",
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

	public ServiceResponseDTO enableDisableClientData(ClientMasterRequestDTO clientMasterRequestDTO, Long clientId) {
		LOGGER.info("client master data in IMasterServiceImpl and enableDisableClientData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (clientMasterRequestDTO != null) {
			Optional<ClientMasterEntity> clientMasterEntity = clientMasterRepository.findById(clientId);
			if (clientMasterEntity.isEmpty()) {
				LOGGER.info("Invalid client for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_CLIENT_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_CLIENT_DOESNT_EXIST_DESC, null);
			}
			ClientMasterEntity entity = clientMasterEntity.get();
			entity.setClientActiveStatus(clientMasterRequestDTO.getClientActiveStatus());
			try {
				entity = clientMasterRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getClientId()));
				LOGGER.info("Client data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableClientData with Exception {}",
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

	public ServiceResponseDTO getAllClientDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllClientDetails process start in IMasterServiceImpl and getAllClientDetails method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<ClientMasterEntity> clientDetailList = clientMasterRepository.findAll(pageable);
		if (clientDetailList.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, clientDetailList);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getClientDetailsById(Long clientId) {
		LOGGER.info(
				"getClientDetailsById process start in IMasterServiceImpl and getClientDetailsById method Executing ");
		Optional<ClientMasterEntity> clientDetail = clientMasterRepository.findById(clientId);
		if (!clientDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, clientDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveVehicleMasterData(VehicleRequestDTO vehicleTyreRequestDTO) {
		LOGGER.info("Vehicle data in IMasterServiceImpl and saveVehicleMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleTyreRequestDTO != null) {
			VehicleMasterEntity entity = new VehicleMasterEntity();
			try {
				if (null != vehicleTyreRequestDTO.getVehicleId()) {
					LOGGER.info(" Need to do Updation (Vehicle exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VEHICLE_ALREADY_EXIST_DESC, null);
				}
				vehicleTyreRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(vehicleTyreRequestDTO, entity);
				entity = vehicleRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getVehicleId()));
				LOGGER.info(" Vehicle Tyre data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveVehicleMasterData with Exception {}",
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

	public ServiceResponseDTO updateVehicleMasterData(VehicleRequestDTO vehicleRequestDTO, Long vehicleId) {
		LOGGER.info("Vehicle data in IMasterServiceImpl and updateVehicleMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleRequestDTO != null) {
			Optional<VehicleMasterEntity> vehicleTyreEntity = vehicleRepository.findById(vehicleId);
			if (vehicleTyreEntity.isEmpty()) {
				LOGGER.info("Invalid Vehicle for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_DOESNT_EXIST_DESC, null);
			}
			VehicleMasterEntity entity = new VehicleMasterEntity();
			vehicleRequestDTO.setVehicleId(vehicleId);
			vehicleRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(vehicleRequestDTO, entity);
			try {
				entity = vehicleRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info(" Vehicle data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateVehicleMasterData with Exception {}",
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

	public ServiceResponseDTO enableDisableVehicleData(VehicleRequestDTO vehicleTyreRequestDTO, Long vehicleId) {
		LOGGER.info("vehicle data in IMasterServiceImpl and enableDisableVehicleData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleTyreRequestDTO != null) {
			Optional<VehicleMasterEntity> vehicleTyreEntity = vehicleRepository.findById(vehicleId);
			if (vehicleTyreEntity.isEmpty()) {
				LOGGER.info("Invalid Vehicle for acvtivation and deactivation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_DOESNT_EXIST_DESC, null);
			}
			VehicleMasterEntity entity = vehicleTyreEntity.get();
			entity.setActiveStatus(vehicleTyreRequestDTO.getActiveStatus());
			try {
				entity = vehicleRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getVehicleId()));
				LOGGER.info(" Vehicle data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableVehicleData with Exception {}",
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

	public ServiceResponseDTO getAllVehicleDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllVehicleDetails process start in IMasterServiceImpl and getAllVehicleDetails method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleMasterEntity> vehicleDetail = vehicleRepository.findAll(pageable);
		if (vehicleDetail.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getVehicleDetailsById(Long vehicleTyreId) {
		LOGGER.info(
				"getVehicleDetailsById process start in IMasterServiceImpl and getVehicleDetailsById method Executing ");
		Optional<VehicleMasterEntity> vehicleDetail = vehicleRepository.findById(vehicleTyreId);
		if (!vehicleDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveTyreMasterData(TyreRequestDTO tyreRequestDTO) {
		LOGGER.info("Tyre data in IMasterServiceImpl and saveTyreMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tyreRequestDTO != null) {
			TyreMasterEntity entity = new TyreMasterEntity();
			try {
				if (null != tyreRequestDTO.getTyreId()) {
					LOGGER.info(" Need to do Updation (Tyre exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_TYRE_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_TYRE_ALREADY_EXIST_DESC, null);
				}
				tyreRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(tyreRequestDTO, entity);
				entity = tyreRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getTyreId()));
				LOGGER.info(" Tyre data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveTyreMasterData with Exception {}",
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

	public ServiceResponseDTO updateTyreMasterData(TyreRequestDTO tyreRequestDTO, Long tyreId) {
		LOGGER.info("Tyre data in IMasterServiceImpl and updateTyreMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tyreRequestDTO != null) {
			Optional<TyreMasterEntity> tyreEntity = tyreRepository.findById(tyreId);
			if (tyreEntity.isEmpty()) {
				LOGGER.info("Invalid Tyre for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_TYRE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_TYRE_DOESNT_EXIST_DESC, null);
			}
			TyreMasterEntity entity = new TyreMasterEntity();
			tyreRequestDTO.setTyreId(tyreId);
			tyreRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(tyreRequestDTO, entity);
			try {
				entity = tyreRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info(" Tyre data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateTyreMasterData with Exception {}",
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

	public ServiceResponseDTO enableDisableTyreData(TyreRequestDTO tyreRequestDTO, Long tyreId) {
		LOGGER.info("Tyre data in IMasterServiceImpl and enableDisableTyreData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tyreRequestDTO != null) {
			Optional<TyreMasterEntity> tyreEntity = tyreRepository.findById(tyreId);
			if (tyreEntity.isEmpty()) {
				LOGGER.info("Invalid Tyre for acvtivation and deactivation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_TYRE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_TYRE_DOESNT_EXIST_DESC, null);
			}
			TyreMasterEntity entity = tyreEntity.get();
			entity.setActiveStatus(tyreRequestDTO.getActiveStatus());
			try {
				entity = tyreRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getTyreId()));
				LOGGER.info("Tyre data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableTyreData with Exception {}",
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

	public ServiceResponseDTO getAllTyreDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info("getAllTyreDetails process start in IMasterServiceImpl and getAllTyreDetails method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<TyreMasterEntity> tyreDetailList = tyreRepository.findAll(pageable);
		if (tyreDetailList.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, tyreDetailList);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getTyreDetailsById(Long vehicleTyreId) {
		LOGGER.info("getTyreDetailsById process start in IMasterServiceImpl and getTyreDetailsById method Executing ");
		Optional<TyreMasterEntity> tyreDetail = tyreRepository.findById(vehicleTyreId);
		if (!tyreDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, tyreDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveDropDownMasterData(DropDownMasterDTO dropDownMasterDTO) {
		LOGGER.info("Drop Down master data in IMasterServiceImpl and saveDropDownMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (dropDownMasterDTO != null) {
			DropDownEntity entity = new DropDownEntity();
			try {
				if (null != dropDownMasterDTO.getDropDownId()) {
					LOGGER.info("Need to do Updation (Drop Down exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_DROP_DOWN_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_DROP_DOWN_ALREADY_EXIST_DESC, null);
				}
				Integer dataCount = checkDropDownAvailablity(dropDownMasterDTO.getDropDownName(),
						dropDownMasterDTO.getDropDownKey(), Long.valueOf(0));
				if (dataCount <= 0) {
					dropDownMasterDTO.setActiveStatus(URLConstants.ACTIVE);
					BeanUtils.copyProperties(dropDownMasterDTO, entity);
					entity = dropDownMasterRepository.save(entity);
					response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
					response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
					response.setResult(new GenericResponseDTO(entity.getDropDownId()));
					LOGGER.info(" Client data saved Successfully");
				} else {
					response.setStatusCode(ResponseKeysValue.DUPLICATE_DROP_DOWN_COMBINATION_CODE);
					response.setStatusDescription(ResponseKeysValue.DUPLICATE_DROP_DOWN_COMBINATION_DESC);
					LOGGER.info("Duplicate data #########");
				}
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveDropDownMasterData with Exception {}",
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

	public ServiceResponseDTO updateDropDownMasterData(DropDownMasterDTO dropDownMasterDTO, Long dropDownId) {
		LOGGER.info("Vehicle Tyre data in IMasterServiceImpl and updateDropDownMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (dropDownMasterDTO != null) {
			Optional<DropDownEntity> dropDownEntity = dropDownMasterRepository.findById(dropDownId);
			if (dropDownEntity.isEmpty()) {
				LOGGER.info(" Invalid Vehicle Tyre for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_DROP_DOWN_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_DROP_DOWN_DOESNT_EXIST_DESC, null);
			}
			Integer dataCount = checkDropDownAvailablity(dropDownMasterDTO.getDropDownName(),
					dropDownMasterDTO.getDropDownKey(), dropDownId);
			if (dataCount <= 0) {
				DropDownEntity entity = new DropDownEntity();
				dropDownMasterDTO.setDropDownId(dropDownId);
				dropDownMasterDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(dropDownMasterDTO, entity);
				try {
					entity = dropDownMasterRepository.save(entity);
					response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
					response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
					response.setResult(entity);
					LOGGER.info(" Vehicle Tyre data update Successfully");
				} catch (Exception ex) {
					LOGGER.error(
							"Exception occur in IMasterServiceImpl calss in method updateDropDownMasterData with Exception {}",
							ex.getMessage());
					response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
					response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
					response.setResult(ex.getMessage());
				}
			} else {
				response.setStatusCode(ResponseKeysValue.DUPLICATE_DROP_DOWN_COMBINATION_CODE);
				response.setStatusDescription(ResponseKeysValue.DUPLICATE_DROP_DOWN_COMBINATION_DESC);
				LOGGER.info("Duplicate data #########");
			}
		} else {
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		return response;
	}

	public ServiceResponseDTO enableDisableDropDownMasterData(DropDownMasterDTO dropDownMasterDTO, Long dropDownId) {
		LOGGER.info("vehicle Tyre data in IMasterServiceImpl and enableDisableVehicleTyreData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (dropDownMasterDTO != null) {
			Optional<DropDownEntity> dropDownEntity = dropDownMasterRepository.findById(dropDownId);
			if (dropDownEntity.isEmpty()) {
				LOGGER.info(" Invalid Drop Down for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_DROP_DOWN_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_DROP_DOWN_DOESNT_EXIST_DESC, null);
			}
			DropDownEntity entity = dropDownEntity.get();
			entity.setActiveStatus(dropDownMasterDTO.getActiveStatus());
			try {
				entity = dropDownMasterRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getDropDownId()));
				LOGGER.info(" Drop Down data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableDropDownMasterData with Exception {}",
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

	public ServiceResponseDTO getAllDropDownMasterDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info("getAllDropDownMasterDetails process start in IMasterServiceImpl");
		PageRequest pageable = null;
		if (size != 0) {
			pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		} else {
			pageable = PageRequest.of(0, Integer.MAX_VALUE);
		}
		Page<DropDownEntity> dropDownDetailList = dropDownMasterRepository.findAll(pageable);
		if (dropDownDetailList.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, dropDownDetailList);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getDropDownMasterDetailsById(Long dropDownId) {
		LOGGER.info("getDropDownMasterDetailsById process start in IMasterServiceImpl ");
		Optional<DropDownEntity> dropDownDetail = dropDownMasterRepository.findById(dropDownId);
		if (!dropDownDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, dropDownDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO checkDropDownAvailable(String dropDownName, String dropDownKey, Long dropDownId) {
		LOGGER.info("checkDropDownAvailable process start in IMasterServiceImpl ");
		Integer dataCount = checkDropDownAvailablity(dropDownName, dropDownKey, dropDownId);
		Map<String, Object> dataAvailable = new HashMap<>();
		dataAvailable.put("dataAvailable", dataCount == 0);
		if (dataCount == 0) {
			return new ServiceResponseDTO(ResponseKeysValue.VALID_DROP_DOWN_DATA_CODE,
					ResponseKeysValue.VALID_DROP_DOWN_DATA_CODE, dataAvailable);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.DUPLICATE_DROP_DOWN_COMBINATION_CODE,
					ResponseKeysValue.DUPLICATE_DROP_DOWN_COMBINATION_DESC, dataAvailable);
		}

	}

	private Integer checkDropDownAvailablity(String dropDownName, String dropDownKey, Long dropDownId) {
		LOGGER.info("checkDropDownAvailablity process start in IMasterServiceImpl ");
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<DropDownEntity> criteriaQuery = criteriaBuilder.createQuery(DropDownEntity.class);
		Root<DropDownEntity> dropDown = criteriaQuery.from(DropDownEntity.class);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(criteriaBuilder.equal(dropDown.get("activeStatus"), 1));
		if (dropDownId != null && dropDownId != 0) {
			predicates.add(criteriaBuilder.notEqual(dropDown.get("dropDownId"), dropDownId));
		}
		if (!StringUtils.isEmpty(dropDownName)) {
			predicates.add(criteriaBuilder.equal(dropDown.get("dropDownName"), dropDownName));
		}
		if (!StringUtils.isEmpty(dropDownKey)) {
			predicates.add(criteriaBuilder.equal(dropDown.get("dropDownKey"), dropDownKey));
		}
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		return entityManager.createQuery(criteriaQuery).getResultList().size();
	}

	public ServiceResponseDTO saveMasterDataListMasterData(MasterDataRequestDTO masterDataRequestDTO) {
		LOGGER.info("Master Data List master data in IMasterServiceImpl and saveMasterDataListMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (masterDataRequestDTO != null) {
			MasterDataListEntity entity = new MasterDataListEntity();
			DropDownEntity dropDownEntity = new DropDownEntity();
			try {
				if (null != masterDataRequestDTO.getDataId()) {
					LOGGER.info(" Need to do Updation (Master Data exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_MASTER_DATA_LIST_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_MASTER_DATA_LIST_ALREADY_EXIST_DESC, null);
				}
				masterDataRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(masterDataRequestDTO, entity);
				dropDownEntity.setDropDownId(masterDataRequestDTO.getDropDownId());
				entity.setDropDownId(dropDownEntity);
				entity.setDataType(masterDataRequestDTO.getDataType());
				entity = masterDataListRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getDataId()));
				LOGGER.info(" Master data List data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveMasterDataListMasterData with Exception {}",
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

	public ServiceResponseDTO updateMasterDataListMasterData(MasterDataRequestDTO masterDataRequestDTO, Long dataId) {
		LOGGER.info("Master Data List master data in IMasterServiceImpl and updateMasterDataListMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (masterDataRequestDTO != null) {
			Optional<MasterDataListEntity> masterDataEntity = masterDataListRepository.findById(dataId);
			if (masterDataEntity.isEmpty()) {
				LOGGER.info(" Invalid master Data for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_MASTER_DATA_LIST_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_MASTER_DATA_LIST_DOESNT_EXIST_DESC, null);
			}
			MasterDataListEntity entity = new MasterDataListEntity();
			DropDownEntity dropDownEntity = new DropDownEntity();
			masterDataRequestDTO.setDataId(dataId);
			masterDataRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(masterDataRequestDTO, entity);
			dropDownEntity.setDropDownId(masterDataRequestDTO.getDropDownId());
			entity.setDropDownId(dropDownEntity);
			entity.setDataType(masterDataRequestDTO.getDataType());
			entity.setDropDownId(dropDownEntity);
			try {
				entity = masterDataListRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info("Master Data List data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateMasterDataListMasterData with Exception {}",
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

	public ServiceResponseDTO enableDisableMasterDataListMasterData(MasterDataRequestDTO masterDataRequestDTO,
			Long dataId) {
		LOGGER.info(
				"Master Data List master data in IMasterServiceImpl and enableDisableMasterDataListMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (masterDataRequestDTO != null) {
			Optional<MasterDataListEntity> masterDataEntity = masterDataListRepository.findById(dataId);
			if (masterDataEntity.isEmpty()) {
				LOGGER.info(" Invalid Master Data List for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_MASTER_DATA_LIST_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_MASTER_DATA_LIST_DOESNT_EXIST_DESC, null);
			}
			MasterDataListEntity entity = masterDataEntity.get();
			entity.setActiveStatus(masterDataRequestDTO.getActiveStatus());
			try {
				entity = masterDataListRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getDataId()));
				LOGGER.info(" Master Data List data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableMasterDataListMasterData with Exception {}",
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

	public ServiceResponseDTO getMasterDataList(String dataType, Long parentId, Integer activeStatus, int pageNumber,
			int size, String sortBy) {
		LOGGER.info("Master data in IMasterServiceImpl and getMasterDataList method");
		PageRequest pageable = null;
		if (size != 0) {
			pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		} else {
			pageable = PageRequest.of(0, Integer.MAX_VALUE);
		}
		Page<MasterDataListEntity> masterList = null;
		if (!StringUtils.isEmpty(dataType)) {
			if (activeStatus == 1 || activeStatus == 0) {
				masterList = masterDataListRepository.findAllByDataTypeAndActiveStatus(dataType, parentId, activeStatus,
						pageable);
			} else {
				masterList = masterDataListRepository.findAllByDataType(dataType, parentId, pageable);
			}
		} else {
			masterList = masterDataListRepository.findAllByActiveStatus(activeStatus, pageable);
		}
		return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
				ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, masterList);
	}

	public ServiceResponseDTO getMasterDataListDetailsById(Long dataId) {
		LOGGER.info("getDropDownMasterDetailsById process start in IMasterServiceImpl ");
		Optional<MasterDataListEntity> masterDataDetailList = masterDataListRepository.findById(dataId);
		if (!masterDataDetailList.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, masterDataDetailList.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO checkMasterDataListAvailable(String dataKey, String dataValue, String dataLabel,
			Long dropDownId, Long dataId) {
		LOGGER.info("checkMasterDataListAvailable process start in IMasterServiceImpl ");
		Integer dataCount = checkMasterDataListAvailablity(dataKey, dataValue, dataLabel, dropDownId, dataId);
		Map<String, Object> dataAvailable = new HashMap<>();
		dataAvailable.put("dataAvailable", dataCount == 0);
		if (dataCount == 0) {
			return new ServiceResponseDTO(ResponseKeysValue.VALID_MASTER_DATA_LIST_CODE,
					ResponseKeysValue.VALID_MASTER_DATA_LIST_DESC, dataAvailable);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.DUPLICATE_MASTER_DATA_LIST_COMBINATION_CODE,
					ResponseKeysValue.DUPLICATE_MASTER_DATA_LIST_COMBINATION_DESC, dataAvailable);
		}
	}

	private Integer checkMasterDataListAvailablity(String dataKey, String dataValue, String dataLabel, Long dropDownId,
			Long dataId) {
		LOGGER.info("checkMasterDataListAvailablity process start in IMasterServiceImpl ");
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MasterDataListEntity> criteriaQuery = criteriaBuilder.createQuery(MasterDataListEntity.class);
		Root<MasterDataListEntity> dropDown = criteriaQuery.from(MasterDataListEntity.class);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(criteriaBuilder.equal(dropDown.get("dropDownId"), dropDownId));
		if (dataId != null && dataId != 0) {
			predicates.add(criteriaBuilder.notEqual(dropDown.get("dataId"), dataId));
		}
		if (!StringUtils.isEmpty(dataKey)) {
			predicates.add(criteriaBuilder.equal(dropDown.get("dataKey"), dataKey));
		}
		if (!StringUtils.isEmpty(dataValue)) {
			predicates.add(criteriaBuilder.equal(dropDown.get("dataValue"), dataValue));
		}
		if (!StringUtils.isEmpty(dataLabel)) {
			predicates.add(criteriaBuilder.equal(dropDown.get("dataLabel"), dataLabel));
		}
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		return entityManager.createQuery(criteriaQuery).getResultList().size();
	}

	public ServiceResponseDTO saveObservationMasterData(ObservationRequestDTO observationRequestDTO) {
		LOGGER.info("Save Observation master data in IMasterServiceImpl and saveObservationMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (observationRequestDTO != null) {
			ObservationEntity entity = new ObservationEntity();
			try {
				if (null != observationRequestDTO.getObservationId()) {
					LOGGER.info("Need to do Updation (observation data exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING__Observation_Master_Data_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_Observation_Master_Data_ALREADY_EXIT_DESC, null);
				}
				observationRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(observationRequestDTO, entity);
				entity = observationRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getObservationId()));
				LOGGER.info("observation data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveObservationMasterData  with Exception {}",
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

	public ServiceResponseDTO updateObservation(ObservationRequestDTO observationRequestDTO, long observationId) {
		LOGGER.info(" Observation data in IMasterServiceImpl and updateObservation method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (observationRequestDTO != null) {
			Optional<ObservationEntity> observationEntity = observationRepository.findById(observationId);
			if (observationEntity.isEmpty()) {
				LOGGER.info(" Invalid observation data for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_OBSERVATION_MASTER_DATA_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_OBSERVATION_MASTER_DATA_DOESNT_EXIT_DESC, null);
			}
			ObservationEntity entity = new ObservationEntity();
			observationRequestDTO.setObservationId(observationId);
			observationRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(observationRequestDTO, entity);
			try {
				entity = observationRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info("Master observation data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateObservation  with Exception {}",
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

	public ServiceResponseDTO enableDisableObservationData(ObservationRequestDTO observationRequestDTO,
			Long observationId) {
		LOGGER.info("observation master data in IMasterServiceImpl and enableDisableObservationMaster method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (observationRequestDTO != null) {
			Optional<ObservationEntity> ObservationEntity = observationRepository.findById(observationId);
			if (ObservationEntity.isEmpty()) {
				LOGGER.info("Invalid observation for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_OBSERVATION_MASTER_DATA_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_OBSERVATION_MASTER_DATA_DOESNT_EXIT_DESC, null);
			}
			ObservationEntity entity = ObservationEntity.get();
			entity.setActiveStatus(observationRequestDTO.getActiveStatus());
			try {
				entity = observationRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getObservationId()));
				LOGGER.info("Observation data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableObservationMasterData with Exception {}",
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

	public ServiceResponseDTO getAllObservationDetials(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllObservationDetials process start in IMasterServiceImpl and getAllObservationDetials method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<ObservationEntity> observationDetail = observationRepository.findAll(pageable);
		if (observationDetail.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, observationDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getObservationDetailsById(Long observationId) {
		LOGGER.info(
				"getObservationDetailsById process start in IMasterServiceImpl and geObservationDetailsById method Executing ");
		Optional<ObservationEntity> observationDetails = observationRepository.findById(observationId);
		if (!observationDetails.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, observationDetails.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveVehicleManufacturerMasterData(
			VehicleManufacturerRequestDTO vehicleManufacturerRequestDTO) {
		LOGGER.info(
				"Save vehicle manufacturer master data in IMasterServiceImpl and  saveVehicleManufacturerMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleManufacturerRequestDTO != null) {
			VehicleManufacturerEntity entity = new VehicleManufacturerEntity();
			try {
				if (null != vehicleManufacturerRequestDTO.getVehicleManufacturerId()) {
					LOGGER.info("Need to do Updation (VehicleManufacturer data exist) ");
					return new ServiceResponseDTO(
							ResponseKeysValue.WARNING__VehicleManufacture_Master_Data_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VehicleManufacture_Master_Data_ALREADY_EXIT_DESC, null);
				}
				vehicleManufacturerRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(vehicleManufacturerRequestDTO, entity);
				entity = vehicleManufacturerRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getVehicleManufacturerId()));
				LOGGER.info("VehicleManufacturer data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method  saveVehicleManufacturerMasterData  with Exception {}",
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

	public ServiceResponseDTO updateVehicleManufacturer(VehicleManufacturerRequestDTO vehicleManufacturerRequestDTO,
			Long vehicleManufacturerId) {

		LOGGER.info("VehicleManufacturer data in IMasterServiceImpl and updateVehicleMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleManufacturerRequestDTO != null) {
			Optional<VehicleManufacturerEntity> vehicleManufacturerEntity = vehicleManufacturerRepository
					.findById(vehicleManufacturerId);
			if (vehicleManufacturerEntity.isEmpty()) {
				LOGGER.info("Invalid VehicleManufacturer for updation");
				return new ServiceResponseDTO(
						ResponseKeysValue.WARNING__VehicleManufacture_Master_Data_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VehicleManufacture_Master_Data_DOESNT_EXIST_DESC, null);
			}
			VehicleManufacturerEntity entity = new VehicleManufacturerEntity();
			vehicleManufacturerRequestDTO.setVehicleManufacturerId(vehicleManufacturerId);
			vehicleManufacturerRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(vehicleManufacturerRequestDTO, entity);
			try {
				entity = vehicleManufacturerRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info(" Vehicle Manufacturer data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateVehicleManufacturer with Exception {}",
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

	public ServiceResponseDTO enableDisableVehicleManufacturerData(
			VehicleManufacturerRequestDTO vehicleManufacturerRequestDTO, Long vehicleManufacturerId) {
		LOGGER.info(" master data in IMasterServiceImpl and enableDisableVehicleManufacturerData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleManufacturerRequestDTO != null) {
			Optional<VehicleManufacturerEntity> vehicleManufacturerEntity = vehicleManufacturerRepository
					.findById(vehicleManufacturerId);
			if (vehicleManufacturerEntity.isEmpty()) {
				LOGGER.info("Invalid  VehicleManufacturer for updation");
				return new ServiceResponseDTO(
						ResponseKeysValue.WARNING__VehicleManufacture_Master_Data_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VehicleManufacture_Master_Data_DOESNT_EXIST_DESC, null);
			}
			VehicleManufacturerEntity entity = vehicleManufacturerEntity.get();
			entity.setActiveStatus(vehicleManufacturerRequestDTO.getActiveStatus());
			try {
				entity = vehicleManufacturerRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getVehicleManufacturerId()));
				LOGGER.info("  VehicleManufacturer data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method  enableDisableVehicleManufactureData with Exception {}",
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

	public ServiceResponseDTO getAllVehicleManufacturerDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllVehicleManufacturerDetails process start in IMasterServiceImpl and getAllVehicleManufacturerDetails method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleManufacturerEntity> vehicleManufactureDetail = vehicleManufacturerRepository.findAll(pageable);
		if (vehicleManufactureDetail.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleManufactureDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getVehicleManufacturerDetailsById(Long vehicleManufacturerId) {
		LOGGER.info(
				"getVehicleManufacturerDetailsById process start in IMasterServiceImpl and getVehicleManufacturerDetailsById method Executing ");
		Optional<VehicleManufacturerEntity> vehicleManufacturerDetail = vehicleManufacturerRepository
				.findById(vehicleManufacturerId);
		if (!vehicleManufacturerDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleManufacturerDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveVehicleTypeMasterData(VehicleTypeRequestDTO vehicleTypeRequestDTO) {
		LOGGER.info("Vehicle Type data in IMasterServiceImpl and saveVehicleTypeMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleTypeRequestDTO != null) {
			VehicleTypeEntity entity = new VehicleTypeEntity();
			try {
				if (null != vehicleTypeRequestDTO.getVehicleTypeId()) {
					LOGGER.info(" Need to do Updation (VehicleType exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_TYPE_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VEHICLE_TYPE_ALREADY_EXIST_DESC, null);
				}
				vehicleTypeRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(vehicleTypeRequestDTO, entity);
				entity = vehicleTypeRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getVehicleTypeId()));
				LOGGER.info(" Vehicle Type data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveVehicleMasterData with Exception {}",
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

	public ServiceResponseDTO updateVehicleTypeMasterData(VehicleTypeRequestDTO vehicleTypeRequestDTO,
			Long vehicleTypeId) {
		LOGGER.info("VehicleType data in IMasterServiceImpl and updateVehicleTypeMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleTypeRequestDTO != null) {
			Optional<VehicleTypeEntity> vehicleTypeEntity = vehicleTypeRepository.findById(vehicleTypeId);
			if (vehicleTypeEntity.isEmpty()) {
				LOGGER.info("Invalid VehicleType for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_TYPE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_TYPE_DOESNT_EXIST_DESC, null);
			}
			VehicleTypeEntity entity = new VehicleTypeEntity();
			vehicleTypeRequestDTO.setVehicleTypeId(vehicleTypeId);
			vehicleTypeRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(vehicleTypeRequestDTO, entity);
			try {
				entity = vehicleTypeRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info(" Vehicle Type data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateVehicleManufacturer with Exception {}",
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

	public ServiceResponseDTO enableDisableVehicleTypeData(VehicleTypeRequestDTO vehicleTypeRequestDTO,
			Long vehicleTypeId) {
		LOGGER.info(" master data in IMasterServiceImpl and enableDisableVehicleTypeData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleTypeRequestDTO != null) {
			Optional<VehicleTypeEntity> vehicleTypeEntity = vehicleTypeRepository.findById(vehicleTypeId);
			if (vehicleTypeEntity.isEmpty()) {
				LOGGER.info("Invalid  VehicleType for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_TYPE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_TYPE_DOESNT_EXIST_DESC, null);

			}
			VehicleTypeEntity entity = vehicleTypeEntity.get();
			entity.setActiveStatus(vehicleTypeRequestDTO.getActiveStatus());
			try {
				entity = vehicleTypeRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getVehicleTypeId()));
				LOGGER.info("  VehicleType data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method  enableDisableVehicleManufactureData with Exception {}",
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

	public ServiceResponseDTO getAllVehicleTypeDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				" getAllVehicleTypeDetails process start in IMasterServiceImpl and getAllVehicleTypeDetails method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleTypeEntity> vehicleTypeDetail = vehicleTypeRepository.findAll(pageable);
		if (vehicleTypeDetail.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleTypeDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getVehicleTypeDetailsById(Long vehicleTypeId) {
		LOGGER.info(
				"getVehicleTypeDetailsById process start in IMasterServiceImpl and getVehicleTypeDetailsById method Executing ");
		Optional<VehicleTypeEntity> vehicleTypeDetail = vehicleTypeRepository.findById(vehicleTypeId);
		if (!vehicleTypeDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleTypeDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveVehicleUsageMasterData(VehicleUsageRequestDTO vehicleUsageRequestDTO) {
		LOGGER.info("Vehicle Usage data in IMasterServiceImpl and saveVehicleUsageMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleUsageRequestDTO != null) {
			VehicleUsageEntity entity = new VehicleUsageEntity();
			try {
				if (null != vehicleUsageRequestDTO.getVehicleUsageId()) {
					LOGGER.info(" Need to do Updation (VehicleUsage exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_USAGE_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VEHICLE_USAGE_ALREADY_EXIST_DESC, null);
				}
				vehicleUsageRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(vehicleUsageRequestDTO, entity);
				entity = vehicleUsageRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getVehicleUsageId()));
				LOGGER.info(" Vehicle Usage data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveVehicleUsageMasterData with Exception {}",
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

	public ServiceResponseDTO updateVehicleUsageMasterData(VehicleUsageRequestDTO vehicleUsageRequestDTO,
			Long vehicleUsageId) {
		LOGGER.info("VehicleUsage data in IMasterServiceImpl and updateVehicleUsageMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleUsageRequestDTO != null) {
			Optional<VehicleUsageEntity> vehicleUsageEntity = vehicleUsageRepository.findById(vehicleUsageId);
			if (vehicleUsageEntity.isEmpty()) {
				LOGGER.info("Invalid VehicleUsage for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_USAGE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_USAGE_DOESNT_EXIST_DESC, null);
			}
			VehicleUsageEntity entity = new VehicleUsageEntity();
			vehicleUsageRequestDTO.setVehicleUsageId(vehicleUsageId);
			vehicleUsageRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(vehicleUsageRequestDTO, entity);
			try {
				entity = vehicleUsageRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info(" Vehicle Usage data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateVehicleUsage with Exception {}",
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

	public ServiceResponseDTO enableDisableVehicleUsageData(VehicleUsageRequestDTO vehicleUsageRequestDTO,
			Long vehicleUsageId) {
		LOGGER.info(" master data in IMasterServiceImpl and enableDisableVehicleUsageData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleUsageRequestDTO != null) {
			Optional<VehicleUsageEntity> vehicleUsageEntity = vehicleUsageRepository.findById(vehicleUsageId);
			if (vehicleUsageEntity.isEmpty()) {
				LOGGER.info("Invalid  VehicleUsage for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_USAGE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_USAGE_DOESNT_EXIST_DESC, null);

			}
			VehicleUsageEntity entity = vehicleUsageEntity.get();
			entity.setActiveStatus(vehicleUsageRequestDTO.getActiveStatus());
			try {
				entity = vehicleUsageRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getVehicleUsageId()));
				LOGGER.info("  VehicleUsage data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method  enableDisableVehicleUsageData with Exception {}",
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

	public ServiceResponseDTO getAllVehicleUsageDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				" getAllVehicleUsageDetails process start in IMasterServiceImpl and getAllVehicleUsageDetails method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleUsageEntity> vehicleUsageDetail = vehicleUsageRepository.findAll(pageable);
		if (vehicleUsageDetail.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleUsageDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getVehicleUsageDetailsById(Long vehicleUsageId) {
		LOGGER.info(
				"getVehicleUsageDetailsById process start in IMasterServiceImpl and getVehicleUsageDetailsById method Executing ");
		Optional<VehicleUsageEntity> vehicleUsageDetail = vehicleUsageRepository.findById(vehicleUsageId);
		if (!vehicleUsageDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleUsageDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveVehicleSubTypeData(VehicleSubTypeRequestDTO vehicleSubTypeRequestDTO) {
		LOGGER.info("VehicleSub Type Data List master data in IMasterServiceImpl and saveVehicleSubTypeData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleSubTypeRequestDTO != null) {
			VehicleSubTypeEntity entity = new VehicleSubTypeEntity();
			VehicleTypeEntity vehicleTypeEntity = new VehicleTypeEntity();
			try {
				if (null != vehicleSubTypeRequestDTO.getVehicleSubTypeId()) {
					LOGGER.info(" Need to do Updation (VehicleSubType Data exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_SUB_TYPE_DATA__ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VEHICLE_SUB_TYPE_DATA__ALREADY_EXIST_DESC, null);
				}
				vehicleSubTypeRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(vehicleSubTypeRequestDTO, entity);
				vehicleTypeEntity.setVehicleTypeId(vehicleSubTypeRequestDTO.getVehicleTypeId());
				entity.setVehicleTypeId(vehicleTypeEntity);
				entity.setVehicleSubTypeName(vehicleSubTypeRequestDTO.getVehiclesubTypeName());
				entity = vehicleSubTypeRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getVehicleSubTypeId()));
				LOGGER.info(" Master data List data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveVehicleSubTypeData with Exception {}",
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

	public ServiceResponseDTO updateVehicleSubTypeMasterData(VehicleSubTypeRequestDTO vehicleSubTypeRequestDTO,
			Long vehicleSubTypeId) {
		LOGGER.info(
				"VehiclesubTypeMaster Data List master data in IMasterServiceImpl and updateVehicleSubTypeMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleSubTypeRequestDTO != null) {
			Optional<VehicleSubTypeEntity> vehicleSubTypeEntity = vehicleSubTypeRepository.findById(vehicleSubTypeId);
			if (vehicleSubTypeEntity.isEmpty()) {
				LOGGER.info(" Invalid Vehicle master Data for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_SUB_TYPE_DATA__DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_SUB_TYPE_DATA__DOESNT_EXIST_DESC, null);
			}
			VehicleSubTypeEntity entity = new VehicleSubTypeEntity();
			VehicleTypeEntity vehicleTypeEntity = new VehicleTypeEntity();
			vehicleSubTypeRequestDTO.setVehicleSubTypeId(vehicleSubTypeId);
			vehicleSubTypeRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(vehicleSubTypeRequestDTO, entity);
			vehicleTypeEntity.setVehicleTypeId(vehicleSubTypeRequestDTO.getVehicleTypeId());
			entity.setVehicleTypeId(vehicleTypeEntity);
			entity.setVehicleSubTypeName(vehicleSubTypeRequestDTO.getVehiclesubTypeName());
			entity.setVehicleTypeId(vehicleTypeEntity);
			try {
				entity = vehicleSubTypeRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info("VehicleMaster Data List data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateVehicleSubTypeMasterData with Exception {}",
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

	public ServiceResponseDTO enableDisableVehicleSubTypeMaster(VehicleSubTypeRequestDTO vehicleSubTypeRequestDTO,
			Long vehicleSubTypeId) {
		LOGGER.info(
				"Vehicle Master Data  master data in IMasterServiceImpl and  enableDisableVehicleSubTypeMaster method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleSubTypeRequestDTO != null) {
			Optional<VehicleSubTypeEntity> vehicleSubTypeEntity = vehicleSubTypeRepository.findById(vehicleSubTypeId);
			if (vehicleSubTypeEntity.isEmpty()) {
				LOGGER.info(" Invalid  Vehicle Master Data List for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_SUB_TYPE_DATA__DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_SUB_TYPE_DATA__DOESNT_EXIST_DESC, null);

			}
			VehicleSubTypeEntity entity = vehicleSubTypeEntity.get();
			entity.setActiveStatus(vehicleSubTypeRequestDTO.getActiveStatus());
			try {
				entity = vehicleSubTypeRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getVehicleSubTypeId()));
				LOGGER.info(" Vehicle Master Data List data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableVehicleSubTypeMaster with Exception {}",
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

	public ServiceResponseDTO getVehicleSubTypeMasterData(int pageNumber, int size, String sortBy) {
		LOGGER.info("Vechile Master data in IMasterServiceImpl and getVehicleSubTypeMasterData method");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleSubTypeEntity> vehicleSubTypeDetails = vehicleSubTypeRepository.findAll(pageable);
		if (vehicleSubTypeDetails.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleSubTypeDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}

	}

	public ServiceResponseDTO getVehicleMasterDataById(Long vehicleSubTypeId) {
		LOGGER.info("getVehicleMasterDataById  process start in IMasterServiceImpl ");
		Optional<VehicleSubTypeEntity> vehicleSubTypeEntity = vehicleSubTypeRepository.findById(vehicleSubTypeId);
		if (!vehicleSubTypeEntity.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleSubTypeEntity.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}

	}

	public ServiceResponseDTO saveTireMakeMasterData(TireMakeRequestDTO tireMakeRequestDTO) {
		LOGGER.info("TireMake master data in IMasterServiceImpl and saveTireMakeMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tireMakeRequestDTO != null) {
			TireMakeEntity tireMakeEntity = new TireMakeEntity();
			try {
				if (null != tireMakeRequestDTO.getTireMakeId()) {
					LOGGER.info("Need to do Updation (Tire Make exist)");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_TIRE_MAKE_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_TIRE_MAKE_ALREADY_EXIST_DESC, null);
				}
				tireMakeRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(tireMakeRequestDTO, tireMakeEntity);
				tireMakeEntity = tireMakeRepository.save(tireMakeEntity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(tireMakeEntity.getTireMakeId()));
				LOGGER.info("Tire Make data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveTireMakeMasterData with Exception {}",
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

	public ServiceResponseDTO updateTireMakeMasterData(TireMakeRequestDTO tireMakeRequestDTO, Long tireMakeId) {
		LOGGER.info("	TireMake data in IMasterServiceImpl and updateTireMakeMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tireMakeRequestDTO != null) {
			Optional<TireMakeEntity> tireMakeEntity = tireMakeRepository.findById(tireMakeId);
			if (tireMakeEntity.isEmpty()) {
				LOGGER.info("Invalid TireMake for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_TIRE_MAKE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_TIRE_MAKE_DOESNT_EXIST_DESC, null);

			}
			TireMakeEntity entity = new TireMakeEntity();
			tireMakeRequestDTO.setTireMakeId(tireMakeId);
			tireMakeRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(tireMakeRequestDTO, entity);
			try {
				entity = tireMakeRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info(" TireMake Usage data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method  with Exception updateTireMakeMasterData{}",
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

	public ServiceResponseDTO enableDisableTireMakeData(TireMakeRequestDTO tireMakeRequestDTO, Long tireMakeId) {
		LOGGER.info("Tire Make master data in IMasterServiceImpl and enableDisableTireMakeData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tireMakeRequestDTO != null) {
			Optional<TireMakeEntity> tireMakeEntity = tireMakeRepository.findById(tireMakeId);
			if (tireMakeEntity.isEmpty()) {
				LOGGER.info("Invalid 	TireMake for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_TIRE_MAKE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_TIRE_MAKE_DOESNT_EXIST_DESC, null);

			}
			TireMakeEntity entity = tireMakeEntity.get();
			entity.setActiveStatus(tireMakeRequestDTO.getActiveStatus());
			try {
				entity = tireMakeRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getTireMakeId()));
				LOGGER.info("Tire Make data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method with enableDisableTireMakeData Exception {}",
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

	public ServiceResponseDTO getTireMakeTypeMasterData(int pageNumber, int size, String sortBy) {
		LOGGER.info("TireMake Master data in IMasterServiceImpl and getTireMakeTypeMasterData method");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<TireMakeEntity> tireMakeDetails = tireMakeRepository.findAll(pageable);
		if (tireMakeDetails.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, tireMakeDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getTireMakeDetailsById(Long tireMakeId) {
		LOGGER.info("getTireMakeDataById  process start in IMasterServiceImpl ");
		Optional<TireMakeEntity> tireMakeEntity = tireMakeRepository.findById(tireMakeId);
		if (!tireMakeEntity.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, tireMakeEntity.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveVehicleModelTypeData(VehicleModelRequestDTO vehicleModelRequestDTO) {
		LOGGER.info(
				"VehicleModel Type Data List master data in IMasterServiceImpl and saveVehicleModelDataType method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleModelRequestDTO != null) {
			VehicleModelEntity entity = new VehicleModelEntity();
			VehicleManufacturerEntity vehicleManufacturerEntity = new VehicleManufacturerEntity();
			try {
				if (null != vehicleModelRequestDTO.getVehicleModelId()) {
					LOGGER.info(" Need to do Updation (VehicleModelType Data exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_MODEL_TYPE_DATA__ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VEHICLE_MODEL_TYPE_DATA__ALREADY_EXIST_DESC, null);
				}
				vehicleModelRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(vehicleModelRequestDTO, entity);
				vehicleManufacturerEntity.setVehicleManufacturerId(vehicleModelRequestDTO.getVehicleManufacturerId());
				entity.setVehicleManufacturerId(vehicleManufacturerEntity);
				entity.setVehicleModelName(vehicleModelRequestDTO.getVehicleModelName());
				entity = vehicleModelRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getVehicleModelId()));
				LOGGER.info(" Master data List data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveVehicleModelTypeData with Exception {}",
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

	public ServiceResponseDTO updateVehicleModelTypeMasterData(VehicleModelRequestDTO vehicleModelRequestDTO,
			Long vehicleModelId) {
		LOGGER.info(
				"VehicleModelMaster Data List master data in IMasterServiceImpl and updateVehicleModelMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleModelRequestDTO != null) {
			Optional<VehicleModelEntity> vehicleModelEntity = vehicleModelRepository.findById(vehicleModelId);
			if (vehicleModelEntity.isEmpty()) {
				LOGGER.info(" Invalid Vehicle Model Master Data for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_MODEL_TYPE_DATA__DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_MODEL_TYPE_DATA__DOESNT_EXIST_DESC, null);
			}
			VehicleModelEntity entity = new VehicleModelEntity();
			VehicleManufacturerEntity vehicleManufacturerEntity = new VehicleManufacturerEntity();
			vehicleModelRequestDTO.setVehicleModelId(vehicleModelId);
			vehicleModelRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(vehicleModelRequestDTO, entity);
			vehicleManufacturerEntity.setVehicleManufacturerId(vehicleModelRequestDTO.getVehicleManufacturerId());
			entity.setVehicleManufacturerId(vehicleManufacturerEntity);
			try {
				entity = vehicleModelRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info("VehicleModelMaster Data List data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateVehicleMpodel with Exception {}",
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

	public ServiceResponseDTO enableDisableVehicleModelTypeMaster(VehicleModelRequestDTO vehicleModelRequestDTO,
			Long vehicleModelId) {
		LOGGER.info(
				"Vehicle Model Master Data  master data in IMasterServiceImpl and  enableDisableVehicleModelTypeMaster method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleModelRequestDTO != null) {
			Optional<VehicleModelEntity> vehicleModelEntity = vehicleModelRepository.findById(vehicleModelId);
			if (vehicleModelEntity.isEmpty()) {
				LOGGER.info(" Invalid  Vehicle Model Master Data List for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_MODEL_TYPE_DATA__DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_MODEL_TYPE_DATA__DOESNT_EXIST_DESC, null);

			}
			VehicleModelEntity entity = vehicleModelEntity.get();
			entity.setActiveStatus(vehicleModelRequestDTO.getActiveStatus());
			try {
				entity = vehicleModelRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getVehicleModelId()));
				LOGGER.info(" Vehicle Model Master Data List data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableVehicleModelMaster with Exception {}",
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

	public ServiceResponseDTO getVehicleModelMasterData(int pageNumber, int size, String sortBy) {
		LOGGER.info("Vechile Model Master data in IMasterServiceImpl and getVehicleModelMasterData method");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleModelEntity> vehicleModelDetails = vehicleModelRepository.findAll(pageable);
		if (vehicleModelDetails.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleModelDetails);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}

	}

	public ServiceResponseDTO getVehicleModelDataById(Long vehicleModelId) {
		LOGGER.info("getVehicleModelDataById  process start in IMasterServiceImpl ");
		Optional<VehicleModelEntity> vehicleModelEntity = vehicleModelRepository.findById(vehicleModelId);
		if (!vehicleModelEntity.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleModelEntity.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}

	}

	public ServiceResponseDTO saveObservationCategoryMasterData(
			ObservationCategoryRequestDTO observationCategoryRequestDTO) {
		LOGGER.info("Save Observation Category master data in IMasterServiceImpl and saveObservationMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (observationCategoryRequestDTO != null) {
			ObservationCategoryEntity entity = new ObservationCategoryEntity();
			try {
				if (null != observationCategoryRequestDTO.getObservationCategoryId()) {
					LOGGER.info("Need to do Updation (observation data exist) ");
					return new ServiceResponseDTO(
							ResponseKeysValue.WARNING__OBSERVATION_CATEGORY_MASTER_DATA_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING__OBSERVATION_CATEGORY_MASTER_DATA_ALREADY_EXIST_DESC, null);
				}
				observationCategoryRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(observationCategoryRequestDTO, entity);
				entity = observationCategoryRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getObservationCategoryId()));
				LOGGER.info("observation Category data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveObservationCategoryMasterData  with Exception {}",
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

	public ServiceResponseDTO updateObservationCategoryMaster(
			ObservationCategoryRequestDTO observationCategoryRequestDTO, long observationCategoryId) {
		LOGGER.info(" ObservationCategory data in IMasterServiceImpl and updateObservation method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (observationCategoryRequestDTO != null) {
			Optional<ObservationCategoryEntity> observationCategoryEntity = observationCategoryRepository
					.findById(observationCategoryId);
			if (observationCategoryEntity.isEmpty()) {
				LOGGER.info(" Invalid observationCategory data for updation ");
				return new ServiceResponseDTO(
						ResponseKeysValue.WARNING_OBSERVATION_CATEGORY_MASTER_DATA_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_OBSERVATION_CATEGORY_MASTER_DATA_DOESNT_EXIT_DESC, null);
			}
			ObservationCategoryEntity entity = new ObservationCategoryEntity();
			observationCategoryRequestDTO.setObservationCategoryId(observationCategoryId);
			observationCategoryRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(observationCategoryRequestDTO, entity);
			try {
				entity = observationCategoryRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info("Master observation Category data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateObservationCategoryMaster  with Exception {}",
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

	public ServiceResponseDTO enableDisableObservationCategoryData(
			ObservationCategoryRequestDTO observationCategoryRequestDTO, Long observationCategoryId) {
		LOGGER.info(
				"observationCategory  master data in IMasterServiceImpl and enableDisableObservationCategoryMaster method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (observationCategoryRequestDTO != null) {
			Optional<ObservationCategoryEntity> ObservationCategoryEntity = observationCategoryRepository
					.findById(observationCategoryId);
			if (ObservationCategoryEntity.isEmpty()) {
				LOGGER.info("Invalid observationCategory for updation");
				return new ServiceResponseDTO(
						ResponseKeysValue.WARNING_OBSERVATION_CATEGORY_MASTER_DATA_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_OBSERVATION_CATEGORY_MASTER_DATA_DOESNT_EXIT_DESC, null);
			}
			ObservationCategoryEntity entity = ObservationCategoryEntity.get();
			entity.setActiveStatus(observationCategoryRequestDTO.getActiveStatus());
			try {
				entity = observationCategoryRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getObservationCategoryId()));
				LOGGER.info("ObservationCategory data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableObservationCategoryMasterData with Exception {}",
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

	public ServiceResponseDTO getAllObservationCategoryDetials(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllObservationCategoryDetials process start in IMasterServiceImpl and getAllObservationCategoryDetials method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<ObservationCategoryEntity> observationCategoryDetail = observationCategoryRepository.findAll(pageable);
		if (observationCategoryDetail.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, observationCategoryDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getObservationCategoryDetailsById(Long observationCategoryId) {
		LOGGER.info(
				"getObservationCategoryDetailsById process start in IMasterServiceImpl and geObservationCategoryDetailsById method Executing ");
		Optional<ObservationCategoryEntity> observationCategoryDetails = observationCategoryRepository
				.findById(observationCategoryId);
		if (!observationCategoryDetails.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, observationCategoryDetails.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO saveTireConfigurationMaster(TireConfigurationRequestDTO tireConfigurationRequestDTO) {
		LOGGER.info(
				"Tire Configuratrion Sub Type Data List master data in IMasterServiceImpl and saveTireConfiguration method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tireConfigurationRequestDTO != null) {
			TireConfigurationEntity entity = new TireConfigurationEntity();
			TireMakeEntity tireMakeEntity = new TireMakeEntity();
			try {
				if (null != tireConfigurationRequestDTO.getTireConfigurationId()) {
					LOGGER.info(" Need to do Updation (TireConfigurationType Data exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_TIRE_CONFIGURATION_DATA_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_TIRE_CONFIGURATION_DATA_ALREADY_EXIST_DESC, null);
				}
				tireConfigurationRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(tireConfigurationRequestDTO, entity);
				tireMakeEntity.setTireMakeId(tireConfigurationRequestDTO.getTireMakeId());
				entity.setTireMakeId(tireMakeEntity);
				entity.setTireType(tireConfigurationRequestDTO.getTireType());
				entity = tireConfigurationRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getTireConfigurationId()));
				LOGGER.info(" Master data List data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveVehicleSubTypeData with Exception {}",
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

	public ServiceResponseDTO updateTireConfigurationMaster(TireConfigurationRequestDTO tireConfigurationRequestDTO,
			Long tireConfigurationId) {
		LOGGER.info(
				"TireConfiguration  Data List master data in IMasterServiceImpl and updateTireConfigurationMaster method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tireConfigurationRequestDTO != null) {
			Optional<TireConfigurationEntity> tireConfigurationEntity = tireConfigurationRepository
					.findById(tireConfigurationId);
			if (tireConfigurationEntity.isEmpty()) {
				LOGGER.info(" Invalid TireConfiguration master Data for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_TIRE_CONFIGURATION_DATA__DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_TIRE_CONFIGURATION_DATA__DOESNT_EXIST_DESC, null);
			}
			TireConfigurationEntity entity = new TireConfigurationEntity();
			TireMakeEntity tireMakeEntity = new TireMakeEntity();
			tireConfigurationRequestDTO.setTireConfigurationId(tireConfigurationId);
			tireConfigurationRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(tireConfigurationRequestDTO, entity);
			tireMakeEntity.setTireMakeId(tireConfigurationRequestDTO.getTireMakeId());
			entity.setTireMakeId(tireMakeEntity);
			entity.setTireType(tireConfigurationRequestDTO.getTireType());
			entity.setTireMakeId(tireMakeEntity);
			try {
				entity = tireConfigurationRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info("Tire Configuration Master Data List data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateTireConfigurationMaster with Exception {}",
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

	public ServiceResponseDTO enableDisableTireConfigurationMaster(
			TireConfigurationRequestDTO tireConfigurationRequestDTO, Long tireConfigurationId) {
		LOGGER.info(
				"TireConfiguration  Master Data  master data in IMasterServiceImpl and  enableDisableTireConfiguration method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (tireConfigurationRequestDTO != null) {
			Optional<TireConfigurationEntity> tireConfigurationEntity = tireConfigurationRepository
					.findById(tireConfigurationId);
			if (tireConfigurationEntity.isEmpty()) {
				LOGGER.info(" Invalid  Tire Configuration Master Data List for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_TIRE_CONFIGURATION_DATA__DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_TIRE_CONFIGURATION_DATA__DOESNT_EXIST_DESC, null);

			}
			TireConfigurationEntity entity = tireConfigurationEntity.get();
			entity.setActiveStatus(tireConfigurationRequestDTO.getActiveStatus());
			try {
				entity = tireConfigurationRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getTireConfigurationId()));
				LOGGER.info(" Tire Configuration  Master Data List data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableTireConfigurationMaster  with Exception {}",
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

	public ServiceResponseDTO getAllTireConfigurationDetials(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllTireConfigurationDetials process start in IMasterServiceImpl and getTireConfigurationDetials method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<TireConfigurationEntity> tireConfigurationDetail = tireConfigurationRepository.findAll(pageable);
		if (tireConfigurationDetail.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, tireConfigurationDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getTireConfigurationById(Long tireConfigurationId) {
		LOGGER.info(
				"getTireConfigurationById process start in IMasterServiceImpl and getTireConfigurationById method Executing ");
		Optional<TireConfigurationEntity> tireConfigurationDetails = tireConfigurationRepository
				.findById(tireConfigurationId);
		if (!tireConfigurationDetails.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, tireConfigurationDetails.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

}
