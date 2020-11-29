<!DOCTYPE html>
<html>
<title>Jiscuss Demo</title>
<head>
    <#include "comm/commjs.ftl"/>

    <style type="text/css">
        body {
            background-color: #f7f8fa;
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
                登录到账号
            </div>
        </h2>
        <form class="ui large form" action="/login" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="ui stacked segment">
                <div class="field">
                    <div class="ui left icon input">
                        <i class="user icon"></i>
                        <input type="text" name="username" placeholder="用户名">
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="password" name="password" placeholder="密码">
                    </div>
                </div>
                <div class="field" id="msgId" style="display:none">
                    <div class="ui pointing red basic label">
                        ${msg}
                    </div>
                </div>
                <button class="ui fluid large blue button" type="submit">登录</button>
            </div>

            <div class="ui error message"></div>

        </form>

        <div class="ui message">
            <a href="/"><——Jiscuss首页</a> 新用户？ <a href="/register">注册</a>
        </div>
    </div>
</div>
<script type="text/javascript">

    $(document).ready(function () {
        <#if msg??>
        $('#msgId').show();
        </#if>
    });


</script>
</body>

</html>
