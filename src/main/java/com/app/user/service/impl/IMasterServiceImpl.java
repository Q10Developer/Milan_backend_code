package com.app.user.service.impl;

import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.user.constants.ResponseKeysValue;
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
			BeanUtils.copyProperties(clientMasterRequestDTO, entity);
			try {
				if (null != clientMasterRequestDTO.getClientId()) {
					LOGGER.info(" Need to do Updation (Client exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_CLIENT_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_CLIENT_ALREADY_EXIST_DESC, null);
				}
				entity = clientMasterRepository.save(entity);
				response.setResult(new GenericResponseDTO(entity.getClientId()));
				LOGGER.info(" User data save/update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IUserRegistrationServiceImpl calss in method saveUserData with Exception {}",
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
			BeanUtils.copyProperties(clientMasterRequestDTO, entity);
			try {
				entity = clientMasterRepository.save(entity);
				response.setResult(new GenericResponseDTO(entity.getClientId()));
				LOGGER.info(" User data save/update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IUserRegistrationServiceImpl calss in method saveUserData with Exception {}",
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

	public ServiceResponseDTO getMasterDataList(String dataType, String activeStatus) {
		LOGGER.info("client master data in IMasterServiceImpl and updateClientMasterData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		List<MasterDataListEntity> masterList = null;
		if (!StringUtils.isEmpty(dataType)) {
			if (activeStatus.equalsIgnoreCase("1") || activeStatus.equalsIgnoreCase("0")) {
				masterList = masterDataListRepository.findAllByDataTypeAndActiveStatus(dataType,
						Integer.valueOf(activeStatus));
			} else {
				masterList = masterDataListRepository.findAllByDataType(dataType);
			}
		} else {
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		response.setResult(masterList);
		return response;
	}

}
