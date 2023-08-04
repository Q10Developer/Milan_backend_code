package com.app.user.entity;

import org.springframework.stereotype.Component;
import com.app.user.dto.request.ClientMasterRequestDTO;
import com.app.user.dto.request.ClientServiceLocationRequestDTO;

@Component
public class ClientDataMapper {

	public ClientMasterEntity fromClientDataDTOToEntity(ClientMasterRequestDTO clientMasterRequestDTO) {
		ClientMasterEntity entity = new ClientMasterEntity();
		entity.setClientId(clientMasterRequestDTO.getClientId());
		entity.setClientTitle(clientMasterRequestDTO.getClientTitle());
		entity.setClientFirstName(clientMasterRequestDTO.getClientFirstName());
		entity.setClientMiddleName(clientMasterRequestDTO.getClientMiddleName());
		entity.setClientLastName(clientMasterRequestDTO.getClientLastName());
		entity.setClientCompanyName(clientMasterRequestDTO.getClientCompanyName());
		entity.setClientEmailId(clientMasterRequestDTO.getClientEmailId());
		entity.setClientWebsite(clientMasterRequestDTO.getClientWebsite());
		entity.setClientMobileNo(clientMasterRequestDTO.getClientMobileNo());
		entity.setClientPhoneNo(clientMasterRequestDTO.getClientPhoneNo());
		entity.setGstRegistrationType(clientMasterRequestDTO.getGstRegistrationType());
		entity.setClientGstNumber(clientMasterRequestDTO.getClientGstNumber());
		entity.setClientPanNumber(clientMasterRequestDTO.getClientPanNumber());
		entity.setClientBillingAddress(clientMasterRequestDTO.getClientBillingAddress());
		entity.setClientBillingState(clientMasterRequestDTO.getClientBillingState());
		entity.setClientBillingCity(clientMasterRequestDTO.getClientBillingCity());
		entity.setClientBillingCountry(clientMasterRequestDTO.getClientBillingCountry());
		entity.setClientBillingPincode(clientMasterRequestDTO.getClientBillingPincode());
		entity.setClientActiveStatus(clientMasterRequestDTO.getClientActiveStatus());
		return entity;
	}

	public ClientServiceLocationEntity fromClientServiceLocationDTOToEntity(
			ClientServiceLocationRequestDTO clientServiceLocationRequestDTO) {
		ClientServiceLocationEntity entity = new ClientServiceLocationEntity();
		if (clientServiceLocationRequestDTO.getClientServiceLocationId() != null
				&& clientServiceLocationRequestDTO.getClientServiceLocationId() != 0) {
			entity.setClientServiceLocationId(clientServiceLocationRequestDTO.getClientServiceLocationId());
		}
		entity.setClientServiceAddress(clientServiceLocationRequestDTO.getClientServiceAddress());
		entity.setClientServicePincode(clientServiceLocationRequestDTO.getClientServicePincode());
		entity.setClientServiceCity(clientServiceLocationRequestDTO.getClientServiceCity());
		entity.setClientServiceState(clientServiceLocationRequestDTO.getClientServiceState());
		entity.setClientServiceCountry(clientServiceLocationRequestDTO.getClientServiceCountry());
		return entity;
	}

}
