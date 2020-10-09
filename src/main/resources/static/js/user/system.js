let pageNum = null;
let pageAll = null;
let pageUrl = '/';

function setpageNum(data, allList) {
    var url = window.location.href;
    console.log('当前url：' + url)
    if (url.indexOf('index') > 0) {
        pageUrl = '/index';
    }
    console.log('当前页码：' + data)
    pageNum = parseInt(data)          // pageNum
    pageAll = parseInt(allList)
}

$("#upPage").click(function () {
    console.log("点击  upPage");
    console.log('当前页码：' + pageNum);
    if (pageNum > 1) {
        let page = pageNum - 1
        window.location.href = pageUrl + "?pageNum=" + page;
    } else {
        massage('已经是首页!', '');
    }
});

$("#nextPage").click(function () {
    console.log("点击  nextPage");
    console.log('当前页码：' + pageNum);
    console.log('当前pageAll页码：' + pageAll);
    if ((pageNum + 1) <= pageAll) {
        let page = pageNum + 1
        window.location.href = pageUrl + "?pageNum=" + page;
    } else {
        massage('已经是尾页!', '');
    }
});

$("#createNewDiccuss").click(function () {
    console.log("点击  createNewDiccuss");
    console.log(username);

    if (username && username != null) {
        $('.ui.modal.createNewDiccuss')
            .modal('show')
        ;
        tinymce.init({
            selector: '#discussionscontent',
        });
    } else {
        massage('您未登录，请先登录!', '');

    }
});


$("#newdiscussions").click(function () {

    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    console.warn(header)
    console.warn(token)
    var title = $("#discussionstitle").val();
    var tag = $("#selectTag").val();
//     $("#discussionscontent").val();
    console.log(tinyMCE.editors[0].getContent());
    var content = tinyMCE.editors[0].getContent();
    console.log(title);
    console.log(content);
    $.ajax({
        type: "POST",
        url: "/newdiscussions",
        data: JSON.stringify({
            title: title,
            content: content
        }),
        contentType: 'application/json',
        beforeSend: function (request) {
            request.setRequestHeader(header, token); // 添加  CSRF Token
        },
        dataType: "JSON",
        success: function (data) {
            console.log(data);
            if (data.flag) {
                massage(title + ',添加成功!', '');
                $('.ui.modal.createNewDiccuss').modal('hide');
                location.reload();
            } else {
                massage(data.msg, '');
                return false;
            }
        }
    });

});

$("#cancelnewtags").click(function () {
    $('#createNewtagsDiv').hide();
    $('#tagDescriptionDiv').hide();
    $('#parentTagDiv').hide();
    $('#colorIconDiv').hide();
});

$("#newtags").click(function () {
    $('#createNewtagsDiv').show();
    $('#tagDescriptionDiv').show();
    $('#parentTagDiv').show();
    $('#colorIconDiv').show();
});

function onTags(data) {
    console.log('123');
    console.log(data);
}

$("#commitnewtags").click(function () {

    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");

    var name = $("#tagsname").val();

    var tagColor = $("#tagColor").val();
    var tagIcon = $("#tagIcon").val();
    var parentTag = $("#parentTag").val();

    let coloricon = tagColor + ',' + tagIcon
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
            color: coloricon,
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
                massage(name + ',添加成功!', '');
                $("#selectTag").html("");
            } else {
                massage(name + ',添加失败!', '');
            }
        }
    });


});


$('#menu')
    .sticky({
        context: '#container'
    })
;

$('#context2 .menu .item')
    .tab({
        // special keyword works same as above
        context: 'parent'
    })
;

$('.ui.dropdown')
    .dropdown()
;
