package com.mybbs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component("user")
@Entity
@Table(name="yazduser")
public class User {
	@Column(name="userID")
	@Id
	private Integer id;
	private String name;
	private String username;
	
	@Column(name="passwordHash")
	private String password;
	
	private String email;
	//private UserWithCons userWithCons;
	
	public User(){}
//	public User(UserWithCons userWithCons){
//		this.userWithCons = userWithCons;
//	}
//	public UserWithCons getUserWithCons() {
//		return userWithCons;
//	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "id:"+id+",name:"+name+",username:"+username+",email:"+email;
	}
}
