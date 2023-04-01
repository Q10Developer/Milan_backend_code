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
import com.app.user.dto.request.DropDownMasterDTO;
import com.app.user.dto.request.MasterDataRequestDTO;
import com.app.user.dto.request.TyreRequestDTO;
import com.app.user.dto.request.VehicleRequestDTO;
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
		LOGGER.info("Executing  enableDisableClient() method of MasterController");
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

	@PostMapping(value = URLConstants.SAVE_VEHICLE)
	public ServiceResponseDTO createVehicle(@RequestBody VehicleRequestDTO vehicleTyreRequestDTO) {
		LOGGER.info("Executing  createVehicle() method of MasterController");
		return masterServiceImpl.saveVehicleMasterData(vehicleTyreRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_VEHICLE)
	public ServiceResponseDTO updateVehicle(@RequestParam(name = "vehicleId") Long vehicleId,
			@RequestBody VehicleRequestDTO vehicleTyreRequestDTO) {
		LOGGER.info("Executing  updateVehicle() method of MasterController");
		return masterServiceImpl.updateVehicleMasterData(vehicleTyreRequestDTO, vehicleId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_VEHICLE)
	public ServiceResponseDTO enableDisableVehicle(@RequestParam(name = "vehicleId") Long vehicleId,
			@RequestBody VehicleRequestDTO vehicleTyreRequestDTO) {
		LOGGER.info("Executing  enableDisableVehicle() method of MasterController");
		return masterServiceImpl.enableDisableVehicleData(vehicleTyreRequestDTO, vehicleId);
	}

	@GetMapping(value = URLConstants.GET_ALL_VEHICLE)
	public ServiceResponseDTO getAllVehicleDetails(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "vehicleId") String sortBy) {
		LOGGER.info("Executing  getAllVehicleDetails() method of MasterController");
		return masterServiceImpl.getAllVehicleDetails(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_BY_ID)
	public ServiceResponseDTO getVehicleDetail(@RequestParam(name = "vehicleId") Long vehicleTyreId) {
		LOGGER.info("Executing  getVehicleDetail() method of MasterController");
		return masterServiceImpl.getVehicleDetailsById(vehicleTyreId);
	}

	@PostMapping(value = URLConstants.SAVE_TYRE)
	public ServiceResponseDTO createTyre(@RequestBody TyreRequestDTO tyreRequestDTO) {
		LOGGER.info("Executing  createTyre() method of MasterController");
		return masterServiceImpl.saveTyreMasterData(tyreRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_TYRE)
	public ServiceResponseDTO updateTyre(@RequestParam(name = "tyreId") Long tyreId,
			@RequestBody TyreRequestDTO tyreRequestDTO) {
		LOGGER.info("Executing  updateTyre() method of MasterController");
		return masterServiceImpl.updateTyreMasterData(tyreRequestDTO, tyreId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_TYRE)
	public ServiceResponseDTO enableDisableTyre(@RequestParam(name = "tyreId") Long tyreId,
			@RequestBody TyreRequestDTO tyreRequestDTO) {
		LOGGER.info("Executing  enableDisableTyre() method of MasterController");
		return masterServiceImpl.enableDisableTyreData(tyreRequestDTO, tyreId);
	}

	@GetMapping(value = URLConstants.GET_ALL_TYRE)
	public ServiceResponseDTO getAllTyreDetails(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "tyreId") String sortBy) {
		LOGGER.info("Executing  getAllTyreDetails() method of MasterController");
		return masterServiceImpl.getAllTyreDetails(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_TYRE_BY_ID)
	public ServiceResponseDTO getTyreDetail(@RequestParam(name = "tyreId") Long tyreId) {
		LOGGER.info("Executing  getTyreDetail() method of MasterController");
		return masterServiceImpl.getTyreDetailsById(tyreId);
	}

	@PostMapping(value = URLConstants.SAVE_DROP_DOWN_MASTER)
	public ServiceResponseDTO saveDropDownMaster(@RequestBody DropDownMasterDTO dropDownMasterDTO) {
		LOGGER.info("Executing  saveDropDownMaster() method of MasterController");
		return masterServiceImpl.saveDropDownMasterData(dropDownMasterDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_DROP_DOWN_MASTER)
	public ServiceResponseDTO updateDropDownMaster(@RequestParam(name = "dropDownId") Long dropDownId,
			@RequestBody DropDownMasterDTO dropDownMasterDTO) {
		LOGGER.info("Executing  updateDropDownMaster() method of MasterController");
		return masterServiceImpl.updateDropDownMasterData(dropDownMasterDTO, dropDownId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_DROP_DOWN_MASTER)
	public ServiceResponseDTO enableDisableDropDownMaster(@RequestParam(name = "dropDownId") Long dropDownId,
			@RequestBody DropDownMasterDTO dropDownMasterDTO) {
		LOGGER.info("Executing  enableDisableDropDownMaster() method of MasterController");
		return masterServiceImpl.enableDisableDropDownMasterData(dropDownMasterDTO, dropDownId);
	}

	@GetMapping(value = URLConstants.GET_ALL_DROP_DOWN_MASTER)
	public ServiceResponseDTO getAllDropDownMasterList(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "dropDownId") String sortBy) {
		LOGGER.info("Executing  getAllDropDownMasterList() method of MasterController");
		return masterServiceImpl.getAllDropDownMasterDetails(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_DROP_DOWN_MASTER_BY_ID)
	public ServiceResponseDTO getDropDownMasterDetail(@RequestParam(name = "dropDownId") Long dropDownId) {
		LOGGER.info("Executing  getDropDownMasterDetail() method of MasterController");
		return masterServiceImpl.getDropDownMasterDetailsById(dropDownId);
	}

	@GetMapping(value = URLConstants.CHECK_DROP_DOWN_MASTER_DUPLICATE)
	public ServiceResponseDTO checkDropDownMasterDuplicate(
			@RequestParam(name = "dropDownName", defaultValue = "") String dropDownName,
			@RequestParam(name = "dropDownKey", defaultValue = "") String dropDownKey,
			@RequestParam(name = "dropDownId", defaultValue = "0") Long dropDownId) {
		LOGGER.info("Executing  checkDropDownMasterDuplicate() method of MasterController");
		return masterServiceImpl.checkDropDownAvailable(dropDownName, dropDownKey, dropDownId);
	}

	@PostMapping(value = URLConstants.SAVE_MASTER_DATA_LIST_MASTER)
	public ServiceResponseDTO saveMasterDataListMaster(@RequestBody MasterDataRequestDTO masterDataRequestDTO) {
		LOGGER.info("Executing  createClient() method of MasterController");
		return masterServiceImpl.saveMasterDataListMasterData(masterDataRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_MASTER_DATA_LIST_MASTER)
	public ServiceResponseDTO updateMasterDataListMaster(@RequestParam(name = "dataId") Long dataId,
			@RequestBody MasterDataRequestDTO masterDataRequestDTO) {
		LOGGER.info("Executing  updateDropDownMaster() method of MasterController");
		return masterServiceImpl.updateMasterDataListMasterData(masterDataRequestDTO, dataId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_MASTER_DATA_LIST_MASTER)
	public ServiceResponseDTO enableDisableMasterDataListMaster(@RequestParam(name = "dataId") Long dataId,
			@RequestBody MasterDataRequestDTO masterDataRequestDTO) {
		LOGGER.info("Executing  enableDisableMasterDataListMaster() method of MasterController");
		return masterServiceImpl.enableDisableMasterDataListMasterData(masterDataRequestDTO, dataId);
	}

	@GetMapping(value = URLConstants.GET_MASTER_DATA_LIST)
	public ServiceResponseDTO getMasterDataList(@RequestParam(name = "datatype", defaultValue = "") String dataType,
			@RequestParam(name = "parentId", defaultValue = "0") Long parentId,
			@RequestParam(name = "activeStatus", defaultValue = "1") Integer activeStatus,
			@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "dataId") String sortBy) {
		LOGGER.info("Executing  getMasterDataList() method of MasterController");
		return masterServiceImpl.getMasterDataList(dataType, parentId, activeStatus, pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_MASTER_DATA_BY_ID)
	public ServiceResponseDTO getMasterDataListDetail(@RequestParam(name = "dataId") Long dataId) {
		LOGGER.info("Executing  getMasterDataListDetail() method of MasterController");
		return masterServiceImpl.getMasterDataListDetailsById(dataId);
	}

	@GetMapping(value = URLConstants.CHECK_MASTER_DATA_LIST_DUPLICATE)
	public ServiceResponseDTO checkMasterDataListDuplicate(
			@RequestParam(name = "dataKey", defaultValue = "") String dataKey,
			@RequestParam(name = "dataValue", defaultValue = "") String dataValue,
			@RequestParam(name = "dataLabel", defaultValue = "") String dataLabel,
			@RequestParam(name = "dropDownId") Long dropDownId,
			@RequestParam(name = "dataId", defaultValue = "0") Long dataId) {
		LOGGER.info("Executing  checkMasterDataListDuplicate() method of MasterController");
		return masterServiceImpl.checkMasterDataListAvailable(dataKey, dataValue, dataLabel, dropDownId, dataId);
	}
}