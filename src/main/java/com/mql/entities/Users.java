package com.mql.entities;

import java.io.Serializable;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Role",discriminatorType=DiscriminatorType.STRING,length=8)
public class Users implements Serializable {
	 /**      
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 @Id @GeneratedValue
	 private Long id;
	 private String name;
	 private String password;
	 private String email;
	 private String tel;
	 private String photo;
	
	public Users(String username, String password, String email, String tel) {
		super();
		this.name = username;
		this.password = password;
		this.email = email;
		this.tel = tel;
	}
	
	public Users(String username, String password, String email, String tel, String photo) {
		super();
		this.name = username;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.photo = photo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id_User) {
		this.id = id_User;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String username) {
		this.name = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String username, String password) {
		super();
		this.name = username;
		this.password = password;
		
	}
	
	 
}
