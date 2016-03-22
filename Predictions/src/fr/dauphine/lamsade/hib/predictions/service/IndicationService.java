package fr.dauphine.lamsade.hib.predictions.service;

import java.sql.SQLException;

import fr.dauphine.lamsade.hib.predictions.dao.IndicationDAO;
import fr.dauphine.lamsade.hib.predictions.dao.PredictionDAO;
import fr.dauphine.lamsade.hib.predictions.dao.UserDAO;
import fr.dauphine.lamsade.hib.predictions.objects.Indication;
import fr.dauphine.lamsade.hib.predictions.objects.Prediction;
import fr.dauphine.lamsade.hib.predictions.objects.User;

public class IndicationService {
	
	private UserDAO userDAO = new UserDAO();
	private PredictionDAO predictionDAO = new PredictionDAO();
	private IndicationDAO indicationDAO = new IndicationDAO();
	
	public Indication create(String temp, String humidite, String weather, String count, String userId, String predictionId) {
		
		Indication indication = new Indication();
		
		try {
			indication.setTemp(Double.parseDouble(temp));
		}catch(NumberFormatException e){
			System.out.println("Temps error : " + e.getMessage());
		}
		
		try {
			indication.setHumidite(Double.parseDouble(humidite));
		}catch(NumberFormatException e){
			System.out.println("Humidité error : " + e.getMessage());
		}
		
		try {
			indication.setCount(Integer.parseInt(count));
		}catch(NumberFormatException e){
			System.out.println("Count error : " + e.getMessage());
		}
		
		try {
			User user = userDAO.find(Integer.parseInt(userId));
			indication.setUser(user);
		}catch(NumberFormatException e){
			System.out.println("User Id error : " + e.getMessage());
		}
		
		try {
			Prediction prediction = predictionDAO.find(Integer.parseInt(predictionId));
			indication.setPrediction(prediction);
		}catch(NumberFormatException e){
			System.out.println("Prediction Id error : " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Prediction error : " + e.getMessage());
		}
		
		try {
			indicationDAO.create(indication);
		} catch (SQLException e) {
			System.out.println("Indication Creation Failed : " + e.getMessage());
		}
		
		return indication;
	}
	
	public Indication find(String id) {
		
		Indication indication = new Indication();
		
		try {
			indication = indicationDAO.find(Integer.parseInt(id));
		}catch(SQLException e){
			System.out.println("Indication Search Failed : " + e.getMessage());
		}
		
		return indication;
	}
	
	public Indication update(String id, String temp, String humidite, String weather, String count, String userId, String predictionId) {
		
		Indication indication = new Indication();
		
		try {
			indication = indicationDAO.find(Integer.parseInt(id));
		}catch(SQLException e){
			System.out.println("Indication Search Failed : " + e.getMessage());
		}
		
		try {
			indication.setTemp(Double.parseDouble(temp));
		}catch(NumberFormatException e){
			System.out.println("Temps error : " + e.getMessage());
		}
		
		try {
			indication.setHumidite(Double.parseDouble(humidite));
		}catch(NumberFormatException e){
			System.out.println("Humidité error : " + e.getMessage());
		}
		
		try {
			indication.setCount(Integer.parseInt(count));
		}catch(NumberFormatException e){
			System.out.println("Count error : " + e.getMessage());
		}
		
		try {
			User user = userDAO.find(Integer.parseInt(userId));
			indication.setUser(user);
		}catch(NumberFormatException e){
			System.out.println("User Id error : " + e.getMessage());
		}
		
		try {
			Prediction prediction = predictionDAO.find(Integer.parseInt(predictionId));
			indication.setPrediction(prediction);
		}catch(NumberFormatException e){
			System.out.println("Prediction Id error : " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Prediction error : " + e.getMessage());
		}
		
		try {
			indicationDAO.update(indication);
		} catch (SQLException e) {
			System.out.println("Indication Update Failed : " + e.getMessage());
		}
		
		return indication;
		
	}
	
	public void delete(String id) {
		Indication indication = new Indication();
		
		try {
			indication = indicationDAO.find(Integer.parseInt(id));
		}catch(SQLException e){
			System.out.println("Indication Search Failed : " + e.getMessage());
		}
		
		try {
			indicationDAO.delete(indication);
		} catch (SQLException e) {
			System.out.println("Indication delete Failed : " + e.getMessage());
		}
	}

}
