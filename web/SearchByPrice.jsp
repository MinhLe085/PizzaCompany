

<%@page import="Models.Entities.ProductItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search By Price Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="./Customize/CustomizeSearchPricePage.css"/>
        <style>
            .mobile-image {
                height: 200px; /* Adjust the height as needed */
                width: auto; /* Ensures the aspect ratio is maintained */
                object-fit: cover; /* Ensures the image covers the container */
            }
        </style>
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
                            <a class="nav-link active" aria-current="page" href="UserPage.jsp">Pizzas</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Search
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="SearchByName.jsp">Search By Name</a></li>
                                <li><a class="dropdown-item" href="SearchByPrice.jsp">Search By Price</a></li>
                                <li><a class="dropdown-item" href="SearchByID.jsp">Search By ID</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Reviews</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="viewOrderHistory.jsp?txtCustomerID=${sessionScope.user.getAccountID()}">Orders History</a>
                        </li>
                    </ul>
                    <ul class="nav">
                        <li class="nav-item"><a aria-current="page" class="nav-link link-body-emphasis px-2">User Page</a></li>
                        <li class="nav-item"><a class="nav-link link-body-emphasis px-2">Welcome, ${sessionScope.user.getUserName()}</a></li>
                        <li class="nav-item"><a href="LogoutController" class="nav-link link-body-emphasis px-2">Log Out</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <!--search-form-->
        <div class="form-custom">
            <form action="SearchByPriceController" class="form">
                <p class="title">Search Pizzas by Price</p>
                <div class="flex">
                    <label>
                        <input required="" name="txtPrice" placeholder="" type="number" class="input">
                        <span>Enter Price (below or equal) </span>
                    </label>
                </div>
                <input class="btn btn-primary" type="submit" value="Search">
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
    </body>
    <%
        List<ProductItem> productItemList = (List<ProductItem>) request.getAttribute("mobilePrice");
        if (productItemList != null) {
    %>
    <!--search-display-->
    <div class="container mt-4">
        <!-- Main container for card layout -->
        <div class="card">
            <h3 class="card-header">
                Search Results
            </h3>
            <div class="card-body">
                <div class="container">
                    <div class="row"> 

                        <%
                            for (ProductItem productItem : productItemList) {
                        %>

                        <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
                            <div class="card h-100 card-custom" style="width: 18rem;">
                                <img height="400px" class="mobile-image img-fluid" src="./image/<%=productItem.getProductImage()%>" alt="Pizza"/>
                                <div class="card-body">                                            
                                    <h5 style="text-align: center" class="card-title"><%=productItem.getProductID()%></h5>
                                    <p class="card-text">Product Name:<strong> <%=productItem.getProductName()%> </strong></p>
                                    <p class="card-text">Description:<strong> <%=productItem.getDescription()%></strong></p>
                                    <p class="card-text">Price:<strong> $<%=productItem.getUnitPrice()%></strong></p>
                                    <p class="card-text">Category Name:<strong> <%=productItem.getCategoryName()%></strong></p>
                                </div>
                            </div>
                        </div>                   
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
        <%
        } else {
        %>
        <h3 style="text-align: center">No Pizzas found!</h3>
        <%
            }
        %>
</html>
