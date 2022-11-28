<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="CSS/boiteArtisan.css">
		
		
	</head>

<body>
	<c:forEach items="${transactions}" var="transaction" varStatus="loop">
	
		<ul id="ul"> 
 <div  id="container" class="container" name="container">
			
  <div id="id01" class="modal">
		<form class="modal-content animate" action="BoiteArtisan" method="post" onsubmit="return false">
		 <label for="justification"><b>Justification</b></label>
		<input type="text" placeholder="Votre justification" name="justification" required>
		<input type="submit" onclick="document.getElementById('id01').style.display='none';document.getElementById('container').style.display='none';"  id="env" class="envoyerbtn" name="Envoi" value="Envoyer"></input>
		</form>
    </div> 
  
				<li>
	    			<div  class="demande">
	    			<form action="BoiteArtisan" method="post">
	  					<a >   Vous avez reçu une demande.</a>
	  					</form>
								</div>
						<div class="panel">
						<p> De: <c:out value = "${client.prenom} ${client.nom}"/> </p>
						<p> <c:out value = "${transaction.message }"></c:out></p>
						</div>
	  		
  				</li>
  				<li>
  					
    			<ul>
   
    					<div class="bouttons">
    					<li>
    					<form action="BoiteArtisan" method="post" onsubmit="return false">
    						<input type="hidden" name="hdnbt" />
    						
 	 						<button   id="buttonV"  type="submit" name="first" value="buttonVa"  > valider </button>
 	 						<input type="hidden" name="bt" value=" ${client.username}"  />
 	 							
 	 							
 	 							
 	 						<button  onclick="document.getElementById('id01').style.display='block'"   id="buttonD" name="action"> décliner</button>
  						     
  						         	</form>	
  						         	    </li>
  						</div>
  				</ul>
    			</li>
		</div>
		</ul> 
		
	</c:forEach>
  
 <script>
 var allContainers = document.querySelectorAll(".container");
 for (var index = 0; index <allContainers.length; index++){
	 allContainers[index].addEventListener("click", function(){
       this.classList.toggle("active");
    });
	 allContainers[index].querySelector("#buttonV").addEventListener("click",
			    function(){
			       this.closest(".container").remove();
			    });
	 allContainers[index].querySelector("#env").addEventListener("click",
			    function(){
			       this.closest(".container").remove();
			    });
	
 }
 var acc = document.getElementsByClassName("demande");
 var i;
 for (i = 0; i < acc.length; i++) {
   acc[i].addEventListener("click", function() {
     this.classList.toggle("active");
     var panel = this.nextElementSibling;
     if (panel.style.display === "block") {
       panel.style.display = "none";
     } else {
       panel.style.display = "block";
     }
   });
 }
 var modal = document.getElementById('id01');
//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
      modal.style.display = "none";
  }
}
</script> 

</body>
</html>

