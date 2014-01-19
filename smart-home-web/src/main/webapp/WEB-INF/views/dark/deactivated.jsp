<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <c:forEach items="${devices}" var="device">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail box">
                    <div class="caption">
                        <h2 style="height: 40px; margin-top: 0px; padding-bottom: 10px; border-bottom: 1px solid #d3d4d4;">
                            <div class="pull-right">${device.name}</div>
                        </h2>
                        <h4>Pin: ${device.raspiPin} </h4>
                        <h4>State: <span id="device-state-label-${device.id}">${device.deviceState}</span></h4>
                        <div class="row">
                            <div class="col-md-6">
                            </div>
                            <div class="col-md-6">
                                <div class="btn-group btn-block ">
                                    <button type="button" class="btn btn-default btn-block dropdown-toggle" data-toggle="dropdown">
                                        Change <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#" class="remove-device" device-id="${device.id}">Remove</a></li>
                                        <li><a href="#" class="activate-device" device-id="${device.id}">Activate</a></li>
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
</div> <!-- /container -->