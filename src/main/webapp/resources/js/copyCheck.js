	
	
	
	document.getElementById("cancle").style.display = "none";
    function check() {
        
        alert('승인 되었습니다');
        let check = document.getElementById("check");
        check.innerHTML = "완료";
        check.style.backgroundColor='orange';
        document.getElementById("cancle").style.display = "block";
    }

    function cancle() {
        let check = document.getElementById("check");
        let cancle = document.getElementById("cancle");
        alert('취소 되었습니다');
        check.innerHTML = "승인";
        check.style.backgroundColor='#869ec9';
        document.getElementById("cancle").style.display = "none";
    }