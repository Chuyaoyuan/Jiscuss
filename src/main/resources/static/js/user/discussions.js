
let discussionsId = null;

function setDiscussionsId(id) {
    console.log('setDiscussionsId：'+id);
    discussionsId = id;           // id
}
$("#addPost").click(function () {
    console.log("点击  addPost");
    console.log(username);
    console.log(discussionsId);

    if(username && username!=null){
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        console.warn(header)
        console.warn(token)
        var title = $("#postcontent").val();
        console.log(title);
        $.ajax({
            type: "POST",
            url: "/newpost",
            data: JSON.stringify({
                content: content,
                discussion_id: discussionsId
            }),
            contentType: 'application/json',
            beforeSend: function(request) {
                request.setRequestHeader(header, token); // 添加  CSRF Token
            },
            dataType: "JSON",
            success: function (data) {
                console.log(data);
                if(data.flag){
                    window.alert(title+',添加成功!');
                    $('.ui.modal.createNewDiccuss').modal('hide');
                    location.reload();
                }else{
                    window.alert(data.msg);
                    return false;
                }
            }
        });
    }else{
        massage('您未登录，请先登录!','');

    }
});


