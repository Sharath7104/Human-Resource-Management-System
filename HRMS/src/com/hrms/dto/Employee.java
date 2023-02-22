package com.hrms.dto;

public interface Employee {
	public int getId();
	public void setId(int id);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getMobile();
	public void setMobile(String mobile);
	public String getEmail();
	public void setEmail(String email);
	public String getPassword();
	public void setPassword(String password);
	public String getDateOfBirth();
	public void setDateOfBirth(String dateOfBirth);
	public String getAddress();
	public void setAddress(String address);
	public int getSalary();
	public void setSalary(int salary);
	public String getDateOfJoining();
	public void setDateOfJoining(String dateOfJoining);
	public int getDepartmentId();
	public void setDepartmentId(int departmentId);
}
