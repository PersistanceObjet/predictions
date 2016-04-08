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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userLogin = service.getInputValue(request, "userLogin" );
        String password = service.getInputValue( request, "password" );
        
        HttpSession session = request.getSession();       
 
        User user = service.connect(userLogin, password);
        
        if (user != null) {
            session.setAttribute( "session_user", user );           
        } else {                     
            this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
        }
        
    }
}
