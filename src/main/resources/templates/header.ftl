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
			                   <a href="/login" id="loginmodel">登录 & 注册</a>
			            </#if>
                       </div>
			</div>
		</div>
	</div>


<script type="text/javascript" charset="UTF-8" src="/static/js/user/header.js"></script>