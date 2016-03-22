package fr.dauphine.lamsade.hib.predictions.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.dauphine.lamsade.hib.predictions.connection.DBConnection;
import fr.dauphine.lamsade.hib.predictions.objects.Prediction;
import fr.dauphine.lamsade.hib.predictions.objects.WebSite;

public class PredictionDAO {

	private WebSiteDAO webSiteDAO = new WebSiteDAO();
	private DBConnection dbc = null;
	private PreparedStatement pstmt = null;

	public void insert(Prediction prediction) throws SQLException {
		String sql = "INSERT INTO prediction(temperature, humidity, weather, prediction_date, region, country, city, webSite_id) VALUES(?,?,?,?,?,?,?,?)";

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setDouble(1, prediction.getTemperature());
			pstmt.setDouble(2, prediction.getHumidity());
			pstmt.setString(3, prediction.getWeather());
			pstmt.setDate(4, prediction.getPrediction_date());
			pstmt.setString(5, prediction.getRegion());
			pstmt.setString(6, prediction.getCountry());
			pstmt.setString(7, prediction.getCity());
			pstmt.setLong(8, prediction.getWebsite().getId());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println("Erreur lors de l'insertion de la prediction :" + e.getMessage());
		} finally {

			dbc.getConnection().close();
			;
		}

	}

	public void update(Prediction prediction) throws SQLException {
		String sql = "UPDATE prediction SET temperature=?, humidity=?, weather=?, prediction_date=?, region=?, country=?, city=?, website_id=? WHERE prediction_id=?";

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setDouble(1, prediction.getTemperature());
			pstmt.setDouble(2, prediction.getHumidity());
			pstmt.setString(3, prediction.getWeather());
			pstmt.setDate(4, prediction.getPrediction_date());
			pstmt.setString(5, prediction.getRegion());
			pstmt.setString(6, prediction.getCountry());
			pstmt.setString(7, prediction.getCity());
			pstmt.setLong(8, prediction.getWebsite().getId());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println("Erreur lors de l'update de la prediction : " + e.getMessage());
		} finally {
			dbc.getConnection().close();
		}
	}

	public void delete(Prediction prediction) throws SQLException {
		String sql = "DELETE FROM prediction WHERE prediction_id=?";

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, prediction.getPrediction_id());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println("Erreur lors de la suppression de la prediction  : " + e.getMessage());
		} finally {
			dbc.getConnection().close();
		}

	}

	public Prediction find(int id) throws SQLException {

		Prediction prediction = new Prediction();
		String sql = "SELECT * FROM prediction WHERE prediction_id=?";

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				prediction.setPrediction_id(rs.getInt(1));
				prediction.setTemperature(rs.getFloat(2));
				prediction.setHumidity(rs.getFloat(3));
				prediction.setWeather(rs.getString(4));
				prediction.setPrediction_date(rs.getDate(5));
				prediction.setRegion(rs.getString(6));
				prediction.setCountry(rs.getString(7));
				prediction.setCity(rs.getString(8));
				WebSite webSite = webSiteDAO.find(rs.getLong(9));
				prediction.setWebsite(webSite);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Erreur lors de la recherche de la prevision : " + e.getMessage());
		} finally {
			dbc.getConnection().close();
		}

		return prediction;
	}

}
