package com.app.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private final AuthenticationService authenticationService;

    public LoginServlet() {
    
        authenticationService = new AuthenticationService();
   
    }
   
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramUsername = req.getParameter("username");
        String paramPassword = req.getParameter("password");
        
        if (authenticationService.authenticate("C:\\Users\\usera\\Desktop\\ProyectoMynorChoc\\ProyectoLogin\\build\\web\\WEB-INF\\classes\\com\\app\\paquetexml\\archivoxml.xml",
                paramUsername, paramPassword)) {

            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate(); 
            }
            
            HttpSession currentSession = req.getSession(); 
            currentSession.setAttribute("user", paramUsername);
            currentSession.setMaxInactiveInterval(5*60); 
            resp.sendRedirect("success.jsp");
            
            
        } else {
        
            resp.sendRedirect("login.jsp");
        }
    
    }

}
