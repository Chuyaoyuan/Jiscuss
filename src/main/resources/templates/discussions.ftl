<!DOCTYPE html>
<html>
<title>主题详情页</title>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="static/semanticui/semantic.css"> -->
    <!-- <script src="static/jquery/jquery-3.4.1.min.js"></script> -->
    <!-- <script src="static/semanticui/semantic.min.js"></script> -->

    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <#include "comm/commjs.ftl"/>
</head>
<body style="  background: #f7f8fa;">
<#include "comm/header.ftl"/>

<div class="ui container" id="container">
    <div class="ui info message">
        <i class="close icon"></i>
        <div class="header">欢迎来到这里</div>
        <ul class="list">
            <li>JAVA + DISCUSS = JISCUSS 。</li>
            <li>简单的，易用的JAVA论坛。</li>
            <li>请享受发帖回帖带来的乐趣吧！</li>
        </ul>
    </div>

    <h3 class="ui center aligned header"></h3>
    <div class="ui four column grid">
        <div class="ui widescreen  large screen computer tablet only twelve wide column">
            <div id="context2" style="padding-left: 14px;  padding-right: 14px;background: #FFFFFF; padding: 1em 1em; border-radius: 0.28571429rem; border: 1px solid rgba(34, 36, 38, 0.15);">

                <h2 class="ui header">
                    <i class="edit outline icon"></i>
                    <div class="content">
                        ${discussions.title}
                        <#list tags as tag>
                            <div class="sub header">${tag.name}</div>
                        </#list>
                    </div>
                </h2>


                <div class="ui main text container">
                    ${discussions.content}
                </div>

                <div class="ui labeled button" tabindex="0" style=" margin-top: 30px;">
                    <div class="ui red button">
                        <i class="heart icon"></i> 赞这个主题
                    </div>
                    <a class="ui basic red left pointing label">
                        1,048
                    </a>
                </div>


                <div class="ui feed">
                    <div class="event">
                        <div class="label">
                            <img src="/static/assets/images/logo.png">
                        </div>
                        <div class="content">
                            <div class="summary">
                                用户 <a>${discussions.realname}</a> 发布于
                                <div class="date">
                                    ${discussions.startTime}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui feed">
                    <div class="event">
                        <div class="label">
                            <img src="/static/assets/images/logo.png">
                        </div>
                        <div class="content">
                            <div class="summary">
                                用户 <a>${discussions.realnameLast}</a> 最后回复于
                                <div class="date">
                                    ${discussions.lastTime}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="ui threaded comments">
                    <h3 class="ui dividing header">评论区</h3>
                    <input type="hidden" name="postId" id="postId" value=""/>

                    <!-- 定义遍历方法 -->
                    <#macro bpTree posts>
                        <#if posts?? && posts?size gt 0> <!-- 判断是否为空，并且长度是否大于0 -->
                            <!-- 不为空 开始遍历 -->
                            <#list posts as post>
                                <#if post.nextNodes?? && post.nextNodes?size gt 0>
                                    <!-- 如果是拥有子节点 -->
                                    <div class="comment">
                                        <a class="avatar">
                                            <img src="/static/assets/images/logo.png">
                                        </a>
                                        <div class="content">
                                            <a class="author">${post.username}</a>
                                            <div class="metadata">
                                                <span class="date">${post.createTime}</span>
                                            </div>
                                            <div class="text">
                                                ${post.content}
                                            </div>
                                            <div class="actions">
                                                <a class="reply" onclick="replyThis('${post.username}', '${post.id}')">回复</a>
                                            </div>
                                        </div>
                                        <div class="comments">
                                            <@bpTree posts=post.nextNodes />
                                        </div>
                                    </div>
                                <#else>
                                    <!-- 没有子节点！ -->
                                    <div class="comment">
                                        <a class="avatar">
                                            <img src="/static/assets/images/logo.png">
                                        </a>
                                        <div class="content">
                                            <a class="author">${post.username}</a>
                                            <div class="metadata">
                                                <span class="date">${post.createTime}</span>
                                            </div>
                                            <div class="text">
                                                ${post.content}
                                            </div>
                                            <div class="actions">
                                                <a class="reply" onclick="replyThis('${post.username}', '${post.id}')">回复</a>
                                            </div>
                                        </div>
                                    </div>
                                </#if>
                            </#list>
                        </#if>
                    </#macro>
                    <@bpTree posts=posts /> <!-- 调用方法 -->

                    <div class="ui">

                    </div>
                    <form class="ui reply form">
                        <div class="field">
                            <textarea id="postContent"></textarea>
                        </div>
                        <div class="ui blue labeled submit icon button" id="addPost">
                            <i class="icon edit"></i> 添加评论
                        </div>
                    </form>
                </div>

            </div>
        </div>

        <div class="widescreen  large screen computer tablet only four wide column">
            <div class="ui fluid action input">
                <input type="text" placeholder="搜索...">
                <div class="ui button">搜索</div>
            </div>

            <div class="ui section divider"></div>

            <div class="ui card">
                <div class="content">
                    <div class="header">作者</div>
                </div>
                <div class="content">
                    <h4 class="ui sub header">测试人员1</h4>
                    <div class="ui small feed">
                        <div class="event">
                            <div class="content">
                                <div class="summary">
                                    <a>Jiscuss</a> 一直， <a>Jiscuss</a> 一感谢支持！
                                </div>
                            </div>
                        </div>

                        <div class="event">
                            <div class="content">
                                <div class="summary">
                                    <a>2019</a> 测试内容
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="extra content">
                    <button class="ui button">预留按钮</button>
                </div>
            </div>

            <div class="ui card">
                <div class="content">
                    <div class="header">作者的热门主题</div>
                </div>
                <div class="content">
                    <div class="ui middle aligned divided list">
                        <div class="item">
                            <img class="ui avatar image" src="/static/assets/images/logo.png">
                            <div class="content">
                                <a class="header">他的测试主题1</a>
                            </div>
                        </div>
                        <div class="item">
                            <img class="ui avatar image" src="/static/assets/images/logo.png">
                            <div class="content">
                                <a class="header">他的测试主题2</a>
                            </div>
                        </div>
                        <div class="item">
                            <img class="ui avatar image" src="/static/assets/images/logo.png">
                            <div class="content">
                                <a class="header">他的测试主题3</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="extra content">
                    <p>预留信息</p>
                </div>
            </div>


            <div class="ui card">
                <div class="content">
                    <img class="right floated mini ui image"
                         src="static/assets/images/logo.png">
                    <div class="header">Jiscuss Demo</div>
                    <div class="meta">简单、易用、开源</div>
                    <div class="description">一款基于JAVA的开源论坛 框架采用：Spring Boot + H2
                        + Semantic UI
                    </div>
                </div>
                <div class="extra content">
                    <div class="ui two buttons">
                        <div class="ui basic red button">
                            <div class="ui mini statistic">
                                <div class="value">1</div>
                                <div class="label">用户数</div>
                            </div>
                        </div>
                        <div class="ui basic green button">
                            <div class="ui mini statistic">
                                <div class="value">10</div>
                                <div class="label">发帖数</div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>


        <div class="mobile only sixteen wide column">
            <div class="ui segment">Jiscuss手机可见，内容正在编写中，pc端可正常访问</div>
            <div class="ui pagination menu">
                <a class="icon item">
                    <i class="left chevron icon"></i>
                </a>
                <a class="item">
                    1
                </a>
                <a class="item">
                    2
                </a>
                <div class="disabled item">
                    ...
                </div>
                <a class="item">
                    10
                </a>
                <a class="item">
                    11
                </a>
                <a class="icon item"> <i class="right chevron icon"></i>
                </a>
            </div>
        </div>

    </div>


</div>

<#include "comm/footer.ftl"/>

<script type="text/javascript">

    $(document).ready(function () {
        <#if username??>
        setusername('${username}');
        console.log('已经登陆：' + username);
        </#if>
        setDiscussionsId('${discussions.id}');

    });

</script>
<script type="text/javascript" charset="UTF-8" src="/static/js/user/discussions.js"></script>
</body>

</html>
