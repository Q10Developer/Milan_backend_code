package com.app.user.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleModelEntity;

public interface VehicleModelRepository extends PagingAndSortingRepository<VehicleModelEntity, Long> {

	List<VehicleModelEntity> findByVehicleManufacturerId_VehicleManufacturerIdAndActiveStatus(Long vehicleManufacturer,
			int activeStatus);

}
