package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.VehicleTypeEntity;
import com.app.user.entity.VehicleUsageEntity;

public interface VehicleUsageRepository extends PagingAndSortingRepository<VehicleUsageEntity, Long>{

}
