<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script channel="text/javascript">
    $(document).ready(function () {
        $("#menuBtn li").click(function () {
            $(this).siblings("li").removeClass("current").end().addClass("current");
        });
        slideMenu("#topMenu");
    });
</script>
<div class="header">
    <div class="logo" onclick="window.location.href='/'" style="float:left">
    </div>
    <div style="float:right;margin-top: 50px;">
        <span style="height: 25px;line-height: 25px;padding: 0 10px;float: left;color: #FFCC00;font-weight: 700;">
            <c:set var="userType" scope="page" value="${fn:split(cookie['user_t'].value, '^')}"></c:set>
            ${userType[0]}&nbsp;&nbsp;
        </span>
        <a href="/adm/logout" class="logout">[退出]</a>
    </div>
    <ul class="topNav" id="topMenu" style=" display:block; float:left;">
        <li class="subnav">
            <a href="/adm/bill/billList">发票团购</a>
            <ul>
                <li><a href="/adm/bill/billList">发票团购</a></li>
                <li class="end"></li>
            </ul>
        </li>

    </ul>
</div>
