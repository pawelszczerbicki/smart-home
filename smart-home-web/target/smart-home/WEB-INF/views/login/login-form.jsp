<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:if test="${param.error==true}">
<script>
$(document).ready(function () {
    $(".form-inline").effect("shake", { times:3 }, 10);
})
</script>
</c:if>
<div id="sign_in1">
    <div class="container">
        <div class="row">
            <div class="col-md-12 header">
                <h4>Log in to your account</h4>
                <c:if test="${param.error==true}"><h4 class="text-danger">Wrong username or password</h4></c:if>
                <c:if test="${not empty errors}"><h4 class="text-danger"><s:message code="${errors}"/></h4></c:if>
                <c:if test="${not empty success}"><h4 class="text-success"><s:message code="${success}"/></h4></c:if>
            </div>
            <div class="col-md-12 footer <c:if test='${param.error==true}'>has-error</c:if>">
            <form class="form-inline" action="<c:url value='/j_spring_security_check' />" method="POST">

                    <input type="text" placeholder="Email or username" name = "j_username" class="form-control login-input">
                    <input type="password" placeholder="Password" name="j_password" class="form-control login-input">
                    <input type="submit" value="sign in">
                </form>
            </div>

            <div class="col-md-12 proof">
                <div class="col-md-6 remember">
                    <%--<label class="checkbox">--%>
                        <%--<input id="rememeberMe" type="checkbox" name="_spring_security_remember_me">--%>
                    <%--</label>--%>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                    Forgot your password?
                                </a>
                            </div>
                            <div id="collapseOne" class="accordion-body collapse" style="height: 0px; ">
                                <div class="accordion-inner">
                                    <br/>

                                        <form class="form-inline footer" style="text-align: left;" action="<c:url value='/forgot-password' />" method="POST">
                                            <input type="text" placeholder="Email or username" style="width: 50%" name = "username" class="form-control login-input">
                                            <input type="submit" value="reset">
                                        </form>

                                </div>
                            </div>
                        </div>
                </div>

                <div class="col-md-6">
                    <div class="dosnt">
                        <span>Do not have an account?</span>
                        <a href="<c:url value='/register'/>">Register</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>