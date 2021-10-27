package com.spring5.prueba;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;



@SpringBootApplication
public class ProyectoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
			configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081","http://localhost:132.145.24.245"));
			configuration.setAllowedMethods(Arrays.asList("GET", "POST", "HEAD", "PUT", "DELETE"));
			configuration.setAllowCredentials(true);
			configuration.setExposedHeaders(Arrays.asList("Authorization"));
			
			http.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers(HttpMethod.POST, "/api/auth").permitAll().anyRequest().authenticated()
			    .and().csrf().disable().cors().configurationSource(request -> configuration);
			   
			    
		}
	}
}
