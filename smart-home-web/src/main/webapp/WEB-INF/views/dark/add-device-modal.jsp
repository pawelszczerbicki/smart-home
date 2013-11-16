<div class="modal fade" id="addDeviceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Add device</h4>
            </div>
            <form class="light-ui" method="post" id="add-device-form"
                  action="<c:url value='/dashboard/device/add-device'/>">
                <div class="modal-body">

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
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->