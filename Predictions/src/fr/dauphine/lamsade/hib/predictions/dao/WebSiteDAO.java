package fr.dauphine.lamsade.hib.predictions.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.dauphine.lamsade.hib.predictions.connection.DBConnection;
import fr.dauphine.lamsade.hib.predictions.objects.WebSite;

public class WebSiteDAO {

	private DBConnection dbc = null;
	private PreparedStatement pstmt = null;

	public void insert(WebSite webSite) throws SQLException {
		String sql = "INSERT INTO website(website_name, website_url) VALUES(?,?)";

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, webSite.getWebsite_Name());
			pstmt.setString(2, webSite.getWebsite_URL());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			System.out.println("Erreur lors de l'insertion du site : " + e.getMessage());
		} finally {

			dbc.getConnection().close();
			;
		}

	}

	public void update(WebSite webSite) throws SQLException {
		String sql = "UPDATE webSite SET website_name=?, website_url=? WHERE website_id=?";

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, webSite.getWebsite_Name());
			pstmt.setString(2, webSite.getWebsite_URL());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println("Erreur lors de l'update du site : " + e.getMessage());
		} finally {
			dbc.getConnection().close();
		}
	}

	public void delete(WebSite webSite) throws SQLException {
		String sql = "DELETE FROM website WHERE website_id=?";

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setLong(1, webSite.getId());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println("Erreur lors de la suppression du site  : " + e.getMessage());
		} finally {
			dbc.getConnection().close();
		}

	}

	public WebSite find(Long id) throws SQLException {

		WebSite webSite = new WebSite();
		String sql = "SELECT * FROM website WHERE website_id=?";

		try {
			dbc = DBConnection.getInstance();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				webSite.setId(rs.getLong(1));
				webSite.setWebsite_Name(rs.getString(2));
				webSite.setWebsite_URL(rs.getString(3));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Erreur lors de la recherche du site : " + e.getMessage());
		} finally {
			dbc.getConnection().close();
		}

		return webSite;
	}

}
