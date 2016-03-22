package fr.dauphine.lamsade.hib.predictions.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	protected void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
	
	public void resetErreurs() {
		this.erreurs = new HashMap<String, String>();
	}
	
	public Indication create(String temp, String humidite, String weather, String count, String userId, String predictionId) {
		
		Indication indication = new Indication();
		
		try {
			indication.setTemp(Double.parseDouble(temp));
		}catch(NumberFormatException e){
			setErreur("temp_error", e.getMessage());
		}
		
		try {
			indication.setHumidite(Double.parseDouble(humidite));
		}catch(NumberFormatException e){
			setErreur("humidité_error", e.getMessage());
		}
		
		try {
			indication.setCount(Integer.parseInt(count));
		}catch(NumberFormatException e){
			setErreur("count_error", e.getMessage());
		}
		
		try {
			User user = userDAO.find(Integer.parseInt(userId));
			indication.setUser(user);
		}catch(NumberFormatException e){
			setErreur("userId_error", e.getMessage());
		}catch(SQLException e){
			setErreur("user_error", e.getMessage());
		}
		
		try {
			Prediction prediction = predictionDAO.find(Integer.parseInt(predictionId));
			indication.setPrediction(prediction);
		}catch(NumberFormatException e){
			setErreur("predictionId_error", e.getMessage());
		}catch (Exception e) {
			setErreur("prediction_error", e.getMessage());
		}
		
		if (getErreurs().isEmpty()) {
			try {
				indicationDAO.create(indication);
			} catch (SQLException e) {
				setErreur("sql_error", e.getMessage());
			}
        }
		
		return indication;
	}
	
	public Indication find(String id) {
		
		Indication indication = new Indication();
		
		try {
			indication = indicationDAO.find(Integer.parseInt(id));
		}catch(SQLException e){
			setErreur("sql_error", e.getMessage());
		}
		
		return indication;
	}
	
	public Indication update(String id, String temp, String humidite, String weather, String count, String userId, String predictionId) {
		
		Indication indication = new Indication();
		
		try {
			indication = indicationDAO.find(Integer.parseInt(id));
		}catch(SQLException e){
			setErreur("sql_error", e.getMessage());
		}
		
		try {
			indication.setTemp(Double.parseDouble(temp));
		}catch(NumberFormatException e){
			setErreur("temp_error", e.getMessage());
		}
		
		try {
			indication.setHumidite(Double.parseDouble(humidite));
		}catch(NumberFormatException e){
			setErreur("humidité_error", e.getMessage());
		}
		
		try {
			indication.setCount(Integer.parseInt(count));
		}catch(NumberFormatException e){
			setErreur("count_error", e.getMessage());
		}
		
		try {
			User user = userDAO.find(Integer.parseInt(userId));
			indication.setUser(user);
		}catch(NumberFormatException e){
			setErreur("userId_error", e.getMessage());
		}catch(SQLException e){
			setErreur("user_error", e.getMessage());
		}
		
		try {
			Prediction prediction = predictionDAO.find(Integer.parseInt(predictionId));
			indication.setPrediction(prediction);
		}catch(NumberFormatException e){
			setErreur("predictionId_error", e.getMessage());
		}catch (SQLException e) {
			setErreur("prediction_error", e.getMessage());
		}
		
		if (getErreurs().isEmpty()) {
			try {
				indicationDAO.update(indication);
			} catch (SQLException e) {
				setErreur("sql_error", e.getMessage());
			}
		}
	
		return indication;
		
	}
	
	public void delete(String id) {
		Indication indication = new Indication();
		
		try {
			indication = indicationDAO.find(Integer.parseInt(id));
		}catch(NumberFormatException e){
			setErreur("indicationId_error", e.getMessage());
		}catch(SQLException e){
			setErreur("indication_error", e.getMessage());
		}
		
		if (getErreurs().isEmpty()) {
			try {
				indicationDAO.delete(indication);
			} catch (SQLException e) {
				setErreur("sql_error", e.getMessage());
			}
		}
		
	}

}
