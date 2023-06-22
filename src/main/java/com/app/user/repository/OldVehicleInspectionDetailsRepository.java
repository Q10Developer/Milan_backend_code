package com.app.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.OldVehicleInspectionDetailsEntity;
import com.app.user.entity.OldVehicleInspectionEntity;
import com.app.user.entity.VehicleInspectionDetailsEntity;


public interface OldVehicleInspectionDetailsRepository  extends PagingAndSortingRepository<OldVehicleInspectionDetailsEntity, Long>{
             


	

	List<OldVehicleInspectionDetailsEntity> findByRegistrationNo(Long registratioNo);

	

	
}
