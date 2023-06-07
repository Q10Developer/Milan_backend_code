package com.app.user.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleInspectionEntity;

public interface VehicleInspectionRepository extends PagingAndSortingRepository<VehicleInspectionEntity, String> {

	List<VehicleInspectionEntity> findByClientId(Long clientId);

}
