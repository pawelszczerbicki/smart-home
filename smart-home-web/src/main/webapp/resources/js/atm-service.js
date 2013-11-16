var subSocket;
$(function () {
    var localhost_url = 'http://localhost:8080/chat/' + $("body").attr("account-id");
    var remote_url = 'http://pawelszczerbicki.pl:8080/smart-home/chat/' + $("body").attr("account-id");
    var content = $('#content');
    var input = $('#input');
    var status = $('#status');
    var statusLed = $('#connection-status-led');
    var logged = false;
    var socket = $.atmosphere;
    var request = { url: localhost_url,
        contentType: "application/json",
        logLevel: 'debug',
        transport: 'websocket',
        trackMessageLength: true,
        fallbackTransport: 'long-polling'};

    request.onOpen = function (response) {
        statusLed.removeClass('led-red').addClass('led-green');
    };

    request.onMessage = function (response) {
        var msgBody = response.responseBody;
        console.log("reposnse body: " + msgBody);
        onAnyMessage();
        try {
            var msg = jQuery.parseJSON(msgBody);
        } catch (e) {
            console.log('This doesn\'t look like a valid JSON: ', msgBody);
            return;
        }
        var type = msg.type;

        if (type === "HEARTBEAT") {
            onHeartbeat();
        } else if (type === "NOTIFICATION") {
            onNotification(msg.message);
        } else if (type === "ACTION") {
            onAction(msg.action, msg.deviceId, msg.message, msg.raspiPin)
        }
    };


    request.onClose = function (response) {
        logged = false;
    }

    request.onError = function (response) {
        statusLed.removeClass('led-green').addClass('led-red');
        content.html($('<p>', { text: 'Sorry, but there\'s some problem with your '
            + 'socket or the server is down' }));
    };

    subSocket = socket.subscribe(request);

    function onHeartbeat() {
        flicker(statusLed, "led-green", "led-blue", 200);
    }

    function onAnyMessage() {
        flicker(statusLed, "led-green", "led-orange", 100);
    }

    function onNotification(message) {

        $.pnotify({
            text: message,
            type: 'info',
            hide: false,
            nonblock_opacity: .2,
            closer_hover: false,
            animation: 'show',
            styling: 'jqueryui'
        });
    }

    function onAction(action, deviceId, message, raspiPin) {
        var state = $("#device-state-label-" + deviceId);
        if (action === "ON") {
            serviceOnAction(deviceId, action, state);
        } else if (action === "OFF") {
            serviceOffAction(deviceId,action, state);
        } else if (action === "FLICKER") {
            serviceFlickerAction(message, deviceId);
        } else if(action === "ADJUST"){
            serviceAdjustAction(message, deviceId);
        } else if(action === "READ"){
            serviceReadAction(message, raspiPin);
        }
    }

    function serviceOnAction(deviceId, action, state) {
        state.html(action);
        $("#onoffswitch-" + deviceId).attr("checked", true);
    }

    function serviceOffAction(deviceId, action, state) {
        state.html(action);
        $("#onoffswitch-" + deviceId).removeAttr("checked");
    }

    function serviceFlickerAction(message, deviceId){
        var time = message ? message : 500;
        $("#action-status-text").fadeIn("slow").html("Performed");
        setTimeout(function(){
            $("#action-status-text").fadeIn("slow").html("");
        }, time) ;
    }

    function serviceAdjustAction(message, deviceId) {
        alert(message);
        $('#read-value-'+deviceId).html(message);
    }

    function serviceReadAction(message,raspiPin) {
        $('#get-value-div-pin-'+raspiPin).html(message);
    }

    function flicker(object, removeClass, addClass, time) {
        object.removeClass(removeClass).addClass(addClass);
        setTimeout(function () {
            object.removeClass(addClass).addClass(removeClass);
        }, time);
    }
});


function sendNotification(message) {
    subSocket.push(jQuery.stringifyJSON({message: message, type: 'NOTIFICATION' }));
}

function sendActionMessage(deviceId, raspiPin, action, message) {
    subSocket.push(jQuery.stringifyJSON({deviceId: deviceId, raspiPin: raspiPin, action: action, type: 'ACTION', message: message }));
}



