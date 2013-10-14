$(function () {
    var localhost_url = 'http://localhost:8080/chat/' + $("body").attr("account-id");
    var remote_url = 'http://pawelszczerbicki.pl:8080/smart-home/chat/' + $("body").attr("account-id");
    var content = $('#content');
    var input = $('#input');
    var status = $('#status');
    var myName = false;
    var author = null;
    var logged = false;
    var socket = $.atmosphere;
    var request = { url: localhost_url   ,
        contentType : "application/json",
        logLevel : 'debug',
        transport : 'websocket' ,
        trackMessageLength : true,
        fallbackTransport: 'long-polling'};
    var sampleNumber = 1;


    request.onOpen = function(response) {
        content.html($('<p>', { text: 'Atmosphere connected using ' + response.transport }));
        input.removeAttr('disabled').focus();
        status.text('Choose name:');
    };

    request.onMessage = function (response) {
        $("#deegrees").html(sampleNumber);
        sampleNumber = sampleNumber +1;
        var message = response.responseBody;
        console.log("reposnse body: " + message);
//        try {
//            var json = jQuery.parseJSON(message);
//        } catch (e) {
//            console.log('This doesn\'t look like a valid JSON: ', message);
//            return;
//        }
//            var type = json.type;
//        if(type === "WELCOME"){
//            alert("welcome");
//        }

//            var date =  typeof(json.time) == 'string' ? parseInt(json.time) : json.time;
//            addMessage(json.author, json.text, me ? 'blue' : 'black', new Date(date));
//        }
    };

    request.onClose = function(response) {
        logged = false;
    }

    request.onError = function(response) {
        content.html($('<p>', { text: 'Sorry, but there\'s some problem with your '
            + 'socket or the server is down' }));
    };

    var subSocket = socket.subscribe(request);
    $("#myButton").click(function(){
        subSocket.push(jQuery.stringifyJSON({ type: "INFO"}));
    });
    input.keydown(function(e) {
        if (e.keyCode === 13) {
            var msg = $(this).val();

            // First message is always the author's name
            if (author == null) {
                author = msg;
            }

            subSocket.push(jQuery.stringifyJSON({ author: author, message: msg }));
            $(this).val('');

            input.attr('disabled', 'disabled');
            if (myName === false) {
                myName = msg;
            }
        }
    });

    function addMessage(author, message, color, datetime) {
        content.append('<p><span style="color:' + color + '">' + author + '</span> @ ' +
            + (datetime.getHours() < 10 ? '0' + datetime.getHours() : datetime.getHours()) + ':'
            + (datetime.getMinutes() < 10 ? '0' + datetime.getMinutes() : datetime.getMinutes())
            + ': ' + message + '</p>');
    }
});

