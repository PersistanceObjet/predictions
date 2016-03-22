package fr.dauphine.lamsade.hib.predictions.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.dauphine.lamsade.hib.predictions.connection.DBConnection;
import fr.dauphine.lamsade.hib.predictions.objects.Confirmation;

public class ConfirmationDAO {

	public void insert(Confirmation con) throws Exception {
		String sql = "INSERT INTO Confirmation(Confirmation_flag,Confirmation_id,user_id,indication_id) VALUES(?,?,?,?)";
		PreparedStatement pstmt = null;
		DBConnection dbc = null;
		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setBoolean(1, con.isConfirmation_flag());
			pstmt.setInt(2, con.getConfirmation_id());
			pstmt.setInt(3, con.getUser().getId());
			pstmt.setInt(4, con.getIndication().getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("ERROR! ");
		} finally {
			dbc.getConnection().close();
		}
	}

	public void delete(Confirmation con) throws Exception {
		String sql = "DELETE FROM Confirmation WHERE Confirmation_id=?";
		PreparedStatement pstmt = null;
		DBConnection dbc = null;
		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, con.getConfirmation_id());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("ERROR!");
		} finally {
			dbc.getConnection().close();
		}
	}

	public void update(Confirmation con) throws Exception {
		String sql = "UPDATE Confirmation SET Confirmation_flag=?,user_id,indication_id WHERE Confirmation_id=?";
		PreparedStatement pstmt = null;
		DBConnection dbc = null;

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setBoolean(1, con.isConfirmation_flag());
			pstmt.setInt(2, con.getConfirmation_id());
			pstmt.setInt(3, con.getUser().getId());
	        pstmt.setInt(4, con.getIndication().getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("ERROR!");
		} finally {
			dbc.getConnection().close();
		}
	}

	public Confirmation queryById(int Confirmation_id) throws Exception {
		Confirmation con = null;
		String sql = "SELECT * FROM user WHERE Confirmation_id=?";
		PreparedStatement pstmt = null;
		DBConnection dbc = null;
		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, Confirmation_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				con = new Confirmation();
				con.setConfirmation_id(rs.getInt(1));
				con.setConfirmation_flag(rs.getBoolean(2));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("ERROR!");
		} finally {
			dbc.getConnection().close();
		}
		return con;
	}

	public List<Confirmation> queryAll() throws Exception {
		List<Confirmation> all = new ArrayList<Confirmation>();
		String sql = "SELECT * FROM Confirmation ";
		PreparedStatement pstmt = null;
		DBConnection dbc = null;
		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Confirmation con = new Confirmation();
				con.setConfirmation_id(rs.getInt(1));
				con.setConfirmation_flag(rs.getBoolean(2));
				all.add(con);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("ERROR!");
		} finally {
			dbc.getConnection().close();
		}
		return all;
	}
}
