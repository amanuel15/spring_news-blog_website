package com.webproject.newsblog.repositories;


import com.webproject.newsblog.security.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	User findByFirstName(String firstname);
	List<User> findAll();
	
}
