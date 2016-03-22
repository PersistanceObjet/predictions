package fr.dauphine.lamsade.hib.predictions.objects;

import java.util.Date;

public class Prediction {

	private int id;
	private float temperature;
	private float humidity;
	private String Weather;
	private Date prediction_date;
	private String region;
	private String country;
	private String city;
	private WebSite website;

	public Prediction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPrediction_id() {
		return id;
	}

	public void setPrediction_id(int prediction_id) {
		this.id = prediction_id;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public String getWeather() {
		return Weather;
	}

	public void setWeather(String weather) {
		Weather = weather;
	}

	public java.sql.Date getPrediction_date() {
		return (java.sql.Date) prediction_date;
	}

	public void setPrediction_date(Date prediction_date) {
		this.prediction_date = prediction_date;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public WebSite getWebsite() {
		return website;
	}

	public void setWebsite(WebSite website) {
		this.website = website;
	}

}
