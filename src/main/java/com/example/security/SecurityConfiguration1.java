package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration1 extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Use In-MemoryAutentication with different username/password/role combination
		auth.inMemoryAuthentication()
		.withUser("juj").password(getPasswordEncoder().encode("pap")).roles("ADMIN")
		.and()
		.withUser("sab").password(getPasswordEncoder().encode("sab")).roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Apply the defined role to the enpoint 
		//http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		http.authorizeRequests()
		.antMatchers("/getUsers").hasRole("ADMIN")
		.antMatchers("/getUserById*").hasRole("USER")
		.and()
		.httpBasic();
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
