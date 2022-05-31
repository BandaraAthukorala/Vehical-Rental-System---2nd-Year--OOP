package sliit.easyrent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sliit.easyrent.dao.EmployeeDao;
import sliit.easyrent.model.Employee;


@WebServlet("/EmployeeGetAll")
public class EmployeeGetAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeeDao = new EmployeeDao();
       
    public EmployeeGetAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeList =  employeeDao.getAllEmployees();
		request.setAttribute("listEmployee", employeeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EmployeeList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
