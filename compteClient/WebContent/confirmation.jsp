<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="compteClient.beans.Client" %>
<!DOCTYPE html />
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Inscription validée</title>
	</head>
	
	<body>
		<% Client client = (Client) request.getAttribute("client"); %>
		<h1>Merci ${client.prenom} pour votre inscription</h1>
		
		<p>Cliquez sur le bouton ce dessous afin d'accéder a votre compte</p>
		<form method="post" action="index.html">
			<input type="submit" value="Validez l'inscription"/>
		</form>
	</body>
</html>