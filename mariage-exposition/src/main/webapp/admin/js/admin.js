// admin.js
$(document).ready(function() {

    var urlAll ='../invite/all'

    $.ajax({
        url: urlAll,
        contentType: "application/json",
        dataType: 'json',
        success: function(result){
            console.log(result);
            var tableau = "<table class=\"table\"><thead><tr><th>adresse</th><th>code postal</th><th>ville</th><th>Mr/Mme</th><th>Action</th></tr></thead><tbody>";
            console.log(tableau)
            var row = "";

            for (var i = 0; i < result.length; i += 1){
                console.log(i);
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
                action = "<td><a href=\""+urlModification+"\" > <img src=\"../images/key-24-211406.png\" alt=\"\" /></a></td>";
                row += adresse + codePostal +ville+prenom+action+"</tr>";
                tableau += row ;
                console.log(tableau)
                if(i === result.length-1) {
                    tableau += "</tbody></table>";
                    console.log(tableau)
                    $('#Donnee').html(tableau);
                }
            };
                

        }
    });

});