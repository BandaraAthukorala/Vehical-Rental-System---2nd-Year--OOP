package sliit.easyrent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.DriverDao;
import sliit.easyrent.model.Driver;

/**
 * Servlet implementation class DriverEditServlet
 */
@WebServlet("/DriverEdit")
public class DriverEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DriverDao driverDao = new DriverDao();
    private int id = 0;   //to hold the ID coming from the get request
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/DriverEdit.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String dname = request.getParameter("dname");
		String dphone = request.getParameter("dphone");
		String daddress = request.getParameter("daddress");
		String dnic = request.getParameter("dnic");
		Driver driver = new Driver(id, dname, dnic, dphone, daddress);
		driverDao.updateDriver(driver);
		response.sendRedirect("DriverGetAll");
	}

}
