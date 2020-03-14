<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理登录页</title>

</head>
<body>

    <h2>后台管理登录页</h2>
    <form id="loginForm" action="/login" method="post">
    用户名：<input type="text" id="username" name="username"><br/><br/>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" id="password" name="password"><br/><br/>
 
<!--     <button id="loginBtn" type="submit">登录</button> -->
    <button id="loginBtn" type="button">登录</button>
    </form>

<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">

    $("#loginBtn").click(function () {
        $.ajax({
            type: "POST",
            url: "/login",
            data: $("#loginForm").serialize(),
            dataType: "JSON",
            success: function (data) {
                console.log(data);
                //window.location.href = "/index";
            }
        });

    });

</script>
</body>
</html>
