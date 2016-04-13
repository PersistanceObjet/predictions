/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.servlet;

import fr.dauphine.lamsade.hib.predictions.entity.User;
import fr.dauphine.lamsade.hib.predictions.service.UserService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shitai
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    
    @EJB
    private UserService service;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service.resetErrors();
        this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        service.resetErrors();
        
        request.setAttribute("message", service.getMessage());
        
        String userLogin = service.getInputValue(request, "userLogin" );
        String password = service.getInputValue( request, "password" );
        
        HttpSession session = request.getSession();       
 
        User user = service.connect(userLogin, password);
        
        if (service.getErrors().isEmpty()) {
         
            session.setAttribute( "session_user", user );
            
            if(!(request.getHeader("referer").contains(request.getContextPath() + "/login") || request.getHeader("referer").contains(request.getContextPath() + "/"))) {
                response.sendRedirect(request.getHeader("referer"));
            }               
            else response.sendRedirect(request.getContextPath() + "/user/home");
            
        } else {          
            session.setAttribute("session_user", null);            
            request.setAttribute("user", user);
            request.setAttribute("errors", service.getErrors());
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
    }
}
