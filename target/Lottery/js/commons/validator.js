function checkIdcard(idcard) {
    idcard = $.trim(idcard);
    var Errors = new Array(
        "验证通过!",
        "身份证号码位数不对!",
        "身份证号码出生日期超出范围或含有非法字符!",
        "身份证号码校验错误!",
        "身份证地区非法!"
    );
    var area = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙古",
        21: "辽宁",
        22: "吉林",
        23: "黑龙江",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外"
    }

    var idcard, Y, JYM;
    var S, M;
    var idcard_array = new Array();
    idcard_array = idcard.split("");
//地区检验
    if (area[parseInt(idcard.substr(0, 2))] == null) return Errors[4];
//身份号码位数及格式检验
    switch (idcard.length) {
        case 15:
            if ((parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0 || ((parseInt(idcard.substr(6, 2)) + 1900) % 100 == 0 && (parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0 )) {
                ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性
            } else {
                ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性
            }
            if (ereg.test(idcard)) return Errors[0];
            else return Errors[2];
            break;
        case 18:
//18位身份号码检测
//出生日期的合法性检查
//闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
//平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
            if (parseInt(idcard.substr(6, 4)) % 4 == 0 || (parseInt(idcard.substr(6, 4)) % 100 == 0 && parseInt(idcard.substr(6, 4)) % 4 == 0 )) {
                ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式
            } else {
                ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式
            }
            if (ereg.test(idcard)) {//测试出生日期的合法性
//计算校验位
                S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
                + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
                + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
                + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
                + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
                + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
                + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
                + parseInt(idcard_array[7]) * 1
                + parseInt(idcard_array[8]) * 6
                + parseInt(idcard_array[9]) * 3;
                Y = S % 11;
                M = "F";
                JYM = "10X98765432";
                M = JYM.substr(Y, 1);//判断校验位
                if (M == idcard_array[17])
                    return Errors[0]; //检测ID的校验位
                else
                    return Errors[3];
            }
            else return Errors[2];
            break;
        default:
            return Errors[1];
            break;
    }
}
// 非正则判断
function isphonenumber(str) {
    var i, strlength, tempchar;
    if (str == "") return false;
    strlength = str.length;
    for (i = 0; i < strlength; i++) {
        tempchar = str.substring(i, i + 1);
        if (!(tempchar == 0 || tempchar == 1 || tempchar == 2 || tempchar == 3 || tempchar == 4 || tempchar == 5 || tempchar == 6 || tempchar == 7 || tempchar == 8 || tempchar == 9 || tempchar == '-')) {
            return false;
        }
    }
    return true;
}

function engChiLengthCheck(str, englen, chilen) {
    // 判断str中是否含有中文
    var useChi = /.*[\u4e00-\u9fa5]+.*$/.test(str);
    var maxlen = useChi ? chilen : englen;
    return strLengthCheck(str, 0, maxlen);
}

function strLengthCheck(str, minlen, maxlen) {
    // 如果字符串为空，直接返回true
    if (!notEmptyStr(str))
        return true;
    var strlen = str.length;
    // 字符串中出现换行（通常在textarea中），提交到服务器时会变成\r\n，占两个字符，因此在此处将换行符算成2个字符
    var match = str.match(/(\r)|(\n)/g);
    strlen += (match == null ? 0 : match.length);
    return !(strlen < minlen || strlen > maxlen);
}

function notEmptyStr(str) {
    return str != null && str.length != 0;
}

function checkVersion(str) {
    var regVersion = /^\d{1,3}\.\d{1,3}\.\d{1,3}$/;
    return regVersion.test(str);
}

function testEmail(str) {
    var reg = /^([a-zA-Z0-9]+[_|\_|-|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|-|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    return reg.test(str);
}

function notEmptyCheck(elementId, errorMsg, isfocus) {
    return resCheck(notEmptyStr, elementId, errorMsg, isfocus);
}

// WARNING: 字符串为空时不进行长度检查，
// 如果用来验证非空字符串长度，请配合使用notEmptyCheck
function valueLengthCheck(elementId, minlen, maxlen, errorMsg, isfocus) {
    var value = $("#" + elementId).val();
    value = $.trim(value);
    var res = strLengthCheck(value, minlen, maxlen);
    switchErrorMsg(res, elementId + "Tip", errorMsg);
    if (isfocus && !res) {
        $("#" + elementId).focus();
    }
    $("#" + elementId).val(value);
    return res;
}

// 检查中英文最大长度限制，如果含有中文，即以中文计算
// WARNING: 字符串为空时不进行检查，
// 如果用来验证非空字符串长度，请配合使用notEmptyCheck
function valueEngChiLengthCheck(elementId, englen, chilen, errorMsg, isfocus) {
    var value = $("#" + elementId).val();
    value = $.trim(value);
    var res = engChiLengthCheck(value, englen, chilen);
    switchErrorMsg(res, elementId + "Tip", errorMsg);
    if (isfocus && !res) {
        $("#" + elementId).focus();
    }
    $("#" + elementId).val(value);
    return res;
}

// 检查email格式
// WARNING: 字符串为空时不进行检查，
// 如果用来验证非空email，请配合使用notEmptyCheck
function isEmailCheck(elementId, errorMsg, isfocus) {
    return resCheck(testEmail, elementId, errorMsg, isfocus);
}

// 检查手机号码格式
// WARNING: 字符串为空时不进行检查，
// 如果用来验证非空email，请配合使用notEmptyCheck
function isPhoneNumberCheck(elementId, errorMsg, isfocus) {
    return resCheck(isphonenumber, elementId, errorMsg, isfocus);
}

function switchErrorMsg(isValid, tipId, errorMsg) {
    $("#" + tipId).html(isValid ? "" : errorMsg);
}
// 通用带提示非正则（特有函数）校验方法
function resCheck(func, elementId, errorMsg, isfocus) {
    var value = $("#" + elementId).val();
    value = $.trim(value);
    var res = func(value);
    switchErrorMsg(res, elementId + "Tip", errorMsg);
    if (isfocus && !res) {
        $("#" + elementId).focus();
    }
    $("#" + elementId).val(value);
    return res;
}
// 通用带提示正则校验方法
function testCheck(test, elementId, errorMsg, isfocus) {
    var value = $("#" + elementId).val();
    value = $.trim(value);
    var res = test.test(value);
    switchErrorMsg(res, elementId + "Tip", errorMsg);
    if (isfocus && !res) {
        $("#" + elementId).focus();
    }
    $("#" + elementId).val(value);
    return res;
}

// 验证是否为Int
function isIntCheck(elementId, errorMsg, isfocus) {
    return testCheck(/^(\d+)$/, elementId, errorMsg, isfocus);
}

// 验证是否为Int
function intRanageCheck(elementId, min, max, errorMsg, isfocus) {
    var value = $("#" + elementId).val();
    value = $.trim(value);
    var numValue = Number(value);
    var res = numValue != NaN && numValue >= min && numValue <= max;
    switchErrorMsg(res, elementId + "Tip", errorMsg);
    if (isfocus && !res) {
        $("#" + elementId).focus();
    }
    $("#" + elementId).val(value);
    return res;
}

// 验证是否为double
function isDoubleCheck(elementId, errorMsg, isfocus) {
    return testCheck(/^\d+((\.?\d+)|(\d*))$/, elementId, errorMsg, isfocus);
}

// 验证是否为double
function isDouble2Check(elementId, errorMsg, isfocus) {
    return testCheck(/^[0-9]+([.]\d{0,2})?$/, elementId, errorMsg, isfocus);
}

// 验证是否为double
function isDouble4Check(elementId, errorMsg, isfocus) {
    return testCheck(/^[0-9]+([.]\d{0,4})?$/, elementId, errorMsg, isfocus);
}

// 验证是否为带符号的double
function isSignedDouble2Check(elementId, errorMsg, isfocus) {
    return testCheck(/^-?[0-9]+([.]\d{0,2})?$/, elementId, errorMsg, isfocus);
}

// 数值型值上限检查
function numLessThanCheck(elementId, max, include, errorMsg, isfocus) {
    var value = $("#" + elementId).val();
    value = $.trim(value);
    var numValue = Number(value);
    var res = numValue != NaN && (include ? numValue <= max : numValue < max);
    switchErrorMsg(res, elementId + "Tip", errorMsg);
    if (isfocus && !res) {
        $("#" + elementId).focus();
    }
    $("#" + elementId).val(value);
    return res;
}

// 数值型值下限检查
function numGreatThanCheck(elementId, min, include, errorMsg, isfocus) {
    var value = $("#" + elementId).val();
    value = $.trim(value);
    var numValue = Number(value);
    var res = numValue != NaN && (include ? numValue >= min : numValue > min);
    switchErrorMsg(res, elementId + "Tip", errorMsg);
    if (isfocus && !res) {
        $("#" + elementId).focus();
    }
    $("#" + elementId).val(value);
    return res;
}

// 验证是否为百分比, 且不能大于100
function isPercentageCheck(elementId, errorMsg, isfocus) {
    return testCheck(/^\d+((\.?\d+)|(\d*))$/, elementId, errorMsg, isfocus);
}

// 验证是否URL
function isURLCheck(elementId, errorMsg, isfocus) {
    return testCheck(/[a-zA-z]+:[/][/][^\s]+/, elementId, errorMsg, isfocus);
}

//JS 四舍五入自定义小数位数，空缺补0
function formatNumber(value, num) {
    var a, b, c, i;
    a = value.toString();
    b = a.indexOf(".");
    c = a.length;
    if (num == 0) {
        if (b != -1) {
            a = a.substring(0, b);
        }
    } else {
        if (b == -1) {
            a = a + ".";
            for (i = 1; i <= num; i++) {
                a = a + "0";
            }
        } else {
            a = a.substring(0, b + num + 1);
            for (i = c; i <= b + num; i++) {
                a = a + "0";
            }
        }
    }
    return a;
}
//对数字进行四舍五入计算，并补零
function dightNumber(num, n) {
    var dd = 1;
    var tempnum;
    for (i = 0; i < n; i++) {
        dd *= 10;
    }
    tempnum = num * dd;
    tempnum = Math.round(tempnum);
    return formatNumber(tempnum / dd, n);
}

//对数字设置千分符
function micrometer(num) {
    var reg = /(\d{1,3})(?=(\d{3})+(?:$|\.))/g;
    return num.replace(reg, "$1,");
}

//对td的数字值设置千分符
function setTdNumMicro(td) {
    td.innerHTML = micrometer(td.innerHTML);
}

/* Date format */
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(), //day
        "h+": this.getHours(), //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}
// 数字补零
Number.prototype.LengthWithZero = function (_len) {
    var strText = this.toString();
    while (strText.length < _len) {
        strText = '0' + strText;
    }
    return strText;
};


// 日期格式化，仿java格式，如 yyyy-MM-dd hh:mm:ss
Date.prototype.format = function (format) //author: meizz
{
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(),    //day
        "h+": this.getHours(),   //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter
        "S": this.getMilliseconds() //millisecond
    };
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1,
                RegExp.$1.length == 1 ? o[k] :
                    ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};
