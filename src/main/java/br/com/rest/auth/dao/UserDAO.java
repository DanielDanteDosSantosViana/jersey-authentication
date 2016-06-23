package br.com.rest.auth.dao;

import java.util.ArrayList;

import br.com.rest.auth.domain.User;

public class UserDAO {
	
	private final static String SENHA = "1234";
	static ArrayList<User> usuarios = new ArrayList<>();
	
	static{
		usuarios.add(new User("Daniel","3598-9809","Rua DevMedia","danielvianarj@gmail.com",SENHA,"admin"));
		usuarios.add(new User("Henrique","3598-9809","Rua DevMedia","danielvianarj@gmail.com",SENHA,"admin"));
		usuarios.add(new User("Larissa","3598-9809","Rua DevMedia","danielvianarj@gmail.com",SENHA,"user"));
		usuarios.add(new User("Java","3598-9809","Rua DevMedia","danielvianarj@gmail.com",SENHA,"admin"));
		
			
	}
	public static User getUsuario(String senha, String nome){
		for (User user : usuarios) {
			if(user.getNome().equals(nome) && user.getSenha().equals(senha)){
				return user;
			}
		}
		return null;
	}
	
	public static User getUsuarioByNome(String nome){
		for (User user : usuarios) {
			if(user.getNome().equals(nome)){
				return user;
			}
		}
		return null;
	}
	
	public static ArrayList<User> getUsuarios(){
		return usuarios;
	}	

}
