import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter writer=response.getWriter();
        String operator=request.getParameter("operator");
        double f1=Double.parseDouble(request.getParameter("f1"));
        double f2=Double.parseDouble(request.getParameter("f2"));
        double result=0;

        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        switch (operator)
        {
            case "+":
                result=f1+f2;
                break;
            case "-":
                result=f1-f2;
                break;
            case "*":
                result=f1*f2;
                break;
            case "/":
                result=f1/f2;
                break;
        }
        writer.println("<h2>"+result+"</h2>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
