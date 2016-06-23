package br.com.rest.auth.resource.account;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import br.com.rest.auth.authorization.Authenticator;
import br.com.rest.auth.resource.account.requestParam.LogginParam;
@Path("account")
@PermitAll
public class AccountResource implements AccountResourceProxy{
	
	public Response loggin(LogginParam logginParam) {
		String token = Authenticator.login(logginParam.getPassword(),logginParam.getName());
		if(token!=null){
			return Response.status(Response.Status.ACCEPTED).entity(token).build();			
		}else{
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
	public Response logout(HttpHeaders header) {
		Authenticator.logout(header);
		return null;
	}

}
