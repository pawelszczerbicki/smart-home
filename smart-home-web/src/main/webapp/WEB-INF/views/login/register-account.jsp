<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/account" var="registerUrl"/>
<div id="sign_in2">
    <div class="container">
        <div class="section_header">
            <h3>Dont have account?</h3>
        </div>
        <div class="row login">
            <div class="col-sm-5 left_box">
                <h4>Create account and profile!</h4>

                <div class="perk_box">
                    <div class="perk">
                        <p>Please provide <strong>REAL</strong> email address. After registering you will be prompted to
                            confirm all provided data</p>
                    </div>
                    <div class="perk">
                        <p>After registering you will be only <strong>administrator</strong> of this account. Every new
                            person creating profile on this account will be waiting to your confirmation</p>
                    </div>
                </div>
            </div>

            <div class="col-sm-6 signin_box">
                <div class="box">
                    <div class="box_cont">
                        <div class="form">
                            <form:form commandName="account" action="${registerUrl}">
                                <form:input type="text" placeholder="Admin email" class="form-control" path="email"/>
                                <form:input type="text" placeholder="New account domain" class="form-control"
                                            path="domain"/>
                                <form:input type="password" placeholder="Admin password" class="form-control"
                                            path="password"/>
                                <input type="submit" value="Create account">
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>