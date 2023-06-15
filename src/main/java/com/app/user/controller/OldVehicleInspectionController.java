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
	public ServiceResponseDTO updateOldVehicleInspection(@RequestParam(name = "srNo") Long srNo,
			@RequestBody OldVehicleInspectionRequestDTO oldVehicleInspectionRequestDTO) {
		LOGGER.info("Executing  updateOldVehicleInspection() method of OldVehicleInspectionController");
		return oldVehicleInspectionServiceImpl.updateOldVehicleInspection(srNo, oldVehicleInspectionRequestDTO);
	}
	
	@GetMapping(value = URLConstants.GET_ALL_OLD_VEHICLE_INSPECTION)
	public ServiceResponseDTO getAllOldVehcileInspection(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "DateRegistered") String sortBy) {
		LOGGER.info("Executing  getAllOldVehcileInspection() method of OldVehicleInspectionController");
		return oldVehicleInspectionServiceImpl.getAllOldVehicleInspection(pageNumber, size, sortBy);
	}
	
	
/*	@GetMapping(value = URLConstants.GET_Old_VEHICLE_INSPECTION_BY_REGISTRATION_NO)
	public ServiceResponseDTO getOLdVehicleInspectionByRegistrationNo(@RequestParam(name = "registrationNo") String  registrationNo) {
		LOGGER.info("Executing  getVehcileInspectionById() method of MasterController");
		return oldVehicleInspectionServiceImpl.getOldVehicleInspectionByRegistrationNo(registrationNo);
	}*/
	
	
	

/*	@GetMapping(value = URLConstants.GET_OLD_VEHICLE_INSPECTION_BY_Name_And_Address_Of_Transport_Company)
	public ServiceResponseDTO getOldVehicleInspectionByNameAndAddressofTransportCompany(@RequestParam(name = "nameAndAddressofTransportCompany") String  nameAndAddressofTransportCompany) {
		LOGGER.info("Executing  getVehcileInspectionByClientId() method of MasterController");
		return oldVehicleInspectionServiceImpl.getOldVehicleInspectionByNameAndAddressofTransportCompany(nameAndAddressofTransportCompany);
	}*/
	
	
	
}
