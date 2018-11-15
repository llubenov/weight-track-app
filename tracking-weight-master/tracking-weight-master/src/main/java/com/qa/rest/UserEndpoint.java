package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.WeightService;

@Path("/users")
public class UserEndpoint {
	
	@Inject
	private WeightService service;

	@Path("/getUsers")
	@GET
	@Produces({ "application/json" })
	public String getUsers() {
		return service.getUsers();
	}
	
	@Path("/getUser/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies(@PathParam("id") Long id) {
		return service.getUser(id);
	}

	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String addUser(String movie) {
		return service.addUser(movie);
	}

	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") Long id) {
		return service.deleteUser(id);
	}

	public void setService(WeightService service) {
		this.service = service;
	}

}
