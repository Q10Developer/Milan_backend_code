package com.app.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.app.user.entity.ClientVehicleEntity;
import com.app.user.entity.VehicleInspectionEntity;

public interface  ClientVehicleReposistory extends PagingAndSortingRepository<ClientVehicleEntity, Long>
 {

	List<ClientVehicleEntity> findByClientId(Long clientId);

	ClientVehicleEntity findByVehicleRegNumber(String vehicleRegNumber);
	
	long count();

//	List<ClientVehicleEntity>findByListVehicleRegNumber(String vehicleRegNumber);
	
	@Query(value = "SELECT * FROM client_vehicle WHERE   vehicle_reg_number =:vehicleRegNumber", nativeQuery = true)
	List<ClientVehicleEntity>findByListVehicleRegNumber(@Param("vehicleRegNumber") String vehicleRegNumber);

	

	@Query(value = "SELECT * FROM client_vehicle WHERE client_id = :clientId AND client_service_location_id = :clientServiceLocationId", nativeQuery = true)
	List<ClientVehicleEntity> findByVehicleByClientIdAndServiceLocationId(@Param("clientId") Long clientId, @Param("clientServiceLocationId") Long clientServiceLocationId);

	
	
}
