package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleMasterEntity;

public interface VehicleRepository extends PagingAndSortingRepository<VehicleMasterEntity, Long> {

}
