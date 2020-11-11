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
        massage('已经是首页!', 'warn', '');
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
        massage('已经是尾页!', 'warn', '');
    }
});


$("#createNewDiccuss2").click(function () {
    console.log("点击  createNewDiccuss2");
    console.log(username);

    if (username && username != null) {

        layx.iframe('createNewDiccussContent', '新建主题', './newDiscussionsPage', {
            shadable: 0.8,
            event: {
                ondestroy: {
                    before: function (layxWindow, winform, inside, escKey) {
                        massage('操作成功!', 'success', '')
                        console.log(new Date() + "关闭之前~")
                        console.log(winform);
                        console.log("=============分割线===============")
                    },
                    after: function () {
                        location.reload();
                        console.log(new Date() + "关闭之后~")
                        massage('操作成功!', 'success', '')
                        console.log("=============分割线===============")
                    }
                }
            }
        });

    } else {
        massage('您未登录，请先登录!', 'error', '');

    }
});


function onTags(data) {
    console.log('点击标签跳转' + data);
    if (username && username != null) {
        window.location.href = '/main?tag=' + data
    } else {
        window.location.href = '/?tag=' + data
    }
}

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
