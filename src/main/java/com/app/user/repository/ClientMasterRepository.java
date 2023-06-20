package com.app.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.ClientMasterEntity;

public interface ClientMasterRepository extends PagingAndSortingRepository<ClientMasterEntity, Long> {
	List<ClientMasterEntity> findByClientFullNameAndClientCompanyNameAndClientEmailIdAndClientActiveStatus(
			String clientFullName, String clientCompanyName, String clientEmailId, int clientActiveStatus);

	List<ClientMasterEntity> findByClientFullNameAndClientActiveStatus(String clientFullName, int clientActiveStatus);

	List<ClientMasterEntity> findByClientCompanyNameAndClientActiveStatus(String clientCompanyName,
			int clientActiveStatus);

	List<ClientMasterEntity> findByClientEmailIdAndClientActiveStatus(String clientEmailId, int clientActiveStatus);
}
