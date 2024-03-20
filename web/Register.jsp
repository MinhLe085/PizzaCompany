
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="./Customize/RegisterPage.css"/>
    </head>
    <body style="background-image: url('BackgroundIMG/269.jpg');
          background-size: cover;
          background-repeat: no-repeat">
        <!--header-->
        <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">PizzaStore</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Pizzas</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Categories
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Reviews</a>
                        </li>
                    </ul>
                    <ul class="nav">
                        <li class="nav-item"><a href="#" aria-current="page" class="nav-link link-body-emphasis px-2">Register</a></li>
                        <li class="nav-item"><a href="HomePage.jsp" class="nav-link link-body-emphasis px-2">Log in</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--register-form-->
        <div class="form-custom">
            <form class="form" action="RegisterController" method="post">
                <p class="title">Register </p>
                <p class="message">Signup now and get full access to our app. </p>
                <label>
                    <input required="" name="txtAccountID" type="text" placeholder="" class="input">
                    <span>CustomerID</span>
                </label>
                <label>
                    <input required="" name="txtPassword" type="password" placeholder="" class="input">
                    <span>Password</span>
                </label>
                <label>
                    <input required="" name="txtContactName" type="text" placeholder="" class="input">
                    <span>Contact Name</span>
                </label>
                <div class="flex">
                    <label>
                        <input required="" name="txtAddress" placeholder="" type="text" class="input">
                        <span>Address</span>
                    </label>
                    <label>
                        <input required="" name="txtPhone" placeholder="" type="text" class="input">
                        <span>Phone Number</span>
                    </label>
                </div>
                <button class="submit">Submit</button>
                <p class="signin">Already have an acount ? <a href="HomePage.jsp">Sign in</a> </p>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
    </body>
</html>
