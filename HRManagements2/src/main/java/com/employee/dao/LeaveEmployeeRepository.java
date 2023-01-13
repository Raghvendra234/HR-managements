package com.employee.dao;

import org.springframework.data.repository.CrudRepository;

import com.employee.entities.LeaveEmployee;

public interface LeaveEmployeeRepository extends CrudRepository<LeaveEmployee, Integer>
{

}
