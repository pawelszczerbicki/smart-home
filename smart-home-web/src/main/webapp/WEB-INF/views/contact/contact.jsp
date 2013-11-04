<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <c:if test="${not empty success}">
        $.pnotify({
            text: '<s:message code="${success}"/>',
            type: 'success',
            hide: false,
            styling: 'jqueryui'
        });
        </c:if>
    })
</script>
<div id="contact">
    <div class="container">
        <div class="section_header">
            <h3>Get in touch</h3>
        </div>
        <div class="row contact">
            <form method="POST" action="<c:url value='/contact'/>">
                <div class="row form">
                    <div class="col-sm-6 row-col">
                        <div class="box">
                            <input class="name form-control" type="text" placeholder="Name" name="name" value="${contact.name}">
                            <input class="mail form-control" type="text" placeholder="Email" name="email" value="${contact.email}">
                            <input class="phone form-control" type="text" placeholder="Phone" name="phone" value="${contact.phone}">
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="box">
                            <textarea placeholder="Type a message here..." class="form-control" name="message">${contact.message}</textarea>
                        </div>
                    </div>
                </div>

                <div class="row submit">
                    <div class="col-md-3 right">
                        <input type="submit" value="Send your message">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="map">
        <div class="container">
            <div class="box_wrapp">
                <div class="box_cont">
                    <div class="head">
                        <h6>Contact</h6>
                    </div>
                    <ul class="street">
                        <li>Zygmunta Janiszewskiego 1</li>
                        <li>Wroclaw,</li>
                        <li>Polska</li>
                        <li class="icon icontop">
                            <span class="contacticos ico1"></span>
                            <span class="text">697 517 896</span>
                        </li>
                        <li class="icon">
                            <span class="contacticos ico2"></span>
                            <a class="text" href="#">szczerbicki.pawel@gmail.com</a>
                        </li>
                    </ul>

                    <div class="head headbottom">
                        <h6>Let us now</h6>
                    </div>
                    <p>Let us now if you are interested in our solution</p>

                    <a href="#" class="btn">Contact us</a>
                </div>
            </div>
        </div>
        <iframe width="100%" height="600" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.pl/maps?f=q&amp;source=s_q&amp;hl=pl&amp;geocode=&amp;q=Zygmunta+Janiszewskiego+11,+Wroc%C5%82aw&amp;aq=0&amp;oq=janiszewskiego+11+wroc%C5%82aw&amp;sll=51.127065,16.991864&amp;sspn=0.27235,0.617294&amp;ie=UTF8&amp;hq=&amp;hnear=Zygmunta+Janiszewskiego+11,+50-372+Wroc%C5%82aw,+Wojew%C3%B3dztwo+dolno%C5%9Bl%C4%85skie&amp;t=m&amp;z=14&amp;ll=51.10931,17.060698&amp;output=embed"></iframe>
    </div>
</div>
