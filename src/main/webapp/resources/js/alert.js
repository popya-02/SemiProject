
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
		alertSwal("사업자등록번호를 입력해주세요.", "", "warning", "");
	}else if(businessRegistorCheck.value == '' || businessRegistorCheck == 'unavailable'){
		alertSwal("사업자등록번호를 인증해주세요.", "", "warning", "");
	}else if(copyPwd.value == ''){
		alertSwal("비밀번호를 올바르게 인증해주세요.", "", "warning", "");
	}else if(confirmCheck.value == '' || confirmCheck.value == 'unavailable'){
		alertSwal("비밀번호확인란을 올바르게 인증해주세요.", "", "warning", "");
	}else if(copyName.value == ''){
		alertSwal("업체명을 입력해주세요.", "", "warning", "");
	}else if(ceoName.value == ''){
		alertSwal("대표자명을 입력해주세요.", "", "warning", "");
	}else if(copyAddr.value == ''){
		alertSwal("사업장주소를 입력해주세요.", "", "warning", "");
	}else if(copyRange.value == ''){
		alertSwal("시공지역을 입력해주세요.", "", "warning", "");
	}else if(copyTel.value == ''){
		alertSwal("업체 전화번호를 입력해주세요.", "", "warning", "");
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
		alertSwal("아이디를 입력해주세요.", "", "warning", "");
	}else if(duplicateCheck.value == '' || duplicateCheck.value == 'unavailable'){
		alertSwal("아이디중복확인을 완료해주세요.", "", "warning", "");
	}else if(userPwd.value == ''){
		alertSwal("비밀번호를 입력해주세요.", "", "warning", "");
	}else if(userconfirmCheck.value == '' || userconfirmCheck == 'unavailable'){
		alertSwal("비밀번호확인란을 올바르게 입력해주세요.", "", "warning", "");
	}else if(userName.value == ''){
		alertSwal("성함을 입력해주세요.", "", "warning", "");
	}else if(userAddr.value == ''){
		alertSwal("주소를 입력해주세요.", "", "warning", "");
	}else if(nickName.value == ''){
		alertSwal("별명을 입력해주세요.", "", "warning", "");
	}else if(userPhone.value == ''){
		alertSwal("전화번호를 입력해주세요.", "", "warning", "");
	}else if(phoneCheck.value == '' || phoneCheck == 'unavailable'){
		alertSwal("전화번호인증을 완료해주세요.", "", "warning", "");
	}
}


function alertSwal(titlee, msg, iconn, cUrl){
    Swal.fire({
        title:titlee,
        text: msg,
        icon: iconn,
    }).then(() => {
        if (cUrl === 'b') {
            window.history.back();
        } else if(cUrl === ''){
	
		} else {
            location.href = cUrl;
        }
    });
}