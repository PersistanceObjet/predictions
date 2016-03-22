package fr.dauphine.lamsade.hib.predictions.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.dauphine.lamsade.hib.predictions.connection.DBConnection;
import fr.dauphine.lamsade.hib.predictions.objects.Indication;
import fr.dauphine.lamsade.hib.predictions.objects.Prediction;
import fr.dauphine.lamsade.hib.predictions.objects.User;

public class IndicationDAO{

	private UserDAO userDAO = new UserDAO();
	private PredictionDAO predictionDAO = new PredictionDAO();
	private DBConnection dbc = null;
	private PreparedStatement pstmt = null ; 
	
	public void create(Indication indication) throws SQLException{
		String sql = "INSERT INTO indication(indication_temp, indication_hum, indication_weather, indication_count, user_id, prediction_id) VALUES(?,?,?,?,?,?)" ;  
        
        try{  
            dbc = DBConnection.getInstance();
            
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            
            pstmt.setDouble(1, indication.getTemp());
            pstmt.setDouble(2, indication.getHumidite());
            pstmt.setString(3, indication.getWeather());
            pstmt.setInt(4, indication.getCount());
            pstmt.setInt(5, indication.getUser().getId());
            pstmt.setInt(6, indication.getPrediction().getId());
            
            pstmt.executeUpdate() ;  
            pstmt.close() ;  
        }catch (SQLException e){
        	System.out.println("Indication Creation Failed : " + e.getMessage());
        }  
        finally{  
            
            dbc.getConnection().close(); ;  
        }  
		
	}

	public Indication find(int id) throws SQLException {
		Indication indication = new Indication();
		
		String sql = "SELECT * FROM indication WHERE indication_id=?" ;  
        
        try{  
            dbc = DBConnection.getInstance();
            
            pstmt = dbc.getConnection().prepareStatement(sql) ;  
            
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery() ;  
            
            if(rs.next())  
            {  
                indication.setId(rs.getInt(1));
                indication.setTemp(rs.getDouble(2));
                indication.setHumidite(rs.getDouble(3));
                indication.setWeather(rs.getString(4));
                indication.setCount(rs.getInt(5));
                User user = userDAO.find(rs.getInt(6));
                indication.setUser(user);
                Prediction prediction = predictionDAO.find(rs.getInt(7));
                indication.setPrediction(prediction);
            }  
            
            rs.close() ;  
            pstmt.close() ;  
        }catch (SQLException e){
        	System.out.println("Indication Search Failed : " + e.getMessage());
        }  
        finally{            
            dbc.getConnection().close(); ;  
        }  
		
		return indication;
	}

    public void update(Indication indication) throws SQLException {
    	String sql = "UPDATE indication SET indication_temp=?, indication_hum=?, indication_weather=?, indication_count=?, user_id=?, prediction_id=? WHERE indication_id=?"; 
    	
    	try{ 
    		dbc = DBConnection.getInstance();
            pstmt = dbc.getConnection().prepareStatement(sql);
            
            pstmt.setDouble(1, indication.getTemp());
            pstmt.setDouble(2, indication.getHumidite());
            pstmt.setString(3, indication.getWeather());
            pstmt.setInt(4, indication.getCount());
            pstmt.setInt(5, indication.getUser().getId());
            pstmt.setInt(6, indication.getPrediction().getId());
            pstmt.setInt(7, indication.getId());
            
            pstmt.executeUpdate() ;  
            pstmt.close() ;  
        }  
        catch (Exception e){  
        	System.out.println("Indication Update Failed : " + e.getMessage());
        }  
        finally{  
        	dbc.getConnection().close();
        }  
    }
	
    public void delete(Indication indication) throws SQLException {
    	String sql = "DELETE FROM indication WHERE indication_id=?";  
    	
        try{  
        	dbc = DBConnection.getInstance();
            pstmt = dbc.getConnection().prepareStatement(sql);
            
            pstmt.setInt(1,indication.getId()) ;  
            
            pstmt.executeUpdate() ;  
            pstmt.close() ;  
        }catch (Exception e){  
        	System.out.println("Indication delete Failed : " + e.getMessage());
        }  
        finally{  
        	dbc.getConnection().close();
        }  
    	
    }
}
