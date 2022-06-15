package iuh.se.springboot.springbootcrudspringdatajpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import iuh.se.springboot.springbootcrudspringdatajpa.entity.Employee;
import iuh.se.springboot.springbootcrudspringdatajpa.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
		
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService= theEmployeeService;
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee theEmployee) {

		theEmployee.setId(0);
		employeeService.saveEmployee(theEmployee);
		return theEmployee;

	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee theEmployee = employeeService.getEmployee(id);
		if (theEmployee == null) {
			throw new EmployeeNotFoundException("Employee is not found - " + id);
		}
		employeeService.deleteEmployee(id);
		return "Delete Employee id= " + id;
	}

	@GetMapping("/employees")
	public List<Employee> listEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee theEmployee = employeeService.getEmployee(id);
		if (theEmployee == null) {
			throw new EmployeeNotFoundException("Employee is not found - " + id);
		}
		return theEmployee;
	}


}
