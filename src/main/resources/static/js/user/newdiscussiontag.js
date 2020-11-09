let pageNum = null;
let pageAll = null;
let pageUrl = '/';


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
                massage(title + ',添加成功!','success', '');
                $('.ui.modal.createNewDiccuss').modal('hide');
                location.reload();
            } else {
                massage(data.msg,'error', '');
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
    debugger
    $('#createNewtagsDiv').show();
    $('#tagDescriptionDiv').show();
    $('#colorIconDiv').show();
});



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
                massage(name + ',添加成功!', 'success','');
                $("#selectTag").html("");
            } else {
                massage(name + ',添加失败!', 'error','');
            }
        }
    });


});



