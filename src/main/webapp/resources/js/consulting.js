function consultingEnd(){
	const chatNum  = document.getElementById("chatting-num").value;

	
	$.ajax({
		type: "POST",
		url: "/chatting/deleteChatLog.do",
		data: {chatNum : chatNum},
		success:function(data){
			if(data === 'isDelete'){
				// send -> message 보내주고
				ws.send("상담이 종료되었습니다.ed");
				ws.onclose = function(event){
					if(event.wasClean){
						console.log("close");
					}else{
						console.log("NOTclose");
						
					}
				};
				alert("상담이 정상적으로 종료되었습니다.");
				window.history.back();
				
			}else{
				alert("상담 종료가 실패되었습니다.");
			}
		},
		error:function(){
			alert("ERROR");
		}
	})
}