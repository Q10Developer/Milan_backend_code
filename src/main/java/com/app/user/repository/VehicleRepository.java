package com.app.user.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleMasterEntity;

public interface VehicleRepository extends PagingAndSortingRepository<VehicleMasterEntity, Long> {

	Optional<VehicleMasterEntity> findByVehicleManufacturerAndVehicleModelAndVehicleTypeAndActiveStatus(
			Long vehicleManufacturer, Long vehicleModel, Long vehicleType, int activeStatus);

}
