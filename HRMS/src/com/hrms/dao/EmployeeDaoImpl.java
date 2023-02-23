package com.hrms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.hrms.dto.Employee;
import com.hrms.dto.EmployeeImpl;
import com.hrms.exception.EmployeeException;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void registerEmployee(EmployeeImpl employee) throws EmployeeException {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			conn = DBUtils.connectToDatabase();
			String insertquery = "INSERT INTO EMPLOYEE(FIRSTNAME,LASTNAME,MOBILE,EMAIL,PASSWORD,DATEOFBIRTH,ADDRESS,SALARY,DATEOFJOINING,DEPARTMENTID) VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(insertquery);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getMobile());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.setString(6, employee.getDateOfBirth());
			ps.setString(7, employee.getAddress());
			ps.setInt(8, employee.getSalary());
			ps.setString(9, employee.getDateOfJoining());
			ps.setInt(10, employee.getDepartmentId());
			
			System.out.println(ps.executeUpdate()>0 ? "Employee Added Successfully ! Password is " + employee.getPassword()+" " : "Something went wrong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<EmployeeImpl> getAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		
		List<EmployeeImpl> emplist= new ArrayList();
		
		
		try(Connection con=DBUtils.connectToDatabase()) {
         PreparedStatement ps=con.prepareStatement("select * from employee");
         
         ResultSet rs=ps.executeQuery();
         while(rs.next()) {
        	 EmployeeImpl emp = new EmployeeImpl();
        	 emp.setId(rs.getInt("id"));
        	 emp.setFirstName(rs.getString("firstName"));
			 emp.setLastName(rs.getString("lastName"));
	         emp.setMobile(rs.getString("mobile"));
			 emp.setEmail(rs.getString("email"));
			 emp.setPassword(rs.getString("password"));
			 emp.setDateOfBirth(rs.getString("dateOfBirth"));
			 emp.setAddress(rs.getString("address"));
			 emp.setSalary(rs.getInt("salary"));
			 emp.setDateOfJoining(rs.getString("dateofjoining"));
			 emp.setDepartmentId(rs.getInt("departmentID"));
			 
			 emplist.add(emp);
         }
         
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return emplist;
	}

	@Override
	public void changeDepartment(int employeeID, int newDepartmentID) throws EmployeeException {
		// TODO Auto-generated method stub
		try(Connection con=DBUtils.connectToDatabase()) {
			PreparedStatement ps=con.prepareStatement("update employee set departmentid=? where id=?");
			ps.setInt(1,newDepartmentID);
			ps.setInt(2,employeeID);
			
			System.out.println(ps.executeUpdate()>0 ? "Department Changed" : "Something went wrong");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	private void changePass(int id) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter new password");
		String npass=sc.next();
		
		try (Connection con=DBUtils.connectToDatabase()){
			String updatepassquery = "update employee set password=? where id=?";
			PreparedStatement ps=con.prepareStatement(updatepassquery);
			ps.setString(1, npass);
			ps.setInt(2, id);
			
			System.out.println(ps.executeUpdate()>0 ? "Password Updated Successfully": "Something went wrong");
		} catch (SQLException e) {
			e.getMessage();
		}
		
	 
		
	}
	
	
	@Override
	public void changeEmpPassword(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		try (Connection con=DBUtils.connectToDatabase()) {
			
			PreparedStatement ps = con.prepareStatement(" select * from employee where id = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			String message;
			if(rs.next()) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter existing password");
				String pass=sc.next();
				if(pass.equals(rs.getString("password"))) {
					changePass(id);
				}
				else {
					message="Incorrect password";
				}
			}
			else {
				System.out.println("Employee Not Found");
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	@Override
	public Employee getEmployeeByID(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee emp=new EmployeeImpl();
		try(Connection con=DBUtils.connectToDatabase()) {
			String getEmployeequery = "select * from employee where id=?";
			PreparedStatement ps =con.prepareStatement(getEmployeequery);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
			
            if(rs.next()) {
				
				int id1=rs.getInt("id");
				String firstname=rs.getString("firstName");
				String lastname=rs.getString("lastName");
				String mobile=rs.getString("mobile");
				String email=rs.getString("email");
				String password=rs.getString("password");
				Date dob=rs.getDate("dateOfBirth");
				String dateOfBirth=dateFormat.format(dob); 
				String address=rs.getString("address");
				int salary=rs.getInt("salary");
				Date hd=rs.getDate("dateofjoining");
				String dateofjoining=dateFormat.format(hd);
				int departmentId=rs.getInt("departmentId");
				
				emp= new EmployeeImpl(id1,firstname, lastname, mobile, email, password, dateOfBirth, address, salary, dateofjoining, departmentId);
				
			}else {
				throw new EmployeeException("Employee not exist with this id : "+id);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		return emp;
	}

	@Override
	public List<EmployeeImpl> employeeByDepartment(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(String Column, String typeName, int id) throws EmployeeException {
		// TODO Auto-generated method stub
		
	}

}
