window.onload= function validCheck(){
    var form = document.forms[0];
    form.id.addEventListener("input", function(){
        if(form.id.nextElementSibling!==null){
            form.id.nextElementSibling.remove();
        }
        if(form.id.value.length<1||form.id.value.length>20){
            var error= createErrormessage("1~20 사이");
            form.id.after(error);
        }
    });
    form.nickname.addEventListener("input", function(){
        if(form.nickname.nextElementSibling!==null){
            form.nickname.nextElementSibling.remove();
        }
        if(form.nickname.value.length<1||form.nickname.value.length>20){
            var error= createErrormessage("1~20 사이");
            form.nickname.after(error);
        }
    });



    form.email.addEventListener("input", function(){
        if(form.email.nextElementSibling!==null){
            form.email.nextElementSibling.remove();
        }
        if(form.email.value.length<1 || form.email.value.length>40){
            var error= createErrormessage("1자 이상 40자 이하");
            form.email.after(error);
        }
    });

    form.email.addEventListener("focus", function(){
        if(form.email.nextElementSibling!==null){
            form.email.nextElementSibling.remove();
        }
        if(form.email.value.length<2){
            var error= createErrormessage("1자 이상 40자 이하");
            form.email.after(error);
        }
    });






    form.password.addEventListener("input", function(){
        if(form.password.nextElementSibling!==null){
            form.password.nextElementSibling.remove();
        }
        if(form.password.value.length< 6||form.password.value.length>20){
            var error= createErrormessage("6~20 사이");
            form.password.after(error);
        }
    });

    form.passwordChk.addEventListener("input",function(){
        if(form.passwordChk.nextElementSibling!==null){
            form.passwordChk.nextElementSibling.remove();
        }
        if(form.password.value !== form.passwordChk.value){
            var error= createErrormessage("password not correct");
            form.passwordChk.after(error);
        }
    });
}


function createErrormessage(message){
    var div= document.createElement("div");
    div.innerText=message;
    return div;
}