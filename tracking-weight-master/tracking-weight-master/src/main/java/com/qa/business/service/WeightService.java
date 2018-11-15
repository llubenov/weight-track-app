package com.qa.business.service;

public interface WeightService {

	String getUsers();

	String addUser(String user);

	String deleteUser(Long id);

	String getUser(Long id);

}