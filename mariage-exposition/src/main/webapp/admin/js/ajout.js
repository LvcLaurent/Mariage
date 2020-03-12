$( "#boutonFormulaire" ).click(function() {
    alert( "Une sauvegarde va être effectué en base" );

    var prenom1=$('#inputPersonneUnPrenom').val();
    $('#inputPersonneUnPrenom').val(" ");
    var prenom2=$('#inputPersonneDeuxPrenom').val();
    $('#inputPersonneDeuxPrenom').val(" ");
    var prenom3=$('#inputPersonneTroisPrenom').val();
    $('#inputPersonneTroisPrenom').val(" ");
    var prenom4=$('#inputPersonneQuatrePrenom').val();
    $('#inputPersonneQuatrePrenom').val(" ");
    var prenom5=$('#inputPersonneCinqPrenom').val();
    $('#inputPersonneCinqPrenom').val(" ");

    var nom1=$('#inputPersonneUnNom').val();
    $('#inputPersonneUnNom').val(" ");
    var nom2=$('#inputPersonneDeuxNom').val();
    $('#inputPersonneDeuxNom').val(" ");
    var nom3=$('#inputPersonneTroisNom').val();
    $('#inputPersonneTroisNom').val(" ");
    var nom4=$('#inputPersonneQuatreNom').val();
    $('#inputPersonneQuatreNom').val(" ");
    var nom5=$('#inputPersonneCinqNom').val();
    $('#inputPersonneCinqNom').val(" ");

    var inviteRepas=$('#repas').val();
    $('#repas').val(" ");

    var adresse=$('#inputAdresse').val();
    $('#inputAdresse').val(" ");
    var codePostal=$('#inputCodePostal').val();
    $('#inputCodePostal').val(" ");
    var ville=$('#inputVille').val();
    $('#inputVille').val(" ");

    if(inviteRepas=="on"){
        inviteRepas=true;
    } else{
        inviteRepas=false;
    }

    var urlAjout ='../invite/creation'

    $.ajax
    ({
        type: "POST",
        url: urlAjout,
        contentType : 'application/json',
        dataType: 'json',
        data: '{"prenom_un": "' + prenom1 + '", "nom_un" : "' + nom1 + '", "invite_repas" : "' + inviteRepas + '", "adresse" : "' + adresse + '", "code_postal" : "' + codePostal + '", "ville" : "' + ville + '", "nom_deux" : "' + nom2 + '", "prenom_deux" : "' + prenom2 + '", "nom_trois" : "' + nom3 + '", "prenom_3" : "' + prenom3 + '", "nom_quatre" : "' + nom4 + '", "prenom_quatre" : "' + prenom4 + '", "nom_cinq" : "' + nom5 + '", "prenom_cinq" : "' + prenom5 + '"}',
        success: function (data) {
            console.log("sucess")
            console.log(data);
        }
    }).then(function(data){
        console.log("then");
        console.log(data);
    });

  });