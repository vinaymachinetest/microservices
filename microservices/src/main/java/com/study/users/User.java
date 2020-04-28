package com.study.users;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Description about user") //swagger annotation
public class User {
	private Integer id;
	
	@Size(min=3, message = "name should have at least 3 char")//it means name at 3 char
	@ApiModelProperty(notes="name should have at least 3 char")//swagger annotation
	private String name;
	
	@Past //it means birthdate always be past date not future date
	@ApiModelProperty(notes="birth should be past date")//swagger annotation
	private Date birthDate;	
	
	protected User() {
			
	}
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
