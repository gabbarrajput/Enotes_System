package com.gabbar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nane;
   private String qualification;
   private String address;
   private String email;
   private String password;
   private String gender;
   private String role;
   
   
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNane() {
	return nane;
}
public void setNane(String nane) {
	this.nane = nane;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "User [id=" + id + ", nane=" + nane + ", qualification=" + qualification + ", address=" + address
			+ ", email=" + email + ", password=" + password + ", gender=" + gender + ", role=" + role + "]";
}
   
   
}
