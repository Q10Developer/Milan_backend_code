package com.app.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.app.user.entity.DropDownEntity;

public interface DropDownMasterRepository extends PagingAndSortingRepository<DropDownEntity, Long> {

	@Query(value = "SELECT COUNT(1) FROM DropDownEntity drop where drop.dropDownName=:dropDownName and drop.dropDownKey=:dropDownKey and drop.activeStatus=:activeStatus")
	Integer findDropDownByNameAndKeyAndActiveStatus(@Param("dropDownName") String dropDownName,
			@Param("dropDownKey") String dropDownKey, @Param("activeStatus") int activeStatus);

	@Query(value = "SELECT COUNT(1) FROM DropDownEntity drop where drop.dropDownName=:dropDownName and drop.activeStatus=:activeStatus")
	Integer findDropDownByNameAndActiveStatus(@Param("dropDownName") String dropDownName,
			@Param("activeStatus") int activeStatus);

	@Query(value = "SELECT COUNT(1) FROM DropDownEntity drop where drop.dropDownKey=:dropDownKey and drop.activeStatus=:activeStatus")
	Integer findDropDownByKeyAndActiveStatus(@Param("dropDownKey") String dropDownKey,
			@Param("activeStatus") int activeStatus);
}
