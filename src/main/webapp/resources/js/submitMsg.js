var wsUrl; 
if(window.location.protocol == 'http:'){
	wsUrl = 'ws://';
}else{
	wsUrl = 'wss://';
}

var ws = new WebSocket(wsUrl + window.location.host + "/chatting/consultation.do");
console.log(ws);
ws.onmessage = function(event){
	var area = document.getElementById("chatting-area");
	
	const div =  document.createElement("div");
	div.className = "transmit-msg";
	const divBox = area.appendChild(div);
	const p = document.createElement("p");
	const resultBox = divBox.appendChild(p);
	
	resultBox.innerHTML += event.data;

}

ws.onerror = function(event){
	console.log("Error : ", event);
}

function submitMsg(){
	const message = document.getElementById("transmit-msg").value;
	
	if(message){
		ws.send(message);
	}
	document.getElementById("transmit-msg").value = "";
}