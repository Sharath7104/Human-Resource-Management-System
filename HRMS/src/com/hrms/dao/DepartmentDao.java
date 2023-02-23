package com.hrms.dao;

import java.util.List;

import com.hrms.dto.DepartmentImpl;
import com.hrms.exception.DepartmentException;

public interface DepartmentDao {
	public void addDepartment(DepartmentImpl dept) throws DepartmentException;
	public List<DepartmentImpl> getAllDepartment() throws DepartmentException;
	public void updateDepartment(DepartmentImpl department) throws DepartmentException;
}
