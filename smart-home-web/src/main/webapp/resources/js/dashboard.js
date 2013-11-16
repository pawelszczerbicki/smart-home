$(document).ready(function () {
    registerModals();
    $("#message-submit").click(function () {
        var message = $("#message-content").val();
        if (message) {
            sendNotification(message);
        }
    });

    $(".confirm").click(function () {
        $("form#add-device-form").submit();
    });

    $('.onoffswitch-checkbox').change(function () {
        var deviceId = $(this).attr("device-id");
        var raspiPin = $(this).attr("pin");
        var action = "OFF";
        if ($(this).is(':checked')) {
            action = "ON";
        }
        sendActionMessage(deviceId, raspiPin, action);
    });

    $(".device-flicker-button").click(function () {
        var deviceId = $(this).attr("device-id");
        var raspiPin = $(this).attr("pin");
        sendActionMessage(deviceId, raspiPin, "FLICKER", 1000)
    });

    $('.slider').noUiSlider({
        range: [10,40]
        ,start: 10
        ,step: 1
        ,handles: 1
    }).change(function(){
            var deviceId = $(this).attr("device-id");
            var raspiPin = $(this).attr("pin");
            var val = $(this).val();
            sendActionMessage(deviceId, raspiPin, "ADJUST", val);
        });
});

function registerModals() {
    $('#sharing-url-menu-button').click(function () {
        $('#sharing-url-menu-nav').toggle();
    });

    $('#sharing-url-menu-nav, #sharing-url-menu-button, #add-widget, #add-device-modal, #admin-menu-toggle').click(function (e) {
        e.stopPropagation();
        return false;
    })

    $(document).click(function () {
        $('#sharing-url-menu-nav, #admin-menu-options, #add-device-modal').hide();
    });

    $('#add-widget').click(function () {
        $('#add-device-modal').toggle();
    });

    $('#admin-menu-toggle').click(function () {
        $('#admin-menu-options').toggle();
    });

    $('#cancel-add-device').click(function () {
        $('#add-device-modal').hide();
    });
}


