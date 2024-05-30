

function effectivePwd(){
	const pwd = document.getElementById("password").value;
	const pwdMsg = document.getElementById("password-msg");

	
	$.ajax({
		type: "POST",	// method
		url: "/signupUser/effective/password.do",
		data: {pwd : pwd},	// 전송할 데이터 {키 : 값}
		success:function(data){
			if(data === 'isMatche'){
				pwdMsg.style.color = "blue";
				pwdMsg.innerHTML = "사용 가능한 비밀번호입니다.";
			}else {
				pwdMsg.style.color = "red";
				pwdMsg.innerHTML = "비밀번호 정책에 맞지 않습니다.";
			}
        },
        error:function(){

        }
	})
}

function confirmPwdFunc(){
	const confirmPwd = document.getElementById("confirmPwd").value;
	const pwd2 = document.getElementById("password").value;
	const confirmMsg = document.getElementById("confirmPwd-msg");
	const confirmCheck = document.getElementById("confirmCheck");
	
	if(confirmPwd === pwd2){
		confirmCheck.value = "available";
		confirmMsg.style.color = "blue";
		confirmMsg.innerHTML = "비밀번호가 일치합니다.";		
	}else{
		confirmCheck.value = "unavailable";
		confirmMsg.style.color = "red";
		confirmMsg.innerHTML = "비밀번호가 일치하지 않습니다.";
	}
	
	
}

function effectiveName(){
	const name = document.getElementById("name").value;
	const nameMsg = document.getElementById("name-msg");
	const effectiveNameCheck = document.getElementById("effectiveNameCheck");
	
	$.ajax({
		type: "POST",	// method
		url: "/signupUser/effective/name.do",
		data: {name : name},	// 전송할 데이터 {키 : 값}
		success:function(data){
			if(data === 'isMatche'){
				effectiveNameCheck.value = "available";
				nameMsg.innerHTML = "";				
			}else {
				effectiveNameCheck.value = "unavailable";
				nameMsg.style.color = "red";
				nameMsg.innerHTML = "이름을 올바르게 작성해주세요.";
			}
        },
        error:function(){

        }
	})
	
}