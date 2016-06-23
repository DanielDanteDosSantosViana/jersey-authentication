package br.com.rest.auth.authorization;

import javax.ws.rs.core.HttpHeaders;

import br.com.rest.auth.dao.UserDAO;
import br.com.rest.auth.domain.User;
import br.com.rest.auth.token.JwtUtil;

public class Authenticator {

	public static String login(String pwd ,String nome){
		User user = UserDAO.getUsuario(pwd, nome);
		if(user!=null){
			return JwtUtil.generatorToken(user);
		}
		return null;
	}
	
	public static void logout(HttpHeaders header){
		 if(header.getHeaderString("Authorization")!=null){
			 header.getRequestHeaders().remove("Authorization");
		 }
	}
}
