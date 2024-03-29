package com.hrms.login;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.hrms.dao.Login;
import com.hrms.dto.EmployeeImpl;
import com.hrms.exception.DepartmentException;
import com.hrms.exception.EmployeeException;
import com.hrms.menudisplay.MenuDisplay;
import com.hrms.tablesprint.ConsoleColors;

public class LoginMain {
	public static void main(String[] args) throws EmployeeException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			
				System.out.println(ConsoleColors.ANSI_GREEN+"*** Please choose Option ***"+ConsoleColors.ANSI_RESET);
				System.out.println(ConsoleColors.BLUE_BOLD +" 1.Admin Login");
				System.out.println(" 2.Employee Login");
				System.out.println(" 0.Exit");
				
			try {
				choice = sc.nextInt();
			}catch(InputMismatchException ex) {
				System.out.println("Enter Valid Input");
				LoginMain.main(null);
			}
			
			
			switch(choice) {
			case 1:
				
					if(Login.adminLogin()) {
						try {
							MenuDisplay.welcomeAdmin();
							MenuDisplay.admin();
							
						} catch (DepartmentException e) {
					 		// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
					}else {
						System.err.println("Incorrect Email Or Password!! Please check and try again later");
					}
				
				break;
				
			case 2:
				try {
					EmployeeImpl emp = Login.employeeLogin();
					MenuDisplay.welcomeEmployee(emp);
					MenuDisplay.employee(emp);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
				
				
			case 0:
				System.out.println(ConsoleColors.GREEN+"Thank you see you again!!!"+ConsoleColors.RESET);
				System.exit(0);
				break;
				
			default:
				System.err.println("Wrong Input!!!!");
			}
			
		}while(choice!=0);
		
		sc.close();
	}
}
