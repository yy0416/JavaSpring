package com.example.MamazonBack.Model.DTO;


public class UserDTO {
	private Long id;
	private String name;
	private String email;
	private String password;
	private int age;
	private Long panierId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getPanierId() {
		return panierId;
	}
	public void setPanierId(Long panierId) {
		this.panierId = panierId;
	}
	

	
}
