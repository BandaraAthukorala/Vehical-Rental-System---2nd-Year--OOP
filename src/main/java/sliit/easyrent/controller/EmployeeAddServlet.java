package sliit.easyrent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.EmployeeDao;
import sliit.easyrent.model.Employee;

/**
 * Servlet implementation class EmployeeAddServlet
 */
@WebServlet("/EmployeeAdd")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeeDao = new EmployeeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EmployeeAdd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename = request.getParameter("ename");
		String eusername = request.getParameter("eusername");
		String epassword = request.getParameter("epassword");
		String ephone = request.getParameter("ephone");
		String eposition = request.getParameter("eposition");
		
		Employee employee = new Employee(ename, eusername, epassword, ephone, eposition);
		
		try {
			employeeDao.addEmployee(employee);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("EmployeeGetAll");
	}

}
