<!DOCTYPE html>
<html>
<title>Jiscuss Demo</title>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="static/semanticui/semantic.css"> -->
    <!-- <script src="static/jquery/jquery-3.4.1.min.js"></script> -->
    <!-- <script src="static/semanticui/semantic.min.js"></script> -->

    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <script crossorigin="anonymous" integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh"
            src="https://lib.baomitu.com/jquery/3.4.1/jquery.min.js"></script>
    <#--semantic-->
    <link crossorigin="anonymous" integrity="sha384-ATvSpJEmy1egycrmomcFxVn4Z0A6rfjwlzDQrts/1QRerQhR9EEpEYtdysLpQPuQ"
          href="https://lib.baomitu.com/semantic-ui/2.4.1/semantic.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/static/semanticui/my.css">
    <script crossorigin="anonymous" integrity="sha384-6urqf2sgCGDfIXcoxTUOVIoQV+jFr/Zuc4O2wCRS6Rnd8w0OJ17C4Oo3PuXu8ZtF"
            src="https://lib.baomitu.com/semantic-ui/2.4.1/semantic.min.js"></script>

    <#--tinymce-->
    <script crossorigin="anonymous" integrity="sha384-CpsBIlOAWHuSRRN235sCBzEeKN6hLT6SpOGRkGadKpYj0gDP7+s3Q8pC38z8uGHH"
            src="https://lib.baomitu.com/tinymce/5.1.1/tinymce.min.js"></script>
    <#--jquery-cookie-->
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>

</head>
<body>
<#include "header.ftl"/>

<div class="ui container" id="container">
    <div class="ui info message">
        <i class="close icon"></i>
        <div class="header">欢迎来到这里，${data},主题数： ${allDiscussions?size} ，主题页数：${pageDiscussions?size}
            ，标签数 ${allTags?size} </div>
        <ul class="list">
            <li>JAVA + DISCUSS = JISCUSS 。</li>
            <li>简单的，易用的JAVA论坛。</li>
            <li>请享受发帖回帖带来的乐趣吧！</li>
        </ul>
    </div>

    <h3 class="ui center aligned header"></h3>
    <div class="ui four column grid">
        <div
                class="widescreen  large screen computer tablet only four wide column">

            <div class="fluid ui animated fade primary button" tabindex="0" id='createNewDiccuss'>
                <div class="visible content">
                    <i class="pen square icon"></i>创建新帖
                </div>
                <div class="hidden content">
                    您是最棒的<i class="thumbs up icon"></i>
                </div>
            </div>

            <div class="ui modal createNewDiccuss">
                <i class="close icon"></i>
                <div class="header">
                    创建新帖
                </div>
                <div class=" content">
                    <form class="ui form">

                        <div class="field">
                            <label>标题</label>
                            <input type="text" placeholder="标题" id="discussionstitle">
                        </div>
                        <div class="field">
                            <label>选择标签</label>
                            <select multiple="" class="ui dropdown">
                                <option value="">选择标签</option>

                                <#list allTags as tags>
                                    <option value=${tags.id}>${tags.name}</option>

                                </#list>
                            </select>
                        </div>

                        <div class="field">
                            <button class="ui teal button" id="newtags">新增标签</button>
                        </div>

                        <div class="field" id="createNewtagsDiv" style="display:none">
                            <label>标签名</label>
                            <input type="text" placeholder="标签名" id="tagsname">
                        </div>
                        <div class="field" id="createNewtagsBtn" style="display:none">
                            <button class="ui teal button" id="commitnewtags">保存</button>
                        </div>

                        <div class="field">
                            <label>内容</label>
                            <textarea id="discussionscontent"></textarea>


                        </div>

                        <div class="ui fluid large blue  button" id="newdiscussions">提交内容</div>
                    </form>
                </div>
            </div>


            <div class="ui list">
                <div class="item">下面这个按钮可以过滤帖子呦</div>
            </div>

            <div class="fluid ui floating dropdown labeled icon orange button">
                <i class="filter icon"></i> <span class="text">过滤帖子标签</span>
                <div class="menu">
                    <div class="ui icon search input">
                        <i class="search icon"></i> <input type="text"
                                                           placeholder="搜索标签...">
                    </div>
                    <div class="divider"></div>
                    <div class="header">
                        <i class="tags icon"></i> 标签
                    </div>
                    <div class="scrolling menu">
                        <div class="item">
                            <div class="ui red empty circular label"></div>
                            重要
                        </div>
                        <div class="item">
                            <div class="ui blue empty circular label"></div>
                            通知
                        </div>
                        <div class="item">
                            <div class="ui black empty circular label"></div>
                            无法修复
                        </div>
                        <div class="item">
                            <div class="ui purple empty circular label"></div>
                            新闻
                        </div>
                        <div class="item">
                            <div class="ui orange empty circular label"></div>
                            交换
                        </div>
                        <div class="item">
                            <div class="ui empty circular label"></div>
                            改变下降
                        </div>
                        <div class="item">
                            <div class="ui yellow empty circular label"></div>
                            题外话
                        </div>
                        <div class="item">
                            <div class="ui pink empty circular label"></div>
                            有趣
                        </div>
                        <div class="item">
                            <div class="ui green empty circular label"></div>
                            讨论
                        </div>
                    </div>
                </div>
            </div>

            <div class="ui section divider"></div>

            <div class="ui fluid action input">
                <input type="text" placeholder="搜索...">
                <div class="ui button">搜索</div>
            </div>


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
        <div
                class="widescreen  large screen computer tablet only twelve wide column">

            <div id="context2">
                <div class="ui secondary menu">
                    <a class="item active" data-tab="fourth"> <i class="icon mail"></i>
                        最新回复
                        <div class="floating ui red label">22</div>
                    </a> <a class="item "
                            data-tab="fifth">热门</a> <a class="item " data-tab="sixth">新帖</a>
                </div>
                <div class="ui active tab segment" data-tab="fourth">
                    <div class="ui large feed">

                        <#list allDiscussions as discussions>
                            <div class="event">
                                <div class="label">
                                    <img src="static/assets/images/logo.png">
                                </div>
                                <div class="content">
                                    <div class="summary">
                                        <a href="/getdiscussionsbyid?id=${discussions.id}">
                                            ${discussions.title}
                                        </a>

                                        <div class="date">
                                            3 days ago
                                        </div>
                                        <div class="nullright">
                                            <a class="ui teal label">
                                                标签1
                                            </a>
                                            <a class="ui purple label">
                                                标签2
                                            </a>
                                        </div>
                                    </div>
                                    <div class="extra text"
                                         style="width: 300px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
                                        ${discussions.content}
                                    </div>
                                    <div class="meta">
                                        <div class=" description "><i class="edit icon"></i> <a><b>用户1</b></a>&nbsp;&nbsp;•&nbsp;&nbsp;
                                            <i class="reply icon"></i>最后由 <a><b>${discussions.last_user_id}</b></a>
                                            回复于10 hours ago.
                                        </div>
                                    </div>
                                    <div class="nullright  meta">
                                        <a class="like ">
                                            <i class="like icon"></i> 11 喜欢
                                        </a>
                                        <a class="comment ">
                                            <i class="comment icon"></i> 22 回复
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="ui fitted divider"></div>
                        </#list>

                    </div>

                </div>

                <div class="ui  tab segment" data-tab="fifth">
                    <div class="ui divided items">
                        <div class="item">
                            <div class="ui tiny image">
                                <img src="static/assets/images/logo.png">
                            </div>
                            <div class="content">

                                <h4 class="header">置顶测试帖222</h4>
                                <div class="meta">
                                    <span class="cinema">测试广场 14</span>
                                </div>
                                <div class="description">
                                    <p>123234324</p>
                                </div>
                                <div class="extra">
                                    <div class="ui label">IMAX</div>
                                    <div class="ui label">
                                        <i class="globe icon"></i> 附加的留言
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="ui tiny image">
                                <img src="static/assets/images/logo.png">
                            </div>
                            <div class="content">
                                <a class="header">龙猫</a>
                                <div class="meta">
                                    <span class="cinema">测试帖1111</span>
                                </div>
                                <div class="description">
                                    <p></p>
                                </div>
                                <div class="extra">
                                    <div class="ui right floated primary button">
                                        Jiscuss测试内容，测试内容 <i class="right chevron icon"></i>
                                    </div>
                                    <div class="ui label">限制的</div>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class=" ui tiny image">
                                <img src="static/assets/images/logo.png">
                            </div>
                            <div class="content">
                                <a class="header">测试帖子</a>
                                <div class="meta">
                                    <span class="cinema">xxx于什么时候最新回复</span>
                                </div>
                                <div class="meta">
                                    <span class="cinema">IFC2222222。。。。</span>
                                </div>
                                <div class="description">
                                    <p></p>
                                </div>
                                <div class="extra">
                                    <div class="mini ui right floated labeled button" tabindex="0">
                                        <div class="mini ui red button">
                                            <i class="heart icon"></i> 喜欢
                                        </div>
                                        <a class="ui basic red left pointing label"> 1,048 </a>
                                    </div>
                                    <div class="mini ui right floated labeled button" tabindex="0">
                                        <div class=" mini ui basic blue button">
                                            <i class="fork icon"></i>评论
                                        </div>
                                        <a class="ui basic left pointing blue label"> 1,048 </a>
                                    </div>
                                    <div class="ui label">限制的2</div>
                                    <div class="ui label">限制的3</div>
                                    <div class="ui label">限制的4</div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui tab segment" data-tab="sixth">6</div>
            </div>


            <div class="ui borderless menu">
                <a class="icon item">
                    <i class="left chevron icon"></i>
                </a>
                <#list pageDiscussions as page>
                    <a class="item">
                        ${page}
                    </a>
                </#list>
                <a class="icon item"> <i class="right chevron icon"></i>
                </a>
            </div>

        </div>

        <div class="mobile only sixteen wide column">
            <div class="ui segment">Jiscuss手机可见，内容正在编写中，pc端可正常访问</div>
            <div class="ui borderless menu">
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


<div class="ui button" data-tooltip="预留" data-position="top center">
    预留
</div>

<#include "footer.ftl"/>
<script type="text/javascript">

    $(document).ready(function () {
        <#if username??>
        setusername('${username}');
        console.log('已经登陆：' + username);
        </#if>

        var token = $("meta[name='_csrf']").attr("content");
        if(token == '' && username && username != null){
            console.log('因为默认页没有_csrf_token，跳页');
            location.href="/main";
        }
    });

    function massage(msg,type){
        window.alert(msg);
    }
</script>

<script type="text/javascript" charset="UTF-8" src="/static/js/user/system.js"></script>
</body>

</html>
