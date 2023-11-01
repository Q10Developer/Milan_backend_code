package com.app.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.ClientVehicleEntity;
import com.app.user.entity.VehicleMasterEntity;

public interface VehicleRepository extends PagingAndSortingRepository<VehicleMasterEntity, Long> {

	Optional<VehicleMasterEntity> findByVehicleManufacturerAndVehicleModelAndVehicleTypeAndActiveStatus(
			Long vehicleManufacturer, Long vehicleModel, Long vehicleType, int activeStatus);

	ClientVehicleEntity save(ClientVehicleEntity entity);

	/*@Query("SELECT COUNT(*) FROM vehicle_configuration_master c WHERE c.active_status = 1")
	long countActiveVehicle();*/
	
	@Query("SELECT COUNT(v) FROM VehicleMasterEntity v WHERE v.activeStatus = 1")
	long countActiveVehicle();


}
