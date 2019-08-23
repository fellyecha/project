package com.bcaf.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bcaf.project.model.User;
import com.bcaf.project.repository.UserRepo;

@Service
public class UserPrincipalService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	
	public UserPrincipalService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		return userPrincipal;
	}

}
