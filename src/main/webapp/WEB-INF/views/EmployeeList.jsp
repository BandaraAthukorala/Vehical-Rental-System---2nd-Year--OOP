<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<div>
				<a class="navbar-brand" style="color:white; font-family: verdana;" href="<%=request.getContextPath()%>/Home"> Easy Rent</a>
			</div>
			
			<div >
				<ul class="navbar-nav mr-auto">
					<li class="nav-item" ><a class="nav-link" href="<%=request.getContextPath()%>/Home"
						>Home</a></li>
					<li class="nav-item "><a class="nav-link" href="<%=request.getContextPath()%>/CustomerGetAll"
						>Customers</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/VehicleGetAll"
						>Vehicles</a></li>
					<li class="nav-item "><a class="nav-link" href="<%=request.getContextPath()%>/DriverGetAll"
						 >Drivers</a></li>
					<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/EmployeeGetAll"
						>Employees</a></li>
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/RentOrderGetAll"
						>Rent Orders</a></li>
				</ul>
			</div>
			
		</nav>
</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of All Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/EmployeeAdd" class="btn btn-success">Add New Employee</a>
				<a href="<%=request.getContextPath()%>/" class="btn btn-danger">Go Back Home</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Username</th>
						<th>Password</th>
						<th>Contact</th>
						<th>Position</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${listEmployee}">

						<tr>
							<td><c:out value="${employee.eid}" /></td>
							<td><c:out value="${employee.ename}" /></td>
							<td><c:out value="${employee.eusername}" /></td>
							<td><c:out value="${employee.epassword}" /></td>
							<td><c:out value="${employee.ephone}" /></td>
							<td><c:out value="${employee.eposition}" /></td>
							<td><a href="/EasyRent_Management/EmployeeEdit?id=<c:out value='${employee.eid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="/EasyRent_Management/EmployeeDelete?id=<c:out value='${employee.eid}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>