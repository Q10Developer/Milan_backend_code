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
import com.app.user.dto.response.GenericResponseDTO;
import com.app.user.entity.ClientMasterEntity;
import com.app.user.entity.MasterDataListEntity;
import com.app.user.repository.ClientMasterRepository;
import com.app.user.repository.MasterDataListRepository;

@Service
public class IMasterServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IMasterServiceImpl.class);

	@Autowired
	private ClientMasterRepository clientMasterRepository;

	@Autowired
	private MasterDataListRepository masterDataListRepository;

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
				LOGGER.error("Exception occur in IMasterServiceImpl calss in method saveUserData with Exception {}",
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

}
