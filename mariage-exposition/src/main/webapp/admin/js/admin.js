// admin.js
function majTab() {
    var urlAll ='../invite/all'

    $.ajax({
        url: urlAll,
        contentType: "application/json",
        dataType: 'json',
        success: function(result){
            var tableau = "<table class=\"table\"><thead><tr><th>adresse</th><th>code postal</th><th>ville</th><th>Mr/Mme</th><th>Reponse</th><th>Action</th></tr></thead><tbody>";
            var row = "";

            for (var i = 0; i < result.length; i += 1){
                row="";
                
                var adresse = result[i]['adresse'];
                if(adresse == null){
                    adresse="X";
                }
                var codePostal = result[i]['codePostal'];
                if(codePostal == null){
                    codePostal="X";
                }
                var ville = result[i]['ville'];
                if(ville == null){
                    ville="X";
                }
                var prenom = result[i]['habitant1']['prenom'] + " "+ result[i]['habitant1']['nom'];
                if(result[i]['habitant2'] != null){
                    if(result[i]['habitant1']['nom'] == result[i]['habitant2']['nom']){
                        prenom = result[i]['habitant2']['prenom'] +" & " + prenom
                    } else {
                        prenom += " & " + result[i]['habitant2']['prenom'] + " "+ result[i]['habitant2']['nom']
                    }
                }
                if(result[i]['habitant3'] != null){
                    if(result[i]['habitant1']['nom'] == result[i]['habitant3']['nom']){
                        prenom = result[i]['habitant3']['prenom'] +", " + prenom
                    } else {
                        prenom += " & " + result[i]['habitant3']['prenom'] + " "+ result[i]['habitant3']['nom']
                    }
                }
                if(result[i]['habitant4'] != null){
                    if(result[i]['habitant1']['nom'] == result[i]['habitant4']['nom']){
                        prenom = result[i]['habitant4']['prenom'] +", " + prenom
                    } else {
                        prenom += " & " + result[i]['habitant4']['prenom'] + " "+ result[i]['habitant4']['nom']
                    }
                }
                if(result[i]['habitant5'] != null){
                    if(result[i]['habitant1']['nom'] == result[i]['habitant5']['nom']){
                        prenom = result[i]['habitant5']['prenom'] +", " + prenom
                    } else {
                        prenom += " & " + result[i]['habitant5']['prenom'] + " "+ result[i]['habitant5']['nom']
                    }
                }
                row += "<tr>";
                urlModification="modification.html?id="+result[i]['codeUID']
                adresse = "<td>" + adresse + "</td>";
                codePostal = "<td>" + codePostal + "</td>";
                ville = "<td>" + ville + "</td>";
                prenom = "<td>" + prenom + "</td>";
                if(result[i]['reponse']== false){
                    reponse = "<td>" + "<img src=\"../images/X_rouge.png\" alt=\"\" />" + "</td>";
                }else{
                    reponse = "<td>" + "<img src=\"../images/V_vert.png\" alt=\"\" />" + "</td>";
                }
                action = "<td><a href=\""+urlModification+"\" > <img src=\"../images/key-24-211406.png\" alt=\"\" /></a><a onClick=\"supression('"+result[i]['codeUID']+"');\" > <img  src=\"../images/30120.png\" alt=\"\" /></a></td>";
                row += adresse + codePostal +ville+prenom+reponse+action+"</tr>";
                tableau += row ;
                if(i === result.length-1) {
                    tableau += "</tbody></table>";
                    $('#Donnee').html(tableau);
                }
            };
                

        }
    });

}

function supression(uuid) {
    var urlSup ='../invite/supression'

    var admin = prompt("Mot de passe :");
    
    $.ajax({
        type: "POST",
        url: urlSup,
        contentType : 'application/json',
        dataType: 'json',
        data: '{"admin": "'+admin+'","uuid": "' + uuid +'"}',
        success: function(){
            majTab()
        },
        error: function (data) {
            alert( data['responseJSON']['code'] + " : " + data['responseJSON']['message'] + ", " + data['responseJSON']['info']);
        }
    });

}

$(document).ready(function() {

    majTab();

    
});

