package br.com.rest.auth.resource.user;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.rest.auth.dao.UserDAO;
import br.com.rest.auth.domain.User;

/**
 * Classe os Recurso de Usuário
 */
@Path("usuario")
@PermitAll
public class UserResource implements UserResourceProxy {

 	public Response getAll() {
 			List<User> users  =  UserDAO.getUsers();
 			if(users!=null && !users.isEmpty()){
 				GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users){};
 				return Response.status(Status.ACCEPTED).entity(entity).build();
 			}else{
 				return Response.status(Status.BAD_REQUEST).build();	
 			}
 			
 	}	

	 public Response getById(String id) {
 			User user  =  UserDAO.getUserById(id);
 			if(user!=null){
 				return Response.status(Status.ACCEPTED).entity(user).build();
 			}else{
 				return Response.status(Status.BAD_REQUEST).build();	
 			}
 			
 	}
 	
}
