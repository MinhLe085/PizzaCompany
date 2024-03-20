
package Controllers.Product;

import Models.DAO.ProductDAO;
import Models.Entities.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minh Le
 */
@WebServlet(name = "AddProductController", urlPatterns = {"/AddProductController"})
public class AddProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String ProductID = request.getParameter("txtProductID");
            String ProductName = request.getParameter("txtProductName");
            String SupplierID = request.getParameter("txtSupplierID");
            String CategoryID = request.getParameter("txtCategoryID");
            String ProductImage = request.getParameter("txtProductImage");
            int QuantityPerUnit = Integer.parseInt(request.getParameter("txtQuantityPerUnit"));
            float UnitPrice = Float.parseFloat(request.getParameter("txtUnitPrice"));
            Product product = new Product(ProductID, ProductName, SupplierID, CategoryID, ProductImage, QuantityPerUnit, UnitPrice);
            ProductDAO productDao = new ProductDAO();
            productDao.addProduct(product);
            response.sendRedirect("StaffPage.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
