package com.bcaf.project.security;

import java.util.LinkedHashMap;

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
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

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
	
	@Bean
	public AuthenticationEntryPoint delegatingEntryPoint() {
	    final LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> map = new LinkedHashMap();
	    map.put(new AntPathRequestMatcher("/"), new LoginUrlAuthenticationEntryPoint("/login"));
	    map.put(new AntPathRequestMatcher("/api/**"), new Http403ForbiddenEntryPoint());

	    final DelegatingAuthenticationEntryPoint entryPoint = new DelegatingAuthenticationEntryPoint(map);
	    entryPoint.setDefaultEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));

	    return entryPoint;
	}
	
	
	@Override
	public void configure(final HttpSecurity http) throws Exception{
		//delegates based on url (api vs root)
	    http.exceptionHandling().authenticationEntryPoint(delegatingEntryPoint());
	    
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(
				"/bootstrap/dist/css/**","/bootstrap/dist/fonts/**","/bootstrap/dist/js/**",
				"/bootstrap-datepicker/dist/css/**","bootstrap-datepicker/dist/fonts/**","/bootstrap-datepicker/dist/js/**","/bootstrap-daterangepicker/**",
				"/datatables.net/css/**","/datatables.net/js/**","/datatables.net-bs/css/**","/datatables.net-bs/js/**",
				"/dist/css/**","/dist/img/**","/dist/js/**","/fastclick/lib/**",
				"/font-awesome/css/**","/font-awesome/fonts/**","/font-awesome/less/**","/font-awesome/scss/**",
				"/iCheck/flat/**","/iCheck/futurico/**","/iCheck/line/**","/iCheck/minimal/**","/iCheck/polaris/**","/iCheck/square/**","/iCheck/**",
				"/Ionicons/css/**","/Ionicons/fonts/**","/Ionicons/less/**","/Ionicons/scss/**","/Ionicons/src/**","/Ionicons/png/**",
				"/jquery/dist/**","/jquery-slimscroll/**","/jquery-ui/**","/moment/**","/select2/dist/css/**","/select2/dist/js/**").permitAll()
		.antMatchers("/home").hasRole("USER")
		.antMatchers("/manager").hasRole("MANAGER")
		.antMatchers("/home","/admin","/provinsi/*").hasAnyRole("ADMIN","CMCDH","CMC","RM","BM","CMONEW","CMOREF","CMOMUL")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/home",true)
		.loginProcessingUrl("/login")
		.permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(2);
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
