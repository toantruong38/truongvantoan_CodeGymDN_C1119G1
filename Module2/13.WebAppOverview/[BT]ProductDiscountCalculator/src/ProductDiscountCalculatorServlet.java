import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet",urlPatterns = "/product_discount_calculator")
public class ProductDiscountCalculatorServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String descr=request.getParameter("descr");
        double price=Double.parseDouble(request.getParameter("price"));
        double percent=Double.parseDouble(request.getParameter("percent"));
        double amount=price*percent*0.1;
        double discountPrice=amount*price;

        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Discount amount: "+amount+"</h1>");
        writer.println("<br/>");
        writer.println("<h1> Price :  "+discountPrice+"</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }
}
