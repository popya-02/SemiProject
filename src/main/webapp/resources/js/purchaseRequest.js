
const cosntructBtn = document.getElementsByName('construct-price-btn');

for (const ele of Array.from(cosntructBtn)) {
    ele.addEventListener("click", checkPrice);
}


function checkPrice() {
	
	let chattingNum = this.getAttribute("value");
	
	var chat = document.getElementById("chattingNum_" + chattingNum).value;
	const price = document.getElementById("estimatePrice_" + chat).value;
	const constNo = document.getElementById("constNum_" + chat).value;
	
	
	
	
	console.log("price " + price);
	console.log("No " + constNo);
    if (price == null || price == 0) {
		alertSwal("견적서에 예약금액을 입력해주세요.", "", "warning", "");
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

    }

	
}


function alertSwal(titlee, msg, iconn, cUrl){
	
	const swalResult = Swal.fire({
        title: titlee,
        text: msg,
        icon: iconn,
    });

    console.log(swalResult);

    swalResult.then(() => {
        if (cUrl === 'b') {
            window.history.back();
        } else if(cUrl === ''){
			
		} else {
            location.href = cUrl;
        }
    });
}


