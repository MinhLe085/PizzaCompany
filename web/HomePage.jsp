
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="./Customize/CustomizeCommon.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
    </head>
    <body style="background-image: url('BackgroundIMG/269.jpg');
          background-size: cover;
          background-repeat: no-repeat">
        <!--header-->
        <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" aria-current="page" href="#">PizzaStore</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Pizzas</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Categories
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="HomePage.jsp">Orders</a></li>
                                <li><a class="dropdown-item" href="HomePage.jsp">Order Details</a></li>
                                <li><a class="dropdown-item" href="HomePage.jsp">Products</a></li>
                                <li><a class="dropdown-item" href="HomePage.jsp">Customers</a></li>
                                <li><a class="dropdown-item" href="HomePage.jsp">Categories</a></li>
                                <li><a class="dropdown-item" href="HomePage.jsp">Suppliers</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Reviews</a>
                        </li>
                    </ul>
                    <ul class="nav">
                        <li class="nav-item"><a href="Register.jsp" class="nav-link link-body-emphasis px-2">Register</a></li>
                        <li class="nav-item"><a href="#" aria-current="page" class="nav-link link-body-emphasis px-2">Log in</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--login form-->
        <div class="container" style="margin-top: 40px">
            <form class="form" action="LoginController" method="post">
                <p class="form-title">Sign in to your account</p>
                <div class="input-container">
                    User Name <input name="txtAccountID" type="text" placeholder="Enter user name">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Password <input name="password" type="text" placeholder="Enter password">
                </div>
                <button type="submit" class="submit">
                    Sign in
                </button>
                <h3 style="color: red">${requestScope.error}</h3>
                <h3 style="color: red">${requestScope.errorBlank}</h3>
                <p class="signup-link">
                    No account?
                    <a href="Register.jsp">Sign up</a>
                </p>
            </form>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
    </body>
</html>
