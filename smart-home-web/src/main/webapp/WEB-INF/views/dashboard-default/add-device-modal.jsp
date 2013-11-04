<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="add-device-modal" class="modal open" style="display: none">
    <div class="inner">
        <div class="modal-display-area">
            <h2>Configure Dashboard</h2>
            <%--<div class="success"></div>--%>
            <div class="form-wrapper">
                <form class="light-ui" method="post" id="add-device-form" action="<c:url value='/dashboard/device/add-device'/>" >
                    <fieldset>
                        <div class=" form-field">
                            <label class="field-label">Device name</label>
                            <input class="" type="text" maxlength="40" autofocus="" value="" name="name">
                        </div>
                        <div class="col-2 form-field">

                            <label class="field-label">Device action</label>
                              <%--<span class="sneaky-select">--%>
                                  <%--<label>Sample</label>--%>
                            <select id="add-device-action-select" name="action">
                                <c:forEach items="${actions}" var="action">
                                <option value="${action}">${action}</option>
                                </c:forEach>
                            </select>
                           <%--</span>--%>
                        </div>
                        <div class="col-2 form-field">
                            <label class="field-label">Rasp Pin</label>
                             <%--<span class="sneaky-select">--%>
                                  <%--<label>Select PIN number</label>--%>
                            <select id="add-device-pin-select" name="pin">
                                <c:forEach begin="1" end="${pinAmount}" varStatus="pin">
                                    <option value="${pin.index}">PIN ${pin.index}</option>
                                </c:forEach>
                            </select>
                                <%--</span>--%>
                        </div>
                    </fieldset>
                    <a class="btn confirm" type="submit">Add dashboard</a>
                    <a class="btn cancel" id = "cancel-add-device" href="#">Cancel</a>
                </form>
            </div>

        </div>
    </div>
</div>