package com.capgimini.project.services;

import java.util.List;

import com.capgimini.project.entities.libraryUser;

public interface UserService {
	List<libraryUser> getAllUser();

	libraryUser getUserById(Long id);

	libraryUser createUser(libraryUser stu);

	libraryUser updateUser(Long id, libraryUser libraryUser);

	libraryUser patchUser(Long id, libraryUser libraryUser);

	boolean deleteUser(Long id);
}
