package com.webproject.newsblog.services;

import com.webproject.newsblog.repositories.RoleRepository;
import com.webproject.newsblog.security.Role;
import com.webproject.newsblog.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
	
	 private final RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Iterable<Role> saveAll(Iterable<Role> roles) {
		return roleRepository.saveAll(roles);
	}

	@Override
	public Optional<Role> findById(Long id) {
		return roleRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return roleRepository.existsById(id);
	}

	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Iterable<Role> findAllById(Iterable<Long> ids) {
		return roleRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return roleRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
	}

	@Override
	public void deleteAll(Iterable<Role> roles) {
		roleRepository.deleteAll(roles);
	}

	@Override
	public void deleteAll() {
		roleRepository.deleteAll();
	}

	@Override
	public String findRole(User user) {
		Set<Role> role = user.getRoles();
		return role.toString();
	}

}
