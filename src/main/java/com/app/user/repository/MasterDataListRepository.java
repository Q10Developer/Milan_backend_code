package com.app.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.app.user.entity.MasterDataListEntity;

public interface MasterDataListRepository extends JpaRepository<MasterDataListEntity, Long> {

	@Query(value = "SELECT m.dataId , m.dataKey , m.dataValue , m.dataLabel , m.dataType , m.activeStatus "
			+ "FROM MasterDataListEntity m where m.dataType=:dataType and m.activeStatus=:activeStatus")
	List<MasterDataListEntity> findAllByDataTypeAndActiveStatus(@Param("dataType") String dataType,
			@Param("activeStatus") int activeStatus);

	@Query(value = "SELECT m.dataId , m.dataKey , m.dataValue , m.dataLabel , m.dataType , m.activeStatus FROM MasterDataListEntity m where m.dataType=:dataType")
	List<MasterDataListEntity> findAllByDataType(@Param("dataType") String dataType);

}
