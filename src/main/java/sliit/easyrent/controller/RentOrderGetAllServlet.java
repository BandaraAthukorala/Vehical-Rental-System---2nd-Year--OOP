package sliit.easyrent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.RentOrderDao;
import sliit.easyrent.model.RentOrder;

/**
 * Servlet implementation class RentOrderGetAllServlet
 */
@WebServlet("/RentOrderGetAll")
public class RentOrderGetAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RentOrderDao rentOrderDao = new RentOrderDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentOrderGetAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RentOrder> rentOrderList =  rentOrderDao.getAllRentOrders();
		request.setAttribute("listRentOrder", rentOrderList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/RentOrderList.jsp");
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
