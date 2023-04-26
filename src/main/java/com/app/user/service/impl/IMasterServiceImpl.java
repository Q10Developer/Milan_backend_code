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
import com.app.user.dto.request.ObservationRequestDTO;
import com.app.user.dto.request.TyreRequestDTO;
import com.app.user.dto.request.VehicleRequestDTO;
import com.app.user.dto.response.GenericResponseDTO;
import com.app.user.entity.ClientMasterEntity;
import com.app.user.entity.DropDownEntity;
import com.app.user.entity.MasterDataListEntity;
import com.app.user.entity.ObservationEntity;
import com.app.user.entity.TyreMasterEntity;
import com.app.user.entity.VehicleMasterEntity;
import com.app.user.repository.ClientMasterRepository;
import com.app.user.repository.DropDownMasterRepository;
import com.app.user.repository.MasterDataListRepository;
import com.app.user.repository.ObservatioRepository;
import com.app.user.repository.TyreRepository;
import com.app.user.repository.VehicleRepository;

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
	
	public ServiceResponseDTO saveObservationMasterData(ObservationRequestDTO observationrequestDTO) {
		LOGGER.info("Save Observation master data in IMasterServiceImpl and saveObservationMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (observationrequestDTO!= null) {
		ObservationEntity entity = new ObservationEntity();
		try {
				if (null !=observationrequestDTO.getObservationId()) {
					LOGGER.info("Need to do Updation (observation data exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING__Observation_Master_Data_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_Observation_Master_Data_ALREADY_EXIT_DESC, null);
				}
				 observationrequestDTO.setActiveStatus(URLConstants.ACTIVE);
					BeanUtils.copyProperties(observationrequestDTO, entity);
					entity = observationRepository.save(entity);
					response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
					response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
					response.setResult(new GenericResponseDTO(entity.getObservationId()));
					LOGGER.info("observation data saved Successfully");
			}
			catch (Exception ex) {
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
	public ServiceResponseDTO updateObservation (ObservationRequestDTO observationrequestDTO,long observationId ) {
		LOGGER.info(" Observation data in IMasterServiceImpl and updateObservation method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (observationrequestDTO!= null) {
			Optional<ObservationEntity> observationEntity = observationRepository.findById(observationId);
			if (ObservationEntity.isEmpty())
			{
				LOGGER.info(" Invalid observation data for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING__Observation_Master_Data_ALREADY_EXIST_CODE,
						ResponseKeysValue.WARNING_Observation_Master_Data_ALREADY_EXIT_DESC, null);
			}
			ObservationEntity entity = new 	ObservationEntity ();
			observationrequestDTO.setObservationId(observationId);
			observationrequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(observationrequestDTO, entity);
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
	
	public ServiceResponseDTO enableDisableObservationData(ObservationRequestDTO observationrequestDTO,Long observationId)
	{
		LOGGER.info("observation master data in IMasterServiceImpl and enableDisableObservationMaster method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if ( observationrequestDTO!= null) {
			Optional<ObservationEntity> ObservationEntity= observationRepository.findById(observationId);
			if (ObservationEntity.isEmpty()) {
				LOGGER.info("Invalid observation for updation");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING__Observation_Master_Data_ALREADY_EXIST_CODE,
						ResponseKeysValue.WARNING_Observation_Master_Data_ALREADY_EXIT_DESC, null);
			}
			ObservationEntity entity = ObservationEntity.get();
			entity.setActiveStatus(observationrequestDTO.getActiveStatus());
			try {
				entity = observationRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getObservationId ()));
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
		if ( observationDetail.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, observationDetail);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}
	
	public ServiceResponseDTO getObservationDetailsById(Long  observationId) {
		LOGGER.info("getObservationDetailsById process start in IMasterServiceImpl and geObservationDetailsById method Executing ");
		Optional<ObservationEntity> observationDetails= observationRepository.findById(observationId);
		if (!observationDetails.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, observationDetails.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}
	
	
	
	
	
	
	
	
	
	
}