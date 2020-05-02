package com.study.jpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userposts")
public class UserPost {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String description;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private JpaUser user;
	
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUser(JpaUser user) {
		this.user = user;
	}

}
