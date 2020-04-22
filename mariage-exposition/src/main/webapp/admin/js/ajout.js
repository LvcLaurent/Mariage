$( "#boutonFormulaire" ).click(function() {

    var prenom1=$('#inputPersonneUnPrenom').val();
    prenom1=prenom1.charAt(0).toUpperCase() + prenom1.substring(1).toLowerCase();
    var prenom2=$('#inputPersonneDeuxPrenom').val();
    prenom2=prenom2.charAt(0).toUpperCase() + prenom2.substring(1).toLowerCase();
    var prenom3=$('#inputPersonneTroisPrenom').val();
    prenom3=prenom3.charAt(0).toUpperCase() + prenom3.substring(1).toLowerCase();
    var prenom4=$('#inputPersonneQuatrePrenom').val();
    prenom4=prenom4.charAt(0).toUpperCase() + prenom4.substring(1).toLowerCase();
    var prenom5=$('#inputPersonneCinqPrenom').val();
    prenom5=prenom5.charAt(0).toUpperCase() + prenom5.substring(1).toLowerCase();

    var nom1=$('#inputPersonneUnNom').val().toUpperCase();
    var nom2=$('#inputPersonneDeuxNom').val().toUpperCase();
    var nom3=$('#inputPersonneTroisNom').val().toUpperCase();
    var nom4=$('#inputPersonneQuatreNom').val().toUpperCase();
    var nom5=$('#inputPersonneCinqNom').val().toUpperCase();

    var inviteRepas=$('#repas').val();

    var adresse=$('#inputAdresse').val();
    var codePostal=$('#inputCodePostal').val();
    var ville=$('#inputVille').val().toUpperCase();

    if(inviteRepas=="Oui"){
        inviteRepas=true;
    } else{
        inviteRepas=false;
    }

    var urlAjout ='../invite/creation'
    var codeAdmin = prompt("Mot de passe pour la sauvegarde:");

    $.ajax
    ({
        type: "POST",
        url: urlAjout,
        contentType : 'application/json',
        dataType: 'json',
        data: '{"admin": "'+codeAdmin+'","prenom_un": "' + prenom1 + '", "nom_un" : "' + nom1 + '", "invite_repas" : "' + inviteRepas + '", "adresse" : "' + adresse + '", "code_postal" : "' + codePostal + '", "ville" : "' + ville + '", "nom_deux" : "' + nom2 + '", "prenom_deux" : "' + prenom2 + '", "nom_trois" : "' + nom3 + '", "prenom_trois" : "' + prenom3 + '", "nom_quatre" : "' + nom4 + '", "prenom_quatre" : "' + prenom4 + '", "nom_cinq" : "' + nom5 + '", "prenom_cinq" : "' + prenom5 + '"}',
        success: function (data) {
            alert( "La sauvegarde c'est bien passé" );
            document.location.href="index.html";
        },
        error: function (data) {
            alert( data['responseJSON']['code'] + " : " + data['responseJSON']['message'] + ", " + data['responseJSON']['info']);
        }
    });

  });