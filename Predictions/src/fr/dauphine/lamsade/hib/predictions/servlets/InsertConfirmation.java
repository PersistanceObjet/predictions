package fr.dauphine.lamsade.hib.predictions.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.lamsade.hib.predictions.dao.ConfirmationDAO;
import fr.dauphine.lamsade.hib.predictions.objects.Confirmation;

/**
 * Servlet implementation class InsertConfirmation
 */
@WebServlet("/InsertConfirmation")
public class InsertConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");  
        out.println("<HTML>");  
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");  
        out.println("  <BODY>");  
        out.print("    This is ");  
        out.print(this.getClass());  
        out.println(", using the GET method");  
        out.println("  </BODY>");  
        out.println("</HTML>");  
        out.flush();  
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");    
	        try {  
	            String con_id= request.getParameter("confirmed_id");
	            String isConfirmed = request.getParameter("confirmation_flag");
	            int confirmation_id = Integer.parseInt(con_id);
	            ConfirmationDAO conDao = new ConfirmationDAO();	            
	            Confirmation con = new Confirmation();
	            con.setConfirmation_id(confirmation_id);
	            conDao.insert(con);       
	            response.sendRedirect("http://localhost:8080/Prediction/InsertConfirmation.jsp");    
	              
	        } catch(Exception e) {  
	            System.out.println("ERROR!"+e.getMessage());    
	            response.sendRedirect("http://localhost:8080/Prediction/InsertConfirmation.jsp");    
	        }  
	          
	}

}
