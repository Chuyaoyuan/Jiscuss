<!DOCTYPE html>
<html>
<title>后台管理首页</title>
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <#--jquery-->
    <script crossorigin="anonymous" integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh"
            src="https://lib.baomitu.com/jquery/3.4.1/jquery.min.js"></script>

    <#--semantic-ui-->
    <link rel="stylesheet" type="text/css" href="/static/semanticui/semantic.css">
    <script type="text/javascript" src="/static/semanticui/semantic.js"></script>

    <link rel="stylesheet" type="text/css" href="/static/semanticui/my.css">

    <#--tinymce-->
    <script crossorigin="anonymous" integrity="sha384-CpsBIlOAWHuSRRN235sCBzEeKN6hLT6SpOGRkGadKpYj0gDP7+s3Q8pC38z8uGHH"
            src="https://lib.baomitu.com/tinymce/5.1.1/tinymce.min.js"></script>


    <#--layx-->
    <link href="/static/layx/layx.min.css?b14794a8a3baf3e8b58e" rel="stylesheet">

    <script type="text/javascript" src="/static/layx/layx.min.js?b14794a8a3baf3e8b58e"></script>

    <script type="text/javascript" charset="UTF-8" src="/static/js/comm/util.js"></script>


    <style type="text/css">
        body {
            -webkit-font-smoothing: antialiased;
            -moz-font-smoothing: grayscale;
        }

        #sidebar {
            position: fixed;
            height: 100vh;
            background-color: #f5f5f5;
            padding-top: 68px;
            padding-left: 0;
            padding-right: 0;
        }

        #sidebar .ui.menu > a.item {
            padding: 10px 20px;
            line-height: 20px;
            color: #337ab7;
            border-radius: 0 !important;
            margin-top: 0;
            margin-bottom: 0;
        }

        #sidebar .ui.menu > a.item.active {
            background-color: #337ab7;
            color: white;
            border: none !important;
        }

        #sidebar .ui.menu > a.item:hover {
            background-color: #eee;
            color: #23527c;
        }

        #content {
            padding-top: 56px;
            padding-left: 20px;
            padding-right: 20px;
        }

        #content h1 {
            font-size: 36px;
        }

        #content .ui.dividing.header {
            width: 100%;
        }

        .ui.centered.small.circular.image {
            margin-top: 14px;
            margin-bottom: 14px;
        }

        .ui.borderless.menu {
            box-shadow: none;
            flex-wrap: wrap;
            border: none;
            padding-left: 0;
            padding-right: 0;
        }

        .ui.mobile.only.grid .ui.menu .ui.vertical.menu {
            display: none;
        }
    </style>
</head>

<body id="root">
<div class="ui tablet computer only padded grid">
    <div class="ui inverted borderless top fixed fluid menu">
        <a class="header item">Jiscuss后台管理</a>
        <div class="right menu">
            <div class="item">
                <div class="ui small input"><input placeholder="Search..." /></div>
            </div>
            <a class="item">常用管理</a> <a class="item">设置</a>
            <a class="item">用户</a> <a class="item">主题</a> <a class="item">注销</a>
        </div>
    </div>
</div>
<div class="ui mobile only padded grid">
    <div class="ui top fixed borderless fluid inverted menu">
        <a class="header item">Project Name</a>
        <div class="right menu">
            <div class="item">
                <button class="ui icon toggle basic inverted button">
                    <i class="content icon"></i>
                </button>
            </div>
        </div>
        <div class="ui vertical borderless inverted fluid menu">
            <a class="item">Dashboard</a> <a class="item">Settings</a>
            <a class="item">Profile</a> <a class="item">Help</a>
            <div class="ui fitted divider"></div>
            <div class="item">
                <div class="ui small input"><input placeholder="Search..." /></div>
            </div>
        </div>
    </div>
</div>
<div class="ui padded grid">
    <div
            class="three wide tablet only three wide computer only column"
            id="sidebar"
    >
        <div class="ui vertical borderless fluid text menu">
            <a class="active item">常用管理</a> <a class="item">设置</a>
            <div class="ui hidden divider"></div>
            <a class="item">用户</a> <a class="item">主题</a>
            <div class="ui hidden divider"></div>
            <a class="item">Jiscuss文档</a>
            <a class="item"  href="/">返回首页</a>
        </div>
    </div>
    <div
            class="sixteen wide mobile thirteen wide tablet thirteen wide computer right floated column"
            id="content"
    >
        <div class="ui padded grid">
            <div class="row">
                <h1 class="ui huge dividing header">Dashboard</h1>
            </div>
            <div class="center aligned row">
                <div
                        class="eight wide mobile four wide tablet four wide computer column"
                >
                    <img
                            class="ui centered small circular image"
                            src="./static/images/wireframe/square-image.png"
                    />
                    <div class="ui large basic label">Label</div>
                    <p>Something else</p>
                </div>
                <div
                        class="eight wide mobile four wide tablet four wide computer column"
                >
                    <img
                            class="ui centered small circular image"
                            src="./static/images/wireframe/square-image.png"
                    />
                    <div class="ui large basic label">Label</div>
                    <p>Something else</p>
                </div>
                <div
                        class="eight wide mobile four wide tablet four wide computer column"
                >
                    <img
                            class="ui centered small circular image"
                            src="./static/images/wireframe/square-image.png"
                    />
                    <div class="ui large basic label">Label</div>
                    <p>Something else</p>
                </div>
                <div
                        class="eight wide mobile four wide tablet four wide computer column"
                >
                    <img
                            class="ui centered small circular image"
                            src="./static/images/wireframe/square-image.png"
                    />
                    <div class="ui large basic label">Label</div>
                    <p>Something else</p>
                </div>
            </div>
            <div class="ui hidden section divider"></div>
            <div class="row">
                <h1 class="ui huge dividing header">Section title</h1>
            </div>
            <div class="row">
                <table class="ui single line striped selectable unstackable table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Header</th>
                        <th>Header</th>
                        <th>Header</th>
                        <th>Header</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                    </tr>
                    <tr>
                        <td>1,002</td>
                        <td>amet</td>
                        <td>consectetur</td>
                        <td>adipiscing</td>
                        <td>elit</td>
                    </tr>
                    <tr>
                        <td>1,003</td>
                        <td>Integer</td>
                        <td>nec</td>
                        <td>odio</td>
                        <td>Praesent</td>
                    </tr>
                    <tr>
                        <td>1,003</td>
                        <td>libero</td>
                        <td>Sed</td>
                        <td>cursus</td>
                        <td>ante</td>
                    </tr>
                    <tr>
                        <td>1,004</td>
                        <td>dapibus</td>
                        <td>diam</td>
                        <td>Sed</td>
                        <td>nisi</td>
                    </tr>
                    <tr>
                        <td>1,005</td>
                        <td>Nulla</td>
                        <td>quis</td>
                        <td>sem</td>
                        <td>at</td>
                    </tr>
                    <tr>
                        <td>1,006</td>
                        <td>nibh</td>
                        <td>elementum</td>
                        <td>imperdiet</td>
                        <td>Duis</td>
                    </tr>
                    <tr>
                        <td>1,007</td>
                        <td>sagittis</td>
                        <td>ipsum</td>
                        <td>Praesent</td>
                        <td>mauris</td>
                    </tr>
                    <tr>
                        <td>1,008</td>
                        <td>Fusce</td>
                        <td>nec</td>
                        <td>tellus</td>
                        <td>sed</td>
                    </tr>
                    <tr>
                        <td>1,009</td>
                        <td>augue</td>
                        <td>semper</td>
                        <td>porta</td>
                        <td>Mauris</td>
                    </tr>
                    <tr>
                        <td>1,010</td>
                        <td>massa</td>
                        <td>Vestibulum</td>
                        <td>lacinia</td>
                        <td>arcu</td>
                    </tr>
                    <tr>
                        <td>1,011</td>
                        <td>eget</td>
                        <td>nulla</td>
                        <td>Class</td>
                        <td>aptent</td>
                    </tr>
                    <tr>
                        <td>1,012</td>
                        <td>taciti</td>
                        <td>sociosqu</td>
                        <td>ad</td>
                        <td>litora</td>
                    </tr>
                    <tr>
                        <td>1,013</td>
                        <td>torquent</td>
                        <td>per</td>
                        <td>conubia</td>
                        <td>nostra</td>
                    </tr>
                    <tr>
                        <td>1,014</td>
                        <td>per</td>
                        <td>inceptos</td>
                        <td>himenaeos</td>
                        <td>Curabitur</td>
                    </tr>
                    <tr>
                        <td>1,015</td>
                        <td>sodales</td>
                        <td>ligula</td>
                        <td>in</td>
                        <td>libero</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $(".ui.toggle.button").click(function() {
            $(".mobile.only.grid .ui.vertical.menu").toggle(100);
        });
    });
</script>
</body>
</html>