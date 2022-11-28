<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription Artisan</title>
    <link rel="stylesheet" href="CSS/signupClient.css">
</head>
<body>
    <div class="regform">
        <h1>Inscription Artisan</h1>
        <p class="erreur">${artisanform.resultat}</p>
    </div>

     <div class="main">
          <div class="section">
        <h1>Identification</h1>
     </div>
     <form method="POST" enctype="multipart/form-data" >
    
     <div id="name">
     <p class="erreur">${artisanform.erreurs['firstname']}</p>
     <p class="erreur">${artisanform.erreurs['lastname']}</p>  
          <h2 class="CIN">Nom complet <span class="requis">*</span></h2>
                <input class="firstname" type="text" placeholder="Entrer votre prénom" id="firstname" value="${artisan.prenom }" name="firstname" required><br>
                <input class="lastname" type="text" placeholder="Entrer votre nom" name="lastname" value="${artisan.nom }" id="lastname" required><br>
     </div>			
         <h2 class="datenai">Date de naissance  <span class="requis">*</span></h2>
                <input class="datenai2" type="date" max="2003-12-31" id="datenai" value="${artisan.dateNaissance }" name="datenai" required>
         <h2 class="name" id="sexe">Sexe :<span class="requis">*</span></h2>
                <label class="radio" >
                <input class="radio-one" type="radio"  name="sexe" value="Homme" >
                <span class="checkmark"></span>
                Homme
            </label>
            <label class="radio">
                <input class="radio-two" type="radio" name="sexe" value="Femme" >
                <span class="checkmark"></span>
                Femme
            </label>
<h2 class="CIN">Ville : <span class="requis">*</span></h2>
                <select class="option" name="ville" id="ville" required>
                <option disabled="disabled" selected="${artisan.ville }">--Selectionner votre ville--</option>
			    <option value="Rabat">Rabat</option>
			    <option value="Casablanca">Casablanca</option>
			    <option value="Marrakech">Marrakech</option>
			    <option value="Tanger">Tanger</option>
			    <option value="Agadir">Agadir</option>
			    <option value="Fès">Fès</option>
			    <option value="Beni Mellal">Beni Mellal</option>
			    <option value="Meknès">Meknès</option>
			</select>
			<p class="erreur">${artisanform.erreurs['CIN']}</p>
<h2 class="CIN">Le numéro de votre CIN  <span class="requis">*</span></h2>
              <input class="CIN2" type="text" placeholder="Exemple:L214147" name="CIN" value="${artisan.CIN }" id="CIN" required>
<div class="section">
        <h1>Contact</h1>
</div>
<p class="erreur">${artisanform.erreurs['email']}</p>
 <h2 class="name">Email  <span class="requis">*</span></h2>
     <input class="email" type="email"placeholder="Entrer votre email" id="email" value="${artisan.email }" name="email" required>
     <p class="erreur">${artisanform.erreurs['phone']}</p>
  <h2 class="name">Contact <span class="requis">*</span></label></h2>
            <input class="Code" type="text" value="+212" name="area_code" >
            <input class="number" type="text" placeholder="Numéro de téléphone" name="phone" value="${artisan.telephone }" id="phone" required>
           
<div class="section">
    <h1>Profession</h1>
</div>
   <h2 class="CIN">Profession: <span class="requis">*</span></h2>
               <select class="option" name="profession" id="profession" required>
               <option disabled="disabled" selected="${artisan.profession }">--Selectionner votre profession--</option>
			   <option value="Menuisier">Menuisier</option>
			   <option value="Potier">Potier</option>
			   <option value="Cuir">Cuir</option>
			   <option value="Plâtrier">Platrier</option>
			</select>
	 <h2 class="CIN" id="local">Avez-vous un local de travail? ${artisan.local }</h2>
                <label class="radio">
                <input class="radio-one" type="radio"  name="local" value="oui" >
                <span class="checkmark"></span>
                Oui
            </label>
            <label class="radio">
                <input class="radio-two" type="radio" name="local" value="non" >
                <span class="checkmark"></span>
                Non
            </label>
            <p class="erreur"> ${artisanform.erreurs['adress']}</p>
      <h2 class="CIN">Adresse de votre local :</h2>       
           <input class="CIN2" type="text" placeholder="Rue ibn rochd Bloc * N° ** ,Rabat/Maroc" value="${artisan.local }" name="adress" id="adress">
           
      <h2 class="CIN">Description du fichier: <span class="requis">*</span> </h2>
          <input class="CIN2" type="text" placeholder="CV,Carte de viste...etc" name="description" value="${description }" id="description" >
      <h2 class="CIN">Fichier à envoyer : <span class="requis">*</span></h2>
          <input class="CIN2" type="file" name="fichier" value="${nomFichier }" id="fichier" multiple >
           
          <h2 class="CIN">Photo personnelle: <span class="requis">*</span></h2>
           <input  class="CIN2" type="file" name="image" id="image" value="${nomImage}" accept="image/*" >
           
<div class="section">
        <h1> Inscription</h1>
</div>
		<p class="erreur"> ${artisanform.erreurs['uname']}</p>
         <h2 class="CIN">Nom d'utilisateur <span class="requis">*</span></h2>
         
            <input class="CIN2" type="text" placeholder="Veuillez choisir un nom d'utilisateur" name="uname" value="${artisan.username }" id="uname" required>
            
            <p class="erreur"> ${artisanform.erreurs['psw']}</p>
         <h2 class="CIN">Mot de passe <span class="requis">*</span></h2>
              <input class="CIN2" type="password" placeholder="Veuillez choisir un mot de passe sécurisé" name="psw" value="${artisan.password }" id="psw" required>
               <p class="erreur"> ${artisanform.erreurs['psw2']}</p>	
         <h2 class="CIN">Confirmer votre mot de passe <span class="requis">*</span></h2>
              <input class="CIN2" type="password" placeholder="Veuillez confirmer le mot de passe" name="psw2" value="${artisan.psw2 }" id="psw2" required>
              		 
          <button type="submit">S'inscrire</button>
        </form>
</div>
</body>
</html>