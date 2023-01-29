package com.app.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ServiceResponseDTO updateClient(@PathVariable Long clientId,
			@RequestBody ClientMasterRequestDTO clientMasterRequestDTO) {
		LOGGER.info("Executing  updateClient() method of MasterController");
		return masterServiceImpl.updateClientMasterData(clientMasterRequestDTO, clientId);
	}

	@GetMapping(value = URLConstants.GET_MASTER_DATA_LIST)
	public ServiceResponseDTO getMasterDataList(@RequestParam(name = "datatype") String dataType,
			@RequestParam(name = "activeStatus") String activeStatus) {
		LOGGER.info("Executing  getMasterDataList() method of MasterController");
		return masterServiceImpl.getMasterDataList(dataType, activeStatus);
	}

}
