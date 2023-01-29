package com.app.user.repository;

import java.util.Map;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.app.user.entity.UserRegistrationEtity;

public interface UserRepository extends PagingAndSortingRepository<UserRegistrationEtity, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE UserRegistrationEtity u set u.password= ?1 where (u.userId= ?2) AND (u.activeStatus= 1)")
	Integer updatePasswordById(String password, Integer userId);

	@Query(value = "SELECT c.userId as userId  FROM UserRegistrationEtity c WHERE c.password= :password AND (c.emailId= :emailId or c.mobileNumber= :mobileNumber) AND (c.activeStatus= 1)")
	Map<String, Object> findIdByPasswordAndEmailOrMobile(@Param("password") String password,
			@Param("emailId") String emailId, @Param("mobileNumber") Long mobileNumber
	);

	@Query(value = "SELECT count(*) as count FROM UserRegistrationEtity c WHERE  (c.emailId= :emailId or c.mobileNumber= :mobileNumber) AND (c.activeStatus= 1)")
	long findCountByEmailOrMobile(@Param("emailId") String emailId, @Param("mobileNumber") Long mobileNumber

	);

	@Query(value = "SELECT c.password as password,c.userId as userId FROM UserRegistrationEtity c WHERE  (c.emailId= :emailId) AND (c.activeStatus= 1)")
	Map<String, Object> findPasswordAndUserIdByEmail(@Param("emailId") String emailId);

	@Query(value = "SELECT c.userId as id FROM UserRegistrationEtity c WHERE  (c.emailId= :emailId) AND (c.activeStatus= 1)")
	Map<String, Object> findUserIdByEmail(@Param("emailId") String emailId);

}
