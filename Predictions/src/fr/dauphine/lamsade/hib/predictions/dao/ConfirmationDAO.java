package fr.dauphine.lamsade.hib.predictions.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.dauphine.lamsade.hib.predictions.connection.DBConnection;
import fr.dauphine.lamsade.hib.predictions.objects.Confirmation;

public class ConfirmationDAO {

	public void inser(Confirmation con)throws Exception{
		 String sql ="INSERT INTO Confirmation(Confirmation_flag,user_id,indication_id) VALUES(?,?,?)";
		 PreparedStatement pstmt = null;
		 DBConnection dbc =null;
		 try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setBoolean(1, con.isConfirmation_flag());
			pstmt.setInt(2,con.getUser().g;);
			pstmt.executeUpdate();
			pstmt.close();				
		} catch (Exception e) {
			throw new Exception("ERROR! ");
		}finally{
		    dbc.close();
		}
	}
	 public void delete(int Confirmation_id) throws Exception {  
		 String sql = "DELETE FROM Confirmation WHERE Confirmation_id=?" ;  
		 PreparedStatement pstmt = null;
 		 DBConnection dbc =null;  
        try{  
        	dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);       
            pstmt.setInt(1,Confirmation_id) ;  
            pstmt.executeUpdate() ;  
            pstmt.close() ;  
        }catch (Exception e){  
            throw new Exception("ERROR!") ;  
        }  
        finally{  
            dbc.close() ;  
	 }
	    }  
	 public void update(Confirmation confirmation) throws Exception {  
	        String sql = "UPDATE Confirmation SET Confirmation_flag=? WHERE Confirmation_id=?" ;  
	        PreparedStatement pstmt = null ;  
	        DBConnection dbc = null ;  
	     
	        try{   
	            dbc = DBConnection.getInstance();  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;           
	            pstmt.setBoolean(1, confirmation.isConfirmation_flag());  
	            pstmt.setInt(2, confirmation.getConfirmation_id());  
	            pstmt.executeUpdate() ;  
	            pstmt.close() ;  
	        }  
	        catch (Exception e){  
	            throw new Exception("ERROR!") ;  
	        }  
	        finally{   
	            dbc.close() ;  
	        }  
	    }  
	 public Confirmation queryById(int Confirmation_id) throws Exception {  
	        Confirmation con = null ;  
	        String sql = "SELECT * FROM user WHERE Confirmation_id=?" ;  
	        PreparedStatement pstmt = null ;  
	        DBConnection dbc = null ;  
	        try{  
	            dbc = DBConnection.getInstance() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;           
	            pstmt.setInt(1, Confirmation_id);  
	            ResultSet rs = pstmt.executeQuery() ;  
	            if(rs.next())  
	            {  
	                con = new Confirmation() ;  
	                con.setConfirmation_id(rs.getInt(1));  
	                con.setConfirmation_flag(rs.getBoolean(2));  
	            }  
	            rs.close() ;  
	            pstmt.close() ;  
	        }catch (Exception e){  
	            throw new Exception("ERROR!") ;  
	        }  
	        finally{   
	            dbc.close() ;  
	        }  
	        return con ;  
	    }  
	    public List<Confirmation> queryAll() throws Exception {  
	        List<Confirmation> all = new ArrayList<Confirmation>() ;  
	        String sql = "SELECT * FROM Confirmation " ;  
	        PreparedStatement pstmt = null ;  
	        DBConnection dbc = null ;   
	        try{  
	            dbc = DBConnection.getInstance() ;  
	            pstmt = dbc.getConnection().prepareStatement(sql) ;   
	            ResultSet rs = pstmt.executeQuery() ;  
	            while(rs.next()){  
	                Confirmation con = new Confirmation() ;  
	                con.setConfirmation_id(rs.getInt(1));  
	                con.setConfirmation_flag(rs.getBoolean(2));  
	                all.add(con) ;  
	            }  
	            rs.close() ;  
	            pstmt.close() ;  
	        }  
	        catch (Exception e){  
	            throw new Exception("ERROR!") ;  
	        }  
	        finally{  
	            dbc.close() ;  
	        }  
	        return all ;  
	    }  
	}  

		

