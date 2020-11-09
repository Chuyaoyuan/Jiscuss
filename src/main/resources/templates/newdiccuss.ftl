<!DOCTYPE html>
<html>
<title>新建主题页</title>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="static/semanticui/semantic.css"> -->
    <!-- <script src="static/jquery/jquery-3.4.1.min.js"></script> -->
    <!-- <script src="static/semanticui/semantic.min.js"></script> -->

    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <#include "comm/commjs.ftl"/>

</head>
<body>
<div class="ui container" id="container">
        <div class=" content" >
            <form class="ui form">

                <div class="field">
                    <label>标题</label>
                    <input type="text" placeholder="标题" id="discussionstitle">
                </div>
                <div class="field">
                    <label>选择标签</label>
                    <select  multiple="" class="ui fluid dropdown" id="selectTag">
                        <option value="">选择标签</option>
                        <#list allTags as tag>
                            <option value="${tag.id}">${tag.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="field">
                    &nbsp;<button class="ui teal button" onclick="onNewtags()">新增标签</button>
                </div>


                <div class="field">
                    <label>内容</label>
                    <textarea id="discussionsContent"></textarea>
                </div>

                <div class="ui fluid large blue  button" id="newDiscussions">提交内容</div>
            </form>
        </div>
</div>

<script type="text/javascript" charset="UTF-8" src="/static/js/comm/util.js"></script>

<script type="text/javascript">

    $('.ui.dropdown')
        .dropdown()
    ;

    $(document).ready(function () {
        tinymce.init({
            selector: '#discussionsContent',
        });
    });

    function onNewtags() {
        parent.layx.iframe('createNewTagContent','新建标签','./newTagPage',{
            alwaysOnTop:true,
            shadable:true,
            width:380,
            height:500
        });
    }

    $("#newDiscussions").click(function () {

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        console.warn(header)
        console.warn(token)
        debugger
        var title = $("#discussionstitle").val();
        var tag = $("#selectTag").val();
        console.warn(tag)
        let tagStr = tag.join(",")
        console.log(tagStr)
        console.log(tinyMCE.editors[0].getContent());
        var content = tinyMCE.editors[0].getContent();
        console.log(title);
        console.log(content);
        $.ajax({
            type: "POST",
            url: "/newDiscussions",
            data: JSON.stringify({
                title: title,
                content: content,
                tag: tagStr
            }),
            contentType: 'application/json',
            beforeSend: function (request) {
                request.setRequestHeader(header, token); // 添加  CSRF Token
            },
            dataType: "JSON",
            success: function (data) {
                debugger
                console.log(data);
                if (data.flag) {
                    top.layx.destroy('createNewDiccussContent');
                    // parent.layx.destroy('createNewTagContent');   // 方法一（推荐）
                    // location.reload();
                } else {
                    massage(data.msg,'error', '');
                    return false;
                }
            }
        });

    });


</script>

</body>

</html>
