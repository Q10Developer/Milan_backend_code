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
import com.app.user.dto.request.ClientVehicleRequestDTO;
import com.app.user.dto.request.DropDownMasterDTO;
import com.app.user.dto.request.LoginRequestDTO;
import com.app.user.dto.request.MasterDataRequestDTO;
import com.app.user.dto.request.ObservationCategoryRequestDTO;
import com.app.user.dto.request.ObservationRequestDTO;
import com.app.user.dto.request.TireConfigurationRequestDTO;
import com.app.user.dto.request.TireMakeRequestDTO;
import com.app.user.dto.request.TirePatternRequestDTO;
import com.app.user.dto.request.TyreRequestDTO;
import com.app.user.dto.request.VehicleManufacturerRequestDTO;
import com.app.user.dto.request.VehicleModelRequestDTO;
import com.app.user.dto.request.VehicleRequestDTO;
import com.app.user.dto.request.VehicleSubTypeRequestDTO;
import com.app.user.dto.request.VehicleTypeRequestDTO;
import com.app.user.dto.request.VehicleUsageRequestDTO;
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

	
	
	@GetMapping(value = URLConstants.GET_CLIENT_SERVICE_LOCATION_BY_CLIENT_ID)
	public ServiceResponseDTO getClientServiceLocationDetail(@RequestParam(name = "clientId") Long clientId) {
		LOGGER.info("Executing  getClientServiceLocationDetail() method of MasterController");
		return masterServiceImpl.getClientServiceLocationDetailsByClientId(clientId);
	}

	@GetMapping(value = URLConstants.GET_ALL_CLIENT_BY_MULTIPLE_FILTERS)
	public ServiceResponseDTO getAllClientDetailsByMultipleFilter(
			@RequestParam(name = "clientFullName", required = false, defaultValue = "") String clientFullName,
			@RequestParam(name = "clientCompanyName", required = false, defaultValue = "") String clientCompanyName,
			@RequestParam(name = "clientEmailId", required = false, defaultValue = "") String clientEmailId,
			@RequestParam(name = "clientId", required = false, defaultValue = "") Long clientId) {
		LOGGER.info("Executing  getAllClientDetailsByMultipleFilter() method of MasterController");
		return masterServiceImpl.getAllClientDetailsByFilters(clientFullName, clientCompanyName, clientEmailId,
				clientId);
	}

	
	@PostMapping(value = URLConstants.CLIENT_LOGIN_USER)
	public ServiceResponseDTO clientLoginUser(@RequestBody  ClientMasterRequestDTO clientMasterRequestDTO ) {
		LOGGER.info("Executing  clientLoginUser() method of MasterController");
		return  masterServiceImpl.userClientLogin(clientMasterRequestDTO);
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

	@GetMapping(value = URLConstants.GET_VEHICLE_BY_MULTIPLE_FILTER)
	public ServiceResponseDTO getVehicleDetailsByMultipleFilter(
			@RequestParam(name = "vehicleManufacturer", required = false, defaultValue = "0") Long vehicleManufacturer,
			@RequestParam(name = "vehicleModel", required = false, defaultValue = "0") Long vehicleModel,
			@RequestParam(name = "vehicleType", required = false, defaultValue = "0") Long vehicleType) {
		LOGGER.info("Executing  getVehicleDetailsByMultipleFilter() method of MasterController");
		return masterServiceImpl.getVehicleDetailsByMultipleFilter(vehicleManufacturer, vehicleModel, vehicleType);
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

	@PostMapping(value = URLConstants.SAVE_OBSERVATION_MASTER)
	public ServiceResponseDTO saveObservation(@RequestBody ObservationRequestDTO observationRequestDTO) {
		LOGGER.info("Executing  saveObservation() method of MasterController");
		return masterServiceImpl.saveObservationMasterData(observationRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_OBSERVATION_MASTER)
	public ServiceResponseDTO updateObservation(@RequestParam(name = "observationId") Long observationId,
			@RequestBody ObservationRequestDTO observationRequestDTO) {
		LOGGER.info("Executing  updateObservation() method of MasterController");
		return masterServiceImpl.updateObservation(observationRequestDTO, observationId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_OBSERVATION_MASTER)
	public ServiceResponseDTO enableDisableObservationMaster(@RequestParam(name = "observationId") Long observationId,
			@RequestBody ObservationRequestDTO observationRequestDTO) {
		LOGGER.info("Executing  enableDisableObservationMaster() method of MasterController");
		return masterServiceImpl.enableDisableObservationData(observationRequestDTO, observationId);
	}

	@GetMapping(value = URLConstants.GET_ALL_OBSERVATION)
	public ServiceResponseDTO getAllObservationDetails(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "observationId") String sortBy) {
		LOGGER.info("Executing  getAllObservationDetails() method of MasterController");
		return masterServiceImpl.getAllObservationDetials(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_OBSERVATION_DATA_BY_ID)
	public ServiceResponseDTO getObservationmasterDetail(@RequestParam(name = "observationId") Long observationId) {
		LOGGER.info("Executing  getObservationmasterDetail() method of MasterController");
		return masterServiceImpl.getObservationDetailsById(observationId);
	}

	@PostMapping(value = URLConstants.SAVE_VEHICLE_MANUFACTURER_MASTER)
	public ServiceResponseDTO saveVehicleManufacturer(
			@RequestBody VehicleManufacturerRequestDTO vehicleManufacturerRequestDTO) {
		LOGGER.info("Executing saveVehicleManufacturerr() method of MasterController");
		return masterServiceImpl.saveVehicleManufacturerMasterData(vehicleManufacturerRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_VEHICLE_MANUFACTURER_MASTER)
	public ServiceResponseDTO updateVehicleManufacturer(
			@RequestParam(name = "vehicleManufacturerId") Long vehicleManufacturerId,
			@RequestBody VehicleManufacturerRequestDTO vehicleManufacturerRequestDTO) {
		LOGGER.info("Executing  updateVehicleManufacturer() method of MasterController");
		return masterServiceImpl.updateVehicleManufacturer(vehicleManufacturerRequestDTO, vehicleManufacturerId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_VEHICLE_MANUFACTURER_MASTER)
	public ServiceResponseDTO enableDisableVehicleManufacturerMaster(
			@RequestParam(name = "vehicleManufacturerId") Long vehicleManufacturerId,
			@RequestBody VehicleManufacturerRequestDTO vehicleManufacturerRequestDTO) {
		LOGGER.info("Executing  enableDisableVehicleManufacturerMaster() method of MasterController");
		return masterServiceImpl.enableDisableVehicleManufacturerData(vehicleManufacturerRequestDTO,
				vehicleManufacturerId);
	}

	@GetMapping(value = URLConstants.GET_ALL_VEHICLE_MANUFACTURER)
	public ServiceResponseDTO getAllVehicleManufacturDetails(
			@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "vehicleManufacturerId") String sortBy) {
		LOGGER.info("Executing  getAllVehicleManufacturerDetails() method of MasterController");
		return masterServiceImpl.getAllVehicleManufacturerDetails(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_MANUFACTURER_BY_ID)
	public ServiceResponseDTO getVehicleManufacturerDetails(
			@RequestParam(name = "vehicleManufacturerId") Long vehicleManufacturerId) {
		LOGGER.info("Executing  getVehicleManufacturerDetails() method of MasterController");
		return masterServiceImpl.getVehicleManufacturerDetailsById(vehicleManufacturerId);
	}

	@PostMapping(value = URLConstants.SAVE_VEHICLE_TYPE)
	public ServiceResponseDTO saveVehicleType(@RequestBody VehicleTypeRequestDTO vehicleTypeRequestDTO) {
		LOGGER.info("Executing  saveVehicleType() method of MasterController");
		return masterServiceImpl.saveVehicleTypeMasterData(vehicleTypeRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_VEHICLE_TYPE)
	public ServiceResponseDTO updateVehicleType(@RequestParam(name = "vehicleTypeId") Long vehicleTypeId,
			@RequestBody VehicleTypeRequestDTO vehicleTypeRequestDTO) {
		LOGGER.info("Executing updateVehicleType() method of masterController");
		return masterServiceImpl.updateVehicleTypeMasterData(vehicleTypeRequestDTO, vehicleTypeId);

	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_VEHICLE_TYPE_MASTER)
	public ServiceResponseDTO enableDisableVehicleTypeMaster(@RequestParam(name = "vehicleTypeId") Long vehicleTypeId,
			@RequestBody VehicleTypeRequestDTO vehicleTypeRequestDTO) {
		LOGGER.info("Executing  enableDisableVehicleTypeMaster() method of MasterController");
		return masterServiceImpl.enableDisableVehicleTypeData(vehicleTypeRequestDTO, vehicleTypeId);
	}

	@GetMapping(value = URLConstants.GET_ALL_VEHICLE_TYPE)
	public ServiceResponseDTO getAllVehicleTypeDetails(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "vehicleTypeId") String sortBy) {
		LOGGER.info("Executing  getAllVehicleTypeDetails() method of MasterController");
		return masterServiceImpl.getAllVehicleTypeDetails(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_TYPE_BY_ID)
	public ServiceResponseDTO getVehicleTypeDetails(@RequestParam(name = "vehicleTypeId") Long vehicleTypeId) {
		LOGGER.info("Executing  getVehicleTypeDetails() method of MasterController");
		return masterServiceImpl.getVehicleTypeDetailsById(vehicleTypeId);
	}

	@PostMapping(value = URLConstants.SAVE_VEHICLE_USAGE_MASTER)
	public ServiceResponseDTO saveVehicleUsage(@RequestBody VehicleUsageRequestDTO vehicleUsageRequestDTO) {
		LOGGER.info("Executing  saveVehicleUsage() method of MasterController");
		return masterServiceImpl.saveVehicleUsageMasterData(vehicleUsageRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_VEHICLE_USAGE_MASTER)
	public ServiceResponseDTO updateVehicleUsage(@RequestParam(name = "vehicleUsageId") Long vehicleUsageId,
			@RequestBody VehicleUsageRequestDTO vehicleUsageRequestDTO) {
		LOGGER.info("Executing updateVehicleUsage() method of masterController");
		return masterServiceImpl.updateVehicleUsageMasterData(vehicleUsageRequestDTO, vehicleUsageId);

	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_VEHICLE_USAGE_MASTER)
	public ServiceResponseDTO enableDisableVehicleUsageMaster(
			@RequestParam(name = "vehicleUsageId") Long vehicleUsageId,
			@RequestBody VehicleUsageRequestDTO vehicleUsageRequestDTO) {
		LOGGER.info("Executing  enableDisableVehicleUsageMaster() method of MasterController");
		return masterServiceImpl.enableDisableVehicleUsageData(vehicleUsageRequestDTO, vehicleUsageId);
	}

	@GetMapping(value = URLConstants.GET_ALL_VEHICLE_USAGE)
	public ServiceResponseDTO getAllVehicleUsageDetails(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "vehicleUsageId") String sortBy) {
		LOGGER.info("Executing  getAllVehicleUsageDetails() method of MasterController");
		return masterServiceImpl.getAllVehicleUsageDetails(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_USAGE_BY_ID)
	public ServiceResponseDTO getVehicleUsageDetails(@RequestParam(name = "vehicleUsageId") Long vehicleUsageId) {
		LOGGER.info("Executing  getVehicleUsageDetails() method of MasterController");
		return masterServiceImpl.getVehicleUsageDetailsById(vehicleUsageId);
	}

	@PostMapping(value = URLConstants.SAVE_VEHICLE_SUB_TYPE_MASTER)
	public ServiceResponseDTO saveVehicleSubTypeMaster(@RequestBody VehicleSubTypeRequestDTO vehicleSubTypeRequestDTO) {
		LOGGER.info("Executing saveVehicleSubTypeMaster() method of MasterController");
		return masterServiceImpl.saveVehicleSubTypeData(vehicleSubTypeRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_VEHICLE_SUB_TYPE_MASTER)
	public ServiceResponseDTO updateVehicleSubTypeMaster(@RequestParam(name = "vehicleSubTypeId") Long vehicleSubTypeId,
			@RequestBody VehicleSubTypeRequestDTO vehicleSubTypeRequestDTO) {
		LOGGER.info("Executing  updateVehicleSubTypeMaster() method of MasterController");
		return masterServiceImpl.updateVehicleSubTypeMasterData(vehicleSubTypeRequestDTO, vehicleSubTypeId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_VEHICLE_SUB_TYPE_MASTER)
	public ServiceResponseDTO enableDisableVehicleSubTypeMaster(
			@RequestParam(name = "vehicleSubTypeId") Long vehicleSubTypeId,
			@RequestBody VehicleSubTypeRequestDTO vehicleSubTypeRequestDTO) {
		LOGGER.info("Executing  enableDisableVehicleSubTypeMaster() method of MasterController");
		return masterServiceImpl.enableDisableVehicleSubTypeMaster(vehicleSubTypeRequestDTO, vehicleSubTypeId);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_SUB_TYPE_MASTER_DATA)
	public ServiceResponseDTO getVehicleSubTypeMasterData(
			@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "vehicleSubTypeId") String sortBy,
			@RequestParam(name = "vehicleTypeId", defaultValue = "0") int vehicleTypeId) {
		LOGGER.info("Executing  getVehicleSubTypeMasterData method of MasterController");
		return masterServiceImpl.getVehicleSubTypeMasterData(pageNumber, size, sortBy, vehicleTypeId);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_SUB_TYPE_MASTER_DATA_BY_ID)
	public ServiceResponseDTO getVehicleSubTypeMasterDataById(
			@RequestParam(name = "vehicleSubTypeId") Long vehicleSubTypeId) {
		LOGGER.info("Executing  getVehicleSubTypeMasterDataById() method of MasterController");
		return masterServiceImpl.getVehicleMasterDataById(vehicleSubTypeId);
	}

	@PostMapping(value = URLConstants.SAVE_TIRE_MAKE_MASTER)
	public ServiceResponseDTO saveTireMakeMaster(@RequestBody TireMakeRequestDTO tireMakeRequestDTO) {
		LOGGER.info("Executing saveTireMakeMaster() method of MasterController");
		return masterServiceImpl.saveTireMakeMasterData(tireMakeRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_TIRE_MAKE_MASTER)
	public ServiceResponseDTO updateTireMake(@RequestParam(name = "tireMakeId") Long tireMakeId,
			@RequestBody TireMakeRequestDTO tireMakeRequestDTO) {
		LOGGER.info("Executing updateTireMake() method of MasterController");
		return masterServiceImpl.updateTireMakeMasterData(tireMakeRequestDTO, tireMakeId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_TIRE_MAKE_USAGE_MASTER)
	public ServiceResponseDTO enableDisableTireMakeMaster(@RequestParam(name = "tireMakeId") Long tireMakeId,
			@RequestBody TireMakeRequestDTO tireMakeRequestDTO) {
		LOGGER.info("Executing enableDisableTireMakeMaster() method of MasterController");
		return masterServiceImpl.enableDisableTireMakeData(tireMakeRequestDTO, tireMakeId);
	}

	@GetMapping(value = URLConstants.GET_TIRE_MAKE_TYPE_MASTER_DATA)
	public ServiceResponseDTO getTireMakeTypeMasterData(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "tireMakeId") String sortBy) {
		LOGGER.info("Executing  getTireMakeTypeMasterData method of MasterController");
		return masterServiceImpl.getTireMakeTypeMasterData(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_TIRE_MAKE_BY_ID)
	public ServiceResponseDTO getTireMakeDetails(@RequestParam(name = "tireMakeId") Long tireMakeId) {
		LOGGER.info("Executing  getTireMakeDetails() method of MasterController");
		return masterServiceImpl.getTireMakeDetailsById(tireMakeId);
	}

	@PostMapping(value = URLConstants.SAVE_VEHICLE_MODEL_MASTER)
	public ServiceResponseDTO saveVehicleModelMaster(@RequestBody VehicleModelRequestDTO vehicleModelRequestDTO) {
		LOGGER.info("Executing saveVehicleModelMaster() method of MasterController");
		return masterServiceImpl.saveVehicleModelTypeData(vehicleModelRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_VEHICLE_MODEL_MASTER)
	public ServiceResponseDTO updateVehicleModelMaster(
			@RequestParam(name = "vehicleModelTypeId") Long vehicleModelTypeId,
			@RequestBody VehicleModelRequestDTO vehicleModelRequestDTO) {
		LOGGER.info("Executing  updateVehicleModelTypeMaster() method of MasterController");
		return masterServiceImpl.updateVehicleModelTypeMasterData(vehicleModelRequestDTO, vehicleModelTypeId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_VEHICLE_MODEL_MASTER)
	public ServiceResponseDTO enableDisableVehicleModelMaster(
			@RequestParam(name = "vehicleModelId") Long vehicleModelId,
			@RequestBody VehicleModelRequestDTO vehicleModelRequestDTO) {
		LOGGER.info("Executing  enableDisableVehicleModelTypeMaster() method of MasterController");
		return masterServiceImpl.enableDisableVehicleModelTypeMaster(vehicleModelRequestDTO, vehicleModelId);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_MODEL_MASTER_DATA)
	public ServiceResponseDTO getVehicleModelMasterData(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "vehicleModelId") String sortBy) {
		LOGGER.info("Executing  getVehicleModelMasterData method of MasterController");
		return masterServiceImpl.getVehicleModelMasterData(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_MODEL_MASTER_DATA_BY_ID)
	public ServiceResponseDTO getVehicleModelMasterDataById(
			@RequestParam(name = "vehicleModelId") Long vehicleModelId) {
		LOGGER.info("Executing  getVehicleModelMasterDataById() method of MasterController");
		return masterServiceImpl.getVehicleModelDataById(vehicleModelId);
	}

	@PostMapping(value = URLConstants.SAVE_OBSERVATION_CATEGORY_MASTER)
	public ServiceResponseDTO saveObservationCategoryMaster(
			@RequestBody ObservationCategoryRequestDTO observationCategoryRequestDTO) {
		LOGGER.info("Executing  saveObservationCategory() method of MasterController");
		return masterServiceImpl.saveObservationCategoryMasterData(observationCategoryRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_OBSERVATION_CATEGORY_MASTER)
	public ServiceResponseDTO updateObservationCategoryMaster(
			@RequestParam(name = "observationCategoryId") Long observationCategoryId,
			@RequestBody ObservationCategoryRequestDTO observationCategoryRequestDTO) {
		LOGGER.info("Executing  updateObservationCategoryMaster() method of MasterController");
		return masterServiceImpl.updateObservationCategoryMaster(observationCategoryRequestDTO, observationCategoryId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_OBSERVATION_CATEGORY_MASTER)
	public ServiceResponseDTO enableDisableObservationCategoryMaster(
			@RequestParam(name = "observationCategoryId") Long observationCategoryId,
			@RequestBody ObservationCategoryRequestDTO observationCategoryRequestDTO) {
		LOGGER.info("Executing  enableDisableObservationCategoryMaster() method of MasterController");
		return masterServiceImpl.enableDisableObservationCategoryData(observationCategoryRequestDTO,
				observationCategoryId);
	}

	@GetMapping(value = URLConstants.GET_ALL_OBSERVATION_CATEGORY)
	public ServiceResponseDTO getAllObservationCategoryDetails(
			@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "observationCategoryId") String sortBy) {
		LOGGER.info("Executing  getAllObservationCategoryDetails() method of MasterController");
		return masterServiceImpl.getAllObservationCategoryDetials(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_OBSERVATION_CATEGORY_DATA_BY_ID)
	public ServiceResponseDTO getObservationmasterCategoryDetail(
			@RequestParam(name = "observationCategoryId") Long observationCategoryId) {
		LOGGER.info("Executing  getObservationCategorymasterDetail() method of MasterController");
		return masterServiceImpl.getObservationCategoryDetailsById(observationCategoryId);
	}

	@PostMapping(value = URLConstants.SAVE_TIRE_CONFIGURATION_MASTER)
	public ServiceResponseDTO saveTireConfigurationMaster(
			@RequestBody TireConfigurationRequestDTO tireConfigurationRequestDTO) {
		LOGGER.info("Executing saveTireMasterConfigurationmaster() method of MasterController");
		return masterServiceImpl.saveTireConfigurationMaster(tireConfigurationRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_TIRE_CONFIGURATION_MASTER)
	public ServiceResponseDTO updateTireConfigurationMaster(
			@RequestParam(name = "tireConfigurationId") Long tireConfigurationId,
			@RequestBody TireConfigurationRequestDTO tireConfigurationRequestDTO) {
		LOGGER.info("Executing  updateTireConfigurationMaster() method of MasterController");
		return masterServiceImpl.updateTireConfigurationMaster(tireConfigurationRequestDTO, tireConfigurationId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_TIRE_CONFIGURATION_MASTER)
	public ServiceResponseDTO enableDisableTireConfigurationMaster(
			@RequestParam(name = "tireConfigurationId") Long tireConfigurationId,
			@RequestBody TireConfigurationRequestDTO tireConfigurationRequestDTO) {
		LOGGER.info("Executing  enableDisabletireconfigurationMaster() method of MasterController");
		return masterServiceImpl.enableDisableTireConfigurationMaster(tireConfigurationRequestDTO, tireConfigurationId);
	}

	@GetMapping(value = URLConstants.GET_ALL_TIRE_CONFIGURATION)
	public ServiceResponseDTO getAllTireConfigurationDetails(
			@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "tireConfigurationId") String sortBy) {
		LOGGER.info("Executing  getAllTireConfigurationDetails() method of MasterController");
		return masterServiceImpl.getAllTireConfigurationDetials(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_TIRE_CONFIGURATION_BY_ID)
	public ServiceResponseDTO getTireConfigurationDetail(
			@RequestParam(name = "tireConfigurationId") Long tireConfigurationId) {
		LOGGER.info("Executing  getTireConfigurationDetail() method of MasterController");
		return masterServiceImpl.getTireConfigurationById(tireConfigurationId);
	}

	@PostMapping(value = URLConstants.SAVE_TIRE_PATTERN)
	public ServiceResponseDTO saveTirePatternMaster(@RequestBody TirePatternRequestDTO tirePatternRequestDTO) {
		LOGGER.info("Executing saveTirePattternmaster() method of MasterController");
		return masterServiceImpl.saveTirePattern(tirePatternRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_TIRE_PATTERN)
	public ServiceResponseDTO updateTirePattern(@RequestParam(name = "tirepatternId") Long tirePatternId,
			@RequestBody TirePatternRequestDTO tirePatternRequestDTO) {
		LOGGER.info("Executing  updateTirePatternMaster() method of MasterController");
		return masterServiceImpl.updateTirePatternMaster(tirePatternRequestDTO, tirePatternId);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_TIRE_MASTER)
	public ServiceResponseDTO enableDisableTirePatternMaster(@RequestParam(name = "tirePatternId") Long tirePatternId,
			@RequestBody TirePatternRequestDTO tirePatternRequestDTO) {
		LOGGER.info("Executing  enableDisabletirePatternMaster() method of MasterController");
		return masterServiceImpl.enableDisableTirePatternMaster(tirePatternRequestDTO, tirePatternId);
	}

	@GetMapping(value = URLConstants.GET_ALL_TIRE_PATTERN)
	public ServiceResponseDTO getAllTirePattern(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "tirePatternId") String sortBy) {
		LOGGER.info("Executing  getAllTirePatternDetails() method of MasterController");
		return masterServiceImpl.getAllTirePattern(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_TIRE_PATTERN_BY_ID)
	public ServiceResponseDTO getTirePatternById(@RequestParam(name = "tirePatternId") Long tirePatternId) {
		LOGGER.info("Executing  getTirePatternDetail() method of MasterController");
		return masterServiceImpl.getTirePatternById(tirePatternId);
	}

	@GetMapping(value = URLConstants.GET_TIRE_PATERN_MAKE_BY_ID)
	public ServiceResponseDTO getTireMakebyIdDetails(@RequestParam(name = "tireMakeId") Long tireMakeId) {
		LOGGER.info("Executing  getTireMakebyIdDetails() method of MasterController");
		return masterServiceImpl.getTireMakeById(tireMakeId);
	}

	
	
	@PostMapping(value = URLConstants.SAVE_CLIENT_VEHICLE)
	public ServiceResponseDTO createClientVehicle(@RequestBody ClientVehicleRequestDTO clientVehicleRequestDTO) {
		LOGGER.info("Executing  createClientVehicle() method of MasterController");
		return masterServiceImpl.saveClientVehicleMasterData(clientVehicleRequestDTO);
	}
	
	
	@PutMapping(value = URLConstants.UPDATE_CLIENT_VEHICLE)
	public ServiceResponseDTO updateClientVehicle(@RequestParam(name = "clientVehicleId") Long clientVehicleId,
			@RequestBody ClientVehicleRequestDTO clientVehicleRequestDTO ) {
		LOGGER.info("Executing updateClientVehicleMaster() method of MasterController");
		return masterServiceImpl.updateClientVehicle(clientVehicleRequestDTO,clientVehicleId );
	}
	
	
	@GetMapping(value = URLConstants.GET_ALL_CLIENT_VEHICLE)
	public ServiceResponseDTO getAllClientVehicle(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "clientVehicleId") String sortBy) {
		LOGGER.info("Executing  getAllClientVehicle() method of MasterController");
		return masterServiceImpl.getAllClientVehicle(pageNumber, size, sortBy);
	}

	
	@PutMapping(value = URLConstants.ENABLE_DISABLE_CLIENT_VEHICLE_MASTER)
	public ServiceResponseDTO enableDisableClientVehicleMaster(@RequestParam(name = "clientVehicleId") Long clientVehicleId,
			@RequestBody ClientVehicleRequestDTO ClientVehicleRequestDTO) {
		LOGGER.info("Executing  enableDisabletirePatternMaster() method of MasterController");
		return masterServiceImpl.enableDisableClientVehicleMaster(ClientVehicleRequestDTO,clientVehicleId );
	}
	
	
	@GetMapping(value = URLConstants. GET_CLIENT_VEHICLE_BY_ID)
	public ServiceResponseDTO getClientVehiclebyId(
			@RequestParam(name = "clientVehicleId") Long clientVehicleId) {
		LOGGER.info("Executing getClientVehiclebyId  method of MasterController");
		return masterServiceImpl.getClientVehicleById(clientVehicleId);
	}
	
	
	@GetMapping(value = URLConstants.GET_CLIENT_VEHICLE_BY_CLIENT_ID)
	public ServiceResponseDTO getClientVehicleByClientId(@RequestParam(name = "clientId") Long clientId) {
		LOGGER.info("Executing  getClientDetail() method of MasterController");
		return masterServiceImpl.getClientVehicleByClientId(clientId);
	}
	
	
	@GetMapping(value = URLConstants.GET_COUNT)
	public ServiceResponseDTO getActiveCounts() {
	    LOGGER.info("Executing getActiveCounts() method of MasterController #####");
	    return masterServiceImpl.getActiveCounts();
	}

	
	
	
}