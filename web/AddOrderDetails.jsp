<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
	<title>Add Order Details</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="./Customize/CustomizeCommon.css" rel="stylesheet">
    </head>
    <body>
	<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #204ac9">
	    <div class="container-fluid">
		<a class="navbar-brand" href="#">PizzaStore</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
			aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
		    <ul class="navbar-nav me-auto">
			<li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="#">Pizzas</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link active" href="#">Reviews</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link active" href="#">Orders</a>
			</li>
		    </ul>
		    <ul class="navbar-nav ml-auto">
			<li class="nav-item">
			    <a class="nav-link active" href="Register.jsp">Register</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link active" href="Login.jsp">Log in</a>
			</li>
		    </ul>
		</div>
	    </div>
	</nav>

	<div class="container mt-5">
            <form class="form" action="OrderDetailsController" method="post">
                <p class="form-title">Add order</p>
                <div class="input-container">
                    Order ID <input name="txtOrderID" type="text" placeholder="Enter order ID">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Product ID <input name="txtProductID" type="text" placeholder="Enter Product ID">
		    <span>
		    </span>
                </div>
		<div class="input-container">
                    Unit Price <input name="txtUnitPrice" type="text" placeholder="Enter Unit Price">
		    <span>
		    </span>
                </div>
		<div class="input-container">
                    Quantity <input name="txtQuantity" type="text" placeholder="Enter Quantity">
		    <span>
		    </span>
                </div>
                <button type="submit" name="action" value="add" class="submit bg-primary">
                    Add
                </button>
                <h3 style="color: red">${requestScope.error}</h3>
                <h3 style="color: red">${requestScope.errorBlank}</h3>
            </form>
        </div>
    </body>
</html>