package com.bcaf.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserPrincipalService userService;
	
	@Override
	public void configure(final AuthenticationManagerBuilder auth){
		/*
		auth.inMemoryAuthentication()
			.withUser("user1").password(passwordEncoder().encode("user123")).roles("USER")
			.and()
			.withUser("user2").password(passwordEncoder().encode("user123")).roles("USER","ADMIN","MANAGER")
			.and()
			.withUser("admin1").password(passwordEncoder().encode("admin123")).roles("ADMIN")
			.and()
			.withUser("manager1").password(passwordEncoder().encode("manager123")).roles("MANAGER");
			
		*/
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	
	@Override
	public void configure(final HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/home").hasRole("USER")
		.antMatchers("/home","/admin","/provinsi/*").hasRole("ADMIN")
		.antMatchers("/manager").hasRole("MANAGER")
		.antMatchers("/home","/admin","/provinsi/*").hasRole("CMCDH")
		.antMatchers("/home","/admin","/provinsi/*").hasRole("CMC")
		.antMatchers("/home","/admin","/provinsi/*").hasRole("RM")
		.antMatchers("/home","/admin","/provinsi/*").hasRole("BM")
		.antMatchers("/home","/admin","/provinsi/*").hasRole("CMONEW")
		.antMatchers("/home","/admin","/provinsi/*").hasRole("CMOREF")
		.antMatchers("/home","/admin","/provinsi/*").hasRole("CMOMUL")
		.antMatchers("/login").permitAll()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/home")
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(2)
		.expiredUrl("/session-expired");
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setPasswordEncoder(passwordEncoder());
		daoAuthProvider.setUserDetailsService(this.userService);
		return daoAuthProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
