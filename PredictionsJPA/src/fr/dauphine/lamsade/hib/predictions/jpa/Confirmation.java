package fr.dauphine.lamsade.hib.predictions.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the confirmation database table.
 * 
 */
/**
 * @author Shan
 *
 */
@Entity
@NamedQuery(name="Confirmation.findAll", query="SELECT c FROM Confirmation c")
public class Confirmation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="confirmation_id")
	private Integer confirmationId;

	@Column(name="confirmation_flag")
	private Boolean confirmationFlag;

	//bi-directional many-to-one association to Indication
	@ManyToOne
	@JoinColumn(name="indication_id")
	private Indication indication;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Confirmation() {
	}

	public Integer getConfirmationId() {
		return this.confirmationId;
	}

	public void setConfirmationId(Integer confirmationId) {
		this.confirmationId = confirmationId;
	}

	public Boolean getConfirmationFlag() {
		return this.confirmationFlag;
	}

	public void setConfirmationFlag(Boolean confirmationFlag) {
		this.confirmationFlag = confirmationFlag;
	}

	public Indication getIndication() {
		return this.indication;
	}

	public void setIndication(Indication indication) {
		this.indication = indication;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}