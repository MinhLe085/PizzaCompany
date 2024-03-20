
<%@page import="Models.Entities.ProductItem"%>
<%@page import="Models.DAO.ProductItemDAO"%>
<%@page import="Models.Entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Models.DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">

        <style>
            .card {
                width: 18rem; /* Set a fixed width for all cards */
                margin-right: 10px; /* Optional: Add some spacing between cards */
            }

            .card-img-top {
                height: 200px; /* Set a fixed height for the images */
                object-fit: cover; /* Maintain aspect ratio and cover the entire container */
            }
            .container {
                margin-top: 10px;
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
                            <a class="nav-link active" aria-current="page" href="#">Pizzas</a>
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
        <div class="container d-flex flex-nowrap">
            <%
                ProductItemDAO productItemDAO = new ProductItemDAO();
                List<ProductItem> productItemList = productItemDAO.getProductItem();
                for (ProductItem productItem : productItemList) {
            %>
            <div class="card" style="width: 18rem;">
                <img src="./image/<%=productItem.getProductImage()%>" class="card-img-top" alt="Pizza">
                <div class="card-body">
                    <div style="display: flex; justify-content: space-between">
                        <h5 class="card-title"><%=productItem.getProductName()%></h5>
                        <p style="font-weight: bold; font-size: 17px">$<%=productItem.getUnitPrice()%></p>
                    </div>
                    <p class="card-text" style="font-weight: bold">Category: <%=productItem.getCategoryName()%></p>
                    <p class="card-text"><%=productItem.getDescription()%></p>
                    <a href="AddCart.jsp?txtCustomerID=${sessionScope.user.getAccountID()}&txtProductID=<%=productItem.getProductID()%>&txtUnitPrice=<%=productItem.getUnitPrice()%>" 
                       class="btn btn-primary">Add Pizza</a>
                </div>
            </div>

            <%
                }
            %>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
    </body>

</html>
