<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<title>Rent Order</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>

<body class="bg-light">
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
    <div class="container">
      <div class="py-5 text-center">
        <h2>Rent Order</h2>
        <p class="lead">Enter details to place the rent order</p>
      </div>

      <div class="row">
       
        <div class="col-md-8">
        
        
        
          <h4 class="mb-3">Rent Order Details</h4>
          <form class="needs-validation" action="<%= request.getContextPath() %>/RentOrderAdd" novalidate="" method="post">

	              <div class="col-md-5 mb-3">
	                <label for="country">Customer</label>
	                <select class="custom-select d-block w-100" name="cid" required="">
	                  <option value="">Choose...</option>
	                  <c:forEach var="customer" items="${listCustomer}">
	                  	<option value="${customer.cid}"><c:out value="${customer.cname}" /></option>
	                  </c:forEach>
	                </select>
	              </div>
	              
	              <div class="col-md-5 mb-3">
	                <label for="country">Vehicle</label>
	                <select class="custom-select d-block w-100" name="vid" required="">
	                  <option value="">Choose...</option>
	                  <c:forEach var="vehicle" items="${listVehicle}">
	                  <option value="${vehicle.vid}"><c:out value="${vehicle.vplateno}" /></option>
	                  </c:forEach>
	                </select>
	              </div>
	              
	              <div class="col-md-5 mb-3">
	                <label for="country">Driver</label>
	                <select class="custom-select d-block w-100" name="did" required="">
	                  <option value="">Choose...</option>
	                  <c:forEach var="driver" items="${listDriver}">
	                  <option value="${driver.did}"><c:out value="${driver.dname}" /></option>
	                  </c:forEach>
	                </select>
	              </div>
	              
            <hr class="mb-4">
            
            <div class="row">
            
	              <div class="col-md-3 mb-3">
	                <label for="cc-expiration">Number of Days</label>
	                <input type="text" class="form-control" name="rdays" placeholder="" required="">
	              </div>
	              
	              <div class="col-md-3 mb-3">
	                <label for="cc-expiration">Kilometers</label>
	                <input type="text" class="form-control" name="rkilometers" placeholder="" required="">
	              </div>
              
            </div>
            
            <hr class="mb-4">
            
            <button class="btn btn-primary btn-lg btn-block" type="submit">Confirm Rent Order</button>
          </form>
        </div>
      </div>

      
    </div>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>
  
</body>
</html>