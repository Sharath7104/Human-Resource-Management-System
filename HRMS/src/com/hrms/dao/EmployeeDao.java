package com.hrms.dao;

import java.util.List;

import com.hrms.dto.Employee;
import com.hrms.dto.EmployeeImpl;
import com.hrms.exception.EmployeeException;

public interface EmployeeDao {
	public void registerEmployee(EmployeeImpl employee) throws EmployeeException;
	
	public List<EmployeeImpl> getAllEmployee()throws EmployeeException;
	
	public void changeDepartment(int employeeID, int newDepartmentID) throws EmployeeException;
	
	public void changeEmpPassword(int id) throws EmployeeException;
	
	public Employee getEmployeeByID(int id)throws EmployeeException;
	
	public List<EmployeeImpl> employeeByDepartment(int id)throws EmployeeException;
	
	public void updateEmployee(String Column, String typeName, int id) throws EmployeeException;
	
}
