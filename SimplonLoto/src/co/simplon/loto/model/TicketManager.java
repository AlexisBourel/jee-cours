package co.simplon.loto.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Gestionnaire de tickets
public class TicketManager {

	private final static TicketManager INSTANCE = new TicketManager();
	private final Map<String, Ticket> tickets = new HashMap<String, Ticket>();
	
	private TicketManager(){
	}
	
	public static TicketManager getInstance() {
		return INSTANCE;
	}
	
	public Map<String, Ticket> getTickets(){
		return tickets;
	}
	
	public void addTicket(Ticket ticket) throws Exception{
		if(tickets.containsKey(ticket.getTicketId()))
			throw new Exception("Ce billet a déjà été enregistré !");
		
		ticket.setDateEnregistrement(new Date());
		tickets.put(ticket.getTicketId(), ticket);
	}
	
}
