package com.hrms.dao;

import java.util.List;

import com.hrms.dto.LeavesImpl;
import com.hrms.exception.LeavesException;

public interface LeavesDao {
	public void requestLeave(int id, String startDate, String endDate,String fname, String lname,int departmentid) throws LeavesException;
	
	public List<LeavesImpl> approvedLeave() throws LeavesException;
	
	public List<LeavesImpl> showAllRejectLeave() throws LeavesException;
	
	public List<LeavesImpl> pendingLeaves() throws LeavesException;
	
	public List<LeavesImpl> employeeLeaveStatus(int id) throws LeavesException;

}
