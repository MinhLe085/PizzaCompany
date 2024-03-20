

<%@page import="Models.Entities.OrderHistory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Models.DAO.OrderHistoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Order History Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
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

        <h1 class="text-center">Order History</h1>
        <div>
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>OrderID</th>
                        <th>ProductID</th>
                        <th>OrderDate <i class="fa-solid fa-calendar-days"></i></th>
                        <th>RequiredDate <i class="fa-solid fa-calendar-days"></i></th>
                        <th>ShippedDate <i class="fa-solid fa-calendar-days"></i></th>
                        <th>ShipAddress <i class="fa-solid fa-location-dot"></i></th>
                        <th>Freight <i class="fa-solid fa-weight-hanging"></i></th>
                        <th>Quantity </th>
                        <th>Price</th>
                        <th>Total <i class="fa-solid fa-money-bill"></i></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        String customerId = request.getParameter("txtCustomerID");
                        OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAO();
                        List<OrderHistory> orderHistoryList = new ArrayList();
                        orderHistoryList = orderHistoryDAO.getOrderHistoryList(customerId);
                        for (OrderHistory orderHistory : orderHistoryList) {
                    %>
                    <tr>
                        <th><%= orderHistory.getOrderID()%></th>
                        <th><%= orderHistory.getProductID()%></th>
                        <th><%= orderHistory.getOrderDate()%></th>
                        <td><%= orderHistory.getRequiredDate()%></td>
                        <td><%= orderHistory.getShippedDate()%></td>
                        <td><%= orderHistory.getShipAddress()%></td>
                        <td><%= orderHistory.getFreight()%></td>
                        <td><%= orderHistory.getQuantity()%></td>
                        <td><%= orderHistory.getUnitPrice()%></td>
                        <td><%= orderHistory.getQuantity() * orderHistory.getUnitPrice()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>
    </body>
</html>
