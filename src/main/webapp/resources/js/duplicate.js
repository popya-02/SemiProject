function duplicateId(){
		const idInput = document.getElementById("id");
		const id = idInput.value;
		const checkBtn = document.getElementById("id-check");
		const idMsg = document.getElementById("duplicate-msg");
		const duplicateCheck = document.getElementById("duplicateCheck");
		
		if(id.length === 0 || id === null) return alert("아이디를 입력해주세요.");
		console.log("aa");
		$.ajax({
			type: "POST",	// method
			url: "/signupUser/idcheck.do",
			data: {id : id},	// 전송할 데이터 {키 : 값}
			success:function(data){
            	if(data === 'isNotDuplicate'){
					duplicateCheck.value = "available";
					idMsg.style.color = "blue";
					idMsg.innerHTML = "사용 가능한 아이디입니다.";
					
					idInput.readOnly = true;
	                checkBtn.disabled = true;

            	}else if(data === 'isDuplicate'){
					duplicateCheck.value = "unavailable";
					idMsg.style.color = "red";
					idMsg.innerHTML = "중복된 아이디입니다.";
            		
            	}else if(data === 'isNotPolicy'){
					duplicateCheck.value = "unavailable";
					idMsg.style.color = "red";
					idMsg.innerHTML = "아이디 정책에 맞지 않습니다.";
            	}
            },
            error:function(){
                alert("error");
            }
		})
	}
	
