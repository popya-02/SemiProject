let num = 0;

function messageSend(){
		const userPhone = document.getElementById("phonnum").value;
		const pheonCheck = document.getElementById("pheonCheckbox");
		
		if(userPhone.length === 0 || userPhone === null) return alert("전화번호를 입력해주세요.");

		$.ajax({
			type: "POST",	// method
			url: "/signupUser/phoneAute/messageSend.do",
			data: {userPhone : userPhone},	// 전송할 데이터 {키 : 값}
			success:function(data){
            	if(data === null || data === 0){
            		pheonCheck.style.display = "none";			
            	}else{
            		pheonCheck.style.display = "flex";
            		num = data;
					console.log(data);
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