<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription Client</title>
    <link rel="stylesheet" href="CSS/signupClient.css">
</head>
<body>
    <div class="regform">
        <h1>Inscription Client</h1>
        <p class="erreur">${clientform.resultat}</p>
    </div>

<div class="main">
	<div class="section">
	        <h1>Identification</h1>
	</div>
   <form method="POST">
         <div id="name">
	         <p class="erreur">${clientform.erreurs['firstname']}</p>
	         <p class="erreur">${clientform.erreurs['lastname']}</p>  
			<h2 class="CIN">Nom complet <span class="requis">*</span></h2>
            <input class="firstname" type="text"  placeholder="Entrer votre prénom" name="firstname" id="firstname" value="${client.prenom }"required><br>
            <input class="lastname" type="text" placeholder="Entrer votre nom" name="lastname" id="lastname" value="${client.nom }" required><br>
        </div>
                 
                 
<h2 class="datenai">Date de naissance <span class="requis">*</span></h2>
    <input class="datenai2" type="date" max="2003-12-31" id="datenai" name="datenai" value="${client.dateNaissance }" required>
<h2 class="name">Vous êtes  <span class="requis">*</span></h2>
        <label class="radio" id="sexe">
        <input class="radio-one" type="radio"   name="sexe" value="homme" required>
        <span class="checkmark"></span>Homme</label> 
        <label class="radio">
        <input class="radio-two" type="radio" name="sexe" value="femme" required> 
        <span class="checkmark"></span>Femme</label>
<h2 class="name">Ville <span class="requis">*</span></h2>
                 <select class="option" name="ville" id="ville" required>
                <option disabled="disabled" selected="${client.ville }">--Selectionner votre ville--</option>
			    <option value="Rabat">Rabat</option>
			    <option value="Casablanca">Casablanca</option>
			    <option value="Marrakech">Marrakech</option>
			    <option value="Tanger">Tanger</option>
			    <option value="Agadir">Agadir</option>
			    <option value="Fès">Fès</option>
			    <option value="Beni Mellal">Beni Mellal</option>
			    <option value="Meknès">Meknès</option>
			</select>
			<p class="erreur">${clientform.erreurs['CIN']}</p>
<h2 class="CIN">Le numéro de votre CIN <span class="requis">*</span></h2>
           <input class="CIN2" type="text" placeholder="Exemple:L214147"  name="CIN" id="CIN" value="${client.CINc }" required>
           
	<div class="section" id="contact">
	        <h1> Contact</h1>
	</div>            
	<p class="erreur">${clientform.erreurs['email']}</p>
         <h2 class="name">Email <span class="requis">*</span></h2>
            <input class="email" type="email" placeholder="Entrer votre email"  name="email" id="email" value="${client.email }"  required>
            <p class="erreur">${clientform.erreurs['phone']}</p>
         <h2 class="name">Contact <span class="requis">*</span></label></h2>
            <input class="Code" type="text" value="+212" name="area_code" required>
            <input class="number" type="text" placeholder="Numéro de téléphone" name="phone" id="phone"  value="${client.telephone }" required>
           
	<div class="section" id="inscription">
	      <h1>Inscription</h1>
	</div>            
       <h2 class="CIN">Nom d'utilisateur <span class="requis">*</span></h2>
       <p class="erreur"> ${clientform.erreurs['uname']}</p>
             <input class="CIN2" type="text" placeholder="Veuillez choisir un nom d'utilisateur"  name="uname" id="uname"  value="${client.username }" required>
               <p class="erreur"> ${clientform.erreurs['psw']}</p>
       <h2 class="CIN">Mot de passe <span class="requis">*</span></h2>
               <input class="CIN2" placeholder="Veuillez choisir un mot de passe sécurisé"  type="password" name="psw" id="psw" value="${client.password }" required>
              	<p class="erreur"> ${clientform.erreurs['psw2']}</p>
       <h2 class="CIN">Confirmation <span class="requis">*</span></h2>
                <input class="CIN2" type="password" placeholder="Veuillez confirmer le mot de passe"  name="psw2" id="psw2" value="${client.password }" required>	
       <button type="submit" >S'inscrire</button>    
        </form>
</div>
</body>
</html>