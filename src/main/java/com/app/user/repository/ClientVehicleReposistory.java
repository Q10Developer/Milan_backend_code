package com.app.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.ClientVehicleEntity;
import com.app.user.entity.VehicleInspectionEntity;

public interface  ClientVehicleReposistory extends PagingAndSortingRepository<ClientVehicleEntity, Long>
 {

	List<ClientVehicleEntity> findByClientId(Long clientId);

	ClientVehicleEntity findByVehicleRegNumber(String vehicleRegNumber);
	
	long count();
	

}
