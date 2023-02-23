package com.hrms.menudisplay;

import java.util.Scanner;

import com.hrms.exception.DepartmentException;
import com.hrms.exception.EmployeeException;
import com.hrms.operations.AddDepartment;
import com.hrms.operations.AddNewEmployee;
import com.hrms.operations.ChangeEmployeeDepartment;
import com.hrms.operations.ChangeEmployeePassword;
import com.hrms.operations.GetAllDepartment;
import com.hrms.operations.GetAllEmployee;
import com.hrms.operations.GetEmployeeById;
import com.hrms.operations.UpdateDepartment;

public class MenuDisplay {
	public static void admin() throws DepartmentException, EmployeeException {
		int choice = 0;
		do {
			System.out.println("1.Add Department");
			System.out.println("2.View All Departments");
			System.out.println("3.Update Department");
			System.out.println("4.Add new Employee");
			System.out.println("5.Display All Employee's");
			System.out.println("6.Change Employee Department");
			System.out.println("7.Change Employee Password");
			System.out.println("8.Get Employee By Id");
			System.out.println("Choose Option");
			Scanner sc = new Scanner(System.in);
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
				
				ChangeEmployeePassword.main(null);
				break;
			case 8:
				System.out.println("Enter Employee Id");
				int id = sc.nextInt();
				GetEmployeeById.main(id);
			default:
				System.out.println("Please Enter valid Input");
			}
			
		}while(choice != 0);
		
	}
}
