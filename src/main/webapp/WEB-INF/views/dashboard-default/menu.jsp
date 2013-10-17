<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header id="main-header">
    <div id="top-bar">
        <div class="inner dashboard-sized-el" style="max-width: 710px;">
            <div id="branding main-stat " role="branding">
                <a href="<c:url value='/'/>">
                   home
                </a>
            </div>
            <section id="account-admin" class="clear">
                <div id="admin-menu">
                    <div class="float-fix">
                        <a id="get-help" class="btn" href="http://support.geckoboard.com/home">Get help</a>
                    </div>
                    <div id="admin-menu-selector" class="toggle-menu">
                        <a id="admin-menu-toggle" class="btn" href="">
                            <img class="avatar" src="//www.gravatar.com/avatar/e32bd13e2add097461cb96824b7a829c?s=24&d=mm" alt="Account holder's avatar">
                        </a>
                        <nav id="admin-menu-options" class="menu-options" data-menuctx="account">
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
                                    <a id="account-option-logout" href="/logout">Logout</a>
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