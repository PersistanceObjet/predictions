/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.service;

import fr.dauphine.lamsade.hib.predictions.entity.User;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Ayman
 */
@Stateless
@LocalBean
public class UserService extends Service{

    public User connect(String userLogin, String password) {
    	
        User user = new User();

        try {
            verififyUserLogin(userLogin);  
            user = userDAO.findUserByUserLogin(userLogin);           
        } catch ( Exception e ) {
            setError( "userLoginError", e.getMessage() );
        }
        
        try {
            verifyPassword( password, user.getUserPassword());
        } catch ( Exception e ) {
            setError("passwordError", e.getMessage() );
            user = new User();
            user.setUserLogin(userLogin);
        }
        
        if (errors.isEmpty()) {
            message = "Succès de la connexion.";
        } else {
            message = "Échec de la connexion.";
        }

        return user;
    }

    public User createUser(String firstname, String lastname, String userLogin, String password, String confirmation) {
    	
        User user = new User();

        try {
            validateInput(firstname);
        } catch ( Exception e ) {
            setError( "firstNameError", e.getMessage() );
        }
        user.setFirstName(firstname);

        try {
            validateInput(lastname);
        } catch ( Exception e ) {
            setError( "lastNameError", e.getMessage() );
        }
        user.setLastName(lastname);
        
        try {
            validateEmail(userLogin);
        } catch ( Exception e ) {
            setError( "userLoginError", e.getMessage() );
        }
        user.setUserLogin(userLogin);
        
        try {
            validePassword(password, confirmation);
        } catch ( Exception e ) {
            setError( "passwordError", e.getMessage() );
        }
        password = md5(password);
        user.setUserPassword(password);
        
        if(errors.isEmpty()) {
            userDAO.create(user);
            message = "Succès de la création de l'utilisateur.";
        }else {
            message = "Échec de la création de l'utilisateur.";
        }

        return user;
    }
    
}
