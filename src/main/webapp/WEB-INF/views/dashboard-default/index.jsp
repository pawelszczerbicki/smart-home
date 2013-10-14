<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="jquery/jquery-1.9.0.js"></script>
    <script type="text/javascript" src="jquery/jquery.atmosphere.js"></script>
    <script src="<c:url value='/resources/dashboard/js/tracker.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/dashboard/js/library.js'/>" async="" type="text/javascript"></script>
    <script src="<c:url value='/resources/dashboard/js/mixpanel.js'/>" async="" type="text/javascript"></script>
    <script src="<c:url value='/resources/dashboard/js/ga.js'/>" async="" type="text/javascript"></script>
    <script src="<c:url value='/resources/dashboard/atm-service.js'/>" async="" type="text/javascript"></script>
    <meta charset="utf-8">
    <link href="<c:url value='/resources/dashboard/css/dashboard.css'/>" media="screen" rel="stylesheet"type="text/css">


    <title>Default dashboard</title>
    <style> .dashboard-sized-el {
        max-width: 1190px
    } </style>
    <link href="<c:url value='/resources/dashboard/css/d.css'/>" rel="stylesheet">
</head>
<sec:authentication var="user" property="principal"/>
<body style="width: auto;" account-id="${user.account.id}">
<header id="main-header">
<div id="top-bar">
    <div class="inner dashboard-sized-el" style="max-width: 710px;">
        <div id="branding" role="branding">
            <a href="/">
                <img src="https://d28q98t4icjy0h.cloudfront.net/assets/logo-dark-afed709a60be6d966a7270226fd3e1ee.png" alt="Logo-dark">
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
    <%--<div id="dashboard-admin-bar" class="clear">--%>
        <%--<div class="inner dashboard-sized-el" style="max-width: 710px;">--%>
            <%--<a id="add-widget" class="btn" href="#">Add widget</a>--%>
            <%--<section id="dashboard-admin">--%>
                <%--<div class="float-fix">--%>
                    <%--<span>Dashboard:</span>--%>
                <%--</div>--%>
                <%--<div id="switch-dashboard" class="btn">--%>
                    <%--<span id="selected-dashboard-title">Default dashboard</span>--%>
                    <%--<div id="dashboard-selection-list" style="display: none;">--%>
                        <%--<ul style="max-height: 160px;">--%>
                            <%--<li>--%>
                                <%--<a class="dashboard" data-id="64868" href="#">Default dashboard</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                        <%--<a id="add-new-dashboard" class="dashboard" data-id="0" href="#">--%>
                            <%--<span>Add dashboard</span>--%>
                        <%--</a>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div id="dashboard-settings" class="toggle-menu">--%>
                    <%--<a class="btn" href="#">--%>
                        <%--<span></span>--%>
                    <%--</a>--%>
                    <%--<nav class="menu-options" data-menuctx="dashboard" style="display: none;">--%>
                        <%--<ul>--%>
                            <%--<li>--%>
                                <%--<a id="dash-settings-general" href="">General settings</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a id="dash-settings-copy" href="">Copy dashboard</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</nav>--%>
                <%--</div>--%>
                <%--<div id="sharing-url-menu" class="toggle-menu">--%>
                    <%--<a class="btn" href="#">--%>
                        <%--<span class="sharing"></span>--%>
                    <%--</a>--%>
                    <%--<nav id="sharing-url-menu-nav" class="menu-options" data-menuctx="sharing-url" style="display: none;">--%>
                        <%--<ul>--%>
                            <%--<li class="label">Sharing URL</li>--%>
                            <%--<li class="control">--%>
                                <%--<div class="url">--%>
                                    <%--<input type="text" readyonly="" value="URL here">--%>
                                <%--</div>--%>
                                <%--<span class="sharing-lock sharing-action" title="Toggle sharing"> </span>--%>
                                <%--<span class="sharing-regenerate sharing-action" title="Regenerate sharing URL"> </span>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</nav>--%>
                <%--</div>--%>
            <%--</section>--%>
        <%--</div>--%>
        <%--<a id="toggle-header" href="#" class="" style="bottom: 0px;"></a>--%>
    <%--</div>--%>
</header>
  <br/> <br/><br/> <br/><br/>
<div style="max-width: 1190px; width: 1190px; height: 930px;" id="dashboard" class="dashboard-sized-el">
<article style="top: 0px; left: 480px; width: auto;" id="widget-8486" class="widget custom-widgets loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Conversion Rate (30 Days)</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body number-widget">
            <div class="widget-canvas">

                <div class="main-stat t-size-x60">
                    <span class="comma">0.</span>11
                </div>


                <div class="secondary-stat t-size-x48 negative arrow-down-medium">
                    <span>21<sup>.43%</sup></span>
                </div>


            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 0px; left: 720px; width: auto;" id="widget-8487" class="widget custom-widgets loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Retention rate (90 days)</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body number-widget">
            <div class="widget-canvas">

                <div class="main-stat t-size-x60">
                    <span class="comma">0.</span>79
                </div>


                <div class="secondary-stat t-size-x48 positive arrow-up-medium">
                    <span>5<sup>.33%</sup></span>
                </div>


            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 0px; left: 960px; width: auto;" id="widget-8488" class="widget custom-widgets loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Viral coefficient (90 days)</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body number-widget">
            <div class="widget-canvas">

                <div class="main-stat t-size-x60">
                    <span class="comma">0.</span>82
                </div>


                <div class="secondary-stat t-size-x48 positive arrow-up-medium">
                    <span>27<sup>.93%</sup></span>
                </div>


            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 0px; left: 0px; width: auto;" id="widget-8494" class="widget clock loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header class="no-reload">
            <h1>New York</h1>
        </header>


        <section class="widget-body clock-widget">
            <div class="widget-canvas">

                <time class="time t-size-x60">4:26<sub>PM</sub></time>

                <time class="date t-secondary t-size-x20">
                    <span class="day">Sunday</span>
                    <span class="full-date">15 Sep 2013</span>
                </time>
            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 240px; left: 0px; width: auto;" id="widget-69099" class="widget custom-widgets loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>New vs Returning Users</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body highchart-widget">
            <div data-highcharts-chart="3" class="widget-canvas">
                <div style="position: relative; overflow: hidden; width: 198px; height: 149px; text-align: left; line-height: normal; z-index: 0; font-family: &quot;Lucida Grande&quot;,&quot;Lucida Sans Unicode&quot;,Verdana,Arial,Helvetica,sans-serif; font-size: 12px; left: 0.5px; top: 0.199997px;"
                     id="highcharts-8" class="highcharts-container">
                    <svg height="149" width="198" version="1.1" xmlns="http://www.w3.org/2000/svg">
                        <desc>Created with Highcharts 3.0.2</desc>
                        <defs>
                            <clipPath id="highcharts-9">
                                <rect height="88" width="178" y="0" x="0" fill="none"></rect>
                            </clipPath>
                        </defs>
                        <rect fill-opacity="0" height="149" width="198" y="0" x="0" fill="rgb(35,37,38)" ry="5"
                              rx="5"></rect>
                        <rect fill-opacity="0" height="88" width="178" y="10" x="10" fill="rgb(35,37,38)" ry="0"
                              rx="0"></rect>
                        <g zIndex="3" class="highcharts-series-group">
                            <g style="cursor:pointer;" transform="translate(10,10) scale(1 1)" zIndex="0.1"
                               visibility="visible" class="highcharts-series highcharts-tracker">
                                <path transform="translate(0,0)" stroke-linejoin="round" stroke-width="1"
                                      stroke="#FFFFFF"
                                      d="M 88.99307511107436 10.000000705207164 A 34 34 0 0 1 99.52717564393883 76.32922165721997 L 89 44 A 0 0 0 0 0 89 44 Z"
                                      fill="#058DC7"></path>
                                <path transform="translate(-10,2)" stroke-linejoin="round" stroke-width="1"
                                      stroke="#FFFFFF"
                                      d="M 99.49484116408243 76.33973266649991 A 34 34 0 1 1 88.95277468210557 10.000032797525378 L 89 44 A 0 0 0 1 0 89 44 Z"
                                      fill="#50B432"></path>
                            </g>
                            <g transform="translate(10,10) scale(1 1)" zIndex="0.1" visibility="visible"
                               class="highcharts-markers"></g>
                        </g>
                        <g transform="translate(15,103)" zIndex="7" class="highcharts-legend">
                            <rect visibility="visible" stroke-width="1" stroke="rgb(35,37,38)" stroke-opacity="0"
                                  height="30" width="167" y="0.5" x="0.5" fill="none" ry="5" rx="5"></rect>
                            <g zIndex="1">
                                <g>
                                    <g transform="translate(8,3)" zIndex="1" class="highcharts-legend-item">
                                        <text zIndex="2" text-anchor="start"
                                              style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;cursor:pointer;color:#274b6d;fill:#274b6d;"
                                              y="15" x="21">
                                            <tspan x="21">New</tspan>
                                        </text>
                                        <rect zIndex="3" height="12" width="16" y="4" x="0" fill="#058DC7" ry="2"
                                              rx="2"></rect>
                                    </g>
                                    <g transform="translate(88,3)" zIndex="1" class="highcharts-legend-item">
                                        <text zIndex="2" text-anchor="start"
                                              style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;cursor:pointer;color:#274b6d;fill:#274b6d;"
                                              y="15" x="21">
                                            <tspan x="21">Returning</tspan>
                                        </text>
                                        <rect zIndex="3" height="12" width="16" y="4" x="0" fill="#50B432" ry="2"
                                              rx="2"></rect>
                                    </g>
                                </g>
                            </g>
                        </g>
                        <g transform="translate(0,0)" visibility="hidden"
                           style="cursor:default;padding:0;white-space:nowrap;" zIndex="8" class="highcharts-tooltip">
                            <rect transform="translate(1, 1)" stroke-width="5" stroke-opacity="0.049999999999999996"
                                  stroke="black" isShadow="true" fill-opacity="0.85" height="16" width="16" y="0.5"
                                  x="0.5" fill="none" ry="3" rx="3"></rect>
                            <rect transform="translate(1, 1)" stroke-width="3" stroke-opacity="0.09999999999999999"
                                  stroke="black" isShadow="true" fill-opacity="0.85" height="16" width="16" y="0.5"
                                  x="0.5" fill="none" ry="3" rx="3"></rect>
                            <rect transform="translate(1, 1)" stroke-width="1" stroke-opacity="0.15" stroke="black"
                                  isShadow="true" fill-opacity="0.85" height="16" width="16" y="0.5" x="0.5" fill="none"
                                  ry="3" rx="3"></rect>
                            <rect fill-opacity="0.85" height="16" width="16" y="0.5" x="0.5" fill="rgb(255,255,255)"
                                  ry="3" rx="3"></rect>
                            <text zIndex="1"
                                  style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#333333;fill:#333333;"
                                  y="21" x="8"></text>
                        </g>
                    </svg>
                </div>
            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 480px; left: 0px; width: auto;" id="widget-69100" class="widget custom-widgets loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Account Types</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body highchart-widget">
            <div data-highcharts-chart="4" class="widget-canvas">
                <div style="position: relative; overflow: hidden; width: 198px; height: 149px; text-align: left; line-height: normal; z-index: 0; font-family: &quot;Lucida Grande&quot;,&quot;Lucida Sans Unicode&quot;,Verdana,Arial,Helvetica,sans-serif; font-size: 12px; left: 0.5px; top: 0.200012px;"
                     id="highcharts-10" class="highcharts-container">
                    <svg height="149" width="198" version="1.1" xmlns="http://www.w3.org/2000/svg">
                        <desc>Created with Highcharts 3.0.2</desc>
                        <defs>
                            <clipPath id="highcharts-11">
                                <rect height="88" width="178" y="0" x="0" fill="none"></rect>
                            </clipPath>
                        </defs>
                        <rect fill-opacity="0" height="149" width="198" y="0" x="0" fill="rgb(35,37,38)" ry="5"
                              rx="5"></rect>
                        <rect fill-opacity="0" height="88" width="178" y="10" x="10" fill="rgb(35,37,38)" ry="0"
                              rx="0"></rect>
                        <g zIndex="3" class="highcharts-series-group">
                            <g style="cursor:pointer;" transform="translate(10,10) scale(1 1)" zIndex="0.1"
                               visibility="visible" class="highcharts-series highcharts-tracker">
                                <path transform="translate(0,0)" stroke-linejoin="round" stroke-width="1"
                                      stroke="#FFFFFF"
                                      d="M 88.99307511107436 10.000000705207164 A 34 34 0 1 1 62.786453564036215 22.347056014260545 L 89 44 A 0 0 0 1 0 89 44 Z"
                                      fill="#058DC7"></path>
                                <path transform="translate(-5,-9)" stroke-linejoin="round" stroke-width="1"
                                      stroke="#FFFFFF"
                                      d="M 62.808119611185255 22.320853298664602 A 34 34 0 0 1 84.71420630367597 10.271199659748504 L 89 44 A 0 0 0 0 0 89 44 Z"
                                      fill="#50B432"></path>
                                <path transform="translate(0,0)" stroke-linejoin="round" stroke-width="1"
                                      stroke="#FFFFFF"
                                      d="M 84.74793724129144 10.266930731165246 A 34 34 0 0 1 88.95277468210557 10.000032797525378 L 89 44 A 0 0 0 0 0 89 44 Z"
                                      fill="#EF561A"></path>
                            </g>
                            <g transform="translate(10,10) scale(1 1)" zIndex="0.1" visibility="visible"
                               class="highcharts-markers"></g>
                        </g>
                        <g transform="translate(-1,103)" zIndex="7" class="highcharts-legend">
                            <rect visibility="visible" stroke-width="1" stroke="rgb(35,37,38)" stroke-opacity="0"
                                  height="30" width="207" y="0.5" x="0.5" fill="none" ry="5" rx="5"></rect>
                            <g zIndex="1">
                                <g>
                                    <g transform="translate(8,3)" zIndex="1" class="highcharts-legend-item">
                                        <text zIndex="2" text-anchor="start"
                                              style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;cursor:pointer;color:#274b6d;fill:#274b6d;"
                                              y="15" x="21">
                                            <tspan x="21">Free</tspan>
                                        </text>
                                        <rect zIndex="3" height="12" width="16" y="4" x="0" fill="#058DC7" ry="2"
                                              rx="2"></rect>
                                    </g>
                                    <g transform="translate(63,3)" zIndex="1" class="highcharts-legend-item">
                                        <text zIndex="2" text-anchor="start"
                                              style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;cursor:pointer;color:#274b6d;fill:#274b6d;"
                                              y="15" x="21">
                                            <tspan x="21">Basic</tspan>
                                        </text>
                                        <rect zIndex="3" height="12" width="16" y="4" x="0" fill="#50B432" ry="2"
                                              rx="2"></rect>
                                    </g>
                                    <g transform="translate(118,3)" zIndex="1" class="highcharts-legend-item">
                                        <text zIndex="2" text-anchor="start"
                                              style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;cursor:pointer;color:#274b6d;fill:#274b6d;"
                                              y="15" x="21">
                                            <tspan x="21">Premium</tspan>
                                        </text>
                                        <rect zIndex="3" height="12" width="16" y="4" x="0" fill="#EF561A" ry="2"
                                              rx="2"></rect>
                                    </g>
                                </g>
                            </g>
                        </g>
                        <g transform="translate(0,0)" visibility="hidden"
                           style="cursor:default;padding:0;white-space:nowrap;" zIndex="8" class="highcharts-tooltip">
                            <rect transform="translate(1, 1)" stroke-width="5" stroke-opacity="0.049999999999999996"
                                  stroke="black" isShadow="true" fill-opacity="0.85" height="16" width="16" y="0.5"
                                  x="0.5" fill="none" ry="3" rx="3"></rect>
                            <rect transform="translate(1, 1)" stroke-width="3" stroke-opacity="0.09999999999999999"
                                  stroke="black" isShadow="true" fill-opacity="0.85" height="16" width="16" y="0.5"
                                  x="0.5" fill="none" ry="3" rx="3"></rect>
                            <rect transform="translate(1, 1)" stroke-width="1" stroke-opacity="0.15" stroke="black"
                                  isShadow="true" fill-opacity="0.85" height="16" width="16" y="0.5" x="0.5" fill="none"
                                  ry="3" rx="3"></rect>
                            <rect fill-opacity="0.85" height="16" width="16" y="0.5" x="0.5" fill="rgb(255,255,255)"
                                  ry="3" rx="3"></rect>
                            <text zIndex="1"
                                  style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#333333;fill:#333333;"
                                  y="21" x="8"></text>
                        </g>
                    </svg>
                </div>
            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 480px; left: 720px; width: auto;" id="widget-14719297" class="widget chartbeat loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Live Visitors</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body geckometer-widget">
            <div class="widget-canvas">

                <div class="value t-size-x48">7</div>
                <div class="scale">
                    <div style="left: 29px; bottom: -10px;" class="pointer-canvas">
                        <img style="transform: rotate(-60deg);" class="pointer"
                             src="<c:url value='/resources/dashboard/geckometer-pointer.png'/>">
                    </div>
                </div>
                <div class="min">
                    <div class="t-size-x14 t-secondary">30 day min</div>
                    <div class="t-size-x14 negative">0</div>
                </div>
                <div class="max">
                    <div class="t-size-x14 t-secondary">30 day max</div>
                    <div class="t-size-x14 positive">103</div>
                </div>
            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 0px; left: 240px; width: auto;" id="widget-14730216" class="widget pingdom loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Uptime</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body monitoring-widget">
            <div class="widget-canvas">

                <div class="status t-size-x60 positive arrow-up-large">up</div>
                <div class="server-times">
                    <div class="server-time downtime">
                        <div class="label t-size-x10">Last downtime</div>
                        <div class="t-size-x24 t-main">80d 22h</div>
                    </div>
                    <div class="server-time uptime">
                        <div class="label t-size-x10">Response time</div>
                        <div class="t-size-x24 t-main">319ms</div>
                    </div>
                </div>
            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 480px; left: 960px; width: auto;" id="widget-14778024" class="widget uservoice loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Customer Feedback</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body ragcolumn-widget">
            <div class="widget-canvas">

                <div class="column">

                    <div class="negative" style="height:25%"></div>

                    <div class="level" style="height:63%"></div>

                    <div class="positive" style="height:13%"></div>

                </div>
                <table>

                    <tbody>
                    <tr>
                        <td class="t-size-x36 number negative">
                            2
                        </td>
                        <td class="t-secondary">inbox</td>
                    </tr>

                    <tr>
                        <td class="t-size-x36 number level">
                            5
                        </td>
                        <td class="t-secondary">active</td>
                    </tr>

                    <tr>
                        <td class="t-size-x36 number positive">
                            1
                        </td>
                        <td class="t-secondary">closed</td>
                    </tr>

                    </tbody>
                </table>
            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 240px; left: 240px; width: auto;" id="widget-14808658" class="widget google-analytics loaded">
    <div class="widget-inner  widget-size-2x2 large-screen">

        <header>
            <h1>Unique Visitors (30 days)</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body number-widget">
            <div class="widget-canvas">

                <div class="t-secondary t-size-x36">
                    <sec:authorize ifNotGranted="ROLE_ANONYMOUS">
                        <li><a href="<c:url value='/j_spring_security_logout'/>">Log out</a></li>
                    </sec:authorize>
                </div>

                <div class="t-secondary t-size-x36" id="content">There will be atmosphere status</div>

                <div class="t-secondary t-size-x44">

                </div>

            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 240px; left: 720px; width: auto;" id="widget-14808659" class="widget google-analytics loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Avg time on site</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body number-widget">
            <div class="widget-canvas">

                <div class="main-stat t-size-x52">
                    5<span class="unit">m</span> 16<span class="unit">s</span>
                </div>


                <div class="secondary-stat t-size-x48 negative arrow-down-medium">
                    <span>16<sup>.86%</sup></span>
                </div>


            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 240px; left: 960px; width: auto;" id="widget-14893348" class="widget gmail loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">

        <header>
            <h1>Email Inbox</h1>
        </header>


        <a class="led success" href="#"></a>

        <section class="widget-body rag-widget">
            <div class="widget-canvas">

                <table>

                    <tbody>
                    <tr>
                        <td class="t-size-x48 number negative">
                            7<span class="comma">9,</span>761
                        </td>
                        <td class="t-secondary">inbox over 3 days old</td>
                    </tr>

                    <tr>
                        <td class="t-size-x48 number level">
                            200
                        </td>
                        <td class="t-secondary">inbox between the last 1 and 2 days old</td>
                    </tr>

                    <tr>
                        <td class="t-size-x48 number positive">
                            149
                        </td>
                        <td class="t-secondary">inbox within the last 1day</td>
                    </tr>

                    </tbody>
                </table>
            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
<article style="top: 720px; left: 0px; width: auto;" id="widget-14978771" class="widget google-analytics loaded">
    <div class="widget-inner  widget-size-1x1 large-screen">


        <a class="led success" href="#"></a>

        <section class="widget-body number-widget no-title">
            <div class="widget-canvas">

                <div class="main-stat t-size-x60" id="deegrees">
                    0
                </div>

                <%--<div class="t-secondary t-size-x24">Past 30 days</div>--%>
                <button class="btn" id="myButton">Add</button>


                <div class="t-secondary t-size-x44">

                </div>

            </div>
            <!-- .widget-canvas -->
        </section>


    </div>
    <!-- .widget-inner -->

</article>
</div>

</body>
</html>