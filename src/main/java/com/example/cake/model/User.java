/**
 * 
 */
package com.example.cake.model;

import com.example.cake.entity.UserEntity;

/**
 * 
 */
public class User {
	
	private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    
    public User() {
		super();
	}

	public User(UserEntity userEntity) {
		super();
		this.id = userEntity.getId();
		this.name = userEntity.getName();
		this.email = userEntity.getEmail();
		this.phone = userEntity.getPhone();
		this.address = userEntity.getAddress();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
