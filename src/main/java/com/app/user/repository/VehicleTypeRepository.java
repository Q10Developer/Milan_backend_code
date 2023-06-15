package com.app.user.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleTypeEntity;

public interface VehicleTypeRepository extends PagingAndSortingRepository<VehicleTypeEntity, Long> {
	List<VehicleTypeEntity> findByVehicleModelAndActiveStatus(Long vehicleModel, int activeStatus);
}
