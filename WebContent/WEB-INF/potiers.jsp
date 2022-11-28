<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="CSS/potiers.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
		<link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<title>Potiers</title>
	</head>
	<body>
		<header>

			<%@ include file="menu.jsp" %>
			

		</header>
		<main>
			<div class="title">
					<p> Nos Potiers </p>
			</div>
			<ul>
				<c:forEach items="${artisans}" var="artisan" varStatus="loop">
					
						<li>
							<div class="container">
		
								<ul>
									<li>
										<div class="personne">
											<a href="http://localhost:8080/HerftiProject/pageArtisan?username=${artisan.username}">
												<img src="images\\imagesArtisans\\<c:out value = "${artisan.image}"/>" height="150" width="150" >
											</a>
										</div>
										<div class="nom-prenom">
											
												<h3>  <strong> <c:out value = " ${artisan.prenom} ${artisan.nom}"/></strong> </h3>
												
										
										</div>
											
											
									</li>
									<li>
										<div class="description">
											<h3>   Exemples de Réalisations:</h3>
											<ul>
												<c:forEach var="img" items="${imageList[loop.index] }">
													<li>
														<img src="images/echantillonsArtisans/<c:out value = "${artisan.dossEchantillons }"/>/<c:out value="${img }"/>" height=120 width=120>
													</li>
												</c:forEach>
											</ul>
										
										</div>
									</li>
								</ul>
							</div>
						</li>
						</c:forEach>
				</ul>
			
			
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