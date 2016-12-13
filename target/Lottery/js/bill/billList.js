/**
 * Created by srq on 2016/6/1 001.
 */
var flexigrid;
var p = flexigridObj({
    url: "/adm/bill/billGrid",
    colModel: [
        {display: '姓名', name: 'name', width: 150, align: 'left'},
        {display: '抬头', name: 'title', width: 150, align: 'left'},
        {display: '类型', name: 'type', width: 150, align: 'left'},
        {display: '张数', name: 'count', width: 150, align: 'left'},
        {display: '操作', name: 'option', width: 150, align: 'left'}
    ],
    checkbox: true,
    buttons: [
        {name: '添加', bclass: 'add', onpress: add},
        {separator: true},
        {name: '删除', bclass: 'delete', onpress: del},
        {separator: true}
    ],
    sortname: ""
});

function add() {
    post('/adm/bill/toAddBill', {}, 'get');
}

function modify(id) {
    post('/adm/bill/toModifyBill', {}, 'get');
}

function del() {
    var ids = flexigrid.getCheckedRows();
    if (ids == "" || ids == [] || ids == undefined || ids == null) {
        alert("请选择要删除的行");
        return;
    }
    if (confirm("确定要删除吗？")) {
        $.post("/adm/bill/doDelBill", {ids: ids.join(',')}, function(jsonData) {
           if (jsonData.result) {
               p.page = 1;
               flexigrid = $("#dataList").flexReload(p);
           } else {
               alert(jsonData.msg);
           }
        }, "json");
    }
}

function addCell(tdObject, value, index, i) {
    if (index == 4) {
        tdObject.innerHTML = "<input type='button' value='修改' onclick='modify(" + value.id + ")'>";
    }
}

$(document).ready(function () {
    flexigrid = $("#dataList").flexigrid(p);
});