package sliit.easyrent.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sliit.easyrent.dbcon.DBConnection;
import sliit.easyrent.model.Driver;

public class DriverDao {
	
	  Connection connection = DBConnection.getConnection();
	
	  private static final String INSERT_DRIVERS_QUERY = "INSERT INTO driver" +
	        "  (did, dname, dphone, dnic, daddress) VALUES " +
	        " (?, ?, ?, ?, ?);";
	  
	  private static final String GET_ALL_DRIVERS = "SELECT * FROM driver;";
	  private static final String DELETE_DRIVER_BY_ID = "DELETE from driver where did = ?;";
	  private static final String UPDATE_DRIVER_BY_ID = "UPDATE driver set dname=?, dphone=?, dnic=?, daddress=? where did=?";
	
	  
	  
	  
	  //Add Driver
	  public int addDriver(Driver driver) throws ClassNotFoundException {
	        int result = 0;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DRIVERS_QUERY);
	            preparedStatement.setInt(1, 0);
	            preparedStatement.setString(2, driver.getDname());
	            preparedStatement.setString(3, driver.getDphone());
	            preparedStatement.setString(4, driver.getDnic());
	            preparedStatement.setString(5, driver.getDaddress());
	
	            result = preparedStatement.executeUpdate();
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        return result;
	  }
	  
	  
	  
	  
	  
	  //Get all drivers
	  public List<Driver> getAllDrivers(){
		  List<Driver> driverList = new ArrayList<>();
		  try {
	            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DRIVERS);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	int did = resultSet.getInt("did");
	            	String dname = resultSet.getString("dname");
	            	String daddress = resultSet.getString("daddress");
	            	String dphone = resultSet.getString("dphone");
	            	String dnic = resultSet.getString("dnic");
	            	
	            	driverList.add(new Driver(did, dname, dnic,dphone,daddress));
	            }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return driverList;
	  }
	  
	  
	  
	  
	  //delete driver
	  public boolean deleteDriver(int did) {
		  boolean deletionStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DRIVER_BY_ID);
			  preparedStatement.setInt(1, did);
			  deletionStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return deletionStatus;
	  }
	  
	  
	  //update driver
	  public boolean updateDriver(Driver driver) {
		  boolean updationStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DRIVER_BY_ID);
			  preparedStatement.setString(1, driver.getDname());
			  preparedStatement.setString(2, driver.getDphone());
			  preparedStatement.setString(3, driver.getDnic());
			  preparedStatement.setString(4, driver.getDaddress());
			  preparedStatement.setInt(5, driver.getDid());
			  updationStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return updationStatus;
	  }
	  
	  //Get Driver By ID
		  
	  public Driver getDriverByID(int id) throws Exception {
			String authQuery =" select * from driver where did='"+id+"';";
			Statement statement= connection.createStatement();
			ResultSet resultSet = statement.executeQuery(authQuery);
			
			if(resultSet.next()) {
				
				int did = resultSet.getInt("did");
	        	String dname = resultSet.getString("dname");
	        	String daddress = resultSet.getString("daddress");
	        	String dphone = resultSet.getString("dphone");
	        	String dnic = resultSet.getString("dnic");
	        	
	        	return new Driver(did, dname, dnic,dphone,daddress);
				
				
			}else {
				return null;
			}
		}
}
