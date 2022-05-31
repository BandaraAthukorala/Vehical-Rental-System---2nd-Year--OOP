package sliit.easyrent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sliit.easyrent.dbcon.DBConnection;
import sliit.easyrent.model.Customer;
import sliit.easyrent.model.Driver;
import sliit.easyrent.model.RentOrder;
import sliit.easyrent.model.Vehicle;

public class RentOrderDao {
	Connection connection = DBConnection.getConnection();
	
	private VehicleDao vehicleDao = new VehicleDao();
	private DriverDao driverDao = new DriverDao();
	private CustomerDao customerDao = new CustomerDao();
	
	Customer customer = new Customer();
	Vehicle vehicle = new Vehicle();
	Driver driver = new Driver();
	
	RentOrder rentOrder;
	
	
	private static final String INSERT_RENTORDER_QUERY = "INSERT INTO rentorder" +
	        "  (rid, rcustname, rcustphone, rvehiplateNo, rvehimodel, rdrivername, rdriverphone, rdays, rkilometers, rtotal) VALUES " +
	        " (?, ?, ?, ?, ?, ? ,?, ?, ? ,?);";
	  
	private static final String GET_ALL_RENTORDERS = "SELECT * FROM rentorder;";
	private static final String DELETE_RENTORDER_BY_ID = "DELETE from rentorder where rid = ?;";
	
	  
	  
	  
	//Add RentOrder
	public int addRentOrder(RentOrder rentOrder) throws ClassNotFoundException {
	        int result = 0;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RENTORDER_QUERY);
	            preparedStatement.setInt(1, 0);
	            preparedStatement.setString(2, rentOrder.getRcustname());
	            preparedStatement.setString(3, rentOrder.getRcustphone());
	            preparedStatement.setString(4, rentOrder.getRvehiplateNo());
	            preparedStatement.setString(5, rentOrder.getRvehimodel());
	            preparedStatement.setString(6, rentOrder.getRdrivername());
	            preparedStatement.setString(7, rentOrder.getRdriverphone());
	            preparedStatement.setInt(8, rentOrder.getRdays());
	            preparedStatement.setInt(9, rentOrder.getRkilometers());
	            preparedStatement.setFloat(10, rentOrder.getRtotal());
	
	            result = preparedStatement.executeUpdate();
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        return result;
	  }
	  
	  
	  
	  
	  
	  //Get all RentOrders
	public List<RentOrder> getAllRentOrders(){
		  List<RentOrder> rentOrderList = new ArrayList<>();
		  try {
	            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RENTORDERS);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	int rid = resultSet.getInt("rid");
	            	String rcustname = resultSet.getString("rcustname");
	            	String rcustphone = resultSet.getString("rcustphone");
	            	String rvehiplateNo = resultSet.getString("rvehiplateNo");
	            	String rvehimodel = resultSet.getString("rvehimodel");
	            	String rdrivername = resultSet.getString("rdrivername");
	            	String rdriverphone = resultSet.getString("rdriverphone");
	            	int rdays = resultSet.getInt("rdays");
	            	int rkilometers = resultSet.getInt("rkilometers");
	            	float rtotal = resultSet.getFloat("rtotal");
	            	
	            	rentOrderList.add(new RentOrder(rid, rcustname, rcustphone,rvehiplateNo,rvehimodel,rdrivername,rdriverphone,rdays,rkilometers,rtotal));
	            }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return rentOrderList;
	  }
	  
	  
	  
	  
	//delete RentOrder
	public boolean deleteRentOrder(int rid) {
		  boolean deletionStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RENTORDER_BY_ID);
			  preparedStatement.setInt(1, rid);
			  deletionStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return deletionStatus;
	  }
	
	
	
	//This is the method called by the servlet to save data. This method will find the necessary data from the database and create a rent order
	
	public int saveAllDetails(int cid, int vid, int did, int rdays, int rkilometers) {
		
		try {
			customer = customerDao.getCustomerByID(cid);
			vehicle = vehicleDao.getVehicleByID(vid);
			driver = driverDao.getDriverByID(did);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		rentOrder = new RentOrder(customer.getCname(), customer.getCphone(), vehicle.getVplateno(), vehicle.getVmodel(),
				driver.getDname() , driver.getDphone() , rdays, rkilometers, calcTotal(rdays, rkilometers));
		
		try {
			
			return this.addRentOrder(rentOrder);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	//to calculate the total amount to be paid
	public float calcTotal(int rdays, int rkilometers) {
		float tot;
		
		tot = (float)((rdays * Integer.parseInt(vehicle.getVcostperday())) + (rkilometers* Integer.parseInt(vehicle.getVcostperkm())));
		
		return tot;
	}
	
}
