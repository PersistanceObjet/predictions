/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.lamsade.hib.predictions.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shan
 */
@Entity
@Table(name = "confirmation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Confirmation.findAll", query = "SELECT c FROM Confirmation c"),
    @NamedQuery(name = "Confirmation.findByConfirmationId", query = "SELECT c FROM Confirmation c WHERE c.confirmationId = :confirmationId"),
    @NamedQuery(name = "Confirmation.findByConfirmationFlag", query = "SELECT c FROM Confirmation c WHERE c.confirmationFlag = :confirmationFlag")})
public class Confirmation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "confirmation_id")
    private Integer confirmationId;
    
    @Column(name = "confirmation_flag")
    private boolean confirmationFlag;
    
    @JoinColumn(name = "indication_id", referencedColumnName = "indication_id")
    @ManyToOne(optional = false)   
    private Indication indicationId;
    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id") 
    @ManyToOne(optional = false)
    private User userId;

    public Confirmation() {
    }

    public Confirmation(Integer confirmationId) {
        this.confirmationId = confirmationId;
    }

    public Confirmation(Integer confirmationId, boolean confirmationFlag) {
        this.confirmationId = confirmationId;
        this.confirmationFlag = confirmationFlag;
    }

    public Integer getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(Integer confirmationId) {
        this.confirmationId = confirmationId;
    }

    public boolean getConfirmationFlag() {
        return confirmationFlag;
    }

    public void setConfirmationFlag(boolean confirmationFlag) {
        this.confirmationFlag = confirmationFlag;
    }

    public Indication getIndicationId() {
        return indicationId;
    }

    public void setIndicationId(Indication indicationId) {
        this.indicationId = indicationId;
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
        hash += (confirmationId != null ? confirmationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Confirmation)) {
            return false;
        }
        Confirmation other = (Confirmation) object;
        if ((this.confirmationId == null && other.confirmationId != null) || (this.confirmationId != null && !this.confirmationId.equals(other.confirmationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.dauphine.lamsade.hib.predictions.entity.Confirmation[ confirmationId=" + confirmationId + " ]";
    }
    
}
