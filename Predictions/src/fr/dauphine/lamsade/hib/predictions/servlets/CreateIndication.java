package fr.dauphine.lamsade.hib.predictions.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.lamsade.hib.predictions.objects.Indication;
import fr.dauphine.lamsade.hib.predictions.service.IndicationService;

/**
 * Servlet implementation class CreateIndication
 */
@WebServlet("/CreateIndication")
public class CreateIndication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IndicationService service;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		this.getServletContext().getRequestDispatcher("/CreateIndication.jsp").forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String temp = service.getValeurChamp(request, "temp");
		String humidite = service.getValeurChamp(request, "humidite");
		String weather = service.getValeurChamp(request, "weather");
		String count = service.getValeurChamp(request,"count");
		String userId = service.getValeurChamp(request, "userId");
		String predictionId = service.getValeurChamp(request, "predictionId");
		
		service.resetErreurs();
		
		Indication indication = service.create(temp, humidite, weather, count, userId, predictionId);
		
		if (service.getErreurs().isEmpty()) {
            response.sendRedirect("/");
        } else {     
        	request.setAttribute("indication", indication);
        	request.setAttribute("erreur", service.getErreurs());
            this.getServletContext().getRequestDispatcher("/CreateIndication.jsp").forward( request, response );
        }
	}

}
