$(document).ready(function () {

});


$(document).on("click", "#message-submit", function () {
    var message = $("#message-content").val();
    if (message) {
        sendNotification(message);
    }
});

$(document).on("click", ".confirm", function () {
    $("form#add-device-form").submit();
});

$(document).on("change", '.onoffswitch-checkbox', function () {
    var deviceId = $(this).attr("device-id");
    var raspiPin = $(this).attr("pin");
    var action = "OFF";
    if ($(this).is(':checked')) {
        action = "ON";
    }
    sendActionMessage(deviceId, raspiPin, action);
});

$(document).on("click", ".device-flicker-button", function () {
    var deviceId = $(this).attr("device-id");
    var raspiPin = $(this).attr("pin");
    sendActionMessage(deviceId, raspiPin, "FLICKER", 1000)
});

$(document).on("click", ".remove-device", function () {
    var deviceId = $(this).attr("device-id");
    $.ajax({
        url: "/dashboard/device/" + deviceId + "?fragments=body",
        beforeSend: function (req) {
            req.setRequestHeader("Accept", "text/html;type=ajax");
        },
        type: "DELETE",
        success: function (data) {
            $("#body").html(data);
        }
    });
});

$(document).on("click", ".deactivate-device", function () {
    var device = $(this).attr("device-id");
    $.ajax({
        url: "/dashboard/device/deactivate?fragments=body",
        beforeSend: function (req) {
            req.setRequestHeader("Accept", "text/html;type=ajax");
        },
        type: "POST",
        data: {deviceId: device},
        success: function (data) {
            $("#body").html(data);
        }
    });
});

$(document).on("click", ".activate-device", function () {
    var device = $(this).attr("device-id");
    sendPost("deviceId=" + device, "/dashboard/device/activate?fragments=body");
});

$(document).on("click", "#menu-deactivated", function () {
    sendGet("/dashboard/device/deactivated?fragments=body");
});

$(document).on("click", "#menu-active", function () {
    sendGet("/dashboard?fragments=body");
});

$(document).on("click", ".add-action-menu", function () {
    var device = $(this).attr("device-id");
    var action = $(this).attr("action");
    var data ="deviceId=" + device + "&action="+action;
    sendPost(data, "/dashboard/device/add-action?fragments=body")
});

$(document).on("click", ".remove-action-menu", function () {
    var device = $(this).attr("device-id");
    var action = $(this).attr("action");
    var data ="deviceId=" + device + "&action="+action;
    sendPost(data, "/dashboard/device/remove-action?fragments=body")
});

function sendPost(data, url) {
    $.ajax({
        url: url,
        beforeSend: function (req) {
            req.setRequestHeader("Accept", "text/html;type=ajax");
        },
        type: "POST",
        data: data,
        success: function (data) {
            $("#body").html(data);
            runSlider();
        }
    });
}
function sendGet(url) {
    $.ajax({
        url: url,
        beforeSend: function (req) {
            req.setRequestHeader("Accept", "text/html;type=ajax");
        },
        type: "GET",
        success: function (data) {
            $("#body").html(data);
        }
    });
}
function runSlider(){
    $('.slider').noUiSlider({
        range: [10, 40], start: 10, step: 1, handles: 1
    }).change(function () {
            var deviceId = $(this).attr("device-id");
            var raspiPin = $(this).attr("pin");
            var val = $(this).val();
            sendActionMessage(deviceId, raspiPin, "ADJUST", val);
        });
}


