/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "website")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Website.findAll", query = "SELECT w FROM Website w"),
    @NamedQuery(name = "Website.findByWebsiteId", query = "SELECT w FROM Website w WHERE w.websiteId = :websiteId"),
    @NamedQuery(name = "Website.findByWebsiteName", query = "SELECT w FROM Website w WHERE w.websiteName = :websiteName"),
    @NamedQuery(name = "Website.findByWebsiteUrl", query = "SELECT w FROM Website w WHERE w.websiteUrl = :websiteUrl")})
public class Website implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "website_id")
    private Integer websiteId;
    @Size(max = 25)
    @Column(name = "website_name")
    private String websiteName;
    @Size(max = 200)
    @Column(name = "website_url")
    private String websiteUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "websiteId")
    private Collection<Prediction> predictionCollection;

    public Website() {
    }

    public Website(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @XmlTransient
    public Collection<Prediction> getPredictionCollection() {
        return predictionCollection;
    }

    public void setPredictionCollection(Collection<Prediction> predictionCollection) {
        this.predictionCollection = predictionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (websiteId != null ? websiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Website)) {
            return false;
        }
        Website other = (Website) object;
        if ((this.websiteId == null && other.websiteId != null) || (this.websiteId != null && !this.websiteId.equals(other.websiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.dauphine.lamsade.hib.predictions.entity.Website[ websiteId=" + websiteId + " ]";
    }
    
}
