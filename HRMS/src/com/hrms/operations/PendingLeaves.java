package com.hrms.operations;

import java.util.List;

import com.hrms.dao.LeavesDao;
import com.hrms.dao.LeavesDaoImpl;
import com.hrms.dto.LeavesImpl;
import com.hrms.exception.LeavesException;

public class PendingLeaves {
	public static void main(String[] args) {
		LeavesDao leave=new LeavesDaoImpl();
		List<LeavesImpl> list=null;
		try {
			
			list = leave.pendingLeaves();
			
//			PrintTable.printLeaveList(list);
		} catch (LeavesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list.size()==0) {
			System.out.println("No Leave Request");
			return;
		}
	}
}
