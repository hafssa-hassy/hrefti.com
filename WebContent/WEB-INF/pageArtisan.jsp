<!DOCTYPE html>
<html lang="en">
	<head>
	    <link rel="stylesheet" href="CSS/pageArtisan.css">
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	    <link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	    <script type="text/javascript" src="javascript/menuisiertravaux.js"></script>
	<title>pageArtisan</title>
	
	</head>
	<body>
	<header>
<%@ include file="menu.jsp" %>
</header>   
<main>   	
<div class="secondheader">
	</div>
	<div class="row">
	  <div class="side">
    <h2>${ a.prenom } ${ a.nom }</h2>
    <h5>${ a.profession }</h5>
    <img class="showimg" style="height:200px;" src="images/imagesArtisans/${ a.image }"></img>
	   <div class="detail-box">
							<p>Informations personnelles</p>
							<div class="ul-first">
								<p>Email</p>
								<p>Numéro</p>
								<p>Adresse</p>
								<p>Ville</p>
								<p>Description</p>						
							</div>
							<div class="ul-second">
							<p>${ a.email }</p>
							<p>${ a.telephone }</p>
							<p>${ a.adresse }</p>
							<p>${ a.ville }</p>
							<a href="fichiersArtisans/${ a.fichier }">${ a.descriptionFichier }</a>
							</div>
							</div>
		<div class="card">
	    <form action="PageArtisan" method="post" >
						     <label for="message"></label>
					         <input type="text" id="message" name="message" placeholder="Ecrivez un message à l'artisan ..." "></input>
							 <input  type="submit" value="Contacter"  class="btn draw-border" name="action" ></input>
							 </form>
	    <button class="btn draw-border" type="submit">la demande</button>
						</div>
	  </div>
	 
	  <div class="main">
	    <h2>Local du travail</h2>
	     <h5>${a.adresse } </h5>
	    <img class="showimg" style="height:200px;" src="images/imagesArtisans/${ a.local }" id="local" alt="local"></img>
	    <h2>Experience</h2>
	     <p>${a.experience }</p>
	    
	     <h2>Travaux</h2>
	   <!-- Container for the image gallery -->
	<div class="container">
	
	  <!-- Full-width images with number text -->
	  <div class="mySlides">
    <div class="numbertext">1 / 4</div>
      <img src="images/echantillonsArtisans/${ a.dossEchantillons }/${ a.tra1 }" style="width:100%">
  </div>
  <div class="mySlides">
    <div class="numbertext">2 / 4</div>
      <img src="images/echantillonsArtisans/${ a.dossEchantillons}/${ a.tra2 }" style="width:100%">
</div>
  <div class="mySlides">
    <div class="numbertext">3 / 4</div>
      <img src="images/echantillonsArtisans/${ a.dossEchantillons}/${ a.tra3 }" style="width:100%">
  </div>

  <div class="mySlides">
    <div class="numbertext">4 / 4</div>
      <img src="images/echantillonsArtisans/${ a.dossEchantillons}/${ a.tra4 }" style="width:100%">
  </div>
	
	  <!-- Next and previous buttons -->
	  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	  <a class="next" onclick="plusSlides(1)">&#10095;</a>
	
	  <!-- Image text -->
	  <div class="caption-container">
	    <p id="caption"></p>
	  </div>
	
	  <!-- Thumbnail images -->
	  <div class="row">
    
      <img id ="travail1" class="demo cursor" src="images/echantillonsArtisans/${ a.dossEchantillons}/${ a.tra1}" style="width:20%" onclick="currentSlide(1)" alt="travail 1">
      <img  id ="travail2" class="demo cursor" src="images/echantillonsArtisans/${ a.dossEchantillons}/${ a.tra2 }" style="width:20%" onclick="currentSlide(2)" alt="Travail 2">   
      <img id ="travail3" class="demo cursor" src="images/echantillonsArtisans/${ a.dossEchantillons}/${ a.tra3 }" style="width:20%" onclick="currentSlide(3)" alt="Travail 3">
      <img  id ="travail4" class="demo cursor" src="images/echantillonsArtisans/${ a.dossEchantillons}/${ a.tra4 }" style="width:20%" onclick="currentSlide(4)" alt="Travail4">   
  </div>
	  </div>
	</div>
	  </div>
	
	</main>
	<footer>
<div class="footer">
 <ul>
				<li class="about">
					<h2>Qui somme Nous ?</h2>
					<br> 
					<p>On est une  équipe de jeunes qui vise à aider nos artisans marocains
					 compétants à améliorer leurs conditions de travail en passant au monde digital 
					 où il ya plus d'opportunités,et aussi permettre à nos clients de trouver ceux dont
					  ils auront besion à tout memont et en tout lieu facilement.</p>
				
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
</div>
</footer>
</body>
</html>
