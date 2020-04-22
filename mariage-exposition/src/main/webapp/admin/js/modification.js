// admin.js
$(document).ready(function() {

    function getQuerystringDef(key, default_) {

        if (default_==null) default_="";
        key = key.replace(/[[]/,"\[").replace(/[]]/,"\]");
        var regex = new RegExp("[\?&]"+key+"=([^&#]*)");
        var qs = regex.exec(window.location.href);
      
        if(qs == null)
          return default_;
      
        else
          return qs[1];
      
      }
      var uuid = getQuerystringDef('id','false');

      var urlRecherche="../invite/rechercheParUuid";

      $.ajax
      ({
        type: "POST",
        url: urlRecherche,
        contentType : 'application/json',
        dataType: 'json',
        data: '{"uuid": "' + uuid +'"}',
        success: function(result){
            console.log(result);
            $('#inputPersonneUnPrenom').val(result['habitant1']['prenom']);
            $('#inputPersonneUnNom').val(result['habitant1']['nom']);
            if(result['habitant2']!=null){
                $('#inputPersonneDeuxPrenom').val(result['habitant2']['prenom']);
                $('#inputPersonneDeuxNom').val(result['habitant2']['nom']);
            }
            if(result['habitant3']!=null){
                $('#inputPersonneTroisPrenom').val(result['habitant3']['prenom']);
                $('#inputPersonneTroisNom').val(result['habitant3']['nom']);
            }
            if(result['habitant4']!=null){
                $('#inputPersonneQuatrePrenom').val(result['habitant4']['prenom']);
                $('#inputPersonneQuatreNom').val(result['habitant4']['nom']);
            }
            if(result['habitant5']!=null){
                $('#inputPersonneCinqPrenom').val(result['habitant5']['prenom']);
                $('#inputPersonneCinqNom').val(result['habitant5']['nom']);
            }

            
            if(result['inviteRepas']== true){
                $('#inviteRepas').val("Oui");;
            } else {
                $('#inviteRepas').val("Non");;
            }

            $('#inputAdresse').val(result['adresse']);
            $('#inputCodePostal').val(result['codePostal']);
            $('#inputVille').val(result['ville']);
        }
    });

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
    
        var inviteRepas=$('#inviteRepas').val();
    
        var adresse=$('#inputAdresse').val();
        var codePostal=$('#inputCodePostal').val();
        var ville=$('#inputVille').val().toUpperCase();
        var codeAdmin=$('#codeAdmin').val();
        $('#codeAdmin').val("");
    
        if(inviteRepas=="Oui"){
            inviteRepas=true;
        } else{
            inviteRepas=false;
        }
    
        var urlAjout ='../invite/modification'
        var codeAdmin = prompt("Mot de passe pour la modification:");
    
        $.ajax
        ({
            type: "POST",
            url: urlAjout,
            contentType : 'application/json',
            dataType: 'json',
            data: '{"admin": "'+codeAdmin+'","uuid": "'+uuid+'", "prenom_un": "' + prenom1 + '", "nom_un" : "' + nom1 + '", "invite_repas" : "' + inviteRepas + '", "adresse" : "' + adresse + '", "code_postal" : "' + codePostal + '", "ville" : "' + ville + '", "nom_deux" : "' + nom2 + '", "prenom_deux" : "' + prenom2 + '", "nom_trois" : "' + nom3 + '", "prenom_trois" : "' + prenom3 + '", "nom_quatre" : "' + nom4 + '", "prenom_quatre" : "' + prenom4 + '", "nom_cinq" : "' + nom5 + '", "prenom_cinq" : "' + prenom5 + '"}',
            success: function (data) {
                alert( "La sauvegarde c'est bien passé" );
                document.location.href="index.html";
            },
            error: function (data) {
                alert( data['responseJSON']['code'] + " : " + data['responseJSON']['message'] + ", " + data['responseJSON']['info']);
            }
        });
    
      });

});

