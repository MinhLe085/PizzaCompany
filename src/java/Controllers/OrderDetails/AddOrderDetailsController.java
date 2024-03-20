package Controllers.OrderDetails;

import Models.DAO.OrderDetailsDAO;
import Models.Entities.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AddOrderDetailsController", urlPatterns={"/AddOrderDetailsController"})
public class AddOrderDetailsController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String OrderID = request.getParameter("txtOrderID");
        String ProductID = request.getParameter("txtProductID");
        float UnitPrice = Float.parseFloat(request.getParameter("txtUnitPrice"));
        int Quantity = Integer.parseInt(request.getParameter("txtQuantity"));
        
        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
        try {
            orderDetailsDAO.addOrderDetails(new OrderDetails(OrderID, ProductID, UnitPrice, Quantity));
            response.sendRedirect("OrderDetails.jsp");
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
