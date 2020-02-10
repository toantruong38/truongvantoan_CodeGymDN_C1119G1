import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userN=request.getParameter("username");
        String passW=request.getParameter("password");
        RequestDispatcher dPatcher=null;

        if(userN.equals("admin")&&passW.equals("admin"))
        {
            response.sendRedirect("/login/welcomeAdmin");
        }else{
            dPatcher=request.getRequestDispatcher("/index.jsp");
            dPatcher.include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
