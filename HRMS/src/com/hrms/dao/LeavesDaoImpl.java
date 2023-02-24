package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hrms.dto.LeavesImpl;
import com.hrms.exception.DepartmentException;
import com.hrms.exception.EmployeeException;
import com.hrms.exception.LeavesException;
import com.hrms.menudisplay.MenuDisplay;

public class LeavesDaoImpl implements LeavesDao{

	@Override
	public void requestLeave(int id, String startDate, String endDate,String fname, String lname,int departmentid) throws LeavesException {
		// TODO Auto-generated method stub
		try (Connection con= DBUtils.connectToDatabase()){
			PreparedStatement ps=con.prepareStatement("insert into leaves(empID,leavestart,leaveend,firstName,lastName,departmentId) values(?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, startDate);
			ps.setString(3, endDate);
			ps.setString(4, fname);
			ps.setString(5, lname);
			ps.setInt(6, departmentid);
			
			System.out.println(ps.executeUpdate()>0 ? "Your Leave Request has been sent to Admin" : "Something went wrong");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();
		}
		
	}

	@Override
	public String approvedLeave(int id) throws LeavesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rejectLeave(int id) throws LeavesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeavesImpl> pendingLeaves() throws LeavesException {
		List<LeavesImpl> list=new ArrayList<>();
		
		try(Connection con= DBUtils.connectToDatabase()) {
			
			PreparedStatement ps=con.prepareStatement("select l.leaveid,l.empid, l.status, e.firstname, e.lastname, l.leavestart, l.leaveend, e.departmentid from leaves l inner join employee e on e.id=l.empid and l.status='pending';");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				LeavesImpl leave=new LeavesImpl();
				leave.setEmployeeId(rs.getInt("empid"));
				int empid = leave.getEmployeeId();
				leave.setLeaveStart(rs.getString("leavestart"));
				String leavestartdate = leave.getLeaveStart();
				leave.setLeaveEnd(rs.getString("leaveend"));
				String leaveend = leave.getLeaveEnd();
				leave.setStatus(rs.getString("status"));
				leave.setFirstName(rs.getString("firstname"));
				String name = leave.getFirstName();
				leave.setLastName(rs.getString("lastname"));
				leave.setDepartmentId(rs.getInt("departmentid"));
				int deptid = leave.getDepartmentId();
				leave.setLeaveId(rs.getInt("leaveid"));
				int leaveid = leave.getLeaveId();
				list.add(leave);
				
				if(list.size() == 0) {
					System.out.println("No Pending Leaves!!!");
				}else {
					System.out.println(leaveid);
						System.out.println("Name : "+name+ " Leave From : "+leavestartdate+" Leave Till"+leaveend+" DepartmentId : "+deptid);
						LeavesDaoImpl.PendingLeavesStatusUpdate(leaveid);
					}
				}
				
			}
			
		catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		
			
		
		return list;
	}
	
	public static boolean PendingLeavesStatusUpdate(int leaveid) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		int choice;
		boolean set = false;
		LeavesDao leavedao = new LeavesDaoImpl();
			System.out.println("Press 1 to Approve");
			System.out.println("Press 2 to Reject");
			System.out.println("Press 0 to Go back to Main Menu");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				try {
					conn = DBUtils.connectToDatabase();
					String updatequery = "update leaves set status= ? where leaveid=?";
					PreparedStatement ps = conn.prepareStatement(updatequery);
//					String approve = "Approved";
					ps.setString(1,"Approved");
					ps.setInt(2, leaveid);
					
					
					set = ps.executeUpdate()>0 ? true : false;
					try {
						leavedao.pendingLeaves();
					} catch (LeavesException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						DBUtils.closeConnection(conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 2:
				try {
					conn = DBUtils.connectToDatabase();
					String updatequery = "update leaves set status=? where leaveid=?";
					PreparedStatement ps = conn.prepareStatement(updatequery);
//					String reject = "Rejected";
					ps.setString(1,"Rejected");
					ps.setInt(2, leaveid);
					
					set = ps.executeUpdate()>0 ? true : false;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						DBUtils.closeConnection(conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 0:
				try {
					MenuDisplay.admin();
				} catch (DepartmentException | EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return set;
		
    }

}
