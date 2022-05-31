package sliit.easyrent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.CustomerDao;
import sliit.easyrent.dao.DriverDao;
import sliit.easyrent.dao.RentOrderDao;
import sliit.easyrent.dao.VehicleDao;
import sliit.easyrent.model.Customer;
import sliit.easyrent.model.Driver;
import sliit.easyrent.model.Vehicle;

/**
 * Servlet implementation class RentOrderServlet
 */
@WebServlet("/RentOrderAdd")
public class RentOrderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao = new CustomerDao();
	private DriverDao driverDao = new DriverDao();
	private VehicleDao vehicleDao = new VehicleDao(); 
	private RentOrderDao rentOrderDao = new RentOrderDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentOrderAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customerList =  customerDao.getAllCustomers();
		request.setAttribute("listCustomer", customerList);
		
		List<Driver> driverList =  driverDao.getAllDrivers();
		request.setAttribute("listDriver", driverList);
		
		List<Vehicle> vehicleList =  vehicleDao.getAllVehicles();
		request.setAttribute("listVehicle", vehicleList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/RentOrderAdd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid  = Integer.parseInt(request.getParameter("cid"));
		int vid  = Integer.parseInt(request.getParameter("vid"));
		int did  = Integer.parseInt(request.getParameter("did"));
		int rdays  = Integer.parseInt(request.getParameter("rdays"));
		int rkilometers = Integer.parseInt(request.getParameter("rkilometers"));
		
		
		try {
			rentOrderDao.saveAllDetails(cid,vid,did,rdays,rkilometers);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("RentOrderGetAll");
	}

}
