import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CurrencyConverterServlet",urlPatterns = "/convert")
public class CurrencyConverterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Float rate=Float.parseFloat(request.getParameter("rate"));
        Float usd=Float.parseFloat(request.getParameter("usd"));

        Float vnd=usd*rate;
        PrintWriter writer=response.getWriter();

        writer.println("<html>");
        writer.println("<h1 >"+"usd "+usd+"</h1>");
        writer.println("<h1 >"+"rate "+rate+"</h1>");
        writer.println("<h1 >"+"vnd "+vnd+"</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
