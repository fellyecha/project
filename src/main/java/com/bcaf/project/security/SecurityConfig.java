package com.bcaf.project.security;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//tambahan dari pak roni kecuali AntPathRequestMatcher
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.bcaf.project.repository.UserRepo;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserPrincipalService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	public SecurityConfig(UserPrincipalService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }
	
	@Override
	public void configure(final AuthenticationManagerBuilder auth){
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
        // add jwt filters (1. authentication, 2. authorization)
//        .addFilter(new JwtAuthenticationFilter(authenticationManager()))
//        .addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.userRepo))
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
//		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers("/home", "/custDataCMO/*").hasAnyRole("USER","CMONEW","CMOREF","CMOMUL")
		.antMatchers("/manager", "/custDataBM/*").hasAnyRole("MANAGER","RM","BM")
		.antMatchers("/admin","/provinsi/*", "/kabkota/*", "/kecamatan/*", "/kelurahan/*", "/position/*", "/cabangBca/*", "/cabangBcaf/*", "/cabangDs/*", "/customerData/*", "/employee1/*", "/customerData/*", "/api/public/admin/*").hasAnyRole("ADMIN","CMCDH","CMC")
		.antMatchers("/api/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/default",true)
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
