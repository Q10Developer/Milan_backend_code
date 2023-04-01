package com.app.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.app.user.entity.MasterDataListEntity;

public interface MasterDataListRepository extends PagingAndSortingRepository<MasterDataListEntity, Long> {

	@Query(value = "SELECT m FROM MasterDataListEntity m where m.dataType=:dataType and m.parentId=:parentId and m.activeStatus=:activeStatus")
	Page<MasterDataListEntity> findAllByDataTypeAndActiveStatus(@Param("dataType") String dataType,
			@Param("parentId") Long parentId, @Param("activeStatus") int activeStatus, Pageable pageable);

	@Query(value = "SELECT m FROM MasterDataListEntity m where m.dataType=:dataType and m.parentId=:parentId")
	Page<MasterDataListEntity> findAllByDataType(@Param("dataType") String dataType, @Param("parentId") Long parentId,
			Pageable pageable);

	@Query(value = "SELECT m FROM MasterDataListEntity m where m.activeStatus=:activeStatus")
	Page<MasterDataListEntity> findAllByActiveStatus(@Param("activeStatus") int activeStatus, Pageable pageable);

}
