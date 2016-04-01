package fr.dauphine.lamsade.hib.predictions.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the prediction database table.
 * 
 */
@Entity
@NamedQuery(name="Prediction.findAll", query="SELECT p FROM Prediction p")
public class Prediction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prediction_id")
	private Integer predictionId;

	private String city;

	private String country;

	private double humidity;

	@Temporal(TemporalType.DATE)
	@Column(name="prediction_date")
	private Date predictionDate;

	private String region;

	private double temperature;

	private String weather;

	//bi-directional many-to-one association to Indication
	@OneToMany(mappedBy="prediction")
	private List<Indication> indications;

	//bi-directional many-to-one association to Website
	@ManyToOne
	@JoinColumn(name="website_id")
	private Website website;

	public Prediction() {
	}

	public Integer getPredictionId() {
		return this.predictionId;
	}

	public void setPredictionId(Integer predictionId) {
		this.predictionId = predictionId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getHumidity() {
		return this.humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public Date getPredictionDate() {
		return this.predictionDate;
	}

	public void setPredictionDate(Date predictionDate) {
		this.predictionDate = predictionDate;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getWeather() {
		return this.weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public List<Indication> getIndications() {
		return this.indications;
	}

	public void setIndications(List<Indication> indications) {
		this.indications = indications;
	}

	public Indication addIndication(Indication indication) {
		getIndications().add(indication);
		indication.setPrediction(this);

		return indication;
	}

	public Indication removeIndication(Indication indication) {
		getIndications().remove(indication);
		indication.setPrediction(null);

		return indication;
	}

	public Website getWebsite() {
		return this.website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

}