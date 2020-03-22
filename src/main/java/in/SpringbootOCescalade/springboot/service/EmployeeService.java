package in.SpringbootOCescalade.springboot.service;

import java.util.List;

import in.SpringbootOCescalade.springboot.model.*;

public interface EmployeeService {
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
