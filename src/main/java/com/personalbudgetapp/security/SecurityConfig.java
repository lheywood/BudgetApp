package com.personalbudgetapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Prevents the session injections to other sessions
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/js/*", "/css/*").permitAll()
				.antMatchers("/**").hasRole("USER").and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/budgets").and()
			.logout()
				.logoutSuccessUrl("/")
				.permitAll();
	}
}
