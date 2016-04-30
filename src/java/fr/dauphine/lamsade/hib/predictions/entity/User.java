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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ayman
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByUserLogin", query = "SELECT u FROM User u WHERE u.userLogin = :userLogin")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
       
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;
    
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;
    
    @Size(max = 255)
    @Column(name = "user_login")
    private String userLogin;
    
    @Size(max = 255)
    @Column(name = "user_password")
    private String userPassword;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "user_sincerity")
    private Double userSincerity = 0.0;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Confirmation> confirmationCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Indication> indicationCollection;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Double getUserSincerity() {
        return userSincerity;
    }

    public void setUserSincerity(Double userSincerity) {
        this.userSincerity = userSincerity;
    }

    @XmlTransient
    public Collection<Confirmation> getConfirmationCollection() {
        return confirmationCollection;
    }

    public void setConfirmationCollection(Collection<Confirmation> confirmationCollection) {
        this.confirmationCollection = confirmationCollection;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.dauphine.lamsade.hib.predictions.entity.User[ userId=" + userId + " ]";
    }
    
}
