package br.com.rest.auth.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.rest.auth.domain.User;

public class UserDAO {
	
	private final static String PWD = "1234";
	static List<User> users = new ArrayList<>();
	
	static{
		users.add(new User("Daniel","3598-9809","Rua DevMedia","danielvianarj@gmail.com",PWD,"admin","1"));
		users.add(new User("Henrique","3598-9809","Rua DevMedia","danielvianarj@gmail.com",PWD,"admin","2"));
		users.add(new User("Larissa","3598-9809","Rua DevMedia","danielvianarj@gmail.com",PWD,"user","3"));
		users.add(new User("Java","3598-9809","Rua DevMedia","danielvianarj@gmail.com",PWD,"admin","4"));
	}

	public static User getUsuario(String senha, String nome){
		for (User user : users) {
			if(user.getNome().equals(nome) && user.getSenha().equals(senha)){
				return user;
			}
		}
		return null;
	}
	
	public static User getUserById(String id){
		for (User user : users) {
			if(id.equals(user.getId())){
				return user;
			}
		}
		return null;
	}
	
	public static List<User> getUsers(){
		return users;
	}	

}
