<!DOCTYPE html>
<html>
<title>新建标签页</title>
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
        <div class="field"  >
            <label>标签名</label>
            <input type="text" placeholder="标签名" id="tagsname">
        </div>
        <div class="two fields" >
            <div class="field"  >
                <label>描述</label>
                <input type="text" placeholder="描述" id="tagdescription">
            </div>
            <div class="field"  >
                <label>父标签</label>
                <select class="ui fluid dropdown" id="parentTag">
                    <option value="">选择父标签</option>
                    <#list allTags as tag>
                        <option value="${tag.id}">${tag.name}</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="two fields" >
            <div class="field">
                <label>选择颜色</label>
                <div class="ui fluid search selection dropdown">
                    <input type="hidden" id="tagColor">
                    <i class="dropdown icon"></i>
                    <div class="default text">选择颜色</div>
                    <div class="menu">
                        <div class="item" data-value="red"><div class="ui red empty circular label"></div>红色</div>
                        <div class="item" data-value="orange"><div class="ui orange empty circular label"></div>橙色</div>
                        <div class="item" data-value="yellow"><div class="ui yellow empty circular label"></div>黄色</div>
                        <div class="item" data-value="olive"><div class="ui olive empty circular label"></div>橄榄绿</div>
                        <div class="item" data-value="green"><div class="ui green empty circular label"></div>纯绿</div>
                        <div class="item" data-value="teal"><div class="ui teal empty circular label"></div>水鸭蓝</div>
                        <div class="item" data-value="blue"><div class="ui blue empty circular label"></div>纯蓝</div>
                        <div class="item" data-value="violet"><div class="ui violet empty circular label"></div>紫罗兰</div>
                        <div class="item" data-value="purple"><div class="ui purple empty circular label"></div>纯紫</div>
                        <div class="item" data-value="pink"><div class="ui pink empty circular label"></div>粉红</div>
                        <div class="item" data-value="brown"><div class="ui brown empty circular label"></div>棕色</div>
                        <div class="item" data-value="grey"><div class="ui grey empty circular label"></div>灰色</div>
                        <div class="item" data-value="black"><div class="ui black empty circular label"></div>黑色</div>
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
                        <div class="item" data-value="folder open outline"><i class="folder open outline"></i>folder open outline</div>
                        <div class="item" data-value="comment outline"><i class="comment outline"></i>comment outline</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="field" >
            <a class="ui teal button" id="commitnewtags">保存</a>
            <a class="ui grey button" id="cancelnewtags">取消</a>
        </div>

        </form>
    </div>
</div>

<script type="text/javascript" charset="UTF-8" src="/static/js/comm/util.js"></script>

<script type="text/javascript">

    $('.ui.dropdown')
        .dropdown()
    ;
    $(document).ready(function () {

    });

    $("#commitnewtags").click(function () {

        var header = $("meta[name='_csrf_header']").attr("content");
        var token = $("meta[name='_csrf']").attr("content");

        var name = $("#tagsname").val();

        var tagColor = $("#tagColor").val();
        var tagIcon = $("#tagIcon").val();
        var parentTag = $("#parentTag").val();

        var tagdescription = $("#tagdescription").val();

        console.log(tagColor);
        console.log(tagIcon);
        console.log(parentTag);
        console.log(tagdescription);
        console.log(name);
        $.ajax({
            type: "POST",
            url: "/newtags",
            data: JSON.stringify({
                name: name,
                color: tagColor,
                icon: tagIcon,
                description: tagdescription,
                parentId: parentTag
            }),
            contentType: 'application/json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            dataType: "JSON",
            success: function (data) {
                console.log(data);
                if (data.flag) {
                    parent.layx.reloadFrame('createNewDiccussContent');
                    massage(name + ',添加成功!', 'success','');

                    top.layx.destroy('createNewTagContent');   // 方法二
                } else {
                    massage(name + ',添加失败!', 'error','');
                }
            }
        });


    });

    $("#cancelnewtags").click(function () {
        // layx.destroy(id);
        // parent.layx.destroy('createNewTagContent');   // 方法一（推荐）
        top.layx.destroy('createNewTagContent');   // 方法二
    });

</script>

</body>

</html>
