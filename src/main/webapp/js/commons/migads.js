// JavaScript Document
//顶部导航条
function slideMenu(menuId) {
    var timeout = 500;
    var closetimer = 0, closetimer2 = 0;
    var ddmenuitem = 0, ddmenuitem2 = 0;

    function menu_open() {
        menu_canceltimer();
        menu_close();
        ddmenuitem = $(this).find("ul")[0];
        $(ddmenuitem).css("visibility", "visible");
    }

    function menu_open2() {
        menu_canceltimer2();
        menu_close2();
        ddmenuitem2 = $(this).find("ul")[0];
        $(ddmenuitem2).css("visibility", "visible");
    }

    function menu_close() {
        if (ddmenuitem) $(ddmenuitem).css("visibility", "hidden");
    }

    function menu_close2() {
        if (ddmenuitem2) $(ddmenuitem2).css("visibility", "hidden");
    }

    function menu_timer() {
        closetimer = window.setTimeout(menu_close, timeout);
    }

    function menu_timer2() {
        closetimer2 = window.setTimeout(menu_close2, timeout);
    }

    function menu_canceltimer() {
        if (closetimer) {
            window.clearTimeout(closetimer);
            closetimer = null;
        }
    }

    function menu_canceltimer2() {
        if (closetimer2) {
            window.clearTimeout(closetimer2);
            closetimer2 = null;
        }
    }

    $(document).ready(function () {
        $(menuId).children("li").bind("mouseover", menu_open);
        $(menuId).children("li").bind("mouseout", menu_timer);
        $(menuId).children("li").children("ul").children("li").has("ul").addClass("li2");
        $(menuId).children("li").children("ul").children(".li2").bind("mouseover", menu_open2);
        $(menuId).children("li").children("ul").children(".li2").bind("mouseout", menu_timer2);
        var liu = $(menuId).find("li").has("ul");
        $(liu).children("a").addClass("hasChild");
    });

    document.onclick = menu_close;
}