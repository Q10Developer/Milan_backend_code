package com.app.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.TireConfigurationEntity;

public interface TireConfigurationRepository extends PagingAndSortingRepository<TireConfigurationEntity, Long> {

/*	@Query("SELECT COUNT(*) FROM   mst_tire_configuration  t WHERE t.active_status= 1")
	 long countActiveTires();*/
	
	
	@Query("SELECT COUNT(t) FROM TireConfigurationEntity t WHERE t.activeStatus = 1")
	long countActiveTires();


}
