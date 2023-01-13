package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.LeaveEmployee;
import com.employee.entities.ProjectDetails;
import com.employee.service.LeaveEmployeeService;

@RestController
public class LeaveEmployeeController
{
	@Autowired
	private LeaveEmployeeService leaveEmployeeService;
	

	
	//Add Leave
	@PostMapping("/leaveemployee")
	public ResponseEntity<LeaveEmployee> addLeave(@RequestBody LeaveEmployee leaveEmployee)
	{
	  try
		{
		LeaveEmployee leaveEmp=this.leaveEmployeeService.addLeaveEmployee(leaveEmployee);
		return ResponseEntity.of(Optional.of(leaveEmp));
		}catch(Exception e)
		{
		  e.printStackTrace();
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Get LeaveEmployee By Id
	@GetMapping("/leaveemployee/{leaveId}")
	public ResponseEntity<Optional<LeaveEmployee>>  findLeaveById(@PathVariable ("leaveId") int leaveId)
	{
		
		Optional<LeaveEmployee> leaveEmp=this.leaveEmployeeService.getLeaveEmployeeById(leaveId);
		
		if(leaveEmp==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
		{
		return ResponseEntity.of(Optional.of(leaveEmp));
		}
		}
	
	
	
	
	
	
  //Get All LeaveEmployee
   @GetMapping("/leaveemployee")
   public ResponseEntity<List<LeaveEmployee>> getAllLeave()
   {
	 try
	 {
	  List<LeaveEmployee> list=leaveEmployeeService.getAllLeaveEmployee();
	  return ResponseEntity.of(Optional.of(list));	
	 }catch(Exception e)
	 {
		 e.printStackTrace();
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	 }
		   
   }
   
   //Update Leave
  	@PutMapping("/leaveemployee/{leaveId}")
  	public ResponseEntity<ProjectDetails> updateProjectById(@RequestBody LeaveEmployee leaveEmployee, @PathVariable ("leaveId") int leaveId)
  	{
  		try
  		{
  		leaveEmployeeService.updateLeave(leaveEmployee, leaveId);
  		return  ResponseEntity.ok(null);
  		}catch(Exception e)
  		{
  			e.printStackTrace();
  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  		}
  	}
  	
  	
      //Delete Leave by Id
      @DeleteMapping("/leaveemployee/{leaveId}")	
  	public ResponseEntity<LeaveEmployee> deleteProjectById(@PathVariable ("leaveId") int leaveId)
  	{
      	try
      	{
  		this.leaveEmployeeService.deleteLeaveEmployee(leaveId);
  		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      	}catch(Exception e)
      	{
      		e.printStackTrace();
      		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      	}
	
}
}















