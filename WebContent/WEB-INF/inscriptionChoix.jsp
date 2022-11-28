<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="CSS/inscriptionChoix.css">
		<title>inscription Herfti</title>
	</head>
		<body>
			<c:if test="${testInscrit==false }">
				<div class="non-inscrit">
					<h2 class="message">Pour bénéficier des services de notre site web veuillez s'inscrire</h2>
					<h3 class="deja-inscrit"><a  href="http://localhost:8080/HerftiProject/connexion" >Déjà inscrit ? Connectez Vous</a></h3>
				</div>						
			</c:if>
		<div class="wrapper">
				<header class="title"><h1>Inscription</h1></header>  
			
		    <main>
		    	<div class="question"><h2>Etes vous un Artisan ou un client ?</h2></div>

				<ul>
					<li><a href="http://localhost:8080/HerftiProject/formulaireArtisan" class="artisanBtn">Artisan</a></li>
					<li><a href="http://localhost:8080/HerftiProject/formulaireClient" class="clientBtn">Client</a></li>
				</ul>
		    </main>
	    </div>
	     

	
	</body>
</html>