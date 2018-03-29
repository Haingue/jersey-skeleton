

/*
  Fonction permettant de se connecter au serveur
*/

function login() {
	getWithAuthorizationHeader("v1/user", function(data){
	    afficheUser(data);
	});
}

/*
 Fonction permettant la connexion sécurisé sur le serveur
 parametre: l'url ou se trouve le json des utilisateurs

*/

 function getWithAuthorizationHeader(url, callback) {
 if($("#userlogin").val() != "" && $("#userlogin").val() =="admin" ) {
     $.ajax
     ({
       type: "GET",
       url: url,
       dataType: 'json',
       beforeSend : function(req) {
        req.setRequestHeader("Authorization", "Basic " + btoa($("#userlogin").val() + ":" + $("#passwdlogin").val()));
       },
       success: function(){
        // Permet d'afficher la page Admin + utilisation fonction listerUsers
      alert('Authentification OK');
      $("#pageIdentifier").hide();
      $("#pageEnregistrer").hide();	
    	$("#confirmer").hide();
    	$("#logo").hide();
    	$("#bordgauche").hide();
    	$("#borddroit").hide();
      $("#page1").hide();
      $("#PageAdmin").show();
      $("#listUser").show();
      $("#listEvent").show();
      $("#listformu").show();
      listerUsers();
    }
   	,callback,
       error : function(jqXHR, textStatus, errorThrown) {
        if($("#userlogin").val() != "admin"){
            alert('Cette page est reservé aux administrateurs');
       }else{
       			alert('Mauvais login/password');
       		}
        }
     });
     } else {
     $.getJSON(url, function(data) {
     	    afficheUser(data);
        });
     }
 }

// Permet de créer un événement

 function postEvent(label,date,prix,participants){
	postEventGeneric(label,date,prix,participants, 'v1/events/')

}
// Permet la création d'événement

function postEventGeneric(label,date,price,participants,url){
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"label" : label,
			"date" : date,
			"price" : price,
			"participants" : participants,
			"id" : 0
		}),

	});

}

// Permet de créer un utilisateur

function postUser(name, alias, email, pwd) {
    postUserGeneric(name, alias, email, pwd, 'v1/user/')
}

//Permet la création d'un utilisateur

function postUserGeneric(name, alias, email, pwd, url) {
	console.log("postUserGeneric " + url)
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"name" : name,
			"surname" : alias,
			"login" : email,
			"password" : pwd,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			alert("Création utilisateur réussi!");
		
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('Erreur création utilisateur');
		}
	});
}

// Permet de liter les informations des utilisateurs : nom, prénom, et mail.

function listerUsers(){
  $.ajax({
    url: "/v1/user",
    type: "GET",
    dataType : "json",
    beforeSend : function(req) {
        req.setRequestHeader("Authorization", "Basic " + btoa($("#userlogin").val() + ":" + $("#passwdlogin").val()));
       },
    success: function( json ) {
        $('#listUser').children("li").remove();
       
    $.each(json, function(i,event){
      $('#listUser').append("<li> Nom: " + event.name + " Prénom: "+ event.surname+" Mail:  "+ event.login)});
        
    },
    error: function( xhr, status, errorThrown ) {
        alert( "Erreur dans l'affichage des utilisateurs" );
    }
  
  });
}





/* ANCIEN CODE DU PROGRAMME
function listerEvents(){
	$.ajax({
    // The URL for the request
    url: "/v1/events",

    // Whether this is a POST/GET/UPDATE/DELETE request
    type: "GET",
    // The type of data we expect back
    dataType : "json",
    // Code to run if the request succeeds;
    // the response is passed to the function
    success: function( json ) {
    
        $('#eventboard').children("li").remove();
       
		$.each(json, function(i,event){
			$('#eventboard').append("<li>" + event.label + " Nombre de de participants: "+ event.participants+" Prix: "+ event.price +" Date :"+event.date  +"</li>");
        });
        
    },
    // Code to run if the request fails; the raw request and
    // status codes are passed to the function
    error: function( xhr, status, errorThrown ) {
        alert( "Erreur dans l'affichage des livres" );
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    },
  
    complete: function( xhr, status ) {

    }
  });

function listUsers() {
    listUsersGeneric("v1/user/");
}

function listUsersGeneric(url) {
  $.getJSON(url, function(data) {
    afficheListUsers(data)
  });
}

  */

