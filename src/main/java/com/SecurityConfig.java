package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // now this class contains security ruels
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {

		http.csrf().disable()
				// auth is object of AuthorizationManagerRequestMathcherRegistry.
				.authorizeRequests(auth -> auth
						.requestMatchers("/api/save").permitAll()
						.requestMatchers("/api/findall").permitAll()
						.requestMatchers("/api/findbyid/{id}").permitAll()
						.requestMatchers("/api/findbyname/{name}").permitAll()
						.requestMatchers("/api/findbydepartment/{dep}").permitAll()
						.requestMatchers("/api/findbyrole/{role}").permitAll()
						.requestMatchers("/api/findbysalary/{sal}").permitAll()
						.requestMatchers("/api/findbysalarygreter/{sal}").permitAll()
						.requestMatchers("/api/findbysalaryless/{sal}").permitAll()
						.requestMatchers("/api/findbyjoindate/{date}").permitAll()
						.requestMatchers("/api/findbydob/{dob}").permitAll()
						.requestMatchers("/api/deletebyid/{id}").permitAll()
						.requestMatchers("/api/updatebyid/{id}").permitAll()
						.requestMatchers("/leave/apply").permitAll()
						.requestMatchers("/leave/findallleaves").permitAll()
						.requestMatchers("/leave/updateleave/{id}").permitAll()
						.requestMatchers("/leave/cancelleave/{id}").permitAll()
						.requestMatchers("/leave/findleavebyid/{id}").permitAll()
						.requestMatchers("/leave/findbyemployeeid/{id}").permitAll()
						.requestMatchers("/leave/approve/{id}").permitAll()
						.requestMatchers("/leave/reject/{id}").permitAll()
						.requestMatchers("/user/registe").permitAll()
						.requestMatchers("/user/login").permitAll()
						.anyRequest().authenticated())
				// elsit.foreach(ele->System.out.println(ele))
				.formLogin();// show readymade login form

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
