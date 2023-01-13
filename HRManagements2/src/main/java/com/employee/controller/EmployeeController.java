package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.*;
//import com.employee.entities.Address;
//import com.employee.entities.Qualification;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
@CrossOrigin("*")
public class EmployeeController 
{
	
	@Autowired
	private EmployeeService employeeService;
	
	//@Autowired
    //private Address address;
    //@Autowired
	//private Qualification qualification;
	
	
	//Get single Employee URL/handler
	@GetMapping("{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable ("id") int id)
	{
	 Optional<Employee> employee=employeeService.getEmployeeById(id);
	  
	    if(employee==null)
	    {
	     return	ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	 
	    return ResponseEntity.of(Optional.of(employee));
		
    	}
	
	
	
	
	// Get All employee
	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
	  List<Employee> list=employeeService.getAllEmployee();
	  
	   if(list.size()<=0)
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	   
     	   return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
	}
	
	
	
	//Save employee
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	 {
				
		try
	    	{
		     //System.out.println(address.getPermanentAddress());
		     //System.out.println(qualification.getCourse());
			 System.out.println(employee.getFirstName());
			 System.out.println(employee.getLastName());
			 
			 
			 Employee em=employeeService.addNewEmployee(employee);
			 return ResponseEntity.of(Optional.of(em));
		
		   }catch(Exception e)
		   {
		    e.printStackTrace();
	     	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		   }
	 }


	
	
	// Update Employee By Id
	@PutMapping("{employeeId}")
	public ResponseEntity updateEmployee(@PathVariable ("employeeId") int employeeId, @RequestBody Employee empl)
	{
		try
		{
		this.employeeService.updateEmployeeById(employeeId, empl);
		
       return ResponseEntity.ok(null);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	
	
	//Delete Employee
	@DeleteMapping("{employeeId}")
	   public ResponseEntity<Void> deleteBook(@PathVariable("employeeId") int empId)
	   {
		   try
		   {
		   this.employeeService.deleteEmployeeById(empId);
		
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		   }catch(Exception e)
		   {
			   e.printStackTrace();
			   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  
		   }
		   
	   }



}
