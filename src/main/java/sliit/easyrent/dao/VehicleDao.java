package sliit.easyrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sliit.easyrent.dbcon.DBConnection;
import sliit.easyrent.model.Vehicle;

public class VehicleDao {
	Connection connection = DBConnection.getConnection();
	
	  private static final String INSERT_VEHICLES_QUERY = "INSERT INTO vehicle" +
	        "  (vid, vplateno, vmodel, vtype, vyear, vcostperkm, vcostperday) VALUES " +
	        " (?, ?, ?, ?, ?, ?, ?);";
	  
	  private static final String GET_ALL_VEHICLES = "SELECT * FROM vehicle;";
	  private static final String DELETE_VEHICLE_BY_ID = "DELETE from vehicle where vid = ?;";
	  private static final String UPDATE_VEHICLE_BY_ID = "UPDATE vehicle set vplateno = ?, vmodel = ?, vtype = ?, vyear = ?, vcostperkm = ?, vcostperday =? where vid = ?;";
	
	  
	  
	  
	  //Add Vehicle
	  public int addVehicle(Vehicle vehicle) throws ClassNotFoundException {
	        int result = 0;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VEHICLES_QUERY);
	            preparedStatement.setInt(1, 0);
	            preparedStatement.setString(2, vehicle.getVplateno());
	            preparedStatement.setString(3, vehicle.getVmodel());
	            preparedStatement.setString(4, vehicle.getVtype());
	            preparedStatement.setString(5, vehicle.getVyear());
	            preparedStatement.setString(6, vehicle.getVcostperkm());
	            preparedStatement.setString(7, vehicle.getVcostperday());
	
	            result = preparedStatement.executeUpdate();
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        return result;
	  }
	  
	  
	  
	  
	  
	  //Get all vehicles
	  public List<Vehicle> getAllVehicles(){
		  List<Vehicle> vehicleList = new ArrayList<>();
		  try {
	            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_VEHICLES);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	int vid = resultSet.getInt("vid");
	            	String vplateno = resultSet.getString("vplateno");
	            	String vmodel = resultSet.getString("vmodel");
	            	String vtype = resultSet.getString("vtype");
	            	String vyear = resultSet.getString("vyear");
	            	String vcostperkm = resultSet.getString("vcostperkm");
	            	String vcostperday = resultSet.getString("vcostperday");

	            	
	            	vehicleList.add(new Vehicle(vid, vplateno, vmodel,vyear,vcostperkm, vcostperday, vtype));
	            }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return vehicleList;
	  }
	  
	  
	  
	  
	  //delete vehicle
	  public boolean deleteVehicle(int vid) {
		  boolean deletionStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VEHICLE_BY_ID);
			  preparedStatement.setInt(1, vid);
			  deletionStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return deletionStatus;
	  }
	  
	  
	  //update vehicle
	  public boolean updateVehicle(Vehicle vehicle) {
		  boolean updationStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VEHICLE_BY_ID);
			  preparedStatement.setString(1, vehicle.getVplateno());
	            preparedStatement.setString(2, vehicle.getVmodel());
	            preparedStatement.setString(3, vehicle.getVtype());
	            preparedStatement.setString(4, vehicle.getVyear());
	            preparedStatement.setString(5, vehicle.getVcostperkm());
	            preparedStatement.setString(6, vehicle.getVcostperday());
			  preparedStatement.setInt(7, vehicle.getVid());
			  updationStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return updationStatus;
	  }
	  
	  //Get Vehicle by ID
	  public Vehicle getVehicleByID(int id) throws Exception {
			String authQuery =" select * from vehicle where vid='"+id+"';";
			Statement statement= connection.createStatement();
			ResultSet resultSet = statement.executeQuery(authQuery);
			
			if(resultSet.next()) {
				
				int vid = resultSet.getInt("vid");
	        	String vplateno = resultSet.getString("vplateno");
	        	String vmodel = resultSet.getString("vmodel");
	        	String vtype = resultSet.getString("vtype");
	        	String vyear = resultSet.getString("vyear");
	        	String vcostperkm = resultSet.getString("vcostperkm");
	        	String vcostperday = resultSet.getString("vcostperday");

	        	
	        	return new Vehicle(vid, vplateno, vmodel,vyear,vcostperkm, vcostperday, vtype);
				
				
			}else {
				return null;
			}
		}
}
