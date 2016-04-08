/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.service;

import fr.dauphine.lamsade.hib.predictions.dao.UserDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ayman
 */
@Stateless
public class UserService {

    @EJB
    private UserDAO userDAO;
    
    
    
}
