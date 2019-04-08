package com.yzk.studentweb.model;

public class User {
	private String username;
	private String password;
	private String name;
	private int id;
	public User(String username, String password, String name, int id) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.id = id;
	}
	public User(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", id=" + id + "]";
	}
	
}