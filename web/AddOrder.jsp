<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Order</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
                    <ul class="nav" style="color: white">
                        <li class="nav-item"><a aria-current="page" class="nav-link link-body-emphasis px-2">Admin Page</a></li>
                        <li class="nav-item"><a class="nav-link link-body-emphasis px-2">Welcome, ${sessionScope.user.getUserName()}</a></li>
                        <li class="nav-item"><a href="LogoutController" class="nav-link link-body-emphasis px-2">Log Out</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container mt-5">
            <form class="form" action="OrderController" method="post">
                <p class="form-title">Add order</p>
                <div class="input-container">
                    Order ID <input name="txtOrderID" type="text" placeholder="Enter order ID">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Customer ID <input name="txtCustomerID" type="text" placeholder="Enter customer ID">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Order Date <input name="txtOrderDate" type="text" placeholder="Enter order date">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Required Date <input name="txtRequiredDate" type="text" placeholder="Enter required date">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Shipped Date <input name="txtShippedDate" type="text" placeholder="Enter shipped date">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Freight <input name="txtFreight" type="text" placeholder="Enter freight">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Ship Address <input name="txtShipAddress" type="text" placeholder="Enter ship address">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>