
var data = url ("http://localhost:8080/api/games");


$.getJSON( data, function( data ) {


});







$(function() {

    // display text in the output area
    function showOutput(text) {
        $("#output").text(text);
    }

    // load and display JSON sent by server for /players

    function loadData() {
        $.get("/players")
            .done(function(data) {
                showOutput(JSON.stringify(data, null, 2));
            })
            .fail(function( jqXHR, textStatus ) {
                showOutput( "Failed: " + textStatus );
            });
    }

    // handler for when user clicks add person

    function addPlayer() {
        var user = $("#email").val();
        var name = $("#name").val();
        var lastname = $("#lastnames").val();
        if ( user, name, lastname) {
            postPlayer( user, name, lastname);
        }
    }

    // code to post a new player using AJAX
    // on success, reload and display the updated data from the server

    function postPlayer(username , firstName, lastName) {
        $.post({
            headers: {
                'Content-Type': 'application/json'
            },
            dataType: "text",
            url: "/players",
            data: JSON.stringify({ "username": username , "firstName": firstName, "lastName": lastName})
        })
            .done(function( ) {
                showOutput( "Saved -- reloading");
                loadData();
            })
            .fail(function( jqXHR, textStatus ) {
                showOutput( "Failed: " + textStatus );
            });
    }


    $("#add_player").on("click", addPlayer);

    loadData();
});