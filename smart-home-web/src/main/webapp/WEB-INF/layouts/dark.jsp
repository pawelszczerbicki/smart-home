<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <tiles:insertAttribute name="header"/>
</head>

<sec:authentication var="user" property="principal"/>
<body account-id="${user.account.id}">
<tiles:insertAttribute name="menu"/>
<div id="body">
    <tiles:insertAttribute name="body"/>
</div>
<tiles:insertAttribute name="footer"/>

</body>
</html>


