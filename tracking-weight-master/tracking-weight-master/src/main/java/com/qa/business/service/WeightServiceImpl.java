package com.qa.business.service;


import com.qa.persistence.repository.UserRepository;

import javax.inject.Inject;

public class WeightServiceImpl implements WeightService {

	@Inject
	private UserRepository repo;

	public String getUsers() {
		return repo.getUsers();
	}

	public String addUser(String user) {
		return repo.createUser(user);
	}


	public String deleteUser(Long id) {
		return repo.deleteUser(id);
	}
	
	public String getUser(Long id) {
		return repo.getUser(id);
	}

	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}


}
