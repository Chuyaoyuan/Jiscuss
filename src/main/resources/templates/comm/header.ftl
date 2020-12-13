<div class="ui main  menu" id="menu">
    <div class="ui container">
        <div href="/" class="header borderless item">
            <img class="logo" src="static/assets/images/logo.png">
            &nbsp;Jiscuss
        </div>
        <a class=" item borderless" href="/">首页</a>
        <a class="active borderless item">论坛</a>
        <div class="ui dropdown item borderless" tabindex="0">
            更多
            <i class="dropdown icon"></i>
            <div class="menu transition hidden" tabindex="-1">
                <a class=" item " href="/user">用户页</a>
                <div class="divider"></div>
                <div class="item">分割链接</div>
                <div class="divider"></div>
                <div class="item">后台管理</div>
            </div>
        </div>
        <div class="right menu">
            <div class="item">
                <div class="ui transparent  icon input">
                    <i class="search icon"></i>
                    <input type="text" placeholder="搜索">
                </div>
            </div>
            <div class="item" id="userlogin">
                <#if username??>
                    <form class="ui large form" action="/logout"  id="logoutForm" method="post"  style="display: none;">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    ${username} &nbsp;&nbsp;<a href="javascript:document.getElementById('logoutForm').submit();">注销</a>
                <#else>
                    <a href="/login" id="loginmodel">登录&nbsp;&nbsp;&&nbsp;&nbsp;注册</a>
                </#if>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" charset="UTF-8" src="/static/js/user/header.js"></script>