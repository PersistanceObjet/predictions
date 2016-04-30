/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Shitai
 */
@Entity
@Table(name = "indication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indication.findAll", query = "SELECT i FROM Indication i"),
    @NamedQuery(name = "Indication.findByIndicationId", query = "SELECT i FROM Indication i WHERE i.indicationId = :indicationId"),
    @NamedQuery(name = "Indication.findByIndicationTemp", query = "SELECT i FROM Indication i WHERE i.indicationTemp = :indicationTemp"),
    @NamedQuery(name = "Indication.findByIndicationHum", query = "SELECT i FROM Indication i WHERE i.indicationHum = :indicationHum"),
    @NamedQuery(name = "Indication.findByIndicationWeather", query = "SELECT i FROM Indication i WHERE i.indicationWeather = :indicationWeather"),
    @NamedQuery(name = "Indication.findByIndicationCount", query = "SELECT i FROM Indication i WHERE i.indicationCount = :indicationCount")})
public class Indication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "indication_id")
    private Integer indicationId;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "indication_temp")
    private Double indicationTemp;
    
    @Column(name = "indication_hum")
    private Double indicationHum;
    
    @Size(max = 255)
    @Column(name = "indication_weather")
    private String indicationWeather;
    
    @Column(name = "indication_count")
    private Integer indicationCount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicationId")
    private Collection<Confirmation> confirmationCollection;
    
    @JoinColumn(name = "prediction_id", referencedColumnName = "prediction_id")
    @ManyToOne(optional = false)
    private Prediction predictionId;
    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Indication() {
    }

    public Indication(Integer indicationId) {
        this.indicationId = indicationId;
    }

    public Integer getIndicationId() {
        return indicationId;
    }

    public void setIndicationId(Integer indicationId) {
        this.indicationId = indicationId;
    }

    public Double getIndicationTemp() {
        return indicationTemp;
    }

    public void setIndicationTemp(Double indicationTemp) {
        this.indicationTemp = indicationTemp;
    }

    public Double getIndicationHum() {
        return indicationHum;
    }

    public void setIndicationHum(Double indicationHum) {
        this.indicationHum = indicationHum;
    }

    public String getIndicationWeather() {
        return indicationWeather;
    }

    public void setIndicationWeather(String indicationWeather) {
        this.indicationWeather = indicationWeather;
    }

    public Integer getIndicationCount() {
        return indicationCount;
    }

    public void setIndicationCount(Integer indicationCount) {
        this.indicationCount = indicationCount;
    }

    @XmlTransient
    public Collection<Confirmation> getConfirmationCollection() {
        return confirmationCollection;
    }

    public void setConfirmationCollection(Collection<Confirmation> confirmationCollection) {
        this.confirmationCollection = confirmationCollection;
    }

    public Prediction getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(Prediction predictionId) {
        this.predictionId = predictionId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indicationId != null ? indicationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indication)) {
            return false;
        }
        Indication other = (Indication) object;
        if ((this.indicationId == null && other.indicationId != null) || (this.indicationId != null && !this.indicationId.equals(other.indicationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.dauphine.lamsade.hib.predictions.entity.Indication[ indicationId=" + indicationId + " ]";
    }
    
}
