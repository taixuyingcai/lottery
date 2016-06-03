/**
 * Created by srq on 2016/6/1 001.
 */
var flexigrid;
var p = flexigridObj({
    url: "/adm/admin/adminGrid",
    colModel: [
        {display: '账号', name: 'uid', width: 150, align: 'left'},
        {display: '名称', name: 'name', width: 150, align: 'left'},
        {display: '角色级别', name: 'roleType', width: 150, align: 'left'},
        {display: '操作', name: 'option', width: 150, align: 'left'}
    ],
    checkbox: true,
    buttons: [
        {name: '添加', bclass: 'add', onpress: 'add'},
        {separator: true},
        {name: '删除', bclass: 'delete', onpress: 'del'},
        {separator: true}
    ],
    sortname: ""
});

function add() {

}

function modify(id) {

}

function del() {

}

function addCell(tdObject, value, index, i) {
    if (index == 3) {
        tdObject.innerHTML = "<input type='button' value='修改' onclick='modify(" + value.id + ")'>";
    }
}

$(document).ready(function () {
    flexigrid = $("#dataList").flexigrid(p);
});