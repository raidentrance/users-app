package com.devs4j.users.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String username);

	public Optional<User> findByUsernameAndPassword(String username, String password);
	/**
	 * 
	 * Esto NO es SQL se llama JPQL  
	 */
	@Query("SELECT u.username FROM User u WHERE u.username like '%collins'")
	public Page<String> findUsernames(Pageable pageable);

}
