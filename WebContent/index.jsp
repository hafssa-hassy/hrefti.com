<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Herfti</title>
		<link rel="stylesheet" type="text/css" href="CSS/style.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
		<link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		
	</head>

	<body>
		<header>

			<div class="main">
				<div class="logo">
					<img src="images/whiteLogo.png">
				</div>

				
				<ul class="navbar">
				
					<div class="connexion">
						<c:if test="${! empty sessionScope.user }">
						
								<li><a class="signout" href="http://localhost:8080/HerftiProject/déconnexion">Se déconnecter</a></li>
								<li>
									<c:if test="${sessionScope.userType2=='a' }">
										<a href="http://localhost:8080/HerftiProject/profilArtisan"><img class="profile-img" src="images/imagesArtisans/${sessionScope.image}"/></a>
									</c:if>
									<c:if test="${sessionScope.userType2=='c' }">
										<img class="profile-img" src="images/test.jpg"/>
									</c:if>
									
									<h4 class="username">${sessionScope.user }</h4>
								</li>
						</c:if>
					</div>
				<c:if test="${ empty sessionScope.user }">
					<li><a class="signup" href="http://localhost:8080/HerftiProject/inscription">S'inscrire</a></li>
					<li><a class="signin"  href="http://localhost:8080/HerftiProject/connexion">Se connecter</a></li>
				</c:if>
					

				</ul>
				<div class="search"> 
	            	<form action="Recherche" method="POST"> 
	                	<input type="text"
	                    	placeholder="  Rchercher un nom "
	                    	name="search"> 
	                	<button type="submit"> 
	                	   <c:if test="${! empty sessionScope.user }">
	                           <i class="fa fa-search" style="font-size: 18px;><a  " href="http://localhost:8080/HerftiProject/recherche"> </a>
		                    	</i>
		                    </c:if>	 
		                      <c:if test="${ empty sessionScope.user }">
	                           <i class="fa fa-search" style="font-size: 18px;><a  " href="#"> </a>
		                    	</i>
		                    </c:if>	
	                	</button> 
	            	</form> 
	        	</div> 

			
			</div>
			

		</header>
		<main>
			<div class="title">
					<h1 > Avec nos meilleurs artisans marocains vous pourrez créer de la pure beauté</h1>
			</div>
			<div class="jobs">
					<h2 > Nos métiers </h2>
			</div>
			<div class="job-images">
				<ul >
					<li >
						<div class="job1">
							<a href="http://localhost:8080/HerftiProject/Métier?type=menuisier">
								<img src="images/job1.jpeg" height="200" width="200" >
							</a>
							
							<h3>Menuisiers</h3>
						</div>	
					</li>
					<li >
						<div class="job2">
							<a href="http://localhost:8080/HerftiProject/Métier?type=potier">
								<img src="images/job2.jpg" height="200" width="200" >
							</a>
							<h3>Potiers</h3>
						</div>	
					</li>
					<li >
						<div class="job3">
							<a href="http://localhost:8080/HerftiProject/Métier?type=cuir">
								<img src="images/job3.jpg" height="200" width="200" >
							</a>
							
							<h3>Produits de cuir</h3>
						</div>	
					</li>
					<li >
						<div class="job4">
							<a href="http://localhost:8080/HerftiProject/Métier?type=platrier">
								<img src="images/job4.jpg" height="200" width="200" >
							</a>
							
							<h3>Plâtriers</h3>
						</div>	
					</li>
				
				</ul>
			</div>
			


		</main>
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