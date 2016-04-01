package fr.dauphine.lamsade.hib.predictions.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the website database table.
 * 
 */
@Entity
@NamedQuery(name="Website.findAll", query="SELECT w FROM Website w")
public class Website implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="website_id")
	private Integer websiteId;

	@Column(name="website_name")
	private String websiteName;

	@Column(name="website_url")
	private String websiteUrl;

	//bi-directional many-to-one association to Prediction
	@OneToMany(mappedBy="website")
	private List<Prediction> predictions;

	public Website() {
	}

	public Integer getWebsiteId() {
		return this.websiteId;
	}

	public void setWebsiteId(Integer websiteId) {
		this.websiteId = websiteId;
	}

	public String getWebsiteName() {
		return this.websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getWebsiteUrl() {
		return this.websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public List<Prediction> getPredictions() {
		return this.predictions;
	}

	public void setPredictions(List<Prediction> predictions) {
		this.predictions = predictions;
	}

	public Prediction addPrediction(Prediction prediction) {
		getPredictions().add(prediction);
		prediction.setWebsite(this);

		return prediction;
	}

	public Prediction removePrediction(Prediction prediction) {
		getPredictions().remove(prediction);
		prediction.setWebsite(null);

		return prediction;
	}

}