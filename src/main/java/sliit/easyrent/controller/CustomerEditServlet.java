package sliit.easyrent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.CustomerDao;
import sliit.easyrent.model.Customer;

/**
 * Servlet implementation class CustomerEditServlet
 */
@WebServlet("/CustomerEdit")
public class CustomerEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao = new CustomerDao();
    private int id = 0;   //to hold the ID coming from the get request
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CustomerEdit.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cname = request.getParameter("cname");
		String cphone = request.getParameter("cphone");
		String caddress = request.getParameter("caddress");
		String cnic = request.getParameter("cnic");
		Customer customer = new Customer(id, cname, cnic, cphone, caddress);
		customerDao.updateCustomer(customer);
		response.sendRedirect("CustomerGetAll");
	}

}
