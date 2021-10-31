package com.webproject.newsblog.services;

import com.webproject.newsblog.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

	User findUserByUsername(String username);
	void saveUser(User user, String role);
	List<User> findAll();
	
}
