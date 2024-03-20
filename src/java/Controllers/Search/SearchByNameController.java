
package Controllers.Search;

import Models.DAO.ProductItemDAO;
import Models.Entities.ProductItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minh Le
 */
@WebServlet(name="SearchByNameController", urlPatterns={"/SearchByNameController"})
public class SearchByNameController extends HttpServlet {
   private final String searchPage = "SearchByName.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url, searchValue;
        PrintWriter out = response.getWriter();
        url = searchPage;
        try {
            searchValue = request.getParameter("txtSearchValue");
            request.setAttribute("searchValue", searchValue);
            if(!searchValue.isEmpty()) {
                ProductItemDAO productItemDAO = new ProductItemDAO();
                List<ProductItem> mobileList = productItemDAO.searchProductName(searchValue);
                request.setAttribute("SearchResult", mobileList);
            }
        } catch (Exception e) {
            out.println("Error: " +e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
