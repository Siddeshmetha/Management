package com.sid.models;



import java.util.Collection;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Users implements UserDetails {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private  Integer id;
		
		@Column(name="name" , nullable=false, length=20)
	
		
		private String name;
	
		@Column(nullable = false, unique = true)
		private String email;
	
		private String password;
	
		
	
	
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
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
		public Users() {
			super();
			
		}
		
		@Enumerated(EnumType.STRING)
		private Role role;
		
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
//			SimpleGrantedAuthority simpleGrantedAuthority=  new SimpleGrantedAuthority(role.toString());
			String roleName = "ROLE_" + role.toString();
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);

			return List.of(simpleGrantedAuthority);
//			return authorities;
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return email;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public String toString() {
			return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
					+ role + "]";
		}
		
		
}
