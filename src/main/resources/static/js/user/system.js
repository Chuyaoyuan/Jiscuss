

$("#createNewDiccuss").click(function () {
    console.log("dianji  createNewDiccuss");
    console.log(username);
    if(username&&username!=null){
        $('.ui.modal.createNewDiccuss')
            .modal('show')
        ;
        tinymce.init({
            selector: '#discussionscontent',

          });
    }else{
        window.alert('您未登录，请先登录!');
    }
});



$("#newdiscussions").click(function(){
	
    var title = $("#discussionstitle").val();
//     $("#discussionscontent").val();
    console.log(tinyMCE.editors[0].getContent());
     var content =tinyMCE.editors[0].getContent();
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
        dataType: "JSON",
        success: function (data) {
            console.log(data);
            if(data.flag){
            	window.alert(title+',添加成功!');
                $('.ui.modal.createNewDiccuss').modal('hide');
            }else{
                window.alert(data.msg);
                return false;
            }
        }
    });

});


$("#newtags").click(function(){
	$('#createNewtagsdiv').show();
	return false;
});





$("#commitnewtags").click(function(){

    var name = $("#tagsname").val();

    console.log(name);
    $.ajax({
        type: "POST",
        url: "/newtags",
        data: JSON.stringify({
        	name: name,
        }),
        contentType: 'application/json',
        dataType: "JSON",
        success: function (data) {
            console.log(data);
            if(data.flag){
            	window.alert(name+',添加成功!');
            	return false;
            }else{
            	window.alert(name+',添加失败!');
            	return false;
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
;

$('.ui.dropdown')
    .dropdown()
;
