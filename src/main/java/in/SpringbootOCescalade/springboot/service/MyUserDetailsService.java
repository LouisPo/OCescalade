package in.SpringbootOCescalade.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import in.SpringbootOCescalade.springboot.model.Employee;
import in.SpringbootOCescalade.springboot.model.EmployeeDatabase;
import in.SpringbootOCescalade.springboot.model.EmployeeDatabaseRepository;

public class MyUserDetailsService {
	/* public class MyUserDetailsService implements UserDetailsService { */

	@Autowired
	private EmployeeDatabaseRepository userRepository;

	public void loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<EmployeeDatabase> user = userRepository.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		}

	}
}