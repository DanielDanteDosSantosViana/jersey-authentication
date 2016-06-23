package br.com.rest.auth.domain;

import java.security.Principal;

/**
 * Classe de dominio User
 * @author daniel
 *
 */
public class User implements Principal {

	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	private String role;
	private String senha;
	
	public User(String nome,String telefone,String endereco,String email,String senha,String role){
		this.endereco = endereco;
		this.nome = nome;
		this.telefone = telefone;
		this.senha = senha;
		this.role = role;
		this.email = email;
	}

	
	public User(){}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
}
