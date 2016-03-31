package fr.dauphine.lamsade.hib.predictions.ejb;

import java.util.List;

import javax.ejb.Local;

import fr.dauphine.lamsade.hib.predictions.jpa.User;

@Local
public interface UserBeanLocal {
	
	public List<User> getAllUser();

}
