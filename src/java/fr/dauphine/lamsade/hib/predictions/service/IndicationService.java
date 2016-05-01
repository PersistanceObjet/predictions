/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.service;

import fr.dauphine.lamsade.hib.predictions.dao.IndicationDAO;
import fr.dauphine.lamsade.hib.predictions.dao.PredictionDAO;
import fr.dauphine.lamsade.hib.predictions.dao.UserDAO;
import fr.dauphine.lamsade.hib.predictions.entity.Indication;
import fr.dauphine.lamsade.hib.predictions.entity.Prediction;
import fr.dauphine.lamsade.hib.predictions.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Shitai
 */
@Stateless
public class IndicationService extends Service {

    @EJB
    private UserDAO userDAO;
    private IndicationDAO indicationDAO;
    private PredictionDAO predictionDAO;
    
    public Indication createIndication(String indicationTemp, String indicationHum, String indicationWeather, String predictionId, String userId) {
        Indication indication = new Indication();
        
        try {
            indication.setIndicationTemp(Double.parseDouble(indicationTemp));
        } catch ( Exception e ) {
            setError( "tempError", e.getMessage() );
        }
        
        try {
            indication.setIndicationHum(Double.parseDouble(indicationHum));
        } catch ( Exception e ) { //normalement, il ne faut pas capter une exception générale, il faut traiter les exception en fonction de leur type
            setError( "humError", e.getMessage() );
        }
        
        try {
            validateInput(indicationWeather);
        } catch ( Exception e ) {
            setError( "weatherError", e.getMessage() );
        }
        indication.setIndicationWeather(indicationWeather);
        
        try {
            Prediction prediction = predictionDAO.find(Integer.parseInt(predictionId));
            indication.setPredictionId(prediction);
        } catch ( Exception e ) {
            setError( "categoryError", e.getMessage() );
        }
        
        try {
            User user = userDAO.find(Integer.parseInt(userId));
            indication.setUserId(user);
        } catch ( Exception e ) {
            setError( "categoryError", e.getMessage() );
        }
        
        if(errors.isEmpty()) {
            try {
                indicationDAO.create(indication);
            } catch (Exception ex) {
                Logger.getLogger(IndicationService.class.getName()).log(Level.SEVERE, null, ex);
                message = "Échec de la création de l'indication.";
            }
            message = "Succès de la création de l'indication.";
        }else {
            message = "Échec de la création de l'indication.";
        }
                
        return indication;
    }
    
    public void removeIndication(String indicationId) {
        try {
            Indication indication = indicationDAO.find(Integer.parseInt(indicationId));
            indicationDAO.remove(indication);
        } catch ( Exception e ) {
            setError( "indicationError", e.getMessage() );
        } 
        
        
    }
    
    public Indication editIndication(String indicationId, String indicationTemp, String indicationHum, String indicationWeather, String predictionId) {
        Indication indication = new Indication();
        
        try {
            indication = indicationDAO.find(Integer.parseInt(indicationId));
        } catch ( Exception e ) {
            setError( "indicationError", e.getMessage() );
        }
        
        try {
            indication.setIndicationTemp(Double.parseDouble(indicationTemp));
        } catch ( Exception e ) {
            setError( "tempError", e.getMessage() );
        }
        
        try {
            indication.setIndicationHum(Double.parseDouble(indicationHum));
        } catch ( Exception e ) {
            setError( "humError", e.getMessage() );
        }
        
        try {
            validateInput(indicationWeather);
        } catch ( Exception e ) {
            setError( "weatherError", e.getMessage() );
        }
        indication.setIndicationWeather(indicationWeather);
        
        try {
            Prediction prediction = predictionDAO.find(Integer.parseInt(predictionId));
            indication.setPredictionId(prediction);
        } catch ( Exception e ) {
            setError( "categoryError", e.getMessage() );
        }
       
        if(errors.isEmpty()) {
            try {
                indicationDAO.create(indication);
            } catch (Exception ex) {
                Logger.getLogger(IndicationService.class.getName()).log(Level.SEVERE, null, ex);
                message = "Échec de la modification de l'indication.";
            }
            message = "Succès de la modification de l'indication.";
        }else {
            message = "Échec de la modification de l'indication.";
        }
                
        return indication;        
    }
     
    public List<Indication> findAllIndications() {
        List<Indication> indications = new ArrayList<>();
        
        try {
            indications = indicationDAO.findAll();
        } catch ( Exception e ) {
            setError( "indicationError", e.getMessage() );
        }
        
        if(errors.isEmpty()) {          
            message = "Succès du retrait de l'indication.";
        }else {
            message = "Échec du retrait de l'indication.";
        }
        
        return indications;
    }
    
    public Indication find(String indicationId) {
        Indication indication = null;
        
        try {
            indication = indicationDAO.find(Integer.parseInt(indicationId));
        } catch ( Exception e ) {
            setError( "indicationError", e.getMessage() );
        }
        
        return indication;
    }
}