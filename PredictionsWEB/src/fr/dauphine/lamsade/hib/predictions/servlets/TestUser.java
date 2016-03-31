package fr.dauphine.lamsade.hib.predictions.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.lamsade.hib.predictions.ejb.UserBeanLocal;
import fr.dauphine.lamsade.hib.predictions.jpa.User;

import javax.ejb.*;

/**
 * Servlet implementation class TestUser
 */
@WebServlet("/TestUser")
public class TestUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB 
	private UserBeanLocal userBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(userBean.getAllUser().get(0).getFirstName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
