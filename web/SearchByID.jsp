

<%@page import="Models.Entities.ProductItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search By ID Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
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
        <div class="card-body">
            <div class="container">
                <h1>Search Pizza By ID <i class="fa-solid fa-magnifying-glass"></i> </h1>
                <form action="SearchByIDController" method="post">
                    <input class="form-control me-2 mb-3" name="txtProductID" 
                           type="text" placeholder="Search" aria-label="Search"/>
                    <input class="btn btn-outline-success" type="submit" value="Search" />
                </form>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
                crossorigin="anonymous"></script> 
                </body>
                <%
                    ProductItem productID = (ProductItem) request.getAttribute("ProductItemID");
                    if (productID != null) {%>
                <table class="table table-striped table-hover table-bordered mt-3">
                    <thead>
                        <tr>
                            <th>ProductID</th>
                            <th>ProductName</th>
                            <th>Price</th>
                            <th>Description</th>
                            <th>ProductImage</th>
                            <th>CategoryName</th>
                            <th>Image</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <tr>
                            <td><%= productID.getProductID()%></td>
                            <td><%= productID.getProductName()%></td>
                            <td><%=productID.getUnitPrice()%></td>
                            <td><%=productID.getDescription()%></td>
                            <td><%=productID.getProductImage()%></td>
                            <td><%=productID.getCategoryName()%></td>
                            <td><img height="100px" width="100px" src="./image/<%=productID.getProductImage()%>" alt="Pizza"/></td>
                        </tr>
                    </tbody>
                    <% } else {%>
                    <p><%= request.getAttribute("errorMessage")%></p>
                    <% }%>
                </table>
            </div>
        </div>
</html>
