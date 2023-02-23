package com.hrms.login;

import java.util.Scanner;

import com.hrms.dao.Login;
import com.hrms.dto.Employee;
import com.hrms.exception.DepartmentException;
import com.hrms.exception.EmployeeException;
import com.hrms.menudisplay.MenuDisplay;

public class LoginMain {
	public static void main(String[] args) throws EmployeeException {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		do {
			System.out.println("Please choose Option");
			System.out.println("1.Admin Login");
			System.out.println("2.Employee Login");
			System.out.println("0.Exit");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				if(Login.adminLogin()) {
					try {
						MenuDisplay.admin();
					} catch (DepartmentException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				break;
				
			case 2:
				try {
					Employee emp = Login.employeeLogin();
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
				
			case 0:
				System.out.println("Thank you see you again!!!");
				System.exit(0);
				break;
				
			default:
				System.err.println("Wrong Input!!!!");
			}
			
		}while(choice!=0);
		
	}
}
