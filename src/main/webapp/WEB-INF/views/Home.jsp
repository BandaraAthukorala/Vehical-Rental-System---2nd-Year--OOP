<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Easy Rent - Home</title>
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
					<li class="nav-item  active" ><a class="nav-link" href="<%=request.getContextPath()%>/Home"
						>Home</a></li>
					<li class="nav-item "><a class="nav-link" href="<%=request.getContextPath()%>/CustomerGetAll"
						>Customers</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/VehicleGetAll"
						>Vehicles</a></li>
					<li class="nav-item "><a class="nav-link" href="<%=request.getContextPath()%>/DriverGetAll"
						 >Drivers</a></li>
					<li class="nav-item "><a class="nav-link" href="<%=request.getContextPath()%>/EmployeeGetAll"
						>Employees</a></li>
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/RentOrderGetAll"
						>Rent Orders</a></li>
				</ul>
			</div>
			
		</nav>
</header>
	
	<body>

    <main role="main">

      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Easy Rent - Management Console</h1>
          <p> </p>
          <p><a class="btn btn-primary btn-lg" href="RentOrderAdd" role="button">Create Rent Order</a></p>
        </div>
      </div>

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-3">
            <h2>New Customer</h2>
            <a class="btn btn-secondary" href="CustomerAdd" role="button">Add Customer</a>
          </div>
          <div class="col-md-3">
            <h2>New Vehicle</h2>
            <a class="btn btn-secondary" href="VehicleAdd" role="button">Add Vehicle</a>
          </div>
          <div class="col-md-3">
            <h2>New Driver</h2>
            <a class="btn btn-secondary" href="DriverAdd" role="button">Add Driver</a>
          </div>
          <div class="col-md-3">
            <h2>New Employee</h2>
            <a class="btn btn-secondary" href="EmployeeAdd" role="button">Add Employee</a>
          </div>
         
        </div>

        <hr>

      </div> 

    </main>

    <footer class="container">
      <p>© Easy Rent 2021</p>
    </footer>

  
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
  

</body>
	
	
</html>