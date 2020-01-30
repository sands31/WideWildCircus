package com.wildcodeschool.WideWildCircus.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
		    http
		    .sessionManagement()
        	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)	            
	        .and()
	        .authorizeRequests()
	        .antMatchers("/", "/articles", "/css/**", "/img/**", "/js/**").permitAll()
	        .antMatchers("/admin**").hasRole("ADMIN")
	            .and()
	        .formLogin()
	            .and()
	        .httpBasic()
		    	.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/");
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		    auth
	    		.inMemoryAuthentication()
	    			.withUser("wildchief")
		    			.password(encoder.encode("admin"))
		    			.roles("ADMIN");
		}
} 