package com.devs4j.users.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entities.Role;
import com.devs4j.users.entities.User;
import com.devs4j.users.models.Devs4jSecurityRule;
import com.devs4j.users.repositories.RoleRepository;
import com.devs4j.users.repositories.UserInRoleRepository;

@Service
@Devs4jSecurityRule
public class RoleService {

	@Autowired
	private RoleRepository repository;

	@Autowired
	private UserInRoleRepository inRoleRepository;

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	
	public List<User> getUsersByRole(String roleName) {
		log.info("Getting roles by name {}",roleName);
		return inRoleRepository.findUsersByRoleName(roleName);
	}

	@Cacheable("roles")
	public List<Role> getRoles() {
		log.info("Getting roles");
		return repository.findAll();
	}

	public Role createRole(Role role) {
		return repository.save(role);
	}

	public Role updateRole(Integer roleId, Role role) {
		Optional<Role> result = repository.findById(roleId);
		if (result.isPresent()) {
			return repository.save(role);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exists", roleId));
		}
	}

	public void deleteRole(Integer roleId) {
		Optional<Role> result = repository.findById(roleId);
		if (result.isPresent()) {
			repository.delete(result.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exists", roleId));
		}
	}
}
