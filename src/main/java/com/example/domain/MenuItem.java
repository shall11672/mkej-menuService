package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MenuItem {
	
	MenuItem(){//why JPA?  why?
	}
	
	public MenuItem(String name) {
		this.name = name;
	}
	
	@Id @GeneratedValue	
	private Long Id;
	private String name;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.Id + "  " + this.name;
	}
}
