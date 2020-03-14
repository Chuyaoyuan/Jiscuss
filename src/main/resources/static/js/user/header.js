let username = null;

function setusername(name) {
	console.log('已经登陆：'+name);
	username = name;           // name
}

$("#loginBtn").click(function(){
    $.ajax({
        type: "POST",
        url: "/login",
        data: $("#loginForm").serialize(),
        dataType: "JSON",
        success: function (data) {
            console.log(data);
            if(data.flag){
                username = data.username;
                $('#userlogin').html('');
                $('#userlogin').html(data.username + '<a href="javascript:void(0);" onclick="loginOut(this)" id="loginOut">注销</a>');
//                window.alert(data.username + ',登录成功!');
                $('.ui.modal.login').modal('hide');
                
                console.log($('.ui.modal.login'));
            }else{
                window.alert(data.msg);
                return false;
            }
        }
    });

});

function loginOut() {	
    console.log('loginOut');
    $.ajax({
        type: "POST",
        url: "/loginout",
        dataType: "JSON",
        success: function (data) {
            console.log(data);
            if(data.flag){
                $('#userlogin').html('');
                $('#userlogin').html('<a href="javascript:void(0);"  onclick="loginmodel(this)" id="loginmodel">登录 & 注册</a>');
                window.alert(username + data.msg);
                username = null;
            }else{
                window.alert('用户退出失败!');
                return false;
            }
        }
    });
}


function loginmodel() {	
    $('.ui.modal.login')
        .modal('show')
    ;
}

