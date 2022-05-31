<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Driver</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<div>
				<a class="navbar-brand" style="color:white; font-family: verdana;" href="<%=request.getContextPath()%>/"> Easy Rent</a>
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
  <h1>Edit Driver</h1>
  <form action="<%= request.getContextPath() %>/DriverEdit" method="post">
   <table style="with: 80%">
     <tr>
     <td>Name</td>
     <td><input type="text" name="dname" /></td>
    </tr>
    <tr>
     <td>NIC</td>
     <td><input type="text" name="dnic" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="daddress" /></td>
    </tr>
    <tr>
     <td>Contact No</td>
     <td><input type="text" name="dphone" /></td>
    </tr>
   </table>
   <input type="submit" value="Update Driver" />
  </form>
 </div>


</body>
</html>