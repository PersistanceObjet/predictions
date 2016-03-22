package fr.dauphine.lamsade.hib.predictions.objects;

public class Indication {
	
	private int id;
	private float temp;
	private float humidite;
	private String weather;
	private int count;
	private User user;
	private Prediction prediction;
	
	public Indication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getHumidite() {
		return humidite;
	}
	public void setHumidite(float humidite) {
		this.humidite = humidite;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Prediction getPrediction() {
		return prediction;
	}
	public void setPrediction(Prediction prediction) {
		this.prediction = prediction;
	}
	
	

}
