
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorldServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //this will display the rewuested JSp as a view
        getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Capture the parameters from the POST requet (the form)
        String firstname = request.getParameter("first_name");
        String lastname = request.getParameter("last_name");
        
        //set the attributes for the JSP
        request.setAttribute("firstName", firstname);
        request.setAttribute("lastName", lastname);
        
        // if the parameters dont exist or are empty, show the form again
        if(firstname == null || firstname.equals("") || lastname == null || lastname.equals("")){
           //Message to help the user
            request.setAttribute("message", "Invalid Entry, Please Enter first and last name");
            //forward the request and response objects to the JSP
            getServletContext().getRequestDispatcher("/WEB-INF/helloWorldForm.jsp").forward(request,response);
            return;           //Very important. Stops the code call

        }
        
        //diaplay the helloWorld JSP
        getServletContext().getRequestDispatcher("/WEB-INF/helloWorld.jsp").forward(request, response);
        
    }
}
