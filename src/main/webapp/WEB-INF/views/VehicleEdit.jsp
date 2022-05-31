<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Vehicle</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/RentOrderGetAll"
						>Rent Orders</a></li>
				</ul>
			</div>
			
		</nav>
</header>

 <div align="center">
  <h1>Edit Vehicle</h1>
  <form action="<%= request.getContextPath() %>/VehicleEdit" method="post">
   <table style="with: 80%">
    <tr>
     <td>Plate Number</td>
     <td><input type="text" name="vplateno" /></td>
    </tr>
    <tr>
     <td>Type (Van, Car, etc..)</td>
     <td><input type="text" name="vtype" /></td>
    </tr>
    <tr>
     <td>Model (Toyota Hiace KDH, Nissan Sunny FB15, etc..) </td>
     <td><input type="text" name="vmodel" /></td>
    </tr>
    <tr>
     <td>Year</td>
     <td><input type="text" name="vyear" /></td>
    </tr>
    <tr>
     <td>Cost Per 1 Km</td>
     <td><input type="text" name="vcostperkm" /></td>
    </tr>
    <tr>
     <td>Cost Per 1 day</td>
     <td><input type="text" name="vcostperday" /></td>
    </tr>
   </table>
   <input type="submit" value="Update Vehicle" />
  </form>
 </div>


</body>
</html>