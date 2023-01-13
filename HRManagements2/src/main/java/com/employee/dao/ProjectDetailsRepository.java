package com.employee.dao;

import org.springframework.data.repository.CrudRepository;

import com.employee.entities.ProjectDetails;

public interface ProjectDetailsRepository extends CrudRepository<ProjectDetails,Integer> 
{

}
