package com.app.springbootjpah2.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepositiroy empRepo;
	
	@GetMapping("/api/employees")
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	@GetMapping("/api/employeesByName")
	public List<Employee> employeesByName(){
		return empRepo.findAll(Sort.by(Sort.Direction.ASC,"employeeName"));
	}
	
	@GetMapping("/api/employee/{employeeId}")
	public Employee getAllEmployee(@PathVariable(name="employeeId") Long employeeId ){
		Optional<Employee> emp =empRepo.findById(employeeId);
		return emp.get();
	}
	
	
	@PostMapping("/api/employee")
	public  void saveEmployee(Employee emp) {
			empRepo.save(emp);
		System.out.println("Emplyee Successfully Inserted");
	}
	
	@DeleteMapping("/api/employee/{employeeId}")
	public void deleteEmployee(@PathVariable(name="employeeId") Long employeeId ) {
		empRepo.deleteById(employeeId);
		System.out.println("Emplyee Successfully Deleted ");
	}
	
	@PutMapping("/api/employee/{employeeId}")
	public void updateEmployee(@PathVariable(name="employeeId") Long employeeId ,Employee emp) {
		Optional<Employee> emplyee =empRepo.findById(employeeId);
		if(emplyee !=null) {
			empRepo.save(emp);
		}
		System.out.println("Emplyee Successfully Updated ");
	}
}
