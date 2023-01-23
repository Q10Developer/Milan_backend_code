package com.app.user.service.impl;

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
import com.app.user.repository.ClientMasterRepository;

@Service
public class IMasterServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IMasterServiceImpl.class);

	@Autowired
	private ClientMasterRepository clientMasterRepository;

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

}
