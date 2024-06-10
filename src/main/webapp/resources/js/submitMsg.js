var wsUrl; 
if(window.location.protocol == 'http:'){
	wsUrl = 'ws://';
}else{
	wsUrl = 'wss://';
}

var ws = new WebSocket(wsUrl + window.location.host + "/chatting/consultation.do");

let isNoCheck = 0;
let isUserType = "";
const chatBar = document.getElementById("transmit-msg");
const chatBtn = document.getElementById("enter-btn");

ws.onmessage = function(event){
	var area = document.getElementById("chatting-area");
	const div =  document.createElement("div");
	const chatBox = document.getElementById("chatting-box");

	const lastIndex = event.data.lastIndexOf("/"); //8

	const indexCheck = parseInt(event.data.substr(lastIndex+1));
	
	const resultData = event.data;
	
	if(isNaN(indexCheck)){
		
		chatBar.style.display = "none";
		chatBtn.style.display = "none";
		
		const boxP = document.createElement("p");
		boxP.className = "endmsg";
		chatBox.append(boxP);
		
		boxP.innerText += resultData.substr(0, resultData.length - 2);
		
	}else{
		div.className = "receive-msg"; // 왼쪽
		
		if(isUserType === 'basicUser') {
			if(indexCheck === 0) {
				div.className = "receive-msg"; // 왼쪽
			}else {
				div.className = "transmit-msg"; // 오른쪽
			}
		} else if(isUserType === 'copyUser') {
			if(indexCheck === 0) {
				div.className = "transmit-msg"; // 오른쪽
			}else {
				div.className = "receive-msg"; // 왼쪽
			}
		}
		
		const divBox = area.appendChild(div);
		const p = document.createElement("p");
		const resultBox = divBox.appendChild(p);
		

		
		resultBox.innerHTML += resultData.substr(0, resultData.length - 2);
		
	}
	
	let scrolls = document.getElementById("chatting-area");
	scrolls.scrollTop = scrolls.scrollHeight;
	
}

ws.onerror = function(event){
	console.log("Error : ", event);
}


const chattingNum = document.getElementById("chatting-num").value;



function submitMsg(userType, noCheck){
	const message = document.getElementById("transmit-msg").value;
	
	isUserType = userType;
	isNoCheck = noCheck;
	
	
	if(message){
		ws.send(message+"/"+noCheck);
		
		$.ajax({
			type: "POST",	// method
			url: "/chatting/chattinglog.do",
			data: {
				chattingNum : chattingNum,
				userType : isUserType,
				message : message
			},	// 전송할 데이터 {키 : 값}
			success:function(data){
	
	        },
	        error:function(){
	            alert("error");
	        }
			
		})
		
	}
	document.getElementById("transmit-msg").value = "";
	
	
}



















