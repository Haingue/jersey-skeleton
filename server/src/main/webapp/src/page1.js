$(document).ready(function(){
    $("#pageEnregistrer").hide();	
    $("#pageIdentifier").hide();
    $("#confirmer").hide();
    $("#Accueil").hide();
    $("#PageAdmin").hide();


    //TRANSITION PAGE ADMIN
    function transitionAdmin(){
    $("#page1").hide();
    $("#PageAdmin").show();
    $("#listUser").show();
    $("#listEvent").show();
    $("#listformu").show();

    }

    //Fonction transition
    function transitionId(){
    $("#page1").hide();
    $("#Acceuil").hide();
    $("#pageIdentifier").show();
    }

    // TRANSITION PAGE ENREGISTREMENT
    $("#enregistrer").click(function(){
	$("#page1").hide();
	$("#pageEnregistrer").show();
    });

    // TRANSITION PAGE IDENTIFICATION
    $("#identifier").click(function(){
	transitionId();			
    });

    
    // Inscription
    $("#creerutil").click(function(){
	postUser(
            $('#nomform').val(),
            $('#prenomform').val(),   
            $('#mailform').val(),
            $('#mdpform').val()
            )
            listerUsers();
            listerUsers();

	});
	
	// Identification
	$("#confirmerI").click(function(){
		login();
	});











    /* CODE DE L ANCIENNE PAGE
    $("#profil").click(function(){
        $("#titre1").show();
        $("#titre2").hide();
        $("#titre3").hide();
        $("#titre4").hide();
        $("#eventboard").hide();
        $("#creerevent").hide();
        $("#pageprofil").show();
        $("#pagereglage").hide();           
    });
    $("#programme").click(function(){
        $("#titre1").hide();
        $("#titre2").show();
        $("#titre3").hide();
        $("#titre4").hide();
        $("#eventboard").show();
        $("#creerevent").hide();
        $("#pageprofil").hide();
        $("#pagereglage").hide();       
    });
    $("#eventdispo").click(function(){
        $("#titre1").hide();
        $("#titre2").hide();
        $("#titre3").show();
        $("#titre4").hide();
        $("#eventboard").show();
        $("#creerevent").hide();
        $("#pageprofil").hide();
        $("#pagereglage").hide();       
    });
    $("#settings").click(function(){
        $("#titre1").hide();
        $("#titre2").hide();
        $("#titre3").hide();
        $("#titre4").show();
        $("#eventboard").hide();
        $("#creerevent").hide();
        $("#pageprofil").hide();
        $("#pagereglage").show();   
    });
    $("#creerevent1").click(function(){
        $("#pageprofil").hide();
        $("#pagereglage").hide();
        $("#eventboard").hide();
        $("#creerevent").show();
    });
    $("#creerevent2").click(function(){
        $("#pageprofil").hide();
        $("#pagereglage").hide();
        $("#eventboard").hide();
        $("#creerevent").show();
    });
	

*/
});



