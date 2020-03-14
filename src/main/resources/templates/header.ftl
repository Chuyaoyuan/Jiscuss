	<div class="ui main  menu" id="menu">
	 <div class="ui container">
			<div href="#" class="header borderless item">
				<img class="logo" src="static/assets/images/logo.png">
				&nbsp;Jiscuss
			</div>
			  <a class=" item borderless">首页</a>
				  <a class="active borderless item">论坛</a>
				  <div class="ui dropdown item borderless" tabindex="0">
				    更多
				    <i class="dropdown icon"></i>
				    <div class="menu transition hidden" tabindex="-1">
				      <div class="item">行为</div>
				      <div class="item">另一个行为</div>
				      <div class="item">其他东西</div>
				      <div class="divider"></div>
				      <div class="item">分割链接</div>
				      <div class="divider"></div>
				      <div class="item">另一个分割链接</div>
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
            				${username} <a href="javascript:void(0);" onclick="loginOut(this)" id="loginOut">注销</a>
			            <#else>
			                   <a href="javascript:void(0);" onclick="loginmodel(this)" id="loginmodel">登录 & 注册</a>
			            </#if>
                       </div>
</div>
</div>


<div class="ui mini modal login">
<i class="close icon"></i>

<div class=" content">
<div class="ui middle aligned center aligned grid">
<div class="column">
<h2 class="ui blue image header">
<img src="static/assets/images/logo.png" class="image">
<div class="content">
登录到账号
</div>
</h2>
<form class="ui large form" id="loginForm">
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
<div class="ui fluid large blue  button"  id="loginBtn">登录</div>
</div>

<div class="ui error message"></div>

</form>

<div class="ui message">
新用户？ <a href="l#">注册</a>
</div>
</div>
</div>
</div>
</div>
</div>

<script type="text/javascript" charset="UTF-8" src="/static/js/user/header.js"></script>