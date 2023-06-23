package com.app.user.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.OldVehicleInspectionDetailsEntity;

public interface OldVehicleInspectionDetailsRepository
		extends PagingAndSortingRepository<OldVehicleInspectionDetailsEntity, Long> {

	List<OldVehicleInspectionDetailsEntity> findByRegistrationNo(Long registratioNo);

}
