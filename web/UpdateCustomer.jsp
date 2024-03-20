

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="./Customize/CustomizeCommon.css"/>
    </head>
    <body>
        <!--header-->
        <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" aria-current="true" href="#">PizzaStore</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Pizzas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Reviews</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Orders</a>
                        </li>
                    </ul>
                    <ul class="nav">
                        <li class="nav-item"><a aria-current="page" class="nav-link link-body-emphasis px-2">Admin Page</a></li>
                        <li class="nav-item"><a class="nav-link link-body-emphasis px-2">Welcome, ${sessionScope.user.getUserName()}</a></li>
                        <li class="nav-item"><a href="LogoutController" class="nav-link link-body-emphasis px-2">Log Out</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container mt-5">


            <form class="form" action="CustomerController?txtCustomerID=<%= request.getParameter("txtCustomerID")%>" method="post">
                <p class="form-title">Update Customer</p>
                <div class="input-container">
                    CustomerID <input value="<%= request.getParameter("txtCustomerID")%>"/> <br/>
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Password <input type="text" name="txtPassword" value="" /> <br/>
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    ContactName <input type="text" name="txtContactName" value="" /> <br/>
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Address <input type="text" name="txtAddress" value="" /> <br/>
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Phone <input type="text" name="txtPhone" /> <br/>
                    <span>
                    </span>
                </div>
                <input class="btn btn-primary" type="submit" value="update" name="action"/>
            </form>
        </div>
    </body>
</html>
