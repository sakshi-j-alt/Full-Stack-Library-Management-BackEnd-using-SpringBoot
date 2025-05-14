package com.capgimini.project.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.capgimini.project.entities.libraryUser;
import com.capgimini.project.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<libraryUser>> getAllUsers() {
		List<libraryUser> libraryUsers = service.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(libraryUsers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<libraryUser> getUser(@Valid @PathVariable Long id) {
		libraryUser libraryUser = service.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(libraryUser);
	}

	@PostMapping
	public ResponseEntity<libraryUser> createUser(@Valid @RequestBody libraryUser libraryUser) {
		libraryUser saved = service.createUser(libraryUser);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/users/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<libraryUser> updateUser(@PathVariable Long id, @Valid @RequestBody libraryUser libraryUser) {
		libraryUser updated = service.updateUser(id, libraryUser);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<libraryUser> patchUser(@PathVariable Long id, @Valid @RequestBody libraryUser patch) {
		libraryUser updated = service.patchUser(id, patch);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		boolean deleted = service.deleteUser(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
