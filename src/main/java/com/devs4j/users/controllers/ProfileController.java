package com.devs4j.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.users.entities.Profile;
import com.devs4j.users.services.ProfileService;

@RequestMapping("/users/{userId}/profiles")
@RestController
public class ProfileController {

	@Autowired
	private ProfileService service;

	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> getById(@PathVariable("userId") Integer userId,
			@PathVariable("profileId") Integer profileId) {
		return new ResponseEntity<Profile>(service.getByUserIdAndProfileId(userId,profileId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Profile> create(@PathVariable("userId") Integer userId, @RequestBody Profile profile) {
		return new ResponseEntity<Profile>(service.create(userId, profile), HttpStatus.CREATED);
	}

}
