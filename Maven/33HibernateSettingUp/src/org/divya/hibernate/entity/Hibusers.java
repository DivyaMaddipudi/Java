package org.divya.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibusers")
public class Hibusers {
	
	@Id
	@Column(name="users_id")
	int usersId;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;

}
