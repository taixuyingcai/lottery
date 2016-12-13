<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加发票</title>
    <link rel="stylesheet" type="text/css" href="/css/maincss.css" charset="utf-8"/>
    <script type="text/javascript" src="/js/commons/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="/js/commons/validator.js"></script>
    <script type="text/javascript" src="/js/bill/bill.js"></script>
</head>
<body>
<%@ include file="../commons/header.jsp" %>
<div class="content">
    <div class="tab_ads cb">
        <div class="ads_title">
            <span class="title_tx">添加发票</span>
        </div>
        <div class="cb">
            <form action="/adm/bill/doAddBill" method="post" id="addForm" onsubmit="return
            checkSubmit();">
                <table width="100%" border="0" class="form_tab">
                    <tr class="h15">
                        <th width="28%"></th>
                        <td width="50%">
                            <div id="errTip" class="error">${errorTip}</div>
                        </td>
                        <td width="22%"></td>
                    </tr>
                    <tr>
                        <th>姓名：</th>
                        <td>
                            <input type="text" id="name" name="name" class="regInput"
                                   onblur="emptyCheck(this, '姓名不能为空')"/>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <th>抬头：</th>
                        <td>
                            <select id="title" name="title">
                                <option value="tcl">TCL</option>
                                <option value="qt">其它</option>
                            </select>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <th>数量：</th>
                        <td><input type="text" id="count" name="count"
                                   class="regInput" onblur="emptyCheck(this, '数量不能为空')"/>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <th>面额：</th>
                        <td>
                            <select id="cost" name="cost">
                                <option value="10000">默认（1万）</option>
                                <option value="20000">其它</option>
                            </select>
                        </td>
                        <td>
                        </td>
                    </tr>

                    <tr>
                        <th></th>
                        <td><input name="" type="button" class="btn"
                                   value="提交" onclick="submitAddForm();"/></td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<%@ include file="../commons/footer.jsp" %>
</body>
</html>