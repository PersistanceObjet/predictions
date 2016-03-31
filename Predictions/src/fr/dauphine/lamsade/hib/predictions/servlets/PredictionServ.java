package fr.dauphine.lamsade.hib.predictions.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.lamsade.hib.predictions.dao.PredictionDAO;
import fr.dauphine.lamsade.hib.predictions.dao.WebSiteDAO;
import fr.dauphine.lamsade.hib.predictions.objects.Prediction;
import fr.dauphine.lamsade.hib.predictions.objects.WebSite;

/**
 * Servlet implementation class PredictionServ
 */
@WebServlet("/PredictionServ")
public class PredictionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(WebSiteServ.class.getCanonicalName());

	public PredictionServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOGGER.info("Insertion Prediction");
		WebSite webSite = new WebSite();
		WebSiteDAO webSiteDAO = new WebSiteDAO();
		webSite.setWebsite_Name("METEO FRANCE");
		webSite.setWebsite_URL("http://www.meteofrance.com/");

		Prediction prediction = new Prediction();
		PredictionDAO predictionDAO = new PredictionDAO();
		prediction.setTemperature(33);
		prediction.setHumidity(56);
		prediction.setWeather("Chaud");
		prediction.setRegion("le de france");
		prediction.setCity("Paris");
		prediction.setCountry("France");
		prediction.setWebsite(webSite);
		try {
			predictionDAO.insert(prediction);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("Delete Prediction");
		try {
			predictionDAO.delete(prediction);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
