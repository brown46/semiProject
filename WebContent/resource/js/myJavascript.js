window.onload= function validCheck(){
    var form = document.forms[0];
    var form2 = document.forms[1];
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



    form2.email.addEventListener("input", function(){
        if(form2.email.nextElementSibling!==null){
            form2.email.nextElementSibling.remove();
        }
        if(form2.email.value.length<1 || form2.email.value.length>40){
            var error= createErrormessage("1자 이상 40자 이하");
            form2.email.after(error);
        }
    });

    form2.email.addEventListener("focus", function(){
        if(form2.email.nextElementSibling!==null){
            form2.email.nextElementSibling.remove();
        }
        if(form2.email.value.length<2){
            var error= createErrormessage("1자 이상 40자 이하");
            form2.email.after(error);
        }
    });






    form2.password.addEventListener("input", function(){
        if(form2.password.nextElementSibling!==null){
            form2.password.nextElementSibling.remove();
        }
        if(form2.password.value.length< 6||form2.password.value.length>20){
            var error= createErrormessage("6~20 사이");
            form2.password.after(error);
        }
    });

    form2.passwordChk.addEventListener("input",function(){
        if(form2.passwordChk.nextElementSibling!==null){
            form2.passwordChk.nextElementSibling.remove();
        }
        if(form2.password.value !== form2.passwordChk.value){
            var error= createErrormessage("password not correct");
            form2.passwordChk.after(error);
        }
    });
}


function createErrormessage(message){
            var div= document.createElement("div");
            div.className += 'error';
            div.innerText=message;
    return div;
}



// $("#dupChk").click(checkDupId);
// 	function checkDupId() {
// 		$.ajax({url:"<%=request.getContextPath()%>/dupChk"
// 			  , type:"post" 
// 			  , async:false
// 			  , contentType: "application/json; charset:utf-8"
// 			  , data: {id: $("input").first().val(), nickname :$("#nickname").val()} 
// 			  , success: function(result){
// 				             console.log(result);
// 				             if(result==1){
// 					             $("#dupId").next().html("중복아이디가 있습니다. 다시 입력해주세요");
// 					             $("#dupId").next().css("color","red");				
// 				             }else{
// 					             $("#dupId").next().html("사용가능한 아이디입니다.");
// 					             $("#dupId").next().css("color","blue");
// 				             }
// 			             }
// 			, error: function(request, status, error){
// 				alert(request.status);
// 			}
			
// 			});
// 	}