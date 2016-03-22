package fr.dauphine.lamsade.hib.predictions.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.lamsade.hib.predictions.dao.WebSiteDAO;
import fr.dauphine.lamsade.hib.predictions.objects.WebSite;

/**
 * Servlet implementation class WebSiteServ
 */
@WebServlet("/WebSiteServ")
public class WebSiteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(WebSiteServ.class.getCanonicalName());

	public WebSiteServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("Insertion WebSite");
		WebSite webSite = new WebSite();
		WebSiteDAO webSiteDAO = new WebSiteDAO();
		webSite.setWebsite_Name("METEO FRANCE");
		webSite.setWebsite_URL("http://www.meteofrance.com/");
		try {
			webSiteDAO.insert(webSite);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("Update WebSite");
		webSite.setWebsite_Name("METEO FR");
		try {
			webSiteDAO.update(webSite);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("Delete WebSite");
		try {
			webSiteDAO.delete(webSite);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
