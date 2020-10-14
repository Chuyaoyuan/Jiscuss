
let discussionsId = null;

function setDiscussionsId(id) {
    console.log('setDiscussionsId：'+id);
    discussionsId = id;           // id
}
$("#addPost").click(function () {
    console.log("点击  addPost");
    console.log(username);
    console.log(discussionsId);
    let postId = $("#postId").val();
    console.log(postId);
    if(username && username!=null){
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        console.warn(header)
        console.warn(token)
        var content = $("#postContent").val();
        console.log(content);
        $.ajax({
            type: "POST",
            url: "/newpost",
            data: JSON.stringify({
                content: content,
                discussionId: discussionsId,
                parentId: postId
            }),
            contentType: 'application/json',
            beforeSend: function(request) {
                request.setRequestHeader(header, token); // 添加  CSRF Token
            },
            dataType: "JSON",
            success: function (data) {
                console.log(data);
                if(data.flag){
                    massage(content+',添加成功!','');
                    location.reload();
                    massage('评论添加成功!','');
                }else{
                    massage(data.msg,'');
                    return false;
                }
            }
        });
    }else{
        massage('您未登录，请先登录!','');

    }
});

// 回复
function replyThis(username, postId) {
    console.warn(username)
    console.warn(postId)
    $("#postId").val(postId);
    var content = $("#postContent").val();
    if (content) content += '\n';
    $("#postContent").val(content + "@" + username + " ");
    $("#postContent").focus();
}



