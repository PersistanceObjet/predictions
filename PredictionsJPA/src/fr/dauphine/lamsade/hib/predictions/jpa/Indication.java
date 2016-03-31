package fr.dauphine.lamsade.hib.predictions.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the indication database table.
 * 
 */
/**
 * @author Shitai
 *
 */
@Entity
@NamedQuery(name="Indication.findAll", query="SELECT i FROM Indication i")
public class Indication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="indication_id")
	private Integer indicationId;

	@Column(name="indication_count")
	private Integer indicationCount;

	@Column(name="indication_hum")
	private double indicationHum;

	@Column(name="indication_temp")
	private double indicationTemp;

	@Column(name="indication_weather")
	private String indicationWeather;

	//bi-directional many-to-one association to Confirmation
	@OneToMany(mappedBy="indication")
	private List<Confirmation> confirmations;

	//bi-directional many-to-one association to Prediction
	@ManyToOne
	@JoinColumn(name="prediction_id")
	private Prediction prediction;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Indication() {
	}

	public Integer getIndicationId() {
		return this.indicationId;
	}

	public void setIndicationId(Integer indicationId) {
		this.indicationId = indicationId;
	}

	public Integer getIndicationCount() {
		return this.indicationCount;
	}

	public void setIndicationCount(Integer indicationCount) {
		this.indicationCount = indicationCount;
	}

	public double getIndicationHum() {
		return this.indicationHum;
	}

	public void setIndicationHum(double indicationHum) {
		this.indicationHum = indicationHum;
	}

	public double getIndicationTemp() {
		return this.indicationTemp;
	}

	public void setIndicationTemp(double indicationTemp) {
		this.indicationTemp = indicationTemp;
	}

	public String getIndicationWeather() {
		return this.indicationWeather;
	}

	public void setIndicationWeather(String indicationWeather) {
		this.indicationWeather = indicationWeather;
	}

	public List<Confirmation> getConfirmations() {
		return this.confirmations;
	}

	public void setConfirmations(List<Confirmation> confirmations) {
		this.confirmations = confirmations;
	}

	public Confirmation addConfirmation(Confirmation confirmation) {
		getConfirmations().add(confirmation);
		confirmation.setIndication(this);

		return confirmation;
	}

	public Confirmation removeConfirmation(Confirmation confirmation) {
		getConfirmations().remove(confirmation);
		confirmation.setIndication(null);

		return confirmation;
	}

	public Prediction getPrediction() {
		return this.prediction;
	}

	public void setPrediction(Prediction prediction) {
		this.prediction = prediction;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}