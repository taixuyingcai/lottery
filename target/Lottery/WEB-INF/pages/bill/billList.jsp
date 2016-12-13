<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/css/flexigrid/flexigrid.css" charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="/css/maincss.css" charset="utf-8"/>
    <script type="text/javascript" src="/js/commons/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="/js/commons/flexigrid.js"></script>
    <script type="text/javascript" src="/js/commons/postrequest.js"></script>
    <script type="text/javascript" src="/js/bill/billList.js"></script>
</head>
<body>
<%@ include file="../commons/header.jsp" %>
    <div class="content">
        <div class="ads_title"><span class="title_tx">发票</span></div>
        <div class="cb">
            <div class="toolBar">
                姓名：<input type="text" class="txt-ip" id="name" name="name" value="${name}"/>
                <input id="query" name="query" type="button" value="查询"
                   onclick="searchByCond()">
            </div>
        <div id="dataListDiv">
            <table id="dataList"></table>
        </div>
    </div>
</div>
<%@ include file="../commons/footer.jsp" %>
</body>
</html>
