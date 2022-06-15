package iuh.se.springboot.springbootcrudspringdatajpa.service;

import java.util.List;

import iuh.se.springboot.springbootcrudspringdatajpa.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> getEmployees();
    public void saveEmployee(Employee theEmployee);
    public Employee getEmployee(int theId);
    public void deleteEmployee(int theId);

}
