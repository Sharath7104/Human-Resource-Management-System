package com.hrms.menudisplay;

import java.util.Scanner;

import com.hrms.dto.EmployeeImpl;
import com.hrms.exception.DepartmentException;
import com.hrms.exception.EmployeeException;
import com.hrms.exception.LeavesException;
import com.hrms.operations.AddDepartment;
import com.hrms.operations.AddNewEmployee;
import com.hrms.operations.ApplyLeave;
import com.hrms.operations.ChangeEmployeeDepartment;
import com.hrms.operations.ChangeEmployeePassword;
import com.hrms.operations.EmployeeLeaveStatus;
import com.hrms.operations.GetAllDepartment;
import com.hrms.operations.GetAllEmployee;
import com.hrms.operations.GetEmployeeByDepartment;
import com.hrms.operations.GetEmployeeById;
import com.hrms.operations.PendingLeaves;
import com.hrms.operations.ShowAllApprovedLeaves;
import com.hrms.operations.ShowAllRejectedLeave;
import com.hrms.operations.UpdateDepartment;
import com.hrms.operations.UpdateEmployee;

public class MenuDisplay {
	public static void admin() throws DepartmentException, EmployeeException {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.Add Department");
			System.out.println("2.View All Departments");
			System.out.println("3.Update Department");
			System.out.println("4.Add new Employee");
			System.out.println("5.Display All Employee's");
			System.out.println("6.Change Employee Department");
			System.out.println("7.Change Employee Password");
			System.out.println("8.Get Employee By Id");
			System.out.println("9.Get Employee By Department");
			System.out.println("10.Update Employee");
			System.out.println("11.View Pending Leave Requests");
			System.out.println("12.View Approved Leave Requests");
			System.out.println("13.View Rejected Leave Requests");
			System.out.println("Press 0 to Logout");
			System.out.println("Choose Option");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				AddDepartment.main(null);
				break;
				
			case 2:
				GetAllDepartment.main(null);
				break;
				
			case 3:
				UpdateDepartment.main(null);
				break;
			case 4:
				AddNewEmployee.main(null);
				break;
			case 5:
				GetAllEmployee.main(null);
				break;
			case 6:
				ChangeEmployeeDepartment.main(null);
				break;
			case 7:
				System.out.println("Enter Employee Id");
				int empid = sc.nextInt();
				ChangeEmployeePassword.main(empid);
				break;
			case 8:
				System.out.println("Enter Employee Id");
				int id = sc.nextInt();
				GetEmployeeById.main(id);
				break;
			case 9:
				GetEmployeeByDepartment.main(null);
				break;
			case 10:
				System.out.println("Enter ID of Employee");
				int id1=sc.nextInt();
				UpdateEmployee.main(id1);
				break;
			case 11:
				PendingLeaves.main(null);
				break;
			case 12:
				ShowAllApprovedLeaves.main(null);
				break;
			case 13:
				ShowAllRejectedLeave.main(null);
				break;
			default:
				System.out.println("Please Enter valid Input");
			}
			
			
			
		}while(choice != 0);
		sc.close();
	}
	
	
    public static void employee(EmployeeImpl employee) {
    	
    	Scanner sc=new Scanner(System.in);
    	
    	int choice = 0;
    	do {
    		
    	    	System.out.println();
    	    	
    			System.out.println("1.  View Profile");
    			
    			System.out.println("2.  Update Profile");
    			
    			System.out.println("3.  Change Password");
    			
    			System.out.println("4.  Apply for Leave");
    			
    			System.out.println("5.  Check Leave Status");
    		
    			System.out.println("0.  EXIT");
    			
    			System.out.println();
    			System.out.println("———————— CHOOSE OPTION ————————");
    	    	
    		choice=sc.nextInt();
    		switch(choice) {
    		case 1:
    			GetEmployeeById.main(employee.getId());

    			break;
    		case 2:
    			UpdateEmployee.main(employee.getId());

    			break;
    		case 3:
    			ChangeEmployeePassword.main(employee.getId());

    			break;
    		case 4:
    			ApplyLeave.main(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getDepartmentId());

    			break;
    			
    		case 5:
    			try {
					EmployeeLeaveStatus.main(employee.getId());
				} catch (LeavesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			break;
    		case 0:
    			System.out.println("Thank You See You Again!!");
    			return;
    			default:
    				System.out.println("Wrong Input");
    		}
    	}while(choice != 0);
    	
    	sc.close();
    }
    
}
