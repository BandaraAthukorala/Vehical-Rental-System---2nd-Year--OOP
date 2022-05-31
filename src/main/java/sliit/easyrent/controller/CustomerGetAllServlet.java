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
import sliit.easyrent.model.Customer;

/**
 * Servlet implementation class CustomerGetAll
 */
@WebServlet("/CustomerGetAll")
public class CustomerGetAllServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private CustomerDao customerDao = new CustomerDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerGetAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customerList =  customerDao.getAllCustomers();
		request.setAttribute("listCustomer", customerList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customerlist.jsp");
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
