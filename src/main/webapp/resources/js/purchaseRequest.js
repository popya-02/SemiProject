

function checkPrice(chattingNum) {
	var chat = document.getElementById("chattingNum_" + chattingNum).value;
	const price = document.getElementById("estimatePrice_" + chat).value;
	const constNo = document.getElementById("constNum_" + chat).value;
	
	let titlemsg = "";
	let contentmsg = "";
	let statusmsg = "";
	
	
	console.log("price " + price);
	console.log("No " + constNo);
    if (price == null || price == 0) {
		titlemsg = "견적서에 예약금액을 입력해주세요.";
		contentmsg = "";
		statusmsg = "warning";
    } else {
        var form = document.createElement('form');
        form.method = 'GET';
        form.action = '/purchaseReq.do'; // 서버의 서블릿 엔드포인트

        // Create input elements
        var chatInput = document.createElement('input');
        chatInput.type = 'hidden';
        chatInput.name = 'chattingNum';
        chatInput.value = chat;
        
        var constNoInput = document.createElement('input');
        constNoInput.type = 'hidden';
        constNoInput.name = 'constNum';
        constNoInput.value = constNo;
        
        var priceInput = document.createElement('input');
        priceInput.type = 'hidden';
        priceInput.name = 'price';
        priceInput.value = price;

        // Append inputs to the form
        form.appendChild(chatInput);
        form.appendChild(priceInput);
        form.appendChild(constNoInput);

        // Append the form to the body and submit it
        document.body.appendChild(form);
        form.submit();

		titlemsg = "결제요청 완료!";
		contentmsg = "요청 금액 : " + price + "";
		statusmsg = "success";

    }

	alertSwal(titlemsg, contentmsg , statusmsg, "");
}


function alertSwal(titlee, msg, iconn, cUrl){
    Swal.fire({
        title:titlee,
        text: msg,
        icon: iconn,
    }).then(() => {
        if (cUrl === 'b') {
            window.history.back();
        } else if(cUrl === ''){
			
		} else {
            location.href = cUrl;
        }
    });
}


