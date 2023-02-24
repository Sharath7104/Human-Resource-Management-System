package com.hrms.dao;

import java.util.List;

import com.hrms.dto.LeavesImpl;
import com.hrms.exception.LeavesException;

public interface LeavesDao {
	public void requestLeave(int id, String startDate, String endDate,String fname, String lname,int departmentid) throws LeavesException;
	
	public String approvedLeave(int id) throws LeavesException;
	
	public String rejectLeave(int id) throws LeavesException;
	
	public List<LeavesImpl> pendingLeaves() throws LeavesException;

}
