package br.com.rest.auth.resource.user;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface UserResourceProxy {
	 @GET 
	 @Produces( MediaType.APPLICATION_JSON )	
	 @RolesAllowed("admin")
	 Response getAll();

	 @GET
	 @Produces( MediaType.APPLICATION_JSON )
	 @Path("/{id}")
	 Response getById(@PathParam("id") String id);
}
