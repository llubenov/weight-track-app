package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserDBRepository implements UserRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getUsers() {
		Query query = manager.createQuery("Select a FROM User a");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}

	@Transactional(REQUIRED)
	public String createUser(String jsonUser) {
		User aUser = util.getObjectForJSON(jsonUser, User.class);
		manager.persist(aUser);
		return "{\"message\": \"user has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteUser(Long id) {
		User userDB = findUser(id);
		if (userDB != null) {
			manager.remove(userDB);
		}
		return "{\"message\": \"user sucessfully deleted\"}";
	}
	
	public String getUser(Long id) {
		User aUser =  manager.find(User.class, id);
		return util.getJSONForObject(aUser);
	}

	private User findUser(Long id) {
		return manager.find(User.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	

}
