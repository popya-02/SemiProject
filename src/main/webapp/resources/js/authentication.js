let num = 0;

var timer = null;
let count = 120;

const sendBtn = document.getElementById("message-send");
const phoneLabel = document.getElementById("phone-label");
const phoneA = document.getElementById("phone-a");
const userPhoneInput = document.getElementById("phonnum");

function messageSend(){
	const userPhoneVal = userPhoneInput.value;
	const pheonCheckBox = document.getElementById("pheonCheckbox");

	
	if(userPhoneVal.length === 0 || userPhoneVal === null) return alert("전화번호를 입력해주세요.");

	$.ajax({
		type: "POST",	// method
		url: "/signupUser/messageSend.do",
		data: {userPhone : userPhoneVal},	// 전송할 데이터 {키 : 값}
		success:function(data){
			
        	if(data === 0){
        		pheonCheckBox.style.display = "none";
        	}else{
				num = data;
	
        		pheonCheckBox.style.display = "flex";
				phoneA.style.display = "block";
				phoneLabel.style.display = "none";
				
				userPhoneInput.readOnly = true;
				sendBtn.disabled = true;
				
				startTimer(sendBtn);
				
				if (--count < 0) {

					
					userPhoneInput.readOnly = false;
					
					phoneA.style.display = "none";
					phoneLabel.style.display = "block";
				}
				
        	}
        },
        error:function(){
            alert("error");
        }
	})
}
	
const checkNumBtn = document.getElementById("checknum-btn");
const authenticationCheck = document.getElementById("authenticationCheck");

function sendNumCheck(){
	const checkNumInput = document.getElementById("phoncheck").value;
	const authenMsg = document.getElementById("authenticate-msg");
	const phoneBox = document.getElementById("phonnum");
	
	if(checkNumInput.length === 0 || checkNumInput === null) return alert("확인번호를 입력해주세요.");
	
	console.log(checkNumInput);
	console.log(num);
	
	if(checkNumInput == num){
		clearInterval(timer);
		authenticationCheck.value = "available";
		
        checkNumBtn.disabled = true;
		
		authenMsg.style.color = "blue";
		authenMsg.innerHTML = "인증 성공";
		
		phoneBox.readOnly = true;
		
		sendBtn.innerText = "문자 발송";
			
	}else{				
		clearInterval(timer);
		authenticationCheck.value = "unavailable";
		
		authenMsg.style.color = "red";
		authenMsg.innerHTML = "번호가 일치하지 않습니다.";
        
		checkNumBtn.disabled = false;
        
		sendBtn.disabled = false;
		
		phoneBox.readOnly = false;
		phoneA.style.display = "none";
		phoneLabel.style.display = "block";
		
		sendBtn.innerText = "문자 발송";
	}

}


function startTimer(btn) {  
		var minutes, seconds;
		timer = setInterval(function () {
		minutes = parseInt(count / 60, 10);
		seconds = parseInt(count % 60, 10);
		
		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;
	
		btn.innerText = minutes + ":" + seconds;
	
		// 타이머 끝
		if (--count < 0) {
			num = 0;
			clearInterval(timer);
			sendBtn.disabled = false;
			sendBtn.innerText = "문자 발송";
		}
		
	}, 1000);
}

function resetNum(){
	const inputPhoneReset = document.getElementById("phonnum");
	const inputCheckReset = document.getElementById("phoncheck");
	const autheDiv = document.getElementById("authenticate-msg");
	
	num = 0;
	clearInterval(timer);
	
	authenticationCheck.value = "unavailable";
	
	inputPhoneReset.value = "";
	inputCheckReset.value = "";
	inputPhoneReset.readOnly = false;
	inputCheckReset.readOnly = false;
	
	checkNumBtn.disabled = false;
	
	autheDiv.innerText = "";
	
	sendBtn.disabled = false;
	sendBtn.innerText = "문자 발송";
	
	phoneA.style.display = "none";
	phoneLabel.style.display = "block";
	
}
























