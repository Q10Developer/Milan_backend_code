package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleTyreMasterEntity;

public interface VehicleTyreRepository extends PagingAndSortingRepository<VehicleTyreMasterEntity, Long> {

}
