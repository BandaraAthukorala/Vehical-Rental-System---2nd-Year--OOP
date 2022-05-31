<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rent Order List</title>
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
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/CustomerGetAll"
						>Customers</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/VehicleGetAll"
						>Vehicles</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/DriverGetAll"
						 >Drivers</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/EmployeeGetAll"
						>Employees</a></li>
						<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/RentOrderGetAll"
						>Rent Orders</a></li>
				</ul>
			</div>
			
		</nav>
</header>

	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of All RentOrders</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/RentOrderAdd" class="btn btn-success">Add New RentOrder</a>
				<a href="<%=request.getContextPath()%>/Home" class="btn btn-danger">Go Back Home</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Cust. Name</th>
						<th>Cust. Phone</th>
						<th>Vehi. No</th>
						<th>Vehi. Model</th>
						<th>Driv. Name</th>
						<th>Driv. Phone</th>
						<th>Rent Days</th>
						<th>Rent KMs</th>
						<th>Total Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rentOrder" items="${listRentOrder}">
						<tr>
							<td><c:out value="${rentOrder.rid}" /></td>
							<td><c:out value="${rentOrder.rcustname}" /></td>
							<td><c:out value="${rentOrder.rcustphone}" /></td>
							<td><c:out value="${rentOrder.rvehiplateNo}" /></td>
							<td><c:out value="${rentOrder.rvehimodel}" /></td>
							<td><c:out value="${rentOrder.rdrivername}" /></td>
							<td><c:out value="${rentOrder.rdriverphone}" /></td>
							<td><c:out value="${rentOrder.rdays}" /></td>
							<td><c:out value="${rentOrder.rkilometers}" /></td>
							<td><c:out value="${rentOrder.rtotal}" /></td>
							<td><a href="/EasyRent_Management/RentOrderDelete?id=<c:out value='${rentOrder.rid}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>