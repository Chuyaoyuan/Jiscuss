$("#userButton").click(function () {
    console.log("点击  userButton");
    $('#userButtonsidebar')
        .sidebar({
            transition:'scale down' //默认uncover，可以取值push\overlay\slide along\slide out\scale down
        })
        .sidebar('toggle')
    ;
});
