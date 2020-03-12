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

            

            if(result['habitant1']['inviteRepas']== true){
                $('#repas').prop('checked')
            }

            $('#inputAdresse').val(result['adresse']);
            $('#inputCodePostal').val(result['codePostal']);
            $('#inputVille').val(result['ville']);
        }
    });

    $( "#boutonFormulaire" ).click(function() {
        alert( "Une Modification va être effectué en base" );
    
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
    
        var urlAjout ='../invite/modification'
    
        $.ajax
        ({
            type: "POST",
            url: urlAjout,
            contentType : 'application/json',
            dataType: 'json',
            data: '{"uuid": "'+uuid+'", "prenom_un": "' + prenom1 + '", "nom_un" : "' + nom1 + '", "invite_repas" : "' + inviteRepas + '", "adresse" : "' + adresse + '", "code_postal" : "' + codePostal + '", "ville" : "' + ville + '", "nom_deux" : "' + nom2 + '", "prenom_deux" : "' + prenom2 + '", "nom_trois" : "' + nom3 + '", "prenom_3" : "' + prenom3 + '", "nom_quatre" : "' + nom4 + '", "prenom_quatre" : "' + prenom4 + '", "nom_cinq" : "' + nom5 + '", "prenom_cinq" : "' + prenom5 + '"}',
            success: function (data) {
                console.log("sucess")
                console.log(data);
            }
        }).then(function(data){
            console.log("then");
            console.log(data);
        });
    
      });

});

