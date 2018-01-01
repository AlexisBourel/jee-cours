 package co.simplon.loto.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.loto.model.Ticket;
import co.simplon.loto.model.TicketImpl;
import co.simplon.loto.model.TicketManager;

/**
 * Servlet implementation class TicketServlet
 */
@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketServlet() {
        super();
    }

	/**
	 * La requète GET renvoie la liste de tous les tickets actifs dans la JSP d'affichage
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Récupération des tickets actifs
		request.setAttribute("tickets", TicketManager.getInstance().getTickets().values());
		
		getServletContext().getRequestDispatcher("/listetickets.jsp").forward(request, response);
	}

	/**
	 * La requête POST valide les données envoyé et crée un nouveau ticket qui sera stocké
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupération des informations saisies par l'utilisateur
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String ticketId = request.getParameter("ticketId");
		
		// Vérification des informations saisies
		if((nom == null) || (nom.isEmpty()))
		{
			String message = "Le nom du possesseur du billet n'est pas renseigné !";
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		}
		else if((prenom == null) || (prenom.isEmpty()))
		{
			String message = "Le prenom du possesseur du billet n'est pas renseigné !";
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		}
		else if((ticketId == null) || (ticketId.isEmpty()))
		{
			String message = "Le numéro du billet n'est pas renseigné !";
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		}
		else
		{
			boolean enregistrementOk = true;
			
			// Tout est en règle => Création du nouveau ticket
			Ticket newTicket = new TicketImpl();
			newTicket.setNom(nom);
			newTicket.setPrenom(prenom);
			newTicket.setTicketId(ticketId);
			
			// Ajout du ticket à la liste des tickets déjà entrés
			try {
				TicketManager.getInstance().addTicket(newTicket);
			}
			catch (Exception e) {
				// Gestion des exceptions
				enregistrementOk = false;
				request.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
			}
			
			if(enregistrementOk)
			{
				// L'ajout du ticket s'est bien passé => Affichage de la page de récapitulation
				request.setAttribute("ticket", newTicket);
				getServletContext().getRequestDispatcher("/enregistrementOk.jsp").forward(request, response);
			}	
		}
	}
}
 