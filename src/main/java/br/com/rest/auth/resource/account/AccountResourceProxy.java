package br.com.rest.auth.resource.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rest.auth.resource.account.requestParam.LogginParam;

public interface AccountResourceProxy {
	
	@POST
	@Path("/loggin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response loggin( LogginParam logginParam);


	@POST
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	Response logout(
		@Context HttpHeaders header);
}
