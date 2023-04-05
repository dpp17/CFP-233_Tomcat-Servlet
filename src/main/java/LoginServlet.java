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

    //////////////////::  Checking Input with Regex pattern  :://////////////////
    private static Matcher getValidation(String input, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        return pattern.matcher(input);
    }

    //////////////////::  method to decrease code complexity--- use: error_output  :://////////////////
    private void errorPrint(String errors, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.html");
        PrintWriter writer = response.getWriter();
        writer.println("<font color=red> "+ errors +" </font>");
        dispatcher.include(request,response);
    }

    //////////////////::  Service method: request object, response object  :://////////////////
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");

        boolean userResult = getValidation(username, ELogin.USERNAME_START_WITH_CAPITAL.getConstant()).find();

        if(!userResult){
            errorPrint("Invalid Username",request,response);
        }else{
            if(username.equals("Durga") && password.equals("durga@dp12")){
                HttpSession session = request.getSession();

                session.setAttribute("username",username);
                response.sendRedirect("success.jsp");

            }else {
                errorPrint("Incorrect Credentials",request,response);
            }
        }


    }
}
