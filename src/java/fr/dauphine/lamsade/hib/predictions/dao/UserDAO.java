/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.dao;

import fr.dauphine.lamsade.hib.predictions.entity.User;
import java.util.List;
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
    
    public User findUserByUserLogin(String userLogin) {
        User user = null;
        //user = (User) em.createNamedQuery("User.findByEmail").setParameter("email", email).getSingleResult();
        List<User> results = em.createNamedQuery("User.findByUserLogin").setParameter("userLogin", userLogin).getResultList();
        if(!results.isEmpty()){
            user = results.get(0);
        }
        return user;
    }
    
}
