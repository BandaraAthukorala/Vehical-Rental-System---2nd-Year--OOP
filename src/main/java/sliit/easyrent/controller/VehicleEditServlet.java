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
 * Servlet implementation class VehicleEditServlet
 */
@WebServlet("/VehicleEdit")
public class VehicleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VehicleDao vehicleDao = new VehicleDao();
	private int id = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/VehicleEdit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vplateno  = request.getParameter("vplateno");
		String vtype  = request.getParameter("vtype");
		String vmodel  = request.getParameter("vmodel");
		String vyear  = request.getParameter("vyear");
		String vcostperkm = request.getParameter("vcostperkm");
		String vcostperday = request.getParameter("vcostperday");
		Vehicle vehicle = new Vehicle(id, vplateno, vmodel, vyear, vcostperkm, vcostperday,vtype);
		vehicleDao.updateVehicle(vehicle);
		response.sendRedirect("VehicleGetAll");
	}

}
