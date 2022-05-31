package sliit.easyrent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.VehicleDao;
import sliit.easyrent.model.Vehicle;

/**
 * Servlet implementation class VehicleGetAllServlet
 */
@WebServlet("/VehicleGetAll")
public class VehicleGetAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VehicleDao vehicleDao = new VehicleDao();
    
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleGetAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vehicle> vehicleList =  vehicleDao.getAllVehicles();
		request.setAttribute("listVehicle", vehicleList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/VehicleList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
