package com.app.user.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.user.entity.ClientMasterEntity;

@Repository
public interface ClientMasterRepository extends PagingAndSortingRepository<ClientMasterEntity, Long> {

	@Query("SELECT DISTINCT c FROM ClientMasterEntity c LEFT JOIN FETCH c.serviceLocations sl WHERE c.clientFullName LIKE %:clientFullName% "
			+ " AND c.clientCompanyName = :clientCompanyName AND c.clientEmailId = :clientEmailId AND c.clientActiveStatus = :clientActiveStatus "
			+ "AND (sl.activeStatus = :serviceLocationActiveStatus OR sl.activeStatus IS NULL)")
	List<ClientMasterEntity> findByClientFullNameAndClientCompanyNameAndClientEmailIdAndClientActiveStatus(
			@Param("clientFullName") String clientFullName, @Param("clientCompanyName") String clientCompanyName,
			@Param("clientEmailId") String clientEmailId, @Param("clientActiveStatus") int clientActiveStatus,
			@Param("serviceLocationActiveStatus") int serviceLocationActiveStatus);

	@Query("SELECT DISTINCT c FROM ClientMasterEntity c LEFT JOIN FETCH c.serviceLocations sl WHERE c.clientFullName LIKE %:clientFullName% AND c.clientActiveStatus = :clientActiveStatus "
			+ "AND (sl.activeStatus = :serviceLocationActiveStatus OR sl.activeStatus IS NULL)")
	List<ClientMasterEntity> findByClientFullNameAndClientActiveStatus(@Param("clientFullName") String clientFullName,
			@Param("clientActiveStatus") int clientActiveStatus,
			@Param("serviceLocationActiveStatus") int serviceLocationActiveStatus);

	@Query("SELECT DISTINCT c FROM ClientMasterEntity c LEFT JOIN FETCH c.serviceLocations sl WHERE c.clientCompanyName = :clientCompanyName AND c.clientActiveStatus = :clientActiveStatus "
			+ "AND (sl.activeStatus = :serviceLocationActiveStatus OR sl.activeStatus IS NULL)")
	List<ClientMasterEntity> findByClientCompanyNameAndClientActiveStatus(
			@Param("clientCompanyName") String clientCompanyName, @Param("clientActiveStatus") int clientActiveStatus,
			@Param("serviceLocationActiveStatus") int serviceLocationActiveStatus);

	@Query("SELECT DISTINCT c FROM ClientMasterEntity c LEFT JOIN FETCH c.serviceLocations sl WHERE c.clientEmailId = :clientEmailId AND c.clientActiveStatus = :clientActiveStatus "
			+ "AND (sl.activeStatus = :serviceLocationActiveStatus OR sl.activeStatus IS NULL)")
	List<ClientMasterEntity> findByClientEmailIdAndClientActiveStatus(@Param("clientEmailId") String clientEmailId,
			@Param("clientActiveStatus") int clientActiveStatus,
			@Param("serviceLocationActiveStatus") int serviceLocationActiveStatus);

	List<ClientMasterEntity> findByClientEmailIdAndClientActiveStatus(String clientEmailId, int clientActiveStatus);

	@Query(value = "SELECT DISTINCT c FROM ClientMasterEntity c LEFT JOIN FETCH c.serviceLocations sl WHERE c.clientActiveStatus = :clientActiveStatus "
			+ "AND (sl.activeStatus = :serviceLocationActiveStatus OR sl.activeStatus IS NULL)", countQuery = "SELECT COUNT(DISTINCT c) FROM ClientMasterEntity c LEFT JOIN c.serviceLocations sl WHERE c.clientActiveStatus = :clientActiveStatus "
					+ "AND (sl.activeStatus = :serviceLocationActiveStatus OR sl.activeStatus IS NULL)")
	Page<ClientMasterEntity> findAllActiveClientsWithServiceLocationStatus(
			@Param("clientActiveStatus") int clientActiveStatus,
			@Param("serviceLocationActiveStatus") int serviceLocationActiveStatus, Pageable pageable);

	@Query("SELECT DISTINCT c FROM ClientMasterEntity c LEFT JOIN FETCH c.serviceLocations sl WHERE c.clientId = :clientId AND c.clientActiveStatus = :clientActiveStatus "
			+ "AND (sl.activeStatus = :serviceLocationActiveStatus OR sl.activeStatus IS NULL)")
	Optional<ClientMasterEntity> findByClientIdAndActiveStatusAndServiceLocationStatus(@Param("clientId") Long clientId,
			@Param("clientActiveStatus") int clientActiveStatus,
			@Param("serviceLocationActiveStatus") int serviceLocationActiveStatus);

}
