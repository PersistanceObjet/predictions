/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.service;

import fr.dauphine.lamsade.hib.predictions.dao.UserDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Shitai
 */
public class Service {
    
    private static final String FORMAT_EMAIL = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"; 
    
    @EJB
    protected UserDAO userDAO;
    
    protected String message;
    
    protected Map<String, String> errors = new HashMap<>();

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
    
    protected void setError( String errorName, String errorMessage ) {
        errors.put( errorName, errorMessage );
    }
    
    public void resetErrors() {
            this.errors = new HashMap<>();
    }
    
    public String getInputValue( HttpServletRequest request, String inputName ) {
        String value = request.getParameter( inputName );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value.trim();
        }
    }
    
    protected String md5(String input) {
        
        String output = null;
         
        try {
            
            MessageDigest digest = MessageDigest.getInstance("MD5");

            digest.update(input.getBytes(), 0, input.length());

            output = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (Exception e) {
            setError( "unknownError", e.getMessage());
        }
        return output;
    }
    
    protected void verififyUserLogin(String userLogin) throws Exception {
        if (userLogin!= null) {
            if (userDAO.findUserByUserLogin(userLogin) == null) {            	
                throw new Exception( "L'utilisateur n'existe pas! Veuillez en saisir un autre identifiant." );
            }           
        } else {
            throw new Exception( "Veuillez saisir votre identifiant." );
        }
    }
    
    protected void verifyPassword( String passwordEntered, String password ) throws Exception {
        if ( passwordEntered != null ) {
            if (!password.equals(md5(passwordEntered))) {  
                throw new Exception( "Le mot de passe est incorrect !" );
            }
        }else if ( passwordEntered == null ){
            throw new Exception( "Veuillez saisir votre mot de passe." );
        }
    }
    
    protected void validateInput(String str) throws Exception {
    if (str != null) {
        if(str.length() < 1 || str.length() > 255){
            throw new Exception( "Ce champ doit contenir entre 1 et 255 caractères." );
        }
        }else{
        throw new Exception( "Veuillez saisir ce champ." );
        }
    }
    
    protected void validateEmail(String userLogin) throws Exception {
        if (userLogin != null) {
            if ( !userLogin.matches(FORMAT_EMAIL) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }else if(userDAO.findUserByUserLogin(userLogin) != null) {
            	throw new Exception( "L'adresse mail est déjà prise, veilliez en saisir une autre." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
    
    protected void validePassword( String password, String confirmation ) throws Exception {
        if ( password != null && confirmation != null ) {
            if ( !password.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe saisis sont différents, merci de les saisir à nouveau." );
            } else if ( password.length() < 5 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 5 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }
}
