package com.capgimini.project.services;

import java.util.List;

import com.capgimini.project.entities.User;

public interface UserService {
	List<User> getAllUser();

	User getUserById(Long id);

	User createUser(User stu);

	User updateUser(Long id, User user);

	User patchUser(Long id, User user);

	boolean deleteUser(Long id);
}
