<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/register" var="registerUrl"/>
<script>
    $(document).ready(function () {
        <c:forEach items="${errors}" var="error">
        $.pnotify({
            text: '<s:message code="${error}"/>',
            type: 'error',
            hide: false,
            styling: 'jqueryui'
        });
        </c:forEach>
        <c:forEach items="${success}" var="success">
        $.pnotify({
            text: '<s:message code="${success}"/>',
            type: 'success',
            hide: false,
            styling: 'jqueryui'
        });
        </c:forEach>
    })
</script>
<div id="sign_up1">
    <div class="container">
        <div class="row">
            <div class="col-md-12 header">
                <h4>Create your account</h4>
            </div>

            <div class="col-md-12 footer form-inline text-center">
                <form:form commandName="user" action="${registerUrl}">
                <form:input type="text" placeholder="Email" class="form-control" path="email"/>
                <form:input type="text" placeholder="Account domain" class="form-control" path="domain"/>
            </div>
            <div class="col-md-12 footer form-inline text-center">
                <form:input type="password" placeholder="Password" class="form-control" path="password"/>
                <form:input type="password" placeholder="Confirm Password" class="form-control" path="confirmPassword"/>
            </div>
            <div class="col-md-12 footer text-center h1">
                <input type="submit" value="register">
            </div>
            </form:form>


            <div class="col-md-12 dosnt">
                <span>Already have an account?</span>
                <a href="<c:url value='/login'/>">Login</a>
            </div>
        </div>
    </div>
</div>