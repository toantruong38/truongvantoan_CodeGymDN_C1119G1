import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String us=request.getParameter("username");
        String ps=request.getParameter("password");

        PrintWriter writer=response.getWriter();
        writer.println("<html>");

        if(us.equals("admin")&&ps.equals("admin"))
        {writer.println("<h1>Welcome</h1>");}
        else writer.println("<h1>Error</h1>");

        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
