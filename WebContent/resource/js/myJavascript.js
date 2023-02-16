window.onload= function validCheck(){
    var form = document.forms[0];
    form.id.addEventListener("input", function(){
        if(form.id.nextElementSibling!==null){
            form.id.nextElementSibling.remove();
        }
        if(form.id.valueOf.length<6||form.id.valueOf.length>12){
            var error= createErrormessage("6~12 사이");
            form.id.after(error);
        }
    })
}


function createErrormessage(message){
    var div= document.createElement("div");
    div.innerText=message;
    return div;
}