package sliit.easyrent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.RentOrderDao;

/**
 * Servlet implementation class RentOrderDelete
 */
@WebServlet("/RentOrderDelete")
public class RentOrderDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RentOrderDao rentOrderDao = new RentOrderDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentOrderDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		rentOrderDao.deleteRentOrder(id);

		response.sendRedirect("RentOrderGetAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
