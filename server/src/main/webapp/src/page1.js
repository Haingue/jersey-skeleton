$(document).ready(function(){
    $("#pageEnregistrer").hide();	
    $("#pageIdentifier").hide();
    $("#confirmer").hide();
    $("#Accueil").hide();



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


    $("#creerEventButton").click(){
       
    }
    
    // Inscription
    $("#confirmerE").click(function(){
	postUser(
            $('#nom').val(),
            $('#prenom').val(),   
            $('#email').val(),
            $('#passwd').val())
        $("#pageEnregistrer").hide();
        $("#page1").hide();
        $("#Acceuil").hide();
        $("#pageIdentifier").show();


	});
	
	// Identification
	$("#confirmerI").click(function(){
		login()
        /*
    $("#Accueil").show();
    $("#switch").show();
    $("#titre3").show();
    $("#eventboard").show();
    $("#Menu").show();
    $("#logo2").show();
    $("#profil").show();
    $("#programme").show();
    $("#eventdispo").show();
    $("#settings").show();
    

    $("#bordgauche").hide();
    $("#borddroit").hide();
    $("#pageEnregistrer").hide();   
    $("#pageIdentifier").hide();
    $("#confirmer").hide();
    $("#profilpage").hide();
    $("#titre1").hide();
    $("#titre2").hide();
    $("#titre4").hide();
    $("#creerevent").hide();
    $("#pageprofil").hide();
    $("#pagereglage").hide();
    */
	});
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
    $("#uploadlinkd").click(function(){
        
    });
	


});



