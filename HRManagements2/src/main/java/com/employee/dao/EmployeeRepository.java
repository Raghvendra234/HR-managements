package com.employee.dao;

import org.springframework.data.repository.CrudRepository;

import com.employee.entities.*;

public interface EmployeeRepository  extends CrudRepository<Employee, Integer>
{

}
