package com.hrms.operations;

import java.util.Scanner;

import com.hrms.dao.EmployeeDao;
import com.hrms.dao.EmployeeDaoImpl;
import com.hrms.exception.EmployeeException;

public class ChangeEmployeePassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int empId = sc.nextInt();
		EmployeeDao d=new EmployeeDaoImpl();
		
		
		try {
			d.changeEmpPassword(empId);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
