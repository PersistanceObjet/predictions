package fr.dauphine.lamsade.hib.predictions.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="user_login")
	private String userLogin;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_sincerity")
	private double userSincerity;

	//bi-directional many-to-one association to Confirmation
	@OneToMany(mappedBy="user")
	private List<Confirmation> confirmations;

	//bi-directional many-to-one association to Indication
	@OneToMany(mappedBy="user")
	private List<Indication> indications;

	public User() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public double getUserSincerity() {
		return this.userSincerity;
	}

	public void setUserSincerity(double userSincerity) {
		this.userSincerity = userSincerity;
	}

	public List<Confirmation> getConfirmations() {
		return this.confirmations;
	}

	public void setConfirmations(List<Confirmation> confirmations) {
		this.confirmations = confirmations;
	}

	public Confirmation addConfirmation(Confirmation confirmation) {
		getConfirmations().add(confirmation);
		confirmation.setUser(this);

		return confirmation;
	}

	public Confirmation removeConfirmation(Confirmation confirmation) {
		getConfirmations().remove(confirmation);
		confirmation.setUser(null);

		return confirmation;
	}

	public List<Indication> getIndications() {
		return this.indications;
	}

	public void setIndications(List<Indication> indications) {
		this.indications = indications;
	}

	public Indication addIndication(Indication indication) {
		getIndications().add(indication);
		indication.setUser(this);

		return indication;
	}

	public Indication removeIndication(Indication indication) {
		getIndications().remove(indication);
		indication.setUser(null);

		return indication;
	}

}