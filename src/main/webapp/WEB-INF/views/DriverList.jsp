<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
					<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/DriverGetAll"
						 >Drivers</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/EmployeeGetAll"
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
			<h3 class="text-center">List of All Drivers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/DriverAdd" class="btn btn-success">Add
					New Driver</a>
					<a href="<%=request.getContextPath()%>/Home" class="btn btn-danger">Go Back Home</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>NIC</th>
						<th>Phone</th>
						<th>Address</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="driver" items="${listDriver}">

						<tr>
							<td><c:out value="${driver.did}" /></td>
							<td><c:out value="${driver.dname}" /></td>
							<td><c:out value="${driver.dnic}" /></td>
							<td><c:out value="${driver.dphone}" /></td>
							<td><c:out value="${driver.daddress}" /></td>
							<td><a href="/EasyRent_Management/DriverEdit?id=<c:out value='${driver.did}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="/EasyRent_Management/DriverDelete?id=<c:out value='${driver.did}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>