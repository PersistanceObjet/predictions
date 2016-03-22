package fr.dauphine.lamsade.hib.predictions.dao;

import java.sql.PreparedStatement;

import fr.dauphine.lamsade.hib.predictions.connection.DBConnection;
import fr.dauphine.lamsade.hib.predictions.objects.User;

public class UserDAO {

	public void createUser(String firstName, String lastName, String login, String pass) {

		User user = new User();
		user.setFirst_Name(firstName);
		user.setLast_Name(lastName);
		user.setUser_Login(login);
		user.setUser_Pass(pass);
		user.setUser_Sincerity(0);
		// stmt = connection.getInstance().createStatement();
		String query = "INSERT INTO USER(First_Name,Last_Name,UserLogin,User_Password,UserSincerity) values("
				+ user.getFirst_Name() + "," + user.getLast_Name() + "," + user.getUser_Login() + ","
				+ user.getUser_Pass() + "," + user.getUser_Sincerity() + ")";

		//PreparedStatement stmt = conn.prepareStatement(query);
		//boolean isResultSet = stmt.execute();
		//assert(!isResultSet);
		//assert(stmt.getUpdateCount() == 1);
	}
	
	public User find(int id) {
		return null;
	}

}
