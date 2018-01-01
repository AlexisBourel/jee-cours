package co.simplon.loto.model;

import java.util.Date;

// Classe d'implémentation pour les objets Tickets
public class TicketImpl implements Ticket{

	private String nom;
	private String prenom;
	private String ticketId;
	private Date dateEnregistrement;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	
	public Date getDateEnregistrement()
	{
		return dateEnregistrement;
	}
	
	public void setDateEnregistrement(Date date)
	{
		this.dateEnregistrement = date;
	}
}
