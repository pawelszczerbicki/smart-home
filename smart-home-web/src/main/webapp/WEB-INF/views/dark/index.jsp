<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <c:forEach items="${devices}" var="device">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail box">
                    <div class="caption">
                        <h2 style="height: 40px; margin-top: 0px; padding-bottom: 10px; border-bottom: 1px solid #d3d4d4;">
                            <c:if test="${device.hasAction('SWITCH')}">
                                <div class="onoffplaceholder">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"
                                               device-id="${device.id}" id="onoffswitch-${device.id}"
                                               pin="${device.raspiPin}"
                                               <c:if test="${device.deviceState == 'ON'}">checked="checked"</c:if>
                                                >

                                        <label class="onoffswitch-label" for="onoffswitch-${device.id}">
                                            <div class="onoffswitch-inner"></div>
                                            <div class="onoffswitch-switch"></div>
                                        </label>
                                    </div>
                                </div>
                            </c:if>
                            <div class="pull-right">${device.name}</div>
                        </h2>
                        <h4>Pin: ${device.raspiPin} </h4>
                        <h4>State: <span id="device-state-label-${device.id}">${device.deviceState}</span></h4>
                        <c:if test="${device.hasAction('READ')}">
                            <h1 class="text-center" style="font-size: 60px;">30 K</h1>
                        </c:if>
                        <c:if test="${device.hasAction('ADJUST')}">
                            <div class="slider" style="height: 80px; margin-top: 20px;"></div>
                        </c:if>
                        <div class="row">
                            <div class="col-md-6">
                                <c:if test="${device.hasAction('FLICKER')}">
                                    <a href="#" class="btn btn-primary btn-block device-flicker-button" role="button"
                                       id="flicker-${device.id}" device-id="${device.id}" pin="${device.raspiPin}">Flicker</a>
                                </c:if>
                            </div>
                            <div class="col-md-6">
                                <div class="btn-group btn-block ">
                                    <button type="button" class="btn btn-default btn-block dropdown-toggle"
                                            data-toggle="dropdown">
                                        Change <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li class="dropdown-submenu">
                                            <a tabindex="-1" href="#">Add action</a>
                                            <ul class="dropdown-menu">
                                                <c:forEach items="${actions}" var="action">
                                                    <c:if test="${!device.hasAction(action)}">
                                                        <li><a href="#" class="add-action-menu" device-id="${device.id}" action="${action}">${action}</a></li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                        <li class="dropdown-submenu">
                                            <a tabindex="-1" href="#">Remove action</a>
                                            <ul class="dropdown-menu">
                                                <c:forEach items="${actions}" var="action">
                                                    <c:if test="${device.hasAction(action)}">
                                                        <li><a href="#" class="remove-action-menu" device-id="${device.id}" action="${action}">${action}</a></li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                        <li><a href="#" class="remove-device" device-id="${device.id}">Remove</a></li>
                                        <li><a href="#" class="deactivate-device"
                                               device-id="${device.id}">Deactivate</a></li>
                                        <li><a href="#">Schedule action</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Details</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>
<!-- /container -->
