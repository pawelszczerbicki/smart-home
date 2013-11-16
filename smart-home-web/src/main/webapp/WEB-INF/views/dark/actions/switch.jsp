<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="onoffswitch">
    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" device-id="${device.id}"
           id="onoffswitch-${device.id}" pin="${device.raspiPin}"
           <c:if test="${device.deviceState == 'ON'}">checked="checked"</c:if> />
    <label class="onoffswitch-label" for="onoffswitch-${device.id}">
        <div class="onoffswitch-inner"></div>
        <div class="onoffswitch-switch"></div>
    </label>
</div>