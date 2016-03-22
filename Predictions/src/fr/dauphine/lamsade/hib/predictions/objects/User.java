package fr.dauphine.lamsade.hib.predictions.objects;

public class User {
	
	int id;
	String first_Name;
	String last_Name;
	String user_Login;
	String user_Pass;
	float user_Sincerity;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getUser_Login() {
		return user_Login;
	}

	public void setUser_Login(String user_Login) {
		this.user_Login = user_Login;
	}

	public String getUser_Pass() {
		return user_Pass;
	}

	public void setUser_Pass(String user_Pass) {
		this.user_Pass = user_Pass;
	}

	public float getUser_Sincerity() {
		return user_Sincerity;
	}

	public void setUser_Sincerity(float user_Sincerity) {
		this.user_Sincerity = user_Sincerity;
	}

	
}
