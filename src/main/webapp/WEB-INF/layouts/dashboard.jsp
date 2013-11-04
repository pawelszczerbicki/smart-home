<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>

<head>
    <tiles:insertAttribute name="header"/>
</head>

<sec:authentication var="user" property="principal"/>
<body style="width: auto;" account-id="${user.account.id}">

<tiles:insertAttribute name="menu"/>
<tiles:insertAttribute name="body"/>



</body>
</html>