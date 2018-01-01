package co.simplon.loto.model;

import java.util.Date;

// Interface Ticket
public interface Ticket {

	public String getNom();
	public void setNom(String nom);
	
	public String getPrenom();
	public void setPrenom(String prenom);
	
	public String getTicketId();
	public void setTicketId(String ticketId);
	
	public Date getDateEnregistrement();
	public void setDateEnregistrement(Date date);
}
