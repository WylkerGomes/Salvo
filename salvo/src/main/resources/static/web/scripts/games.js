
var url = "http://localhost:8080/api/games";



$(document).ready(function(){ // this is to show the data in your document. it calls all the functions that you made
    $.getJSON( url, function(data){

            var gamesInfo = data;


            players(gamesInfo);


console.log(gamesInfo);

        }
    );

});


//////////////////////////////////////////////////////////////////////////////

function players(gamesInfo){

var playersDetails = gamesInfo["0"].gameplayer["0"].player;
var dates= gamesInfo["0"].date;

    var template = "";

    gamesInfo.forEach(function(all_players){

    template += `

<ol>
<li><span> ${playersDetails.Username} , ${playersDetails.id} , ${dates}</span></li>
</ol>




`;

    })

    document.getElementById("playersList").innerHTML = template;


}



