package com.stackbill.entitys;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")

public class UserEntity {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	    private String username;
	    private long phoneNumber;
	    private String email;
	    private String password;
	    private String confirmPassword;
	    
	    public UserEntity() {
			super();
		}
	    
		public UserEntity(Long id, String username, long phoneNumber, String email, String password,
				String confirmPassword) {
			super();
			this.id = id;
			this.username = username;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.password = password;
			this.confirmPassword = confirmPassword;
		}

		public String getUsername() {
			return username;	
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public long getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		@Override
		public String toString() {
			return "Entity [id=" + id + ", username=" + username + ", phoneNumber=" + phoneNumber + ", email=" + email
					+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
		}
}