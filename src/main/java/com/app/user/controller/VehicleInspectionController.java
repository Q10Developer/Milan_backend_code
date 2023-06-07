package com.app.user.controller;

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
		return vehicleInspectionServiceImpl.getAllVehcileInspection(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_VEHICLE_INSPECTION_BY_ID)
	public ServiceResponseDTO getVehcileInspectionById(@RequestParam(name = "clientId") Long clientId) {
		LOGGER.info("Executing  getVehcileInspectionById() method of MasterController");
		return vehicleInspectionServiceImpl.getVehcileInspectionById(clientId);
	}

}
