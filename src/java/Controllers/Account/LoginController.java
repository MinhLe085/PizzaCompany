package Controllers.Account;

import Models.DAO.AccountDAO;
import Models.Entities.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        String accountID = request.getParameter("txtAccountID");
        String password = request.getParameter("password");
        if (accountID == null || accountID.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.setAttribute("errorBlank", "AccountID or password must not be blank");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        }
        AccountDAO accountDAO = new AccountDAO();
        HttpSession session = request.getSession();
        try {
            Account account = accountDAO.Login(accountID, password);
            if (account == null) {
                //account does not exist
                request.setAttribute("error", "AccountID or Password does not exist!!");
                request.getRequestDispatcher("HomePage.jsp").forward(request, response);
            } else {
                //account exist
                session.setAttribute("user", account);
                if (account.getType() == 1) {
                    response.sendRedirect("StaffPage.jsp");
                } else if (account.getType() == 2) {
                    response.sendRedirect("UserPage.jsp");
                }
            }
        } catch (Exception ex) {
            out.print("Error!!!");
        }
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
