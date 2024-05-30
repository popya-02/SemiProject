
const conpyIdMsg = document.getElementById("copy-id-msg");
const businessRegistorCheck = document.getElementById("businessRegistorCheck");
const businessRegistorBtn = document.getElementById("businessRegistorBtn");


function businessRegistor(){
	const copyIdInput = document.getElementById("copy-id");
	const copyId = copyIdInput.value;
	
	if(copyId.length === 0 || copyId === null) return alert("사업자등록번호를 입력해주세요.");	
	
	var data = {
      b_no: [copyId], // 실제 존재하는 사업자 번호 10자리 (실제 번호 : 3549400342)
    };

    let serviceKey ="T9bjuYz%2B3QDx85g8KoMzFEa5Ou5sNCQ3OAWkKwjz6QojRhZGh8b1ONk14GTfS4Haf98pchFMn7tFp0s%2FYbDP2A%3D%3D";
    $.ajax({
      url:
        "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=" +
        serviceKey,
      type: "POST",
      data: JSON.stringify(data),
      dataType: "JSON",
      contentType: "application/json",
      accept: "application/json",
      success: function (result) {
		
		if(result.data[0].tax_type === '국세청에 등록되지 않은 사업자등록번호입니다.'){
			businessRegistorCheck.value = "unavailable";
			conpyIdMsg.style.color = "red";
			conpyIdMsg.innerHTML = "국세청에 등록되지 않은 사업자등록번호";
		}else{
			duplicateFunc(copyId);
		}
      },
      error: function (error) {
        console.log("에러 : ", error);
        console.log(error.responseText);
      },
    });
	
}

function duplicateFunc(copyId){
	$.ajax({
			type: "POST",	// method
			url: "/signupCopy/copyidcheck.do",
			data: {copyId : copyId},	// 전송할 데이터 {키 : 값}
			success:function(data){
            	if(data === 'isNotDuplicate'){
					businessRegistorCheck.value = "available";
					conpyIdMsg.style.color = "blue";
					conpyIdMsg.innerHTML = "사업자등록번호 인증 완료";
					
					copyIdInput.readOnly = true;
	                businessRegistorBtn.disabled = true;

            	} else {
					businessRegistorCheck.value = "unavailable";
					conpyIdMsg.style.color = "red";
					conpyIdMsg.innerHTML = "이미 가입된 아이디입니다.";
            		
            	}
            },
            error:function(){
                alert("error");
            }
	})
}