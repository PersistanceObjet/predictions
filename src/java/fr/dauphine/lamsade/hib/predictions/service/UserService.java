/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.service;

import fr.dauphine.lamsade.hib.predictions.dao.UserDAO;
import fr.dauphine.lamsade.hib.predictions.entity.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ayman
 */
@Stateless
public class UserService {

    @EJB
    private UserDAO userDAO;
    
    public String getInputValue( HttpServletRequest request, String inputName ) {
        String value = request.getParameter( inputName );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value.trim();
        }
    }
    /*
    private String md5(String input) {
        
        String output = null;
         
        try {
            
            MessageDigest digest = MessageDigest.getInstance("MD5");

            digest.update(input.getBytes(), 0, input.length());

            output = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (Exception e) {
            
        }
        return output;
    }
    */
    public User connect(String userLogin, String password) {
    	
        boolean flag = false;
        
        User user = new User();

        try {
            user = userDAO.findUserByUserLogin(userLogin);
        } catch (Exception e) {
            
        }
        
        try {
            if (password.equals(user.getUserPassword())) {  
                flag = true;
            }
        } catch (Exception e) {
            
        }

        if(flag)
            return user;
        else return null;
    }
    
    
    
    
}
