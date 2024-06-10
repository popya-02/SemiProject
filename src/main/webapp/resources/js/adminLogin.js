let btnCnt = 0;

function adminLoginFunc(){
	btnCnt += 1;
		
	console.log(btnCnt);
	if(btnCnt == 5){
		btnCnt = 0;
		location.href = '/form/adminLogin.do';
	}
}
