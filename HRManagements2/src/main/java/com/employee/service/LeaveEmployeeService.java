package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.dao.LeaveEmployeeRepository;
import com.employee.entities.LeaveEmployee;
import com.employee.entities.ProjectDetails;

@Controller
public class LeaveEmployeeService
{
  
	@Autowired
	private LeaveEmployeeRepository leaveEmployeeRepository;
	
	
	//Save LeaveEmployee
	public LeaveEmployee addLeaveEmployee(LeaveEmployee leaveEmployee)
	{
	  LeaveEmployee	 leaveEmp=this.leaveEmployeeRepository.save(leaveEmployee);
		return leaveEmp;
	
	}
	
	
	//Get LeaveEmployee By Id
	public Optional<LeaveEmployee> getLeaveEmployeeById(int leaveId)
	{
	 Optional<LeaveEmployee>	leaveEmp=leaveEmployeeRepository.findById(leaveId);
		return leaveEmp;
	}
	
	
	
	
	
	//Get All Leave 
	public List<LeaveEmployee> getAllLeaveEmployee()
		{

		List<LeaveEmployee>	list=	(List<LeaveEmployee>) this.leaveEmployeeRepository.findAll();
		return list;
			
		}
	
	//Update the Leave  
	public void updateLeave(LeaveEmployee leaveEmp, int leaveId)
	{
		leaveEmp.setLeaveId(leaveId);
		leaveEmployeeRepository.save(leaveEmp);
		
	}
	
	
	//Delete The Project 
	public void deleteLeaveEmployee(int leaveId)
	{
		leaveEmployeeRepository.deleteById(leaveId);
		
	}
	
	
}
