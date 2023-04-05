import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Servlet :: It is a server component responsible to create dynamic content
*/

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    //////////////////::  Service method: request object, response object  :://////////////////
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");

            if(username.equals("Durga") && password.equals("durga@dp12")){
                HttpSession session = request.getSession();

                session.setAttribute("username",username);
                response.sendRedirect("success.jsp");

            }else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.html");
                PrintWriter writer = response.getWriter();
                writer.println("<font color=red> Incorrect Credentials </font>");
                dispatcher.include(request,response);
            }


    }
}
