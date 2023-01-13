package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.employee.dao.ProjectDetailsRepository;
import com.employee.entities.*;

@Controller
public class ProjectDetailsService
{

	@Autowired
	private ProjectDetailsRepository projectDetailsRepository;
	
	
	
	// Project Save
	public ProjectDetails addProjectDetails(ProjectDetails projectDetails)
	{
		
		ProjectDetails pdetails=this.projectDetailsRepository.save(projectDetails);
		return pdetails;
		
	}

	
	//Get ProjectDetails by Id
		public Optional<ProjectDetails> getProjectDetailsById(int pId)
	{
		Optional<ProjectDetails> projectDetails=null;
		try
		{
	    projectDetails=this.projectDetailsRepository.findById(pId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return projectDetails;
       		
	}
	
	
	//Get All projects 
	public List<ProjectDetails> findAllProject()
	{
		
	  List<ProjectDetails> list=(List<ProjectDetails>) projectDetailsRepository.findAll();
		 
	  return list;
		
	}

	//Update The Project
	public void updateProjects(ProjectDetails pjDetails, int pId)
	{
		pjDetails.setProjectId(pId);
		projectDetailsRepository.save(pjDetails);
		
	}
	
	
	//Delete The Project 
	public void deleteProject(int pId)
	{
		projectDetailsRepository.deleteById(pId);
		
	}
	
}











