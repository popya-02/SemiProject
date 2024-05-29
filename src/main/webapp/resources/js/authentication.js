let num = 0;

var timer = null;

function messageSend(){
	const userPhone = document.getElementById("phonnum").value;
	const pheonCheck = document.getElementById("pheonCheckbox");
	const sendBtn = document.getElementById("message-send");
	
	if(userPhone.length === 0 || userPhone === null) return alert("전화번호를 입력해주세요.");

	$.ajax({
		type: "POST",	// method
		url: "/signupUser/phoneAute/messageSend.do",
		data: {userPhone : userPhone},	// 전송할 데이터 {키 : 값}
		success:function(data){
			
        	if(data === 0){
        		pheonCheck.style.display = "none";		
        	}else{
	
        		pheonCheck.style.display = "flex";
				sendBtn.disabled = true;
	
				var leftSec = 10;
				
				startTimer(leftSec, sendBtn);
				
				
        	}
        },
        error:function(){
            alert("error");
        }
	})
}
	
function sendNumCheck(){
	const checkNum = document.getElementById("phoncheck").value;
	const msg = document.getElementById("authenticate-msg");
	const authenticationCheck = document.getElementById("authenticationCheck");
	
	if(checkNum.length === 0 || checkNum === null) return alert("확인번호를 입력해주세요.");
	
	console.log(checkNum);
	console.log(num);
	
	if(checkNum == num){
		authenticationCheck.value = "available";
		msg.style.color = "blue";
		msg.innerHTML = "인증 완료";				
	}else{				
		authenticationCheck.value = "unavailable";
		msg.style.color = "red";
		msg.innerHTML = "인증 실패";
	}

}


function startTimer(count, sendBtn) {  
		var minutes, seconds;
		timer = setInterval(function () {
		minutes = parseInt(count / 60, 10);
		seconds = parseInt(count % 60, 10);
		
		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;
	
		sendBtn.innerText = minutes + ":" + seconds;
	
		// 타이머 끝
		if (--count < 0) {
			num = 0;
			sendBtn.disabled = false;
			clearInterval(timer);
			sendBtn.innerText = "문자 발송";
		}
	}, 1000);
}