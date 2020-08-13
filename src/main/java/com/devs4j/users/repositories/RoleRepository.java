package com.devs4j.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
