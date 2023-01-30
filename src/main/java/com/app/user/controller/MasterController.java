package com.app.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.user.constants.URLConstants;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.ClientMasterRequestDTO;
import com.app.user.service.impl.IMasterServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = URLConstants.MASTER_SERVICE)
public class MasterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	private IMasterServiceImpl masterServiceImpl;

	@PostMapping(value = URLConstants.SAVE_CLIENT)
	public ServiceResponseDTO createClient(@RequestBody ClientMasterRequestDTO clientMasterRequestDTO) {
		LOGGER.info("Executing  createClient() method of MasterController");
		return masterServiceImpl.saveClientMasterData(clientMasterRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_CLIENT)
	public ServiceResponseDTO updateClient(@RequestParam(name = "clientId") Long clientId,
			@RequestBody ClientMasterRequestDTO clientMasterRequestDTO) {
		LOGGER.info("Executing  updateClient() method of MasterController");
		return masterServiceImpl.updateClientMasterData(clientMasterRequestDTO, clientId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_CLIENT)
	public ServiceResponseDTO enableDisableClient(@RequestParam(name = "clientId") Long clientId,
			@RequestBody ClientMasterRequestDTO clientMasterRequestDTO) {
		LOGGER.info("Executing  updateClient() method of MasterController");
		return masterServiceImpl.enableDisableClientData(clientMasterRequestDTO, clientId);
	}

	@GetMapping(value = URLConstants.GET_ALL_CLIENT)
	public ServiceResponseDTO getAllClientDetails(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "clientId") String sortBy) {
		LOGGER.info("Executing  getAllClientDetails() method of MasterController");
		return masterServiceImpl.getAllClientDetails(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_CLIENT_BY_ID)
	public ServiceResponseDTO getClientDetail(@RequestParam(name = "clientId") Long clientId) {
		LOGGER.info("Executing  getClientDetail() method of MasterController");
		return masterServiceImpl.getClientDetailsById(clientId);
	}

	@GetMapping(value = URLConstants.GET_MASTER_DATA_LIST)
	public ServiceResponseDTO getMasterDataList(@RequestParam(name = "datatype") String dataType,
			@RequestParam(name = "parentId", defaultValue = "0") Long parentId,
			@RequestParam(name = "activeStatus", defaultValue = "1") Integer activeStatus) {
		LOGGER.info("Executing  getMasterDataList() method of MasterController");
		return masterServiceImpl.getMasterDataList(dataType, parentId, activeStatus);
	}

}
