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

import com.employee.entities.*;
import com.employee.service.*;

@RestController
public class ProjectDetailsController 
{
	
	@Autowired
    private ProjectDetailsService projectDetailsService;
	
	
	// Add Projects  
	@PostMapping("/projectdetails")
	public ResponseEntity<ProjectDetails> addProject(@RequestBody ProjectDetails projectDetails )
	{
	 try
	    {
	        ProjectDetails pdetails=projectDetailsService.addProjectDetails(projectDetails);
	        return ResponseEntity.of(Optional.of(pdetails));
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}
	
	
	//Get ProjectDetails By Id
	@GetMapping("/projectdetails/{pjId}")
	public ResponseEntity<Optional<ProjectDetails>> findProjectById(@PathVariable ("pjId") int pjId)
	{
	 Optional<ProjectDetails>	pjDetails=projectDetailsService.getProjectDetailsById(pjId);
	 
	 if(pjDetails==null)
	 {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 }else
	 {
		 return ResponseEntity.of(Optional.of(pjDetails));
	 }
	}

	
	
	//Get all Projects
	@GetMapping("/projectdetails")
	 public ResponseEntity<List<ProjectDetails>> findAllProject()
	 {
	   List<ProjectDetails> pjDetails=projectDetailsService.findAllProject();
		
	   if(pjDetails.size()<=0)
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	  return ResponseEntity.status(HttpStatus.CREATED).body(pjDetails);
	}

	
   //Update Projects
	@PutMapping("/projectdetails/{pjId}")
	public ResponseEntity<ProjectDetails> updateProjectById(@RequestBody ProjectDetails projectsDetails, @PathVariable ("pjId") int pjId)
	{
		try
		{
		projectDetailsService.updateProjects(projectsDetails, pjId);
		return  ResponseEntity.ok(null);
		}catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
    //Delete Project by Id
    @DeleteMapping("/projectdetails/{pjId}")	
	public ResponseEntity<ProjectDetails> deleteProjectById(@PathVariable ("pjId") int pjId)
	{
    	try
    	{
		this.projectDetailsService.deleteProject(pjId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    	}
	
	
	
	
	
	
}
