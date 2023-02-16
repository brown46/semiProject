
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
    div.className += 'error';
    div.innerText=message;
    return div;
}

$("#dupChk").on("click",handlerClickBtnDupChk);

	function handlerClickBtnDupChk(){
        var form = document.forms[0];
        var id = form.id.value;
        var nickname= form.nickname.value;
		console.log("btnEnroll눌림");
        window.open("${contextPath}/myProject/dupChk?id="+id+"&nickname="+nickname,"","width=500,height=300");
		// alert('${idCount}');
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
