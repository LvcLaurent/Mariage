
// portail.js
$(document).ready(function() {
    $("#formReponse").hide();
    $("#btnValider").hide();
    $("#invitationRepasForm").hide();
});

$("#uuid").click(function() {

    var code=$('#code').val();

    var urlRecherche ='/cherche/uuid';

    $.ajax
    ({
        type: "POST",
        url: urlRecherche,
        contentType : 'application/json',
        dataType: 'json',
        data: '{"uid": "'+code+'"}',
        success: function (data) {
            $("#uuid").hide();
            $("#personne").text(data['personne']);
            var message = data['message'];
            if (message != null){
                $("#personnel").text(data['message']);
            }
            $("#formReponse").show();
            $("#btnValider").show();
            if(data['repas']== true){
                $("#invitationRepasForm").show();
            }
            
        },
        error: function (data) {
            alert( data['responseJSON']['code'] + " : " + data['responseJSON']['message'] + ", " + data['responseJSON']['info']);
        }
    });


});

$("#valider").click(function() {

    var code=$('#code').val();
    var repasPortail=$('#repasReponse').val();
    console.log(repasPortail);
    var vinPortail=$('#repasVin').val();
    console.log(vinPortail);

    var urlPortail ='/portail/save';
    
    if(repasPortail=="Oui"){
        repasPortail=true;
    } else{
        repasPortail=false;
    };
    if(vinPortail=="Oui"){
        vinPortail=true;
    } else{
        vinPortail=false;
    };
    var commentaire=$('#commentaire').val();

    $.ajax
    ({
        type: "POST",
        url: urlPortail,
        contentType : 'application/json',
        dataType: 'json',
        data: '{"code": "'+code+'","commentaire": "' + commentaire + '", "repas" : "' + repasPortail + '", "vin" : "' + vinPortail + '"}',
        success: function (data) {
            alert( "Votre Confirmation est accepté" );
            document.location.href="index.html";
        },
        error: function (data) {
            alert( data['responseJSON']['code'] + " : " + data['responseJSON']['message'] + ", " + data['responseJSON']['info']);
        }
    });


});


