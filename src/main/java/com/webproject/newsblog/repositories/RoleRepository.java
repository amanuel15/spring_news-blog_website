package com.webproject.newsblog.repositories;

import com.webproject.newsblog.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

	 Role findByRole(String role);

	 
}
