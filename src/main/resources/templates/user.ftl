<!DOCTYPE html>
<html>
<title>用户详情页</title>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="static/semanticui/semantic.css"> -->
    <!-- <script src="static/jquery/jquery-3.4.1.min.js"></script> -->
    <!-- <script src="static/semanticui/semantic.min.js"></script> -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <#include "comm/commjs.ftl"/>
</head>
<body>
<#include "comm/header.ftl"/>

<div class="ui container" id="container">
    <h1>用户1的个人主页</h1>

    <h2 class="ui dividing header">详情</h2>

    <div class="ui vertical stripe segment">
        <#--        <div class="ui middle aligned stackable grid container">-->
        <div class="ui internally celled grid">
            <div class="row">
                <div class="eight wide column">
                    <div class="ui secondary menu">
                        <a class="item ${discussion}" href="/user?type=discussion">主题</a>
                        <a class="item ${change}" href="/user?type=change">动态</a>
                        <a class="item ${like}" href="/user?type=like">喜欢收藏</a>

                    </div>
                    <div class="ui bottom attached tab segment ${discussion}" >
                        主题...
                    </div>
                    <div class="ui bottom attached tab segment ${change}" >
                        动态...
                    </div>
                    <div class="ui bottom attached tab segment ${like}" >
                        喜欢收藏...
                    </div>
                </div>
                <div class="six wide right floated column">
                    <div class="ui link cards">
                        <div class="card">
                            <div class="image">
                                <img src="static/assets/images/logo.png">
                            </div>
                            <div class="content">
                                <div class="header">Matt Giampietro</div>
                                <div class="meta">
                                    <a>Friends</a>
                                </div>
                                <div class="description">
                                    Matthew is an interior designer living in New York.
                                </div>
                            </div>
                            <div class="extra content">
                              <span class="right floated">
                                Joined in 2013
                              </span>
                                <span>
                                <i class="user icon"></i>
                                75 Friends
                              </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="center aligned column">
                    <button class="ui basic button" id="userButton">
                        <i class="icon user"></i>
                        小按钮·点下试试
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "comm/footer.ftl"/>

<#--    <div class="ui bottom  vertical inverted sidebar labeled icon menu" id="userButtonsidebar">-->
<div class="ui bottom item three labeled icon sidebar menu scale down" id="userButtonsidebar">
    <#--            <div class="ui bottom demo inverted nine item labeled icon sidebar menu scale down visible" style="">-->

    <a class="item">
        <i class="home icon"></i>
        主题
    </a>
    <a class="item">
        <i class="block layout icon"></i>
        动态
    </a>
    <a class="item">
        <i class="smile icon"></i>
        喜欢收藏
    </a>
</div>
<script type="text/javascript">

    $(document).ready(function () {
        <#if username??>
        setusername('${username}');
        console.log('已经登陆：' + username);
        </#if>
        <#--setDiscussionsId('${discussions.id}');-->

        $('#userTab')
            .tab()
        ;
    });

</script>
<script type="text/javascript" charset="UTF-8" src="/static/js/user/user.js"></script>
</body>

</html>
