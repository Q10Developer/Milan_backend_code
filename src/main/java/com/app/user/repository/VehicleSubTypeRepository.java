package com.app.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.VehicleSubTypeEntity;
import com.app.user.entity.VehicleTypeEntity;

public interface VehicleSubTypeRepository extends PagingAndSortingRepository<VehicleSubTypeEntity, Long> {

	Page<VehicleSubTypeEntity> findByVehicleTypeId(VehicleTypeEntity vehicleTypeId, Pageable pageable);

}
