import java.util.Calendar;
import java.util.GregorianCalendar;

import fr.dauphine.lamsade.hib.predictions.objects.*;
public class TestUser {


	private static User me = new User();

	public static void main(String[] args) {
	
		Calendar cal = GregorianCalendar.getInstance();
		me.setId(1);
		me.setFirst_Name("ayman");
		me.setLast_Name("Nacer");
		me.setUser_Login("MEayNA");
		me.setUser_Pass("12345");
		me.setUser_Sincerity((float) 99.99);
		
// Message d'acceuil
		System.out.println("Welcome Mr. " + me.getLast_Name().toUpperCase() + " to Weather Prediction");
		System.out.println("Your session begins from " + cal.getTime() + " and your sincerity is evaluated as " + me.getUser_Sincerity() + "%");

}
}
