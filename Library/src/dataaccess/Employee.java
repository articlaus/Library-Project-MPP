package dataaccess;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Role role;
	
	public Employee(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
		
	}
	
	public Role getRole() {
		return role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
