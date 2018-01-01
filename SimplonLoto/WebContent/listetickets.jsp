<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.simplon.loto.model.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>Tickets actifs</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body style="text-align:center;">
		<h1>Billets actifs pour le prochain tirage</h1>
		<p>Les billets actuellement enregistrés pour le prochain tirage sont :</p>
			
		<table border=1 class="ticketTable">
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th># Ticket</th>
			<th>Date</th>
		</tr>
		<%
			SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Collection<Ticket> listTickets = (Collection<Ticket>) request.getAttribute("tickets");
			if(listTickets != null){
				Iterator it = listTickets.iterator() ;
			    while (it.hasNext()){
			    	Ticket serveur=(Ticket) it.next() ;
		%>
					<tr>
						<td><%=serveur.getNom()%></td>
						<td><%=serveur.getPrenom()%></td>
						<td><%=serveur.getTicketId()%></td>
						<td><%=dateFormater.format(serveur.getDateEnregistrement())%></td>
					</tr>
		<%      }
			}
		%>
		</table>
		<a href="index.html" >Retour</a>
	</body>
</html>