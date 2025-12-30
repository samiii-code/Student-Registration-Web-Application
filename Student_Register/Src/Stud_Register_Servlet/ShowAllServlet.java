package Stud_Register;
import Stud_Register.DBUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show_all")
public class ShowAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String[]> students = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT name, email, year FROM students";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                students.add(new String[]{
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("year")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("students", students);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}




