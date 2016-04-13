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

/**
 *
 * @author Shitai
 */
@WebServlet(name = "CreateUser", urlPatterns = {"/create-user"})
public class CreateUser extends HttpServlet {

    @EJB
    private UserService service;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service.resetErrors();
        
        this.getServletContext().getRequestDispatcher( "/create-user.jsp" ).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userLogin = service.getInputValue(request, "userLogin");
        String firstname = service.getInputValue(request, "firstName");
        String lastname = service.getInputValue(request, "lastName");
        String password = service.getInputValue(request, "password");
        String confirmation = service.getInputValue(request, "confirmation");
       
        service.resetErrors();
        
        User user = service.createUser(firstname, lastname, userLogin, password, confirmation);       
        request.setAttribute( "message", service.getMessage() );
        
        if (service.getErrors().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setAttribute( "user", user );
            request.setAttribute( "errors", service.getErrors() );
            
            this.getServletContext().getRequestDispatcher( "/create-user.jsp" ).forward( request, response );
        }
    }
}
