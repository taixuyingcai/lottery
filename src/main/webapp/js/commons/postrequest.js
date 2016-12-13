function post(URL, PARAMS, METHOD) {
    var temp = document.createElement("form");
    temp.action = URL;
    temp.method = METHOD;
    temp.style.display = "none";
    for (var x in PARAMS) {
        var opt = document.createElement("textarea");
        opt.name = x;
        opt.value = PARAMS[x];
        temp.appendChild(opt);
    }
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}