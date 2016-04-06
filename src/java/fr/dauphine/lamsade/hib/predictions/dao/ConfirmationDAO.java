/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.dao;

import fr.dauphine.lamsade.hib.predictions.entity.Confirmation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Shitai
 */
@Stateless
public class ConfirmationDAO extends AbstractDAO<Confirmation> {

    @PersistenceContext(unitName = "PredictionsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfirmationDAO() {
        super(Confirmation.class);
    }
    
}
