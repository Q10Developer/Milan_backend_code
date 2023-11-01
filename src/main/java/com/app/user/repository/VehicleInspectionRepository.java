package com.app.user.repository;



import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.app.user.entity.VehicleInspectionDetailsEntity;
import com.app.user.entity.VehicleInspectionEntity;

public interface VehicleInspectionRepository extends PagingAndSortingRepository<VehicleInspectionEntity, String> {

	
	
	List<VehicleInspectionEntity> findByClientId(Long clientId);
	
@Query(value = "SELECT  u.user_name  FROM  " +
            " client_master cm  " +
            "INNER JOIN user_master u ON cm.user_id = u.user_id " +
            "WHERE cm.client_id = ?1", nativeQuery = true)
	String findUserNameByClentId(@Param ("clientId")Long clientId);
	
	
	@Query(value = "SELECT * FROM vehicle_inspection WHERE client_id IN (SELECT client_id FROM client_master WHERE user_id = ?1)", nativeQuery = true)
     List<VehicleInspectionEntity> findByClientIdUserId(@Param("userId") Long userId);

	



	List<VehicleInspectionEntity> findByVehicleRegNumber(String vehicleRegNumber);


	@Query(value = "SELECT * FROM vehicle_inspection WHERE client_id = :clientId AND vehicle_reg_number = :vehicleRegNumber ORDER BY modified_date DESC LIMIT 1 OFFSET 1", nativeQuery = true)
	List<VehicleInspectionEntity> findByLastInspectionDate(@Param("clientId") Long clientId, @Param("vehicleRegNumber") String vehicleRegNumber);

	
	



	 @Query(value = "SELECT vi.* FROM vehicle_inspection vi " +
             "INNER JOIN client_master cm ON vi.client_id = cm.client_id " +
             "INNER JOIN user_master u ON cm.user_id = u.user_id " +
             "WHERE u.user_name = :userName", nativeQuery = true)
List<VehicleInspectionEntity> findByUserName();

	 
	 
	 
	 @Query(value = "SELECT  u.user_name  FROM  " +
	            " client_master cm  " +
	            "INNER JOIN user_master u ON cm.user_id = u.user_id " +
	            "WHERE cm.client_id = :clientId", nativeQuery = true)
	String findUserNameByClientId(@Param ("clientId") long clientId);

	 
	 
	 
	

	 
	 @Query("SELECT vid " +
			   "FROM VehicleInspectionDetailsEntity vid " +
			   "WHERE vid.inspectionId IN " +
			   "(SELECT vi.inspectionId " +
			   "FROM VehicleInspectionEntity vi " +
			   "WHERE vi.clientId = :clientId " +
			   "AND vi.vehicleId = :vehicleId) " +
			   "AND (vid.observationLabel NOT LIKE '%ALL OK' " +
			   "OR vid.pressureColorCode LIKE '%RED' " +
			   "OR vid.leastTireThicknessAllowedAnalysis LIKE '%RED')")
			List<VehicleInspectionDetailsEntity>findByTopTenIssueClientIdAndVehicleId(
			    @Param("clientId") Long clientId,
			    @Param("vehicleId") Long vehicleId
			);

			


	





  
}
