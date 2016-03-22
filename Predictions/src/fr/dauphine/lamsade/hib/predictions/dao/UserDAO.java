package fr.dauphine.lamsade.hib.predictions.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.dauphine.lamsade.hib.predictions.connection.DBConnection;
import fr.dauphine.lamsade.hib.predictions.objects.Indication;
import fr.dauphine.lamsade.hib.predictions.objects.User;

public class UserDAO {

	DBConnection dbc = null;
	
	public void create(User user) throws SQLException{
		String sql = "INSERT INTO user(First_Name,Last_Name,UserLogin,User_Password,UserSincerity)values(?,?,?,?,?)" ;  
        
        
		try{  
            dbc = DBConnection.getInstance();
            
            PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql) ;  
            
            pstmt.setString(1, user.getFirst_Name());
            pstmt.setString(2, user.getLast_Name());
            pstmt.setString(3, user.getUser_Login());
            pstmt.setString(4, user.getUser_Pass());
            pstmt.setFloat(5, user.getUser_Sincerity());
            
            pstmt.executeUpdate() ;  
            pstmt.close() ;  
        }catch (SQLException e){
        	System.out.println("User Creation Failed : " + e.getMessage());
        }  
        finally{  
            
            dbc.getConnection().close(); 
        }  
	}
	
	
	public User find(int id) throws SQLException {
		User user = new User();
		
		String sql = "SELECT * FROM user WHERE User_id=?" ;  
        
        try{  
            dbc = DBConnection.getInstance();
            
            PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql) ;  
            
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery() ;  
            
            if(rs.next())  
            {  
                user.setId(rs.getInt(1));
                user.setFirst_Name(rs.getString(2));
                user.setLast_Name(rs.getString(3));
                user.setUser_Login(rs.getString(4));
                user.setUser_Pass(rs.getString(5));
                user.setUser_Sincerity(rs.getFloat(6));
            }  
            
            rs.close() ;  
            pstmt.close() ;  
        }catch (SQLException e){
        	System.out.println("User Search Failed : " + e.getMessage());
        }  
        finally{            
            dbc.getConnection().close(); ;  
        }  
		
		return user;
	}
	
	 public void update(User user) throws SQLException {
	    	String sql = "UPDATE user SET First_Name=?, Last_Name=?, UserLogin=?, User_Password=?, UserSincerity=? WHERE User_id=? "; 
	    	
	    	try{ 
	    		dbc = DBConnection.getInstance();
	            PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
	            
	            pstmt.setString(1, user.getFirst_Name());
	            pstmt.setString(2, user.getLast_Name());
	            pstmt.setString(3, user.getUser_Login());
	            pstmt.setString(4, user.getUser_Pass());
	            pstmt.setFloat(5, user.getUser_Sincerity());
	            
	            pstmt.setInt(6, user.getId());
	            
	            pstmt.executeUpdate() ;  
	            pstmt.close() ;  
	        }  
	        catch (Exception e){  
	        	System.out.println("User Update Failed : " + e.getMessage());
	        }  
	        finally{  
	        	dbc.getConnection().close();
	        }  
	    }
		
	    public void delete(User user) throws SQLException {
	    	String sql = "DELETE FROM user WHERE User_id=?";  
	    	
	        try{  
	        	dbc = DBConnection.getInstance();
	            PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
	            
	            pstmt.setInt(1,user.getId()) ;  
	            
	            pstmt.executeUpdate() ;  
	            pstmt.close() ;  
	        }catch (Exception e){  
	        	System.out.println("User Update Failed : " + e.getMessage());
	        }  
	        finally{  
	        	dbc.getConnection().close();
	        }  
	    	
	    }
	
	
}
