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
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerAdd")
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDao customerDao = new CustomerDao();
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customeradd.jsp");
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
		
		Customer customer = new Customer(cname, cnic, cphone, caddress);
		
		try {
			customerDao.addCustomer(customer);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("CustomerGetAll");
	}

}
