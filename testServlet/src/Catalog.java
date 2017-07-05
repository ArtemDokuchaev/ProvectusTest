import com.mysoft.DAO;

import java.io.IOException;
import java.sql.SQLException;

@javax.servlet.annotation.WebServlet(name = "MyServlet",urlPatterns = "/catalog")
public class Catalog extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.sendRedirect("/catalog");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            request.setAttribute("books", DAO.getBooks());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/catalog.jsp").forward(request,response);
    }
}
