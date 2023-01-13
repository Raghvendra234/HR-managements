package com.employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Entity
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	private String permanentAddress;
	private String currentAddress;
   
	//@OneToMany(targetEntity = Employee.class)
    //private List<Employee> employee;
	
	public Address() {
		super();
			}


	public Address(int addressId, String permanentAddress, String currentAddress) {
		super();
		this.addressId = addressId;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getPermanentAddress() {
		return permanentAddress;
	}


	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}


	public String getCurrentAddress() {
		return currentAddress;
	}


	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", permanentAddress=" + permanentAddress + ", currentAddress="
				+ currentAddress + "]";
	}


	

}
