package com.hrms.operations;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;

public class ChangeEmployeeDepartment {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Employee ID: ");
	int empid=sc.nextInt();
	System.out.println("Enter New Department ID: ");
	int newDptid=sc.nextInt();
	
	EmployeeDao dao=new EmployeeDaoImpl();
	
	try {
		dao.changeDepartment(empid, newDptid);
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
