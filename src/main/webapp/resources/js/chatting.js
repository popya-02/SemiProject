function chattingConnection(){
	const copyNum = document.getElementById("copy-num").value;
	
	$.ajax({
		type: "POST",
		url: "/chatting/connection.do",
		data: {copyNum : copyNum},
		success:function(data){
			if(data === 'userType is Copy'){
				alert("업체끼리는 상담할 수 없습니다.");
			}

        },
        error:function(){
			alert("error");
        }
	})
}