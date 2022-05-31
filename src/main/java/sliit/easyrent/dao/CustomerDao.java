package sliit.easyrent.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sliit.easyrent.dbcon.DBConnection;
import sliit.easyrent.model.Customer;

public class CustomerDao {
	
	  Connection connection = DBConnection.getConnection();
	
	  private static final String INSERT_CUSTOMERS_QUERY = "INSERT INTO customer" +
	        "  (cid, cname, cphone, cnic, caddress) VALUES " +
	        " (?, ?, ?, ?, ?);";
	  
	  private static final String GET_CUSTOMERS_BY_CONTACT_NUMBER = "SELECT * FROM customer where cphone = ?;";
	  private static final String GET_ALL_CUSTOMERS = "SELECT * FROM customer;";
	  private static final String DELETE_CUSTOMER_BY_ID = "DELETE from customer where cid = ?;";
	  private static final String UPDATE_CUSTOMER_BY_ID = "UPDATE customer set cname=?, cphone=?, cnic=?, caddress=? where cid=?";
	
	  
	  
	  
	  //Add Customer
	  public int addCustomer(Customer customer) throws ClassNotFoundException {
	        int result = 0;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_QUERY);
	            preparedStatement.setInt(1, 0);
	            preparedStatement.setString(2, customer.getCname());
	            preparedStatement.setString(3, customer.getCphone());
	            preparedStatement.setString(4, customer.getCnic());
	            preparedStatement.setString(5, customer.getCaddress());
	
	            result = preparedStatement.executeUpdate();
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        
	        return result;
	  }
	  
	  
	  
	  
	  
	  //Get all customers
	  public List<Customer> getAllCustomers(){
		  List<Customer> customerList = new ArrayList<>();
		  try {
	            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMERS);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	int cid = resultSet.getInt("cid");
	            	String cname = resultSet.getString("cname");
	            	String caddress = resultSet.getString("caddress");
	            	String cphone = resultSet.getString("cphone");
	            	String cnic = resultSet.getString("cnic");
	            	
	            	customerList.add(new Customer(cid, cname, cnic,cphone,caddress));
	            }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return customerList;
	  }
	  
	  
	  
	  
	  //delete customer
	  public boolean deleteCustomer(int cid) {
		  boolean deletionStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
			  preparedStatement.setInt(1, cid);
			  deletionStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return deletionStatus;
	  }
	  
	  
	  //update customer
	  public boolean updateCustomer(Customer customer) {
		  boolean updationStatus = false;
		  
		  try {
			  PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID);
			  preparedStatement.setString(1, customer.getCname());
			  preparedStatement.setString(2, customer.getCphone());
			  preparedStatement.setString(3, customer.getCnic());
			  preparedStatement.setString(4, customer.getCaddress());
			  preparedStatement.setInt(5, customer.getCid());
			  updationStatus = preparedStatement.executeUpdate() > 0;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return updationStatus;
	  }
	  
	  //Get customers by ID
	  public Customer getCustomerByID(int id) throws Exception {
			String authQuery =" select * from customer where cid='"+id+"';";
			Statement statement= connection.createStatement();
			ResultSet resultSet = statement.executeQuery(authQuery);
			
			if(resultSet.next()) {
				
				int cid = resultSet.getInt("cid");
	        	String cname = resultSet.getString("cname");
	        	String caddress = resultSet.getString("caddress");
	        	String cphone = resultSet.getString("cphone");
	        	String cnic = resultSet.getString("cnic");
	        	
	        	return new Customer(cid, cname, cnic, cphone,caddress);
				
				
			}else {
				return null;
			}
		}	  
	  
}
