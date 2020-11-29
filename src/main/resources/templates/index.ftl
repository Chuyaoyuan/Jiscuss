<!DOCTYPE html>
<html>
<title>Jiscuss Demo</title>
<head>
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
        <div class="header">欢迎来到这里，${data} ，当前页主题数： ${allDiscussions?size} ，主题页数：${pageDiscussions?size}
            ，标签数 ${allTags?size} </div>
        <ul class="list">
            <li>JAVA + DISCUSS = JISCUSS 。</li>
            <li>简单的，易用的JAVA论坛。</li>
            <li>请享受发帖回帖带来的乐趣吧！</li>
        </ul>
    </div>

    <h3 class="ui center aligned header"></h3>
    <div class="ui four column grid">
        <div class="widescreen  large screen computer tablet only four wide column">

            <div class="fluid ui animated fade primary button" tabindex="0" id="createNewDiccuss2"
                 style=" margin-bottom: 20px;">
                <div class="visible content">
                    <i class="pen square icon"></i>创建新帖
                </div>
                <div class="hidden content">
                    您是最棒的<i class="thumbs up icon"></i>
                </div>
            </div>

            <div class="ui modal createNewDiccuss" id="createNewDiccussContent">
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
                            <select multiple="" class="ui dropdown" id="selectTag">
                                <option value="">选择标签</option>
                                <#list allTags as tags>
                                    <option value=${tags.id}>${tags.name}</option>
                                </#list>
                            </select>
                        </div>

                        <div class="field">
                            <#--                            <button class="ui teal button" id="newtags">新增标签</button>-->
                            <#--                            <a href="/login" id="loginmodel">登录&nbsp;&nbsp;&&nbsp;&nbsp;注册</a>-->
                            &nbsp;<a onclick="onNewtags()">新增标签</a>
                        </div>

                        <div class="field" id="createNewtagsDiv" style="display:none">
                            <label>标签名</label>
                            <input type="text" placeholder="标签名" id="tagsname">
                        </div>
                        <div class="two fields" id="tagDescriptionDiv" style="display:none">
                            <div class="field">
                                <label>描述</label>
                                <input type="text" placeholder="描述" id="tagdescription">
                            </div>
                            <div class="field">
                                <label>父标签</label>
                                <select class="ui fluid dropdown" id="parentTag">
                                    <#list allTags as tag>
                                        <option value="{tag.id}">{tag.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="two fields" id="colorIconDiv" style="display:none">
                            <div class="field">
                                <label>选择颜色</label>
                                <div class="ui fluid search selection dropdown">
                                    <input type="hidden" id="tagColor">
                                    <i class="dropdown icon"></i>
                                    <div class="default text">选择颜色</div>
                                    <div class="menu">
                                        <div class="item" data-value="red">
                                            <div class="ui red empty circular label"></div>
                                            红色
                                        </div>
                                        <div class="item" data-value="orange">
                                            <div class="ui orange empty circular label"></div>
                                            橙色
                                        </div>
                                        <div class="item" data-value="yellow">
                                            <div class="ui yellow empty circular label"></div>
                                            黄色
                                        </div>
                                        <div class="item" data-value="olive">
                                            <div class="ui olive empty circular label"></div>
                                            橄榄绿
                                        </div>
                                        <div class="item" data-value="green">
                                            <div class="ui green empty circular label"></div>
                                            纯绿
                                        </div>
                                        <div class="item" data-value="teal">
                                            <div class="ui teal empty circular label"></div>
                                            水鸭蓝
                                        </div>
                                        <div class="item" data-value="blue">
                                            <div class="ui blue empty circular label"></div>
                                            纯蓝
                                        </div>
                                        <div class="item" data-value="violet">
                                            <div class="ui violet empty circular label"></div>
                                            紫罗兰
                                        </div>
                                        <div class="item" data-value="purple">
                                            <div class="ui purple empty circular label"></div>
                                            纯紫
                                        </div>
                                        <div class="item" data-value="pink">
                                            <div class="ui pink empty circular label"></div>
                                            粉红
                                        </div>
                                        <div class="item" data-value="brown">
                                            <div class="ui brown empty circular label"></div>
                                            棕色
                                        </div>
                                        <div class="item" data-value="grey">
                                            <div class="ui grey empty circular label"></div>
                                            灰色
                                        </div>
                                        <div class="item" data-value="black">
                                            <div class="ui black empty circular label"></div>
                                            黑色
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="field">
                                <label>选择图标</label>
                                <div class="ui fluid search selection dropdown">
                                    <input type="hidden" id="tagIcon">
                                    <i class="dropdown icon"></i>
                                    <div class="default text">选择图标</div>
                                    <div class="menu">
                                        <div class="item" data-value="bullhorn"><i class="bullhorn"></i>bullhorn</div>
                                        <div class="item" data-value="coffee"><i class="coffee"></i>coffee</div>
                                        <div class="item" data-value="edit"><i class="edit"></i>edit</div>
                                        <div class="item" data-value="fax"><i class="fax"></i>fax</div>
                                        <div class="item" data-value="bug"><i class="bug"></i>bug</div>
                                        <div class="item" data-value="keyboard"><i class="keyboard"></i>keyboard</div>
                                        <div class="item" data-value="folder open outline"><i
                                                    class="folder open outline"></i>folder open outline
                                        </div>
                                        <div class="item" data-value="comment outline"><i class="comment outline"></i>comment
                                            outline
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="field" id="createNewtagsBtn" style="display:none">
                            <a class="ui teal button" id="commitnewtags">保存</a>
                            <a class="ui grey button" id="cancelnewtags">取消</a>
                        </div>

                        <div class="field">
                            <label>内容</label>
                            <textarea id="discussionscontent"></textarea>
                        </div>

                        <div class="ui fluid large blue  button" id="newdiscussions">提交内容</div>
                    </form>
                </div>
            </div>

            <#--            <div class="ui section divider"></div>-->

            <div class="ui card red ">
                <div class="content">
                    <div class="header">全部标签</div>
                </div>
                <div class="content">
                    <div class="ui ordered list">
                        <#list allTags as tags>
                            <div class="item">
                                <i class="icon ${tags.icon} ${tags.color}"></i>
                                <div class="content">
                                    <a class="header" onclick="onTags(${tags.id})">${tags.name}</a>
                                    <div class="description">${tags.description}</div>

                                    <div class="list">

                                        <#list allChildTags as childTags>
                                            <#if childTags.parentId == tags.id>
                                                <div class="item">
                                                    <i class="icon ${childTags.icon} ${childTags.color}"></i>
                                                    <div class="content">
                                                        <a class="header"
                                                           onclick="onTags(${childTags.id})">${childTags.name}</a>
                                                        <div class="description">${childTags.description}</div>
                                                    </div>
                                                </div>
                                            </#if>
                                        </#list>

                                    </div>


                                </div>
                            </div>
                        </#list>

                    </div>
                </div>
            </div>

            <div class="ui card black ">
                <div class="content">
                    <div class="header">预留功能</div>
                </div>
                <div class="content">
                    <h4 class="ui sub header">Jiscuss</h4>
                    <div class="ui small feed">
                        <div class="event">
                            <div class="content">
                                <div class="summary">
                                    <a>Jiscuss</a> 会持续更新， <a>Jiscuss</a> 将一直更新完善，感谢支持！
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


            <div class="ui card violet ">
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
                                <div class="value"> ${allUser?size}</div>
                                <div class="label">用户数</div>
                            </div>
                        </div>
                        <div class="ui basic green button">
                            <div class="ui mini statistic">
                                <div class="value"> ${allDiscussions?size}</div>
                                <div class="label">发帖数</div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
        <div class="widescreen  large screen computer tablet only twelve wide column">

            <div id="context2">
                <div class="ui secondary menu">

                    <#if username??>
                        <a class="item ${typeAll}" href="/main?type=all">
                            <i class="icon mail"></i>
                            最新回复
                            <div class="floating ui red label">1</div>
                        </a>
                        <a class="item ${typeHot}" href="/main?type=hot">热门</a>
                        <a class="item ${typeNew}" href="/main?type=new">新帖</a>
                    <#else>
                        <a class="item ${typeAll}" href="/?type=all"> <i class="icon mail"></i>
                            最新回复
                            <div class="floating ui red label">1</div>
                        </a>
                        <a class="item ${typeHot}" href="/?type=hot">热门</a>
                        <a class="item ${typeNew}" href="/?type=new">新帖</a>
                    </#if>

                </div>
                <div class="ui ${typeAll} tab segment" data-tab="fourth">
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
                                            ${discussions.startTime}
                                        </div>
                                        <div class="nullright">
                                            <#list  discussions.tagList as tags>
                                                <a class="ui ${tags.color} label">
                                                    ${tags.name}
                                                </a>
                                            </#list>
                                        </div>
                                    </div>
                                    <div class="extra text"
                                         style="width: 300px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
                                        ${discussions.content}
                                    </div>
                                    <div class="meta">
                                        <div class=" description "><i class="edit icon"></i>
                                            <a data-tooltip="${discussions.username}" data-position="top center"><b>${discussions.username}</b></a>&nbsp;&nbsp;•&nbsp;&nbsp;
                                            <i class="reply icon"></i>最后由 <a><b>${discussions.usernameLast}</b></a>
                                            回复于${discussions.lastTime}.
                                        </div>
                                    </div>
                                    <div class="nullright  meta">
                                        <a class="like ">
                                            <i class="like icon"></i> ${discussions.likeCount} 喜欢
                                        </a>
                                        <a class="comment ">
                                            <i class="comment icon"></i> ${discussions.commentsCount} 回复
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="ui fitted divider"></div>
                        </#list>
                    </div>
                </div>

                <div class="ui ${typeHot} tab segment" data-tab="fifth">
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
                                            ${discussions.startTime}
                                        </div>
                                        <div class="nullright">
                                            <#list  discussions.tagList as tags>
                                                <a class="ui ${tags.color} label">
                                                    ${tags.name}
                                                </a>
                                            </#list>
                                        </div>
                                    </div>
                                    <div class="extra text"
                                         style="width: 300px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
                                        ${discussions.content}
                                    </div>
                                    <div class="meta">
                                        <div class=" description "><i class="edit icon"></i>
                                            <a><b>${discussions.username}</b></a>&nbsp;&nbsp;•&nbsp;&nbsp;
                                            <i class="reply icon"></i>最后由 <a><b>${discussions.usernameLast}</b></a>
                                            回复于${discussions.lastTime}.
                                        </div>
                                    </div>
                                    <div class="nullright  meta">
                                        <a class="like ">
                                            <i class="like icon"></i> ${discussions.likeCount} 喜欢
                                        </a>
                                        <a class="comment ">
                                            <i class="comment icon"></i> ${discussions.commentsCount} 回复
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="ui fitted divider"></div>
                        </#list>
                    </div>
                </div>
                <div class="ui ${typeNew} tab segment" data-tab="sixth">
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
                                            ${discussions.startTime}
                                        </div>
                                        <div class="nullright">
                                            <#list  discussions.tagList as tags>
                                                <a class="ui ${tags.color} label">
                                                    ${tags.name}
                                                </a>
                                            </#list>
                                        </div>
                                    </div>
                                    <div class="extra text"
                                         style="width: 300px;overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">
                                        ${discussions.content}
                                    </div>
                                    <div class="meta">
                                        <div class=" description "><i class="edit icon"></i>
                                            <a><b>${discussions.username}</b></a>&nbsp;&nbsp;•&nbsp;&nbsp;
                                            <i class="reply icon"></i>最后由 <a><b>${discussions.usernameLast}</b></a>
                                            回复于${discussions.lastTime}.
                                        </div>
                                    </div>
                                    <div class="nullright  meta">
                                        <a class="like ">
                                            <i class="like icon"></i> ${discussions.likeCount} 喜欢
                                        </a>
                                        <a class="comment ">
                                            <i class="comment icon"></i> ${discussions.commentsCount} 回复
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="ui fitted divider"></div>
                        </#list>
                    </div>
                </div>
            </div>


            <div class="ui borderless menu">
                <a class="icon item" id="upPage">
                    <i class="left chevron icon"></i>
                </a>
                <#list pageDiscussions as page>
                    <#if page == pageNum && !(username)??>
                        <a class="item" style="  background-color: #7d827d;" href="/?pageNum=${page}">
                            ${page}
                        </a>
                    </#if>
                    <#if page != pageNum && !(username)??>
                        <a class="item" href="/?pageNum=${page}">
                            ${page}
                        </a>
                    </#if>
                    <#if page == pageNum && username??>
                        <a class="item" style="  background-color: #7d827d;" href="/main?pageNum=${page}">
                            ${page}
                        </a>
                    </#if>
                    <#if page != pageNum  && username??>
                        <a class="item" href="/main?pageNum=${page}">
                            ${page}
                        </a>
                    </#if>
                </#list>
                <a class="icon item" id="nextPage"> <i class="right chevron icon"></i>
                </a>
            </div>
            <!--pager-->
            <#--<div class="ui borderless menu">
                <ul class="pagination">
                    <#import "./comm/page.ftl" as page />
                    <@page.fpage page=pageNum pagesize=pageSize totalpages=pageTotalPages totalrecords=pageTotal url="/" />
                </ul>
            </div>-->

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

<#include "comm/footer.ftl"/>
<script type="text/javascript">

    $(document).ready(function () {
        <#if username??>
        setusername('${username}');
        console.log('已经登陆：' + username);
        </#if>
        console.log('pageNum：' + '${pageNum}');
        console.log('pageNumAll：' + '${pageNumAll}');

        setpageNum('${pageNum}', '${pageNumAll}');

        var token = $("meta[name='_csrf']").attr("content");
        if (token == '' && username && username != null) {
            console.log('因为默认页没有_csrf_token，跳页');
            location.href = "/main";
        }
    });

</script>

<script type="text/javascript" charset="UTF-8" src="/static/js/user/system.js"></script>
</body>

</html>
