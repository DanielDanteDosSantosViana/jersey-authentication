package br.com.rest.auth.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import br.com.rest.auth.domain.User;
import br.com.rest.auth.securitycontext.SimpleServiceSecurityContext;
import br.com.rest.auth.token.JwtUtil;
import io.jsonwebtoken.JwtException;

@Provider
@PreMatching
public class SimpleServiceRequestFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		if(!isAccountPath(requestContext)){
			String headerAuth = requestContext.getHeaderString("Authorization");
			
		   if(headerAuth==null){
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build()); 
				return;
			}
			try{
				User user = JwtUtil.decodeToken(headerAuth);	
				requestContext.setSecurityContext(new SimpleServiceSecurityContext(user));

			}catch(JwtException jex){
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build()); 
				return;
			}
		}
	}

	private boolean isAccountPath(ContainerRequestContext requestContext) {
		return requestContext.getUriInfo().getPath(true).contains("account");
	}

}
