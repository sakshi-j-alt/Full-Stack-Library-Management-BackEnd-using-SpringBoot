package com.capgimini.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgimini.project.entities.User;
import com.capgimini.project.exceptions.UserNotFoundException;
import com.capgimini.project.repositories.UserRepo;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo userRepo;

	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with user id " + id));
	}

	@Override
	public User createUser(@Valid User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(Long id, User user) {
		Optional<User> optional = userRepo.findById(id);
		if (optional.isPresent()) {
			User existing = optional.get();
			existing.setName(user.getName());
			existing.setEmail(user.getEmail());
			existing.setPassword(user.getPassword());
			existing.setPhone(user.getPhone());
			existing.setUserType(user.getUserType());
			return userRepo.save(existing);
		}
		return null;
	}

	@Override
	public User patchUser(Long id, User user) {
		Optional<User> optional = userRepo.findById(id);
		if (optional.isPresent()) {
			User existing = optional.get();
			if (user.getName() != null) {
				existing.setName(user.getName());
			}
			if (user.getEmail() != null) {
				existing.setEmail(user.getEmail());
			}
			if (user.getPassword() != null) {
				existing.setPassword(user.getPassword());
			}
			if (user.getPhone() != null) {
				existing.setPhone(user.getPhone());
			}
			if (user.getUserType() != null) {
				existing.setUserType(user.getUserType());
			}
			return userRepo.save(existing);
		}
		return null;
	}

	@Override
	public boolean deleteUser(Long id) {
		if (userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		}
		return false;
	}
}
