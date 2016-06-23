package br.com.rest.auth.resource.user;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Path;
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
 			ArrayList<User> usuarios  =  UserDAO.getUsuarios();
 			if(usuarios!=null && !usuarios.isEmpty()){
 				return Response.status(Status.ACCEPTED).entity(usuarios.get(0)).build();
 			}else{
 				return Response.status(Status.BAD_REQUEST).build();	
 			}
 			
 	}	

	 public Response getById(String nome) {
 			User usuario  =  UserDAO.getUsuarioByNome(nome);
 			if(usuario!=null){
 				return Response.status(Status.ACCEPTED).entity(usuario).build();
 			}else{
 				return Response.status(Status.BAD_REQUEST).build();	
 			}
 			
 	}
 	
}
