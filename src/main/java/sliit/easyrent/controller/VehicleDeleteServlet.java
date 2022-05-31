package sliit.easyrent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.VehicleDao;

/**
 * Servlet implementation class VehicleDeleteServlet
 */
@WebServlet("/VehicleDelete")
public class VehicleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VehicleDao vehicleDao = new VehicleDao();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		vehicleDao.deleteVehicle(id);

		response.sendRedirect("VehicleGetAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
