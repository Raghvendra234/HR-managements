package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.dao.AddSalaryRepository;
import com.employee.entities.AddSalary;
import com.employee.entities.LeaveEmployee;

@Controller
public class AddSalaryService
{
	@Autowired
	private AddSalaryRepository addSalaryRepository;
	
	//Add salary
	public AddSalary saveSalary(AddSalary addSalary)
	{
		
	   AddSalary salary=this.addSalaryRepository.save(addSalary);
	   return salary;
		
	}
	
	
	//Get Salary By Id
	public Optional<AddSalary> getSalaryById(int salaryId)
	{
	   Optional<AddSalary> salary=this.addSalaryRepository.findById(salaryId);
		return salary;
		
	}
	
	
	
	
	
	//Show All Salary
	public List<AddSalary> getAllSalaryDetails()
	{
	 List<AddSalary> list=(List<AddSalary>) this.addSalaryRepository.findAll();
		return list;
	}
	
	
	//Update Salary
	public void updateSalary(AddSalary addSalary, int salaryId)
		{
			addSalary.setSalaryId(salaryId);
			addSalaryRepository.save(addSalary);
			
		}
		
		
		//Delete The Salary
		public void deleteSalary(int salaryId)
		{
			addSalaryRepository.deleteById(salaryId);
			
		}
	
	
	
	
	
	
	
	

}
