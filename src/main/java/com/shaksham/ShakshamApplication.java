package com.shaksham;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.shaksham.security.JWTAuthorizationFilter;

@SpringBootApplication
//@SpringBootTest(classes=com.shaksham.path.class)
//@SpringBootTest

public class ShakshamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShakshamApplication.class, args);
		System.out.print("Project Initialized...");
	}
	
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.antMatchers(HttpMethod.GET, "/shg/shgrequests").permitAll()
				.antMatchers(HttpMethod.GET, "/shg/verifySHG/{shgId}").permitAll()
				.antMatchers(HttpMethod.POST, "/register").permitAll()
				.antMatchers(HttpMethod.GET, "/getusername/{email}").permitAll()
				.anyRequest().authenticated();
		}
	}
}
