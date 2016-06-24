package br.com.rest.auth.token;

import java.util.Calendar;

import br.com.rest.auth.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	private static String SECRET = "Darth_Vader";
	

	public static User decodeToken(String toke) throws JwtException{
		
			Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(toke).getBody();
			User user = new User();
			user.setNome(body.getSubject());
			user.setRole((String)body.get("role"));
			user.setEmail((String)body.get("email"));
			return user;
	
	}
	public static String generatorToken(User user){
		Calendar dataExpiracao = Calendar.getInstance();
		dataExpiracao.add(Calendar.MINUTE, 3);
		Claims claim = Jwts.claims().setSubject(user.getNome());
		claim.put("email",user.getEmail());
		claim.put("role", user.getRole());
		claim.setExpiration(dataExpiracao.getTime());
		return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}
}
