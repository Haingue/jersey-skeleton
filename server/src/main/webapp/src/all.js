

function getUser(name) {
	getUserGeneric(name, "v1/user/");
}

function getUserGeneric(name, url) {
	$.getJSON(url + name, function(data) {
		afficheUser(data);
	});
}

function login() {
	getWithAuthorizationHeader("v1/user", function(data){
	    afficheUser(data);
	});
}

function profile() {
	getWithAuthorizationHeader("v1/profile", function (data) {afficheUser(data);});
}

 function getWithAuthorizationHeader(url, callback) {
 if($("#userlogin").val() != "") {
     $.ajax
     ({
       type: "GET",
       url: url,
       dataType: 'json',
       beforeSend : function(req) {
        req.setRequestHeader("Authorization", "Basic " + btoa($("#userlogin").val() + ":" + $("#passwdlogin").val()));
       },
       success: function(){
      alert('Authentification OK');
      $("#pageIdentifier").hide();
      $("#pageEnregistrer").hide();	
    	$("#confirmer").hide();
    	$("#logo").hide();
    	$("#bordgauche").hide();
    	$("#borddroit").hide();
    	$("#Accueil").show();
    	$("#Menu").show();
    	$("#switch").show();
    	$("#logo2").show();
    	$("#profil").show();
    	$("#programme").show();
    	$("#eventdispo").show();
    	$("#settings").show();
    }
   	,callback,
       error : function(jqXHR, textStatus, errorThrown) {
       			alert('Mauvais login/password');
       		}
     });
     } else {
     $.getJSON(url, function(data) {
     	    afficheUser(data);
        });
     }
 }
 function postEvent(label,date,prix,participants){
	postEventGeneric(label,date,prix,participants, 'v1/events/')

}

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


function postUser(name, alias, email, pwd) {
    postUserGeneric(name, alias, email, pwd, 'v1/user/')
}

function postUserGeneric(name, alias, email, pwd, url) {
	console.log("postUserGeneric " + url)
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"name" : name,
			"alias" : alias,
			"email" : email,
			"password" : pwd,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			$("#formE").reset();
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
}

function listUsers() {
    listUsersGeneric("v1/user/");
}

function listUsersGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListUsers(data)
	});
}

function afficheUser(data) {
	console.log(data);
	//$("#reponse").html(userStringify(data));
}

function afficheListUsers(data) {
	var ul = document.createElement('ul');
	ul.className = "list-group";
	var index = 0;
	for (index = 0; index < data.length; ++index) {
	    var li = document.createElement('li');
	    li.className = "list-group-item";
		li.innerHTML = userStringify(data[index]);
		ul.appendChild(li);
	}
	$("#reponse").html(ul);
}

function userStringify(user) {
    return user.uno + ". " + user.nom + " &lt;" + user.login + "&gt;" 
    + " (" + user.prenom + ")";
}

/*
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
  */

