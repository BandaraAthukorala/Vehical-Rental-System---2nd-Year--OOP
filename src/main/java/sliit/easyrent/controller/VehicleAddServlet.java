package sliit.easyrent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.VehicleDao;
import sliit.easyrent.model.Vehicle;

/**
 * Servlet implementation class VehicleAddServlet
 */
@WebServlet("/VehicleAdd")
public class VehicleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	VehicleDao vehicleDao = new VehicleDao();
	
      
    public VehicleAddServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/VehicleAdd.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vplateno  = request.getParameter("vplateno");
		String vtype  = request.getParameter("vtype");
		String vmodel  = request.getParameter("vmodel");
		String vyear  = request.getParameter("vyear");
		String vcostperkm = request.getParameter("vcostperkm");
		String vcostperday = request.getParameter("vcostperday");
		
		Vehicle vehicle = new Vehicle(vplateno, vmodel, vyear, vcostperkm, vcostperday ,vtype);
		
		try {
			vehicleDao.addVehicle(vehicle);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("VehicleGetAll");
	}

}
