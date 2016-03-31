package fr.dauphine.lamsade.hib.predictions.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.UserTransaction;
import fr.dauphine.lamsade.hib.predictions.jpa.User;

/**
 * @author Ayman
 *
 */
@Stateless
public class UserDAO implements Serializable {
	

	 public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDAO(UserTransaction utx, EntityManagerFactory emf) {
	        this.utx = utx;
	        this.emf = emf;
	    }
	    private UserTransaction utx = null;
	    private EntityManagerFactory emf = null;

	    public EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }
	    
	    public List<User> findUtilisateurEntities() {
	        return findUtilisateurEntities(true, -1, -1);
	    }

	    private List<User> findUtilisateurEntities(boolean all, int maxResults, int firstResult) {
	        EntityManager em = getEntityManager();
	        try {
	            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	            cq.select(cq.from(User.class));
	            Query q = em.createQuery(cq);
	            if (!all) {
	                q.setMaxResults(maxResults);
	                q.setFirstResult(firstResult);
	            }
	            return q.getResultList();
	        } finally {
	            em.close();
	        }
	    }

}