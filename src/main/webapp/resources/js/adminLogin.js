let btnCntAdmin = 0;

function adminLoginFunc(){
	btnCntAdmin += 1;
		
	console.log(btnCntAdmin);
	if(btnCntAdmin == 5){
		btnCntAdmin = 0;
		location.href = '/form/adminLogin.do';
	}
}
