package com.app.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.app.user.entity.MasterDataListEntity;

public interface MasterDataListRepository extends PagingAndSortingRepository<MasterDataListEntity, Long> {

	@Query(value = "SELECT m FROM MasterDataListEntity m where m.dataType=:dataType and m.parentId=:parentId and m.activeStatus=:activeStatus")
	List<MasterDataListEntity> findAllByDataTypeAndActiveStatus(@Param("dataType") String dataType,
			@Param("parentId") Long parentId, @Param("activeStatus") int activeStatus);

	@Query(value = "SELECT m FROM MasterDataListEntity m where m.dataType=:dataType and m.parentId=:parentId")
	List<MasterDataListEntity> findAllByDataType(@Param("dataType") String dataType, @Param("parentId") Long parentId);

}
