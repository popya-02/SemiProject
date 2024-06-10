
function sigupFailCopyFunc(){

	const copyId = document.getElementById("copy-id");
	const businessRegistorCheck = document.getElementById("businessRegistorCheck");
	const copyPwd = document.getElementById("password");
	const confirmCheck = document.getElementById("confirmCheck");
	const copyName = document.getElementById("name");
	const ceoName = document.getElementById("ceo-name");
	const copyAddr = document.getElementById("addr");
	const copyRange = document.getElementById("area");
	const copyTel = document.getElementById("phonnum");
	
	if(copyId.value == ''){
		alert("사업자등록번호를 입력해주세요.");
	}else if(businessRegistorCheck.value == '' || businessRegistorCheck == 'unavailable'){
		alert("사업자등록번호를 인증해주세요.");
	}else if(copyPwd.value == ''){
		alert("비밀번호를 올바르게 입력해주세요.");		
	}else if(confirmCheck.value == '' || confirmCheck.value == 'unavailable'){
		alert("비밀번호확인란을 올바르게 입력해주세요.");
	}else if(copyName.value == ''){
		alert("업체명을 입력해주세요.");
	}else if(ceoName.value == ''){
		alert("대표자명을 입력해주세요.");
	}else if(copyAddr.value == ''){
		alert("사업장주소를 입력해주세요.");
	}else if(copyRange.value == ''){
		alert("시공지역을 입력해주세요.");
	}else if(copyTel.value == ''){
		alert("업체 전화번호를 입력해주세요.");
	}
	
}

function sigupFailUserFunc(){
	const userId = document.getElementById("id");
	const duplicateCheck = document.getElementById("duplicateCheck");
	const userPwd = document.getElementById("password");
	const userconfirmCheck = document.getElementById("confirmCheck");
	const userName = document.getElementById("name");
	const userAddr = document.getElementById("addr");
	const nickName = document.getElementById("nickname");
	const userPhone = document.getElementById("phonnum");
	const phoneCheck = document.getElementById("authenticationCheck");
	
	if(userId.value == ''){
		alert("아이디를 입력해주세요.");
	}else if(duplicateCheck.value == '' || duplicateCheck.value == 'unavailable'){
		alert("아이디중복확인을 완료해주세요.");
	}else if(userPwd.value == ''){
		alert("비밀번호를 입력해주세요.");
	}else if(userconfirmCheck.value == '' || userconfirmCheck == 'unavailable'){
		alert("비밀번호확인란을 올바르게 입력해주세요.");
	}else if(userName.value == ''){
		alert("성함을 입력해주세요.");
	}else if(userAddr.value == ''){
		alert("주소를 입력해주세요.");
	}else if(nickName.value == ''){
		alert("별명을 입력해주세요.");
	}else if(userPhone.value == ''){
		alert("전화번호 입력해주세요.");
	}else if(phoneCheck.value == '' || phoneCheck == 'unavailable'){
		alert("전화번호인증을 완료해주세요.");
	}
	
	
}