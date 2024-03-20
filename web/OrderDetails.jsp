<%@page import="Models.DAO.OrderDetailsDAO"%>
<%@page import="Models.DAO.OrderDAO"%>
<%@page import="Models.DAO.ProductItemDAO"%>
<%@page import="Models.Entities.OrderDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Models.DAO.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order details page</title>
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
                            <a class="nav-link active" aria-current="page" href="#">Pizza</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Categories
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="Order.jsp">Orders</a></li>
                                <li><a class="dropdown-item" href="OrderDetails.jsp">Order Details</a></li>
                                <li><a class="dropdown-item" href="StaffPage.jsp">Products</a></li>
                                <li><a class="dropdown-item" href="Customer.jsp">Customers</a></li>
                                <li><a class="dropdown-item" href="Category.jsp">Categories</a></li>
                                <li><a class="dropdown-item" href="Supplier.jsp">Suppliers</a></li>
                            </ul>
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
        <!--body-->
        <div class="container">
            <h1>Order Details</h1>
            <a href="AddOrderDetails.jsp" class="btn btn-success mb-3"/>Create New</a>
	<table class="table table-hover table-bordered border-primary">
	    <thead>
		<tr style="text-align: center">
		    <th>OrderID</th>
		    <th>ProductID</th>
		    <th>UnitPrice</th>
		    <th>Quantity</th>
                    <th>Action</th>
		</tr>
	    </thead>
	    <tbody class="table-group-divider">
		<%
		    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
		    List<OrderDetails> orderDetailsList = orderDetailsDAO.getOrderDetailsList();
		    for (OrderDetails orderDetails : orderDetailsList) {
		%>
		<tr style="text-align: center">
		    <td><%=orderDetails.getOrderID()%></td>
		    <td><%=orderDetails.getProductID()%></td>
		    <td><%=orderDetails.getUnitPrice()%></td>
		    <td><%=orderDetails.getQuantity()%></td>
		    <td><a href="UpdateOrderDetails.jsp?txtOrderID=<%=orderDetails.getOrderID()%>&txtProductID=<%=orderDetails.getProductID()%>" class="btn btn-outline-warning">Edit</a> |  
			<a href="OrderDetailsController?action=delete&txtOrderID=<%=orderDetails.getOrderID()%>&txtProductID=<%=orderDetails.getProductID()%>" class="btn btn-outline-danger">Delete</a></td>
		</tr>
		</div>
		<%
		    }
		%>
	    </tbody>
	</table>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
	crossorigin="anonymous"></script>
</body>
</html>
