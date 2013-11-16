<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">

        <div class="col-sm-6 col-md-4">
            <div class="thumbnail box">
                <div class="caption">
                    <h2 style="height: 40px; margin-top: 0px; padding-bottom: 10px; border-bottom: 1px solid #d3d4d4;">
                        <div class="onoffplaceholder">
                            <div class="onoffswitch">
                                <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" >
                                <input type="hidden" name="${id-row}" class="onoffswitch-checkbox" id="myonoffswitch" >

                                <label class="onoffswitch-label" for="myonoffswitch">
                                    <div class="onoffswitch-inner"></div>
                                    <div class="onoffswitch-switch"></div>
                                </label>
                            </div>
                        </div>
                        <div class="pull-right">Some header</div>
                    </h2>
                    <h4>Pin: </h4>
                    <h4>State:</h4>
                    <h1 class="text-center" style="font-size: 60px;">30 K</h1>
                    <div class="slider" style="height: 80px; margin-top: 20px;"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <a href="#" class="btn btn-primary btn-block" role="button">Flicker</a>
                        </div>
                        <div class="col-md-6">
                            <div class="btn-group btn-block ">
                                <button type="button" class="btn btn-default btn-block dropdown-toggle" data-toggle="dropdown">
                                    Change <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Add action</a></li>
                                    <li><a href="#">Remove</a></li>
                                    <li><a href="#">Deactivate</a></li>
                                    <li><a href="#">Schedule action</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Details</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div> <!-- /container -->
