package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	@Id
	private int id = 1;
	
	private String name ="admin";
	
	private String email="admin@gmail.com";
	
	private String password="admin";
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
	private List<User> users;

}
