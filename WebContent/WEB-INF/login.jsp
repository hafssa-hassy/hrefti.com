<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
<div class="container">

	<div class="regform">
	        <h1> Log In</h1>
	        <c:if test="${sessionScope.userType == 'a'}">
				<p class="resultat">${ artisanform.resultat } ${ artisan.username }</p>
			</c:if>
			<c:if test="${sessionScope.userType == 'c'}">
				<p class="resultat">${ clientform.resultat } ${ client.username }</p>
			</c:if>
	</div>
	<div class="imgcontainer">
	    <img src="images/man.png" alt="Avatar" class="avatar">
	</div>
	<form action="/HerftiProject/connexion" method="post">
		   
	   <p class="error">${error}</p>
	    <p>
	    <label for="username"><b>Nom d'utilisateur</b></label>
	    </p>
	    <p><c:if test="${empty sessionScope.userType }">
		    <input type="text" placeholder="Entrer le nom d'utilisateur" id="uname" name="username"  required>
		    </c:if></p>
		    
		<p><c:if test="${sessionScope.userType == 'a'}">
		    <input type="text" placeholder="Entrer le nom d'utilisateur" id="uname" name="username" value="${ artisan.username}" required>
		    </c:if>
	    </p>
		    <p><c:if test="${sessionScope.userType == 'c'}">
		    <input type="text" placeholder="Entrer le nom d'utilisateur" id="uname" name="username" value="${ client.username}" required></c:if>
		    </p>
	    <p>
	    <label for="psw"><b>Mot de passe</b></label>
	     </p>
	     <p><c:if test="${empty sessionScope.userType }">
		    <input type="password" placeholder="Entrer le mot de passe" id="psw" name="psw"  required></c:if>
		    </p>
	    <p><c:if test="${sessionScope.userType == 'a'}">
		    <input type="password" placeholder="Entrer le mot de passe" id="psw" name="psw" value="${artisan.password }" required></c:if>
		    </p>
		     <p><c:if test="${sessionScope.userType == 'c'}">
		    <input type="password" placeholder="Entrer le mot de passe" id="psw" name="psw" value="${client.password }" required></c:if>
   		 </p>
	    <button type="submit">Login</button>
	    <button type="button"  class="cancelbtn"><a class="cancelBtn" href="http://localhost:8080/HerftiProject/">Cancel</a></button>
	      <div class="remember" >
	    <label >
	      <input type="checkbox"  name="remember"> Remember me
	    </label>
	  </div>
	  
	
	
	</form>
</div>
</body>