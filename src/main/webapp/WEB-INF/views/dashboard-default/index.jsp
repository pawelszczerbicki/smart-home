<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="horizontal" value="0"/>
<c:set var="vertical" value="0"/>
<div style="max-width: 1190px; width: 1190px;" id="dashboard" class="dashboard-sized-el">
<c:forEach items="${devices}" var="device" varStatus="index">
    <article style="top: ${vertical}px; left: ${horizontal}px; width: auto;" id="widget-8486"
             class="widget custom-widgets loaded">
        <div class="widget-inner  widget-size-1x1 large-screen">
            <header>
                <h1>${device.name} (Pin: ${device.raspiPin}) <div id="read-value-${device.id}"></div></h1>
            </header>


            <a class="status-led led-widget led-small led-green-off" id="diode-${device.id}" href="#"></a>

            <section class="widget-body number-widget">
                <div class="widget-canvas">
                    <div class="main-stat t-size-x60" id="device-state-label-${device.id}">
                        ${device.deviceState}
                        <div id="get-value-div-pin-${device.raspiPin}"></div>
                    </div>


                    <a></a>

                    <c:if test="${device.hasAction('SWITCH')}">
                        <%@include file="actions/switch.jsp" %>
                    </c:if>
                    <c:if test="${device.hasAction('FLICKER')}">
                        <%@include file="actions/flicker.jsp" %>
                    </c:if>
                    <div class="noUiSlider" device-id="${device.id}" pin = "${device.raspiPin}"></div>
                </div>


                <!-- .widget-canvas -->
            </section>


        </div>
        <!-- .widget-inner -->

    </article>
    <c:set var="horizontal" value="${horizontal + 240}"/>
    <c:if test="${index.index % 4 == 0 and index.index > 0}">
        <c:set var="horizontal" value="0"/>
        <c:set var="vertical" value="${vertical + 240}"/>
    </c:if>
</c:forEach>
<%@include file="add-device-modal.jsp" %>

</div>



