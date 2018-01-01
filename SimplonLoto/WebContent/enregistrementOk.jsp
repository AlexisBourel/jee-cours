<%@page import="co.simplon.loto.model.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>Félicitation</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body style="text-align:center;">
		<% Ticket ticket = (Ticket) request.getAttribute("ticket"); %>
		<h1>Félicitation</h1>
		<p>Votre billet a été enregistré à <%=ticket.getDateEnregistrement()%> avec les informations suivantes :</p>
		<table class="resultTable">
			<tr>
				<td>Identifiant Billet</td>
				<td><%=ticket.getTicketId()%></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><%=ticket.getNom()%></td>
			</tr>
			<tr>
				<td>Prénom</td>
				<td><%=ticket.getPrenom()%></td>
			</tr>
		</table>
		<a href="index.html" >Retour</a>
	</body>
</html>


