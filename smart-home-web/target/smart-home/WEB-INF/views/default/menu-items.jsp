<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="/" class="navbar-brand"><strong>SMART-HOME</strong></a>
    </div>
    <div class="collapse navbar-collapse navbar-ex1-collapse" role="navigation">
        <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="/">HOME</a></li>
            <%--<li><a href="about-us.html">ABOUT</a></li>--%>
            <li><a href="<c:url value='/contact'/>">CONTACT</a></li>
            <li><a href="<c:url value='/dashboard'/>">DASHBOARD</a></li>
            <sec:authorize ifNotGranted="ROLE_ANONYMOUS">
            <li><a href="<c:url value='/j_spring_security_logout'/>">Log out</a></li>
            </sec:authorize>

        </ul>
    </div>
</div>