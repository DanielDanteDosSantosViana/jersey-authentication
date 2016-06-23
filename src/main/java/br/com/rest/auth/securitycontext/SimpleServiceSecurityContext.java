package br.com.rest.auth.securitycontext;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import br.com.rest.auth.domain.User;

public class SimpleServiceSecurityContext implements SecurityContext {
	private User user;
	public SimpleServiceSecurityContext(User user) {
		this.user = user;
	}
	@Override
	public String getAuthenticationScheme() {
		return null;
	}

	@Override
	public Principal getUserPrincipal() {
		return user;
	}

	@Override
	public boolean isSecure() {
		
		return false;
	}

	@Override
	public boolean isUserInRole(String role) {
		if(this.user.getRole().equals(role)){
		  return true;
		}
		return false;
	}
	
	


}
