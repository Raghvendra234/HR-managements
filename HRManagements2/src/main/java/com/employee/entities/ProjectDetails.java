package com.employee.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ProjectDetails 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	private String projectName;
	private String clientName;
	private String projectManager;
	private String projectTeamLeader;
	private String developingPlateform;
	private String databaseTechnology;
	private LocalDate startingDate;
	
	
	
	
	public ProjectDetails() {
		super();
		
	}



	public ProjectDetails(int projectId, String projectName, String clientName, String projectManager,
			String projectTeamLeader, String developingPlateform, String databaseTechnology, LocalDate startingDate) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.clientName = clientName;
		this.projectManager = projectManager;
		this.projectTeamLeader = projectTeamLeader;
		this.developingPlateform = developingPlateform;
		this.databaseTechnology = databaseTechnology;
		this.startingDate = startingDate;
	}



	public int getProjectId() {
		return projectId;
	}



	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getClientName() {
		return clientName;
	}



	public void setClientName(String clientName) {
		this.clientName = clientName;
	}



	public String getProjectManager() {
		return projectManager;
	}



	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}



	public String getProjectTeamLeader() {
		return projectTeamLeader;
	}



	public void setProjectTeamLeader(String projectTeamLeader) {
		this.projectTeamLeader = projectTeamLeader;
	}



	public String getDevelopingPlateform() {
		return developingPlateform;
	}



	public void setDevelopingPlateform(String developingPlateform) {
		this.developingPlateform = developingPlateform;
	}



	public String getDatabaseTechnology() {
		return databaseTechnology;
	}



	public void setDatabaseTechnology(String databaseTechnology) {
		this.databaseTechnology = databaseTechnology;
	}



	public LocalDate getStartingDate() {
		return startingDate;
	}



	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}



	@Override
	public String toString() {
		return "ProjectDetails [projectId=" + projectId + ", projectName=" + projectName + ", clientName=" + clientName
				+ ", projectManager=" + projectManager + ", projectTeamLeader=" + projectTeamLeader
				+ ", developingPlateform=" + developingPlateform + ", databaseTechnology=" + databaseTechnology
				+ ", startingDate=" + startingDate + "]";
	}

	



}
