package com.mymicroservices.user.repository;

/*
 * @created 1/2/2021 - 3:29 PM
 * @author Swapnil Kharche
 */

import com.mymicroservices.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserId(Long userId);


}
