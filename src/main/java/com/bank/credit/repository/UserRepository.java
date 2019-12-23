package com.bank.credit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.credit.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmailIdAndPassword(String userId, String password);
	
	Optional<User> findByEmailId(String emailId);

}
