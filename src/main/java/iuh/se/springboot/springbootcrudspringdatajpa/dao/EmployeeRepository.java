package iuh.se.springboot.springbootcrudspringdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import iuh.se.springboot.springbootcrudspringdatajpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
