package br.com.rest.auth.resource.account.requestParam;

public class LogginParam {

	private String name;
	private String password;
	
	public LogginParam() {
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
