<!DOCTYPE html>
<html>
<title>Jiscuss Demo</title>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="static/semanticui/semantic.css"> -->
    <!-- <script src="static/jquery/jquery-3.4.1.min.js"></script> -->
    <!-- <script src="static/semanticui/semantic.min.js"></script> -->

    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <#include "comm/commjs.ftl"/>

</head>
<body>


<div class="ui fixed inverted menu">
    <div class="ui container">
        <a href="fixed.php#" class="header item">
            <img class="logo" src="assets/images/logo.png">
            项目名
        </a>
        <a href="fixed.php#" class="item">主页</a>
        <div class="ui simple dropdown item">
            Dropdown <i class="dropdown icon"></i>
            <div class="menu">
                <a class="item" href="fixed.php#">链接选项</a>
                <a class="item" href="fixed.php#">链接选项</a>
                <div class="divider"></div>
                <div class="header">标题项</div>
                <div class="item">
                    <i class="dropdown icon"></i>
                    子菜单
                    <div class="menu">
                        <a class="item" href="fixed.php#">链接选项</a>
                        <a class="item" href="fixed.php#">链接选项</a>
                    </div>
                </div>
                <a class="item" href="fixed.php#">链接选项</a>
            </div>
        </div>
    </div>
</div>

<div class="ui main text container">
    <h1 class="ui header">Semantic UI Fixed Template</h1>
    <p>This is a basic fixed menu template using fixed size containers.</p>
    <p>A text container is used for the main container, which is useful for single column layouts</p>
    <img class="wireframe" src="assets/images/wireframe/media-paragraph.png">
    <img class="wireframe" src="assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="assets/images/wireframe/paragraph.png">
    <img class="wireframe" src="assets/images/wireframe/paragraph.png">
</div>

<div class="ui inverted vertical footer segment">
    <div class="ui center aligned container">
        <div class="ui stackable inverted divided grid">
            <div class="three wide column">
                <h4 class="ui inverted header">Group 1</h4>
                <div class="ui inverted link list">
                    <a href="fixed.php#" class="item">Link One</a>
                    <a href="fixed.php#" class="item">Link Two</a>
                    <a href="fixed.php#" class="item">Link Three</a>
                    <a href="fixed.php#" class="item">Link Four</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header">Group 2</h4>
                <div class="ui inverted link list">
                    <a href="fixed.php#" class="item">Link One</a>
                    <a href="fixed.php#" class="item">Link Two</a>
                    <a href="fixed.php#" class="item">Link Three</a>
                    <a href="fixed.php#" class="item">Link Four</a>
                </div>
            </div>
            <div class="three wide column">
                <h4 class="ui inverted header">Group 3</h4>
                <div class="ui inverted link list">
                    <a href="fixed.php#" class="item">Link One</a>
                    <a href="fixed.php#" class="item">Link Two</a>
                    <a href="fixed.php#" class="item">Link Three</a>
                    <a href="fixed.php#" class="item">Link Four</a>
                </div>
            </div>
            <div class="seven wide column">
                <h4 class="ui inverted header">Footer Header</h4>
                <p>Extra space for a call to action inside the footer that could help re-engage users.</p>
            </div>
        </div>
        <div class="ui inverted section divider"></div>
        <img src="assets/images/logo.png" class="ui centered mini image">
        <div class="ui horizontal inverted small divided link list">
            <a class="item" href="fixed.php#">Site Map</a>
            <a class="item" href="fixed.php#">Contact Us</a>
            <a class="item" href="fixed.php#">Terms and Conditions</a>
            <a class="item" href="fixed.php#">Privacy Policy</a>
        </div>
    </div>
</div>

</body>

</html>
