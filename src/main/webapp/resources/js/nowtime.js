const clock = document.getElementById("noew-time");
const now = new Date();


function getClock(){
	const year = now.getFullYear();
	const month = ('0' + (now.getMonth() + 1)).slice(-2);
	const day = ('0' + now.getDate()).slice(-2);

	clock.innerText = year + "-" + month  + "-" + day;
	
}

getClock();