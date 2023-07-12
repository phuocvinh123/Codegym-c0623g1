var string_text = document.getElementById("screen").innerText;
function get_value( get__id ){
    var get__id
    var a = document.getElementById(get__id).innerText
    document.getElementById("screen").innerText = string_text + a;
}
function get_value_clear(){
    var a = document.getElementById("btn_clear").innerText
    document.getElementById("screen").innerText = "";
    
}

