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

    <link crossorigin="anonymous" integrity="sha384-ATvSpJEmy1egycrmomcFxVn4Z0A6rfjwlzDQrts/1QRerQhR9EEpEYtdysLpQPuQ"
          href="https://lib.baomitu.com/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/static/semanticui/my.css">

    <script crossorigin="anonymous" integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh"
            src="https://lib.baomitu.com/jquery/3.4.1/jquery.min.js"></script>
    <script crossorigin="anonymous" integrity="sha384-6urqf2sgCGDfIXcoxTUOVIoQV+jFr/Zuc4O2wCRS6Rnd8w0OJ17C4Oo3PuXu8ZtF"
            src="https://lib.baomitu.com/semantic-ui/2.4.1/semantic.min.js"></script>


</head>
<body>
<#include "header.ftl"/>

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

        <div
                class="widescreen  large screen computer tablet only twelve wide column">

            <div id="context2">

                <h2 class="ui header">
                    <i class="settings icon"></i>
                    <div class="content">
                        ${discussions.title}
                        <div class="sub header">某某标签分类</div>
                    </div>
                </h2>


                <div class="ui main text container">
                    ${discussions.content}
                </div>


                <div class="ui feed">
                    <div class="event">
                        <div class="label">
                            <img src="/static/assets/images/logo.png">
                        </div>
                        <div class="content">
                            <div class="summary">
                                用户 <a>测试人员1</a> 发布于
                                <div class="date">
                                    3 days ago
                                </div>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 4 喜欢
                                </a>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="ui minimal comments">
                    <h3 class="ui dividing header">评论区</h3>
                    <div class="comment">
                        <a class="avatar">
                            <img src="/static/assets/images/logo.png">
                        </a>
                        <div class="content">
                            <a class="author">用户6</a>
                            <div class="metadata">
                                <span class="date">Today at 5:42PM</span>
                            </div>
                            <div class="text">
                                测试测试6666!
                            </div>
                            <div class="actions">
                                <a class="reply">回复</a>
                            </div>
                        </div>
                    </div>
                    <div class="comment">
                        <a class="avatar">
                            <img src="/static/assets/images/logo.png">
                        </a>
                        <div class="content">
                            <a class="author">用户7</a>
                            <div class="metadata">
                                <span class="date">Yesterday at 12:30AM</span>
                            </div>
                            <div class="text">
                                <p>测试评论!</p>
                            </div>
                            <div class="actions">
                                <a class="reply">回复</a>
                            </div>
                        </div>
                        <div class="comments">
                            <div class="comment">
                                <a class="avatar">
                                    <img src="/static/assets/images/logo.png">
                                </a>
                                <div class="content">
                                    <a class="author">用户8</a>
                                    <div class="metadata">
                                        <span class="date">Just now</span>
                                    </div>
                                    <div class="text">
                                        测试平路8 :)
                                    </div>
                                    <div class="actions">
                                        <a class="reply">回复</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="comment">
                        <a class="avatar">
                            <img src="/static/assets/images/logo.png">
                        </a>
                        <div class="content">
                            <a class="author">测试用户999n</a>
                            <div class="metadata">
                                <span class="date">5 days ago</span>
                            </div>
                            <div class="text">
                                哈哈哈哈, 测试评论
                            </div>
                            <div class="actions">
                                <a class="reply">回复</a>
                            </div>
                        </div>
                    </div>
                    <form class="ui reply form">
                        <div class="field">
                            <textarea id="postcontent"></textarea>
                        </div>
                        <div class="ui blue labeled submit icon button" id="addPost">
                            <i class="icon edit"></i> 添加评论
                        </div>
                    </form>
                </div>


            </div>
        </div>

        <div
                class="widescreen  large screen computer tablet only four wide column">


            <div class="ui fluid action input">
                <input type="text" placeholder="搜索...">
                <div class="ui button">搜索</div>
            </div>

            <div class="ui section divider"></div>

            <div class="ui card">
                <div class="content">
                    <div class="header">预留功能</div>
                </div>
                <div class="content">
                    <h4 class="ui sub header">Jiscuss</h4>
                    <div class="ui small feed">
                        <div class="event">
                            <div class="content">
                                <div class="summary">
                                    <a>Jiscuss</a> 一直持续更新， <a>Jiscuss</a> 一直更新完善，感谢支持！
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

<#include "footer.ftl"/>

<script type="text/javascript">

    $(document).ready(function () {
        <#if username??>
        console.log('已经登陆：' + username);
        </#if>
        setDiscussionsId('${discussions.id}');

    });

</script>
<script type="text/javascript" charset="UTF-8" src="/static/js/user/discussions.js"></script>
</body>

</html>
