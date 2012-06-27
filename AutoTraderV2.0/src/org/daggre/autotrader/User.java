package org.daggre.autotrader;

import javax.ws.rs.core.NewCookie;

public class User {
	private String uName;
	private String password;
	private NewCookie cookie;
	
	User() {}
	
	User(String uname) {
		setUsername(uname);
	}
	
	User(String uname, String pwd) {
		setUsername(uname);
		setPassword(pwd);
	}
	

	public void setUsername (String username){
		uName = username;
	}
	public void setPassword (String pwd){
		password = pwd;
	}
	public void setCookie (NewCookie sessionCookie){
		cookie = sessionCookie;
	}

	public String getUsername (){
		return(uName);
	}
	public String getPassword (){
		return(password);
	}
	public NewCookie getCookie (){
		return(cookie);
	}

}
