
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

    var template = "<ol>";

    gamesInfo.forEach( game => { // loops trough the data

        console.log(game.gameplayer);

        // get the playername of gameplayer 1 and 2
        console.log(game.gameplayer["0"].player.Username);
        console.log(game.gameplayer["1"].player.Username);

        var player1 = game.gameplayer["0"].player.Username; // this gets the player 1 of each game
        var player2 = game.gameplayer["1"].player.Username; // this gets the player 2 of each game
        var playersUsernames = player1 + " vs " + player2;



            console.log(gamesInfo["0"].gameid);

            var gameIds = game.gameid; // to get the ids of the game


        // print the template
        template += `


<li><span> ${playersUsernames} , ${gameIds} , ${game.date}</span></li>


`;

    });
    template += "</ol>"; // to create another "ol", it closes and the when loops opens it again

    document.getElementById("playersList").innerHTML = template;

}



