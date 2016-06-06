<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="/js/commons/migads.js"/>
<link type="text/css" href="/css/maincss.css" charset="utf-8"/>

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
            <a href="/adm/app/list">开发者管理</a>
            <ul>
                <li><a href="/adm/app/list">开发者管理</a></li>
                <li><a href="/adm/app/list">应用管理</a></li>
                <li class="end"></li>
            </ul>
        </li>
        <li class="subnav">
            <a href="/adm/app/list">广告主管理</a>
            <ul>
                <li><a href="/adm/app/list">广告主管理</a></li>
                <li><a href="/adm/app/list">广告活动管理</a></li>
                <li><a href="/adm/app/list">广告管理</a></li>
                <li><a href="/adm/app/list">广告物料管理</a></li>
                <li class="end"></li>
            </ul>
        </li>
        <li class="subnav">
            <a href="/adm/model/modelList">手机型号管理</a>
            <ul>
                <li><a href="/adm/model/modelList">手机型号管理</a></li>
                <li class="end"></li>
            </ul>
        </li>
        <li class="subnav">
            <a href="/adm/app/list">统计管理</a>
            <ul>
                <li><a href="/adm/app/list">广告主统计</a></li>
                <li><a href="/adm/app/list">广告活动统计</a></li>
                <li><a href="/adm/app/list">广告统计</a></li>
                <li><a href="/adm/app/list">广告物料统计</a></li>
                <li><a href="/adm/app/list">开发者统计</a></li>
                <li><a href="/adm/app/list">应用统计</a></li>
                <li class="end"></li>
            </ul>
        </li>
        <li class="subnav">
            <a href="/adm/cfg/cfgList">配置管理</a>
            <ul>
                <li><a href="/adm/cfg/cfgList">配置管理</a></li>
                <li><a href="/adm/language/languageList">语言管理</a></li>
                <li class="end"></li>
            </ul>
        </li>
        <li class="subnav">
            <a href="/adm/adminList">系统用户</a>
            <ul>
                <li><a href="/adm/adminList">系统用户</a></li>
                <li><a href="/adm/admRole/roleList">管理员角色列表</a></li>
                <li class="end"></li>
            </ul>
        </li>

        <li class="subnav">
            <a href="/adm/region/regionList">地域管理</a>
            <ul>
                <li><a href="/adm/region/regionList">地域管理</a></li>
                <li class="end"></li>
            </ul>
        </li>

        <li class="subnav">
            <a href="/adm/category/categoryList">分类管理</a>
            <ul>
                <li><a href="/adm/category/categoryList">分类管理</a></li>
                <li class="end"></li>
            </ul>
        </li>
    </ul>
</div>
