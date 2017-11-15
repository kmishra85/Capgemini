package com.cg.cheapstays.bean;

public class AdminDetails {
	private String adminUsername;
	private String adminPassword;
	
	
	public AdminDetails() {
		
	}
	
	
	public AdminDetails(String adminUsername, String adminPassword) {
		super();
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
	@Override
	public String toString() {
		return "AdminDetails [adminUsername=" + adminUsername
				+ ", adminPassword=" + adminPassword + "]";
	}
	
	public String getAdminUsername() {
		return adminUsername;
	}
	
	public String setAdminUsername(String adminUsername) {
		return this.adminUsername = adminUsername;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	public String setAdminPassword(String adminPassword) {
		return this.adminPassword = adminPassword;
	}

}
