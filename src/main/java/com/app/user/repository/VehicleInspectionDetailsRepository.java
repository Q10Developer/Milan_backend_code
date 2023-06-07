package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleInspectionDetailsEntity;

public interface VehicleInspectionDetailsRepository
		extends PagingAndSortingRepository<VehicleInspectionDetailsEntity, Long> {

}
