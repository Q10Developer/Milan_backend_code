package com.app.user.controller;

import java.util.List;

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
import com.app.user.dto.request.OldVehicleInspectionDetailsRequestDTO;
import com.app.user.dto.request.OldVehicleInspectionRequestDTO;
import com.app.user.service.impl.IOldVehicleInspectionServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = URLConstants.OLD_VEHICLE_INSPECTION)
public class OldVehicleInspectionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OldVehicleInspectionController.class);
	
	
	@Autowired
	private IOldVehicleInspectionServiceImpl oldVehicleInspectionServiceImpl;
	
	

	@PostMapping(value = URLConstants.CREATE_OLD_VEHICLE_INSPECTION)
	public ServiceResponseDTO startOldVehicleInspection(
			@RequestBody OldVehicleInspectionRequestDTO oldVehicleInspectionRequestDTO) {
		LOGGER.info("Executing  startOldVehicleInspection() method of OldVehicleInspectionController");
		return oldVehicleInspectionServiceImpl.startOldVehicleInspection(oldVehicleInspectionRequestDTO);
	}
	
	@PutMapping(value = URLConstants.UPDATE_OLD_VEHICLE_INSPECTION)
	public ServiceResponseDTO updateOldVehicleInspection(@RequestParam(name = "registrationNo") Long registrationNo,
			@RequestBody OldVehicleInspectionRequestDTO oldVehicleInspectionRequestDTO) {
		LOGGER.info("Executing  updateOldVehicleInspection() method of OldVehicleInspectionController");
		return oldVehicleInspectionServiceImpl.updateOldVehicleInspection(registrationNo, oldVehicleInspectionRequestDTO);
	}
	
	@GetMapping(value = URLConstants.GET_ALL_OLD_VEHICLE_INSPECTION)
	public ServiceResponseDTO getAllOldVehcileInspection(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "DateRegistered") String sortBy) {
		LOGGER.info("Executing  getAllOldVehcileInspection() method of OldVehicleInspectionController");
		return oldVehicleInspectionServiceImpl.getAllOldVehicleInspection(pageNumber, size, sortBy);
	}
	
	@GetMapping(value = URLConstants.GET_OLD_VEHICLE_INSPECTION_BY_REGISTRATION_NO)
	public ServiceResponseDTO getOldVehicleInspectionByRegistratioNo(@RequestParam(name = "registrationNo") Long registrationNo) {
		LOGGER.info("Executing  getOldVehcileInspectionByRegistratioNo() method of MasterController");
		return oldVehicleInspectionServiceImpl.getOldVehicleInspectionByRegistratioNo(registrationNo);
	}

	@PostMapping(value = URLConstants.SAVE_OLD_VEHICLE_INSPECTION_DETAILS)
	public ServiceResponseDTO saveOldVehicleInspectionDetails(@RequestParam(name = "registrationNo") Long registrationNo,
			@RequestParam(name = "oldVehicleInspectionStatus") int oldVehicleInspectionStatus,
			@RequestBody List<OldVehicleInspectionDetailsRequestDTO> oldVehicleInspectionDetails) {
		LOGGER.info("Executing  saveOldVehicleInspectionDetails() method of OldVehicleInspectionController");
		return oldVehicleInspectionServiceImpl.saveOldVehicleInspectionDetails(registrationNo,oldVehicleInspectionStatus,
				oldVehicleInspectionDetails);
	}
	
	
	@GetMapping(value = URLConstants.GET_OLD_VEHICLE_INSPECTION_DETAILS)
	public ServiceResponseDTO getVehicleInspectionByRegistratioNo(
			@RequestParam(name = "registrationno") Long registrationNo) {
		LOGGER.info("Executing  getOldVehcileInspectionByByRegistratioNo() method of OldVehicleInspectionController");
		return oldVehicleInspectionServiceImpl.getVehicleInspectionByRegistratioNo(registrationNo);
	}


	
	
	
}
