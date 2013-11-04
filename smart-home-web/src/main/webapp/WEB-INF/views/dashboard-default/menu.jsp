<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="main-header">
    <div id="top-bar">
        <div class="inner dashboard-sized-el">
        </div>
        <div class="inner dashboard-sized-el">
            <a href="#" data-toggle="tooltip" title="first tooltip" id="status-led-tooltip">
            <div class="status-led led-medium led-red" id="connection-status-led"></div>
            </a>
            <section id="account-admin" class="clear">
                <div id="admin-menu">
                    <div class="float-fix">
                        <a id="add-widget" class="btn" href="#">Add device</a>
                    </div>

                    <div id="sharing-url-menu" class="toggle-menu">
                        <a id="sharing-url-menu-button" class="btn" href="#">
                            <span class="sharing"></span>
                        </a>
                        <nav id="sharing-url-menu-nav" class="menu-options" data-menuctx="sharing-url" style="display: none;">
                            <ul>
                                <li class="label">Type to all users</li>
                                <li class="control">
                                    <div class="url">
                                        <input class="" type="text" placeholder="Type message here" id="share-message-content">
                                    </div>
                                    <span class="sharing-regenerate sharing-action" id="share-message-submit"></span>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <div id="admin-menu-selector" class="toggle-menu">
                        <a id="admin-menu-toggle" class="btn active" href="#">
                            <img class="avatar" src="//www.gravatar.com/avatar/e32bd13e2add097461cb96824b7a829c?s=24&d=mm" alt="Account holder's avatar">
                        </a>
                        <nav id="admin-menu-options" class="menu-options" data-menuctx="account" style="display: none;">
                            <ul>
                                <li>
                                    <a id="account-option-messages" href="" data-intercom_original_html="Messages" style="visibility: visible;">Messages</a>
                                </li>
                                <li>
                                    <a id="account-option-account" href="/account">Your account</a>
                                </li>
                                <li>
                                    <a id="account-option-help-chat" href="">Live Chat Help</a>
                                </li>
                                <li>
                                    <a id="account-option-logout" href="<c:url value='/j_spring_security_logout'/>">Logout</a>
                                </li>
                            </ul>
                        </nav>

                    </div>
                </div>
            </section>
        </div>
    </div>
</header>
<br/> <br/><br/> <br/><br/>