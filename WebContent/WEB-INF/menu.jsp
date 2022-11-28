<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="main">
				<div class="logo">
						<a href="http://localhost:8080/HerftiProject/"><img src="images/logo.png"></a>
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
	                	<button type="submit" > 
	                    	<i class="fa fa-search" style="font-size: 18px;><a " href="http://localhost:8080/HerftiProject/recherche"> </a>
	                    	</i> 
	                	</button> 
	            	</form> 
	        	</div> 

			
			</div>