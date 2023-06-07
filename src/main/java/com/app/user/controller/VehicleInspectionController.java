package com.app.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.user.constants.URLConstants;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.VehicleInspectionDetailsRequestDTO;
import com.app.user.dto.request.VehicleInspectionRequestDTO;
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

	@GetMapping(value = URLConstants.GET_ALL_VEHICLE_INSPECTION)
	public ServiceResponseDTO getAllVehcileInspection(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "inspectionDateTime") String sortBy) {
		LOGGER.info("Executing  getAllVehcileInspection() method of MasterController");
		return vehicleInspectionServiceImpl.getAllVehicleInspection(pageNumber, size, sortBy);
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

}
