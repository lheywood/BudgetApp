package com.personalbudgetapp.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.personalbudgetapp.domain.Authority;
import com.personalbudgetapp.domain.User;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 6305534786108730691L;

	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	public SecurityUser() {}
	
	public SecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setBudgets(user.getBudgets());
		this.setId(user.getId());
		this.setPassword(encoder.encode(user.getPassword()));
		this.setUsername(user.getUsername());
	}

	@Override
	public Set<Authority> getAuthorities() {
		// TODO Auto-generated method stub
		return super.getAuthorities();
	}	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
