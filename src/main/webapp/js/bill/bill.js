function submitAddForm() {
    if (
        emptyCheck(document.getElementById("name"), "名称不能为空") &&
        emptyCheck(document.getElementById("count"), "count不能为空")
    ) {
        document.forms["addForm"].submit();
    }
}

function emptyCheck(obj, msg) {
    var val = obj.value;
    var id = obj.id;
    if (!notEmptyStr(val)) {
        $("#errTip").html(msg);
        obj.focus();
        return false;
    }
    $("#errTip").html("");
    return true;
}

function numberCheck(obj,msg){
    var val = obj.value;
    if(isNaN(val)){
        $("#errTip").html(msg);
        obj.focus(); 
        return false;
    }
    $("#errTip").html("");
    return true;

}

function check(obj, msg){
    str = obj.value;
    str = str.match(/http[s]?:\/\/.+/);
    if (str == null){
        $("#errTip").html(msg);
        obj.focus();
        return false;
    }
    $("#errTip").html("");
    return true;
}

function submitModifyForm() {
    if (
        emptyCheck(document.getElementById("name"), "名称不能为空") &&
        emptyCheck(document.getElementById("count"), "count不能为空")
    ) {
        document.forms["modifyForm"].submit();
    }
}