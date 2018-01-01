<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html />

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Formulaire d'inscription</title>
	</head>
	
	<body>
		<h1>Formulaire d'inscription</h1>
		
		<div class="form">
			<form method="post" action="Confirmation">
	            <p class="center">Veuillez saisir les champs ci dessous afin de valider votre inscription</p>
			    <div class = "compte">
			    	<H3>Informations du compte</H3>
		            <input type="text" name="utilisateur" id="utilisateur"  required placeholder="utilisateur"/><br></br>
		            <input type="password" name="password" id="password" required placeholder="mot de passe"/><br></br>		                       
		            <input type="password" name="vPassword" id="vPassword" required placeholder="vérifier le mot de passe"/><br></br>
		            <input type="email" name="mail" id="mail"  required placeholder="MAIL"/><br></br>		 
		            <select name="qSecrete" id="qSecrete">
		                <option value="" disabled selected>Question secrète</option>
		                <option value="1">Question1</option>
		                <option value="2">Question2</option>
		                <option value="3">Question3</option>
		                <option value="4">Question4</option>
		                <option value="5">Question5</option>
		                <option value="6">Question6</option>
		                <option value="7">Question7</option>
		                <option value="8">Question8</option>
		            </select>
		            <input type="text" name="rSecrete" id="rSercrete"  required placeholder="Réponse secrète "/><br></br>
		            
	            </div>
	            <div class = "infosPersos">
			    	<H3>Informations personnelles</H3>
		            <input type="text" name="nom" id="nom"  required placeholder="Nom"/><br></br>
		            <input type="text" name="prenom" id="prenom" required placeholder="Prénom"/><br></br>
		            <input type="text" name="adresse" id="adresse" placeholder="adresse"/><br></br>
		            <input type="text" name="cp" id="cp" placeholder="Code Postal"/><br></br>
		            <input type="text" name="ville" id="ville" placeholder="Ville"/><br></br>
	            </div>
	            
	          <input type="submit" value="SUBMIT"/>
	        </form>
		</div>
	</body>
</html>