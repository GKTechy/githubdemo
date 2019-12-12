package com.app.springbootjpah2.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositiroy  extends JpaRepository<Employee, Long>{
	
}
