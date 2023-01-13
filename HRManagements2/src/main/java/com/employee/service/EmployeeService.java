package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.entities.Employee;
import com.employee.dao.EmployeeRepository;


@Controller
public class EmployeeService 
{
    @Autowired
	private EmployeeRepository employeeRepository;
    
   
    // Get Employee By Id
    public Optional<Employee> getEmployeeById(int employeeId)
    {
    	Optional<Employee> employee=null;
    	try
    	{
    		employee=this.employeeRepository.findById(employeeId);	
    		return employee;
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    			
    	return employee;
    }
    
    

	
    // get All Employees
      public List<Employee> getAllEmployee()
	  {
	   
     List<Employee> list=(List<Employee>) this.employeeRepository.findAll();
	 return list;
	  }

      
      
      
    
    // Add new Employee
    public Employee addNewEmployee(Employee empl)
    {
    	System.out.println(empl.getFirstName());
    	
        Employee emp=(Employee) this.employeeRepository.save(empl);
		return emp;
    	
    }
    
    
    
    //Update Employee
    public void updateEmployeeById(int id, Employee emp)
    {
    	emp.setEmployeeId(id);
    	employeeRepository.save(emp);
    }
    
    
    
    //Delete Employee
    public void deleteEmployeeById(int empId)
    {
    	employeeRepository.deleteById(empId);
    }
    
    
    
    
}
