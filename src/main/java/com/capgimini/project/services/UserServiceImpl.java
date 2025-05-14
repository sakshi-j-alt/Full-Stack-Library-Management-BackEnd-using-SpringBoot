package com.capgimini.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgimini.project.entities.libraryUser;
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
	public List<libraryUser> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public libraryUser getUserById(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with user id " + id));
	}

	@Override
	public libraryUser createUser(@Valid libraryUser libraryUser) {
		return userRepo.save(libraryUser);
	}

	@Override
	public libraryUser updateUser(Long id, libraryUser libraryUser) {
		Optional<libraryUser> optional = userRepo.findById(id);
		if (optional.isPresent()) {
			libraryUser existing = optional.get();
			existing.setName(libraryUser.getName());
			existing.setEmail(libraryUser.getEmail());
			existing.setPassword(libraryUser.getPassword());
			existing.setPhone(libraryUser.getPhone());
			existing.setUserType(libraryUser.getUserType());
			return userRepo.save(existing);
		}
		return null;
	}

	@Override
	public libraryUser patchUser(Long id, libraryUser libraryUser) {
		Optional<libraryUser> optional = userRepo.findById(id);
		if (optional.isPresent()) {
			libraryUser existing = optional.get();
			if (libraryUser.getName() != null) {
				existing.setName(libraryUser.getName());
			}
			if (libraryUser.getEmail() != null) {
				existing.setEmail(libraryUser.getEmail());
			}
			if (libraryUser.getPassword() != null) {
				existing.setPassword(libraryUser.getPassword());
			}
			if (libraryUser.getPhone() != null) {
				existing.setPhone(libraryUser.getPhone());
			}
			if (libraryUser.getUserType() != null) {
				existing.setUserType(libraryUser.getUserType());
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
