<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link type="text/css" href="/css/flexigrid/flexigrid.css">
    <link type="text/css" href="/css/maincss.css">
    <script type="text/javascript" src="/js/comm/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="/js/comm/flexigrid.js"></script>
    <script type="text/javascript" src="/js/admin/admin.js"></script>
</head>
<body>
    <div class="content">
        <div class="ads_title"><span class="title_tx">账号管理</span></div>
        <div class="cb">
            <div class="toolBar">
                名称：<input type="text" class="txt-ip" id="name" name="name" value="${name}"/>
                <input id="query" name="query" type="button" value="查询"
                   onclick="searchByCond()">
            </div>
        <div id="dataListDiv">
            <table id="dataList"></table>
        </div>
    </div>
</div>
</body>
</html>
