package com.app.user.controller;


import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.app.user.dto.request.TyreRequestDTO;
import com.app.user.dto.request.VehicleInspectionDetailsRequestDTO;
import com.app.user.dto.request.VehicleInspectionRequestDTO;

import com.app.user.entity.VehicleInspectionEntity;
import com.app.user.service.impl.IVehicleInspectionServiceImpl;



@RestController
@CrossOrigin
@RequestMapping(value = URLConstants.VEHICLE_INSPECTION)
public class VehicleInspectionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleInspectionController.class);

	@Autowired
	private IVehicleInspectionServiceImpl vehicleInspectionServiceImpl;

	@PostMapping(value = URLConstants.CREATE_VEHICLE_INSPECTION)
	public ServiceResponseDTO startVehicleInspection(
			@RequestBody VehicleInspectionRequestDTO vehicleInspectionRequestDTO) {
		LOGGER.info("Executing  startVehicleInspection() method of VehicleInspectionController");
		return vehicleInspectionServiceImpl.startVehicleInspection(vehicleInspectionRequestDTO);
	}

	@PutMapping(value = URLConstants.UPDATE_VEHICLE_INSPECTION)
	public ServiceResponseDTO updateVehicleInspection(@RequestParam(name = "inspectionId") String inspectionId,
			@RequestBody VehicleInspectionRequestDTO vehicleInspectionRequestDTO) {
		LOGGER.info("Executing  updateVehicleInspection() method of VehicleInspectionController");
		return vehicleInspectionServiceImpl.updateVehicleInspection(inspectionId, vehicleInspectionRequestDTO);
	}

	@GetMapping(value = URLConstants.GET_ALL_VEHICLE_INSPECTION)
	public ServiceResponseDTO getAllVehcileInspection(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "inspectionDateTime") String sortBy ){
		LOGGER.info("Executing  getAllVehcileInspection() method of MasterController");
		return vehicleInspectionServiceImpl.getAllVehicleInspection(pageNumber, size, sortBy );
	}
	
	
	@GetMapping(value = URLConstants.GET_VEHICLE_INSPECTION_BY_ID)
	public ServiceResponseDTO getVehicleInspectionById(@RequestParam(name = "inspectionId") String inspectionId) {
		LOGGER.info("Executing  getVehcileInspectionById() method of MasterController");
		return vehicleInspectionServiceImpl.getVehicleInspectionById(inspectionId);
	}
	
	

	@GetMapping(value = URLConstants.GET_VEHICLE_INSPECTION_BY_CLIENT_ID)
	public ServiceResponseDTO getVehicleInspectionByClientId(@RequestParam(name = "clientId") Long clientId) {
		LOGGER.info("Executing  getVehcileInspectionByClientId() method of MasterController");
		return vehicleInspectionServiceImpl.getVehicleInspectionByClientId(clientId);
	}
	
	

	@GetMapping(value = URLConstants.GET_VEHICLE_INSPECTION_BY_CLIENT_ID_USER_ID)
	public ServiceResponseDTO getVehicleInspectionByClientIdUserId(@RequestParam(name = "userId") Long userId) {
		LOGGER.info("Executing  getVehcileInspectionByClientId() method of MasterController");
		return vehicleInspectionServiceImpl.getVehicleInspectionByClientIdUserId(userId);
	}
	
	
	

	@GetMapping(value = URLConstants.GET_LAST_VEHICLE_INSPECTION_DATE)
	public ServiceResponseDTO getVehicleLastInspectionDate(@RequestParam(name = "clientId") Long  clientId,
			@RequestParam(name="vehicleRegNumber") String vehicleRegNumber) {
		LOGGER.info("Executing  getVehicleLastInspectionDate method of MasterController");
		return vehicleInspectionServiceImpl.getVehicleLastInspectionDate(clientId,vehicleRegNumber);
	}
	
	
	@GetMapping(value = URLConstants.GET_VEHICLE_BY_REG_NUMBER)
	public ServiceResponseDTO getVehicleByRegNumber(@RequestParam(name = "vehicleRegNumber") String vehicleRegNumber) {
		LOGGER.info("Executing getVehicleByRegNumber() method of MasterController");
		return vehicleInspectionServiceImpl.getVehicleRegNumber(vehicleRegNumber);
	}
	
	

	@PutMapping(value = URLConstants.ENABLE_DISABLE_INSPECTION)
	public ServiceResponseDTO enableDisableInspection(@RequestParam(name = "inspectionId") String inspectionId,
			 @RequestBody VehicleInspectionRequestDTO vehicleInspectionRequestDTO ) {
		LOGGER.info("Executing  enableDisableInspection() method of VehicleInspectionController ");
		return vehicleInspectionServiceImpl.enableDisableInspection(vehicleInspectionRequestDTO,inspectionId);
	}
	
	
	

	@PostMapping(value = URLConstants.SAVE_VEHICLE_INSPECTION_DETAILS)
	public ServiceResponseDTO saveVehicleInspectionDetails(@RequestParam(name = "inspectionId") String inspectionId,
			@RequestParam(name = "inspectionStatus") int inspectionStatus,
			@RequestBody List<VehicleInspectionDetailsRequestDTO> vehicleInspectionDetails) {
		LOGGER.info("Executing  saveVehicleInspectionDetails() method of VehicleInspectionController");
		return vehicleInspectionServiceImpl.saveVehicleInspectionDetails(inspectionId, inspectionStatus,
				vehicleInspectionDetails);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_INSPECTION_DETAILS)
	public ServiceResponseDTO getVehicleInspectionByInspectionId(
			@RequestParam(name = "inspectionId") String inspectionId) {
		LOGGER.info("Executing  getVehcileInspectionByInspectionId() method of MasterController");
		return vehicleInspectionServiceImpl.getVehicleInspectionByInspectionId(inspectionId);
	}

	
	@GetMapping(value = URLConstants.GET_TOP_TEN_ISSUE_CLIENT_ID_AND_VEHICLE_ID)
	public ServiceResponseDTO getTopTenIssueClientIdAndVehicleId(@RequestParam(name = "clientId") Long  clientId,
			@RequestParam(name="vehicleId") Long vehicleId) {
		LOGGER.info("Executing  getVehicleLastInspectionDate method of MasterController");
		return vehicleInspectionServiceImpl.getTopTenIssueClientIdAndVehicleId(clientId,vehicleId);
	}
	
	@GetMapping(value = URLConstants.GET_TIRE_DETAILS_BY_INSPECTION_ID_CLIENT_ID)
	public ServiceResponseDTO getTireDetailsByInspectionIdClientId(
			@RequestParam(name = "clientId") Long clientId,
			@RequestParam(name="clientServiceLocationId") Long clientServiceLocationId) {
		LOGGER.info("Executing getTireDetailsByInspectionIdClientId method of MasterController");
		return vehicleInspectionServiceImpl.getTireDetailsByInspectionIdClientId(clientId,clientServiceLocationId);
	}
	
	@GetMapping(value = URLConstants.GET_INSPECTION_DONE_BY_CLIENT_ID_LOCATION_ID)
	public ServiceResponseDTO getInspectionDoneByClientIdAndLocationId(
			@RequestParam(name = "clientId") Long clientId,
			@RequestParam(name = "clientServiceLocationId") Long clientServiceLocationId)
	{
		LOGGER.info("Executing getTireDetailsByInspectionIdClientId method of MasterController");
		return vehicleInspectionServiceImpl.getInspectionDoneByClientIdAndLocationId(clientId,clientServiceLocationId);
	}

}

