package fr.dauphine.lamsade.hib.predictions.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.lamsade.hib.predictions.dao.ConfirmationDAO;
import fr.dauphine.lamsade.hib.predictions.objects.Confirmation;

/**
 * Servlet implementation class UpdateConfirmation
 */
@WebServlet("/UpdateConfirmation")
public class UpdateConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");    
	        try {  
	            String con_id= request.getParameter("confirmed_id");
	            String isConfirmed = request.getParameter("confirmation_flag");
	            int confirmation_id = Integer.parseInt(con_id);
	            ConfirmationDAO conDao = new ConfirmationDAO();	            
	            Confirmation con = new Confirmation();
	            con.setConfirmation_id(confirmation_id);
	            conDao.update(con);       
	            response.sendRedirect("http://localhost:8080/Prediction/InsertConfirmation.jsp");    
	              
	        } catch(Exception e) {  
	            System.out.println("ERROR!"+e.getMessage());    
	            response.sendRedirect("http://localhost:8080/Prediction/InsertConfirmation.jsp");    
	        }  
	          
	}
}
