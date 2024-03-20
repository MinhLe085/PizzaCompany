package Controllers.Order;

import Models.DAO.OrderDAO;
import Models.Entities.Order;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UpdateOrderController", urlPatterns={"/UpdateOrderController"})
public class UpdateOrderController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String OrderID = request.getParameter("txtOrderID");
        String CustomerID = request.getParameter("txtCustomerID");
        String OrderDate = request.getParameter("txtOrderDate");
        String RequiredDate = request.getParameter("txtRequiredDate");
        String ShippedDate = request.getParameter("txtShippedDate");
        int Freight = Integer.parseInt(request.getParameter("txtFreight"));
        String ShipAddress = request.getParameter("txtShipAddress");
        
        OrderDAO orderDao = new OrderDAO();
        try {
            orderDao.updateOrder(new Order(OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress));
            response.sendRedirect("Order.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
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
