package com.qa.persistence.repository;

public interface UserRepository {

	String getUsers();
	String createUser(String user);
	String deleteUser(Long id);
	String getUser(Long id);

}