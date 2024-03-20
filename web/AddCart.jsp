
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="Models.DAO.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Date currentDate = new Date(System.currentTimeMillis());
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String currentDateTime = dateFormat.format(currentDate);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add cart</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="./Customize/CustomizeCommon.css" rel="stylesheet">
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
        <div class="container mt-5">
            <form class="form" action="CartController?action=add&txtProductID=<%=request.getParameter("txtProductID")%>&txtUnitPrice=<%=request.getParameter("txtUnitPrice")%>" method="post">
                <p class="form-title">Add order</p>
                <div class="input-container">
                    Order ID <input name="txtOrderID" value="<%=new OrderDAO().getRecentOrderID()%>" readonly>
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Customer ID <input name="txtCustomerID" value="<%=request.getParameter("txtCustomerID")%>" readonly/>
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Order Date <input name="txtOrderDate" value="<%=currentDateTime%>" readonly>
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Required Date <input name="txtRequiredDate" type="date" placeholder="Choose required date">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    Shipped Date <input name="txtShippedDate" type="date" placeholder="Choose shipped date">
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
                <button type="submit" name="action" value="addCart" class="submit bg-primary">
                    Add
                </button>
                <h3 style="color: red">${requestScope.error}</h3>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
    </body>
