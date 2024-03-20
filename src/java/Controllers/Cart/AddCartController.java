package Controllers.Cart;

import Models.DAO.OrderDAO;
import Models.DAO.OrderDetailsDAO;
import Models.Entities.Order;
import Models.Entities.OrderDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddCartController", urlPatterns = {"/AddCartController"})
public class AddCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String OrderID = request.getParameter("txtOrderID");
            String CustomerID = request.getParameter("txtCustomerID");
            String OrderDate = request.getParameter("txtOrderDate");
            String RequiredDate = request.getParameter("txtRequiredDate");
            String ShippedDate = request.getParameter("txtShippedDate");
            int Freight = Integer.parseInt(request.getParameter("txtFreight"));
            String ShipAddress = request.getParameter("txtShipAddress");
            String ProductID = request.getParameter("txtProductID");
            float UnitPrice = Float.parseFloat(request.getParameter("txtUnitPrice"));

            OrderDAO orderDao = new OrderDAO();
            OrderDetailsDAO orderDetailsDao = new OrderDetailsDAO();
            orderDao.addOrder(new Order(OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress));
            orderDetailsDao.addOrderDetails(new OrderDetails(OrderID, ProductID, UnitPrice, Freight));
            response.sendRedirect("UserPage.jsp");
        } catch (Exception ex) {
            request.setAttribute("error", "Error when adding order!");
            request.getRequestDispatcher("UserPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
