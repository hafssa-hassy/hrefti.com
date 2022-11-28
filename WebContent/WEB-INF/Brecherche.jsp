<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="CSS/Brecherche.css">
	    
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
		<link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<title>Résultats de la Recherche</title>
	</head>

<body>
		<header>

			<%@ include file="menu.jsp" %>
			

		</header>
<br>
<br>
<br>


<br>

 <h3>Résultats pour « ${ Rech } »:</h3>


<br>
   
   
     <c:choose>
         <c:when test="${Countrow.equals('0')}">
             <h1><font size="4"> Aucun résultat</h1></font>
        <br />
          </c:when>    
      <c:otherwise>
    

             <div  class="column" >
                <a href="http://localhost:8080/HerftiProject/pageArtisan?username=${artisan.username}">
                  <h2><img alt="Profile Image"  src="images/imagesArtisans/${ artisan.image }"  width="128" height="128" /></h2></a>
                  <p><font size="5" >${ artisan.prenom } ${ artisan.nom } </p></font>
                  <br>
                   <br>
 	
 
              </div> 
                   <br />
                  <br />
      
       </c:otherwise>
     </c:choose>
<footer>
			<ul>
				<li class="about">
					<h2>Qui somme Nous ?</h2>
					<br> <br>
					<p>
					On est une  équipe de jeunes qui vise à aider nos artisans marocains compétants à améliorer leurs conditions de travail en passant au monde digital où il ya plus d'opportunités,et aussi permettre à nos clients de trouver ceux dont ils auront besion à tout memont et en tout lieu facilement.
				</p>
				</li>
				<li class="contact">
					<h2>Contactez Nous</h2>
					<br> 
					<ul>
						<li class="phone"><div> Phone : 0600123579</div> </li>
						<br>
						<li class="email">
							<div><a href="#">Email : Herfti@gmail.com</a></div>
				       </li>
				       <br>
				        <li>
				        	<div class="social-menu">
							  
							  <ul>
							    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
							    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
							    <li><a href="#"><i class="fa fa-instagram"></i></a></li>
							    <li><a href="#"><i class="fa fa-youtube"></i></a></li>
							    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
							  </ul>
							</div>
				        </li>
					</ul>
				</li>
			</ul>
			
			
			<h4>© Copyright Herfti 2021</h4>
		</footer>




</body>
</html>