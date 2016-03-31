package fr.dauphine.lamsade.hib.predictions.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import fr.dauphine.lamsade.hib.predictions.dao.UserDAO;
import fr.dauphine.lamsade.hib.predictions.jpa.User;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)

public class UserBean implements UserBeanLocal {
	
	@Resource
    private EJBContext context;    
    @PersistenceUnit(unitName="PredictionsJPA")
    private EntityManagerFactory emf;
    /**
     * Default constructor. 
     */
    public UserBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<User> getAllUser() {
		
		UserDAO userDAO = 
                new UserDAO(context.getUserTransaction(),emf);
		List<User> users = userDAO.findUtilisateurEntities();
		
		return users;
	}
    
    
    

}
