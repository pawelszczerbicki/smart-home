<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="status-led led-medium led-margin led-red" id="connection-status-led"></div>

        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <h4 class="text-success"><div id="action-status-text"></div></h4>
                </li>
                <li>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control search-input" placeholder="Send message" id="message-content">
                        </div>
                        <button type="button" class="btn btn-default" id="message-submit">Send</button>
                    </form>
                </li>
                <li>
                        <div class=" navbar-form">
                            <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" >
                                <sec:authentication property="principal.email" /> <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#" data-toggle="modal" data-target="#addDeviceModal">Add device</a></li>
                                <li><a href="#" id="menu-deactivated">Deactivated</a></li>
                                <li><a href="#" id="menu-active">Active</a></li>
                                <li><a href="<c:url value='/dashboard'/>">Settings</a></li>
                                <li><a href="#" data-toggle="modal" data-target="#aboutModal">About</a></li>
                                <li class="divider"></li>
                                <li><a href="<c:url value='/j_spring_security_logout'/>">Log out</a></li>
                            </ul>
                        </div>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</div>
<%@include file="add-device-modal.jsp" %>
<%@include file="about-modal.jsp" %>
<br/><br/><br/><br/>
