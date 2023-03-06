package com.app.user.service.impl;

import java.util.List;
import java.util.Optional;
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
import com.app.user.dto.request.VehicleTyreRequestDTO;
import com.app.user.dto.response.GenericResponseDTO;
import com.app.user.entity.ClientMasterEntity;
import com.app.user.entity.DropDownEntity;
import com.app.user.entity.MasterDataListEntity;
import com.app.user.entity.VehicleTyreMasterEntity;
import com.app.user.repository.ClientMasterRepository;
import com.app.user.repository.DropDownMasterRepository;
import com.app.user.repository.MasterDataListRepository;
import com.app.user.repository.VehicleTyreRepository;

@Service
public class IMasterServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IMasterServiceImpl.class);

	@Autowired
	private ClientMasterRepository clientMasterRepository;

	@Autowired
	private VehicleTyreRepository vehicleTyreRepository;

	@Autowired
	private MasterDataListRepository masterDataListRepository;

	@Autowired
	private DropDownMasterRepository dropDownMasterRepository;

	public ServiceResponseDTO saveClientMasterData(ClientMasterRequestDTO clientMasterRequestDTO) {
		LOGGER.info("client master data in IMasterServiceImpl and saveClientMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (clientMasterRequestDTO != null) {
			ClientMasterEntity entity = new ClientMasterEntity();
			try {
				if (null != clientMasterRequestDTO.getClientId()) {
					LOGGER.info(" Need to do Updation (Client exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_CLIENT_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_CLIENT_ALREADY_EXIST_DESC, null);
				}
				clientMasterRequestDTO.setClientActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(clientMasterRequestDTO, entity);
				entity = clientMasterRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getClientId()));
				LOGGER.info(" Client data saved Successfully");
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
				LOGGER.info(" Invalid client for updation ");
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
				LOGGER.info(" Client data update Successfully");
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
				LOGGER.info(" Invalid client for updation ");
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
				LOGGER.info(" Client data enabled or disabled Successfully");
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

	public ServiceResponseDTO saveVehicleTyreMasterData(VehicleTyreRequestDTO vehicleTyreRequestDTO) {
		LOGGER.info("Vehicle Tyre data in IMasterServiceImpl and saveVehicleTyreMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleTyreRequestDTO != null) {
			VehicleTyreMasterEntity entity = new VehicleTyreMasterEntity();
			try {
				if (null != vehicleTyreRequestDTO.getVehicleTyreId()) {
					LOGGER.info(" Need to do Updation (Vehicle Tyre exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_TYRE_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_VEHICLE_TYRE_ALREADY_EXIST_DESC, null);
				}
				vehicleTyreRequestDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(vehicleTyreRequestDTO, entity);
				entity = vehicleTyreRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getVehicleTyreId()));
				LOGGER.info(" Vehicle Tyre data saved Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method saveVehicleTyreMasterData with Exception {}",
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

	public ServiceResponseDTO updateVehicleTyreMasterData(VehicleTyreRequestDTO vehicleTyreRequestDTO,
			Long vehicleTyreId) {
		LOGGER.info("Vehicle Tyre data in IMasterServiceImpl and updateVehicleTyreMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleTyreRequestDTO != null) {
			Optional<VehicleTyreMasterEntity> vehicleTyreEntity = vehicleTyreRepository.findById(vehicleTyreId);
			if (vehicleTyreEntity.isEmpty()) {
				LOGGER.info(" Invalid Vehicle Tyre for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_TYRE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_TYRE_DOESNT_EXIST_DESC, null);
			}
			VehicleTyreMasterEntity entity = new VehicleTyreMasterEntity();
			vehicleTyreRequestDTO.setVehicleTyreId(vehicleTyreId);
			vehicleTyreRequestDTO.setActiveStatus(URLConstants.ACTIVE);
			BeanUtils.copyProperties(vehicleTyreRequestDTO, entity);
			try {
				entity = vehicleTyreRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(entity);
				LOGGER.info(" Vehicle Tyre data update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method updateVehicleTyreMasterData with Exception {}",
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

	public ServiceResponseDTO enableDisableVehicleTyreData(VehicleTyreRequestDTO vehicleTyreRequestDTO,
			Long vehicleTyreId) {
		LOGGER.info("vehicle Tyre data in IMasterServiceImpl and enableDisableVehicleTyreData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (vehicleTyreRequestDTO != null) {
			Optional<VehicleTyreMasterEntity> vehicleTyreEntity = vehicleTyreRepository.findById(vehicleTyreId);
			if (vehicleTyreEntity.isEmpty()) {
				LOGGER.info(" Invalid Vehicle Tyre for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_TYRE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_TYRE_DOESNT_EXIST_DESC, null);
			}
			VehicleTyreMasterEntity entity = vehicleTyreEntity.get();
			entity.setActiveStatus(vehicleTyreRequestDTO.getActiveStatus());
			try {
				entity = vehicleTyreRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200);
				response.setResult(new GenericResponseDTO(entity.getVehicleTyreId()));
				LOGGER.info(" Vehicle Tyre data enabled or disabled Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IMasterServiceImpl calss in method enableDisableVehicleTyreData with Exception {}",
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

	public ServiceResponseDTO getAllVehicleTyreDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllVehicleTyreDetails process start in IMasterServiceImpl and getAllVehicleTyreDetails method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<VehicleTyreMasterEntity> vehicleTyreDetailList = vehicleTyreRepository.findAll(pageable);
		if (vehicleTyreDetailList.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleTyreDetailList);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getVehicleTyreDetailsById(Long vehicleTyreId) {
		LOGGER.info(
				"getVehicleTyreDetailsById process start in IMasterServiceImpl and getClientDetailsById method Executing ");
		Optional<VehicleTyreMasterEntity> vehicleTyreDetail = vehicleTyreRepository.findById(vehicleTyreId);
		if (!vehicleTyreDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, vehicleTyreDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getMasterDataList(String dataType, Long parentId, Integer activeStatus) {
		LOGGER.info("Master data in IMasterServiceImpl and getMasterDataList method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		List<MasterDataListEntity> masterList = null;
		if (!StringUtils.isEmpty(dataType)) {
			if (activeStatus == 1 || activeStatus == 0) {
				masterList = masterDataListRepository.findAllByDataTypeAndActiveStatus(dataType, parentId,
						activeStatus);
			} else {
				masterList = masterDataListRepository.findAllByDataType(dataType, parentId);
			}
		} else {
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		response.setResult(masterList);
		return response;
	}

	public ServiceResponseDTO saveDropDownMasterData(DropDownMasterDTO dropDownMasterDTO) {
		LOGGER.info("Drop Down master data in IMasterServiceImpl and saveDropDownMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (dropDownMasterDTO != null) {
			DropDownEntity entity = new DropDownEntity();
			try {
				if (null != dropDownMasterDTO.getDropDownId()) {
					LOGGER.info(" Need to do Updation (Client exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_CLIENT_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_CLIENT_ALREADY_EXIST_DESC, null);
				}
				dropDownMasterDTO.setActiveStatus(URLConstants.ACTIVE);
				BeanUtils.copyProperties(dropDownMasterDTO, entity);
				entity = dropDownMasterRepository.save(entity);
				response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
				response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
				response.setResult(new GenericResponseDTO(entity.getDropDownId()));
				LOGGER.info(" Client data saved Successfully");
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
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_TYRE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_TYRE_DOESNT_EXIST_DESC, null);
			}
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
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		return response;
	}

	public ServiceResponseDTO enableDisableDropDownMasterData(DropDownMasterDTO dropDownMasterDTO, Long vehicleTyreId) {
		LOGGER.info("vehicle Tyre data in IMasterServiceImpl and enableDisableVehicleTyreData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (dropDownMasterDTO != null) {
			Optional<DropDownEntity> dropDownEntity = dropDownMasterRepository.findById(vehicleTyreId);
			if (dropDownEntity.isEmpty()) {
				LOGGER.info(" Invalid Drop Down for updation ");
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_VEHICLE_TYRE_DOESNT_EXIST_CODE,
						ResponseKeysValue.WARNING_VEHICLE_TYRE_DOESNT_EXIST_DESC, null);
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
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
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
}