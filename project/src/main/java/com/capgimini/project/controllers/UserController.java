package com.capgimini.project.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.capgimini.project.entities.User;
import com.capgimini.project.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = service.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@Valid @PathVariable Long id) {
		User user = service.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saved = service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/users/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
		User updated = service.updateUser(id, user);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<User> patchUser(@PathVariable Long id, @Valid @RequestBody User patch) {
		User updated = service.patchUser(id, patch);
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
