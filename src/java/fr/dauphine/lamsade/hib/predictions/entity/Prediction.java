/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mehdi
 */
@Entity
@Table(name = "prediction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prediction.findAll", query = "SELECT p FROM Prediction p"),
    @NamedQuery(name = "Prediction.findByPredictionId", query = "SELECT p FROM Prediction p WHERE p.predictionId = :predictionId"),
    @NamedQuery(name = "Prediction.findByTemperature", query = "SELECT p FROM Prediction p WHERE p.temperature = :temperature"),
    @NamedQuery(name = "Prediction.findByHumidity", query = "SELECT p FROM Prediction p WHERE p.humidity = :humidity"),
    @NamedQuery(name = "Prediction.findByWeather", query = "SELECT p FROM Prediction p WHERE p.weather = :weather"),
    @NamedQuery(name = "Prediction.findByPredictionDate", query = "SELECT p FROM Prediction p WHERE p.predictionDate = :predictionDate"),
    @NamedQuery(name = "Prediction.findByRegion", query = "SELECT p FROM Prediction p WHERE p.region = :region"),
    @NamedQuery(name = "Prediction.findByCountry", query = "SELECT p FROM Prediction p WHERE p.country = :country"),
    @NamedQuery(name = "Prediction.findByCity", query = "SELECT p FROM Prediction p WHERE p.city = :city")})
public class Prediction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prediction_id")
    private Integer predictionId;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperature")
    private Double temperature;
    
    @Column(name = "humidity")
    private Double humidity;
    
    @Size(max = 255)
    @Column(name = "weather")
    private String weather;
    
    @Column(name = "prediction_date")
    @Temporal(TemporalType.DATE)
    private Date predictionDate;
    
    @Size(max = 255)
    @Column(name = "region")
    private String region;
    
    @Size(max = 255)
    @Column(name = "country")
    private String country;
    
    @Size(max = 255)
    @Column(name = "city")
    private String city;
    
    @JoinColumn(name = "website_id", referencedColumnName = "website_id")
    @ManyToOne(optional = false)
    private Website websiteId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predictionId")
    private Collection<Indication> indicationCollection;

    public Prediction() {
    }

    public Prediction(Integer predictionId) {
        this.predictionId = predictionId;
    }

    public Integer getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(Integer predictionId) {
        this.predictionId = predictionId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Date getPredictionDate() {
        return predictionDate;
    }

    public void setPredictionDate(Date predictionDate) {
        this.predictionDate = predictionDate;
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

    public Website getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Website websiteId) {
        this.websiteId = websiteId;
    }

    @XmlTransient
    public Collection<Indication> getIndicationCollection() {
        return indicationCollection;
    }

    public void setIndicationCollection(Collection<Indication> indicationCollection) {
        this.indicationCollection = indicationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predictionId != null ? predictionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prediction)) {
            return false;
        }
        Prediction other = (Prediction) object;
        if ((this.predictionId == null && other.predictionId != null) || (this.predictionId != null && !this.predictionId.equals(other.predictionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.dauphine.lamsade.hib.predictions.entity.Prediction[ predictionId=" + predictionId + " ]";
    }
    
}
