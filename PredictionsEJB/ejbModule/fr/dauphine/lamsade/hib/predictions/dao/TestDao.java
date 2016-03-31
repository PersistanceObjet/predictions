package fr.dauphine.lamsade.hib.predictions.dao;

import javax.ejb.EJB;

import fr.dauphine.lamsade.hib.predictions.ejb.UserBeanLocal;

public class TestDao {
	@EJB 
	private static UserBeanLocal userBean;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println(userBean.getAllUser().get(0).getFirstName());	

	}

}
