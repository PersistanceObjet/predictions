package fr.dauphine.lamsade.hib.predictions.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.dauphine.lamsade.hib.predictions.jpa.Indication;

/**
 * Session Bean implementation class IndicationDAO
 */
@Stateless
@LocalBean
public class IndicationDAO extends AbstractDAO<Indication>{

	@PersistenceContext(unitName = "PredictionsJPA")
    private EntityManager em;
	
    public IndicationDAO() {
    	super(Indication.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
