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
 * Servlet implementation class EmployeeEditServlet
 */
@WebServlet("/EmployeeEdit")
public class EmployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeeDao = new EmployeeDao();
	private int id = 0;
       
    public EmployeeEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EmployeeEdit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename  = request.getParameter("ename");
		String eusername  = request.getParameter("eusername");
		String epassword  = request.getParameter("epassword");
		String ephone  = request.getParameter("ephone");
		String eposition = request.getParameter("eposition");
		Employee employee = new Employee(id, ename, eusername, epassword, ephone,eposition);
		employeeDao.updateEmployee(employee);
		response.sendRedirect("EmployeeGetAll");
	}

}
