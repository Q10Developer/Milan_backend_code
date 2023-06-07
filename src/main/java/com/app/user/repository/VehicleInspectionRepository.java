package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleInspectionEntity;

public interface VehicleInspectionRepository extends PagingAndSortingRepository<VehicleInspectionEntity, Long> {

}
