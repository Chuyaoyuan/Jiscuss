<!DOCTYPE html>
<html>
<title>Jiscuss Demo</title>
<head>
    <#include "comm/commjs.ftl"/>

    <style type="text/css">
        body {
            background-color: #DADADA;
        }

        body > .grid {
            height: 100%;
        }

        .image {
            margin-top: -100px;
        }

        .column {
            max-width: 450px;
        }
    </style>
</head>
<body>

<div class="ui middle aligned center aligned grid">
    <div class="column">
        <h2 class="ui blue image header">
            <img src="static/assets/images/logo.png" class="image">
            <div class="content">
                注册账号
            </div>
        </h2>
        <form class="ui large form" action="/registerDo" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="ui stacked segment">
                <div class="required field">
                    <label>用户名</label>
                    <input type="text"  name="username"  placeholder="用户名">
                </div>
                <div class="required field">
                    <label>邮箱地址</label>
                    <input type="text" name="email" placeholder="邮箱地址">
                </div>
                <div class="required field">
                    <label>密码</label>
                    <input type="text" name="password" placeholder="密码">
                </div>
                <div class="required field">
                    <label>确认密码</label>
                    <input type="text" name="password2" placeholder="确认密码">
                </div>

                <div class="required inline field">
                    <div class="ui checkbox">
                        <input type="checkbox" tabindex="0" class="hidden">
                        <label>我同意Jiscuss条款</label>
                    </div>
                </div>

                <div class="field" id="msgId" style="display:none">
                    <div class="ui pointing red basic label">
                        ${msg}
                    </div>
                </div>

                <button class="ui fluid large blue button" type="submit">注册</button>
            </div>

            <div class="ui error message"></div>

        </form>

        <div class="ui message">
            <a href="/"><——Jiscuss首页</a> 已有用户？ <a href="/login">登陆</a>
        </div>
    </div>
</div>
<script type="text/javascript">
    $('.ui.checkbox')
        .checkbox()
    ;
    $(document).ready(function () {
        <#if msg??>
        $('#msgId').show();
        </#if>
    });


</script>
</body>

</html>
