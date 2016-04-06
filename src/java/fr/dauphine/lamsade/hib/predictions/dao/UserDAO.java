/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.dao;

import fr.dauphine.lamsade.hib.predictions.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ayman
 */
@Stateless
public class UserDAO extends AbstractDAO<User> {

    @PersistenceContext(unitName = "PredictionsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDAO() {
        super(User.class);
    }
    
}
