package fr.dauphine.lamsade.hib.predictions.objects;

public class Confirmation {
  private int confirmation_id;
  private boolean Confirmation_flag;
  private User user;
  private Indication indication;
public int getConfirmation_id() {
	return confirmation_id;
}
public void setConfirmation_id(int confirmation_id) {
	this.confirmation_id = confirmation_id;
}
public boolean isConfirmation_flag() {
	return Confirmation_flag;
}
public void setConfirmation_flag(boolean confirmation_flag) {
	Confirmation_flag = confirmation_flag;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Indication getIndication() {
	return indication;
}
public void setIndication(Indication indication) {
	this.indication = indication;
}  
}
