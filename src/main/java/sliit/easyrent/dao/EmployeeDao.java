package sliit.easyrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sliit.easyrent.dbcon.DBConnection;
import sliit.easyrent.model.Employee;

public class EmployeeDao {

	 Connection connection = DBConnection.getConnection();
		
	  private static final String INSERT_EMPLOYEES_QUERY = "INSERT INTO employee" +
	        "  (eid, ename, eusername, epassword, ephone, eposition) VALUES " +
	        " (?, ?, ?, ?, ?, ?);";
	  
	  private static final String GET_ALL_EMPLOYEES = "SELECT * FROM employee;";
	  private static final String DELETE_EMPLOYEE_BY_ID = "DELETE from employee where eid = ?;";
	  private static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE employee set ename=?, eusername=?, epassword=?, ephone=?, eposition=? where eid=?";
	
	  
	  public boolean Login(String username, String password) throws Exception {
			String authQuery =" select * from employee where eusername='"+username+"' && epassword='"+password+"';";
			Statement statement= connection.createStatement();
			ResultSet resultSet = statement.executeQuery(authQuery);
			
			if(resultSet.next()) {
				
				return true;
				
				
			}else {
				return false;
			}
		}
	  
	  
	  //Add Employee
	  public int addEmployee(Employee employee) throws ClassNotFoundException {
	        int result = 0;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_QUERY);
	            preparedStatement.setInt(1, 0);
	            preparedStatement.setString(2, employee.getEname());
	            preparedStatement.setString(3, employee.getEusername());
	            preparedStatement.setString(4, employee.getEpassword());
	            preparedStatement.setString(5, employee.getEphone());
	            preparedStatement.setString(6, employee.getEposition());
	            result = preparedStatement.executeUpdate();
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        return result;
	  }
	  
	  
	  
	  
	  
	  //Get all employees
	  public List<Employee> getAllEmployees(){
		  List<Employee> employeeList = new ArrayList<>();
		  try {
	            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEES);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	int eid = resultSet.getInt("eid");
	            	String ename = resultSet.getString("ename");
	            	String eusername = resultSet.getString("eusername");
	            	String epassword = resultSet.getString("epassword");
	            	String ephone = resultSet.getString("ephone");
	            	String eposition = resultSet.getString("eposition");
	            	
	            	employeeList.add(new Employee(eid, ename, eusername,epassword,ephone,eposition));
	            }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return employeeList;
	  }
	  
	  
	  
	  
	  //delete employee
	  public boolean deleteEmployee(int eid) {
		  boolean deletionStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
			  preparedStatement.setInt(1, eid);
			  deletionStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return deletionStatus;
	  }
	  
	  
	  //update employee
	  public boolean updateEmployee(Employee employee) {
		  boolean updationStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);
			  preparedStatement.setString(1, employee.getEname());
	            preparedStatement.setString(2, employee.getEusername());
	            preparedStatement.setString(3, employee.getEpassword());
	            preparedStatement.setString(4, employee.getEphone());
	            preparedStatement.setString(5, employee.getEposition());
			  preparedStatement.setInt(6, employee.getEid());
			  updationStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return updationStatus;
	  }
	  
}
