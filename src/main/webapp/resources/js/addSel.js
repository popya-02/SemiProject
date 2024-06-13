
function addSelFunc() {
	const table = document.getElementById('estimateTable').getElementsByTagName('tbody')[0];
	const newRow = table.insertRow(table.rows.length - 2);

	// 클래스 배열을 정의
	const cellClasses = ['', '', '', '', '', 'border-none2'];

	for (let i = 0; i < 6; i++) {
		const newCell = newRow.insertCell();
		const input = document.createElement('input');
		input.setAttribute("onInput", "this.setAttribute('value', this.value);");
		input.type = 'text';
		newCell.appendChild(input);

		// 각 셀에 클래스를 추가합니다.
		if (cellClasses[i]) {
			newCell.classList.add(cellClasses[i]);
		}
	}

	// 삭제 버튼 셀 생성
	const removeBtnCell = newRow.insertCell();
	removeBtnCell.classList.add('border-none');
	const removeButton = document.createElement('button');
	removeButton.textContent = '-';
	removeButton.className = 'remove-btn';
	removeButton.id = 'remove-btn-2';
	removeButton.setAttribute("onclick", "removeSelFunc(this)");
	removeBtnCell.appendChild(removeButton);
}

function removeSelFunc(btn){
	var tdElement = btn.parentNode;

    var trElement = tdElement.parentNode;
	
	trElement.remove();
}


function saveConstruct() {
	const html = document.getElementById("estimateTable");
	const copyNum = document.getElementById("copyNum").value;
	const basicNum = document.getElementById("basicNum").value;
	const basicName = document.getElementById("basic-name").value;
	const startDate = document.getElementById("start-date").value;
	const endDate = document.getElementById("end-date").value;
	const addr = document.getElementById("addr").value;
	const range = document.getElementById("range").value;
	const tel = document.getElementById("tel").value;
	const estimatePrice = document.getElementById("estimatePrice").value;
	const sumPrice = document.getElementById("sumPrice").value;
	const chatNum = document.getElementById("chat-num").value;
	
	const addBtn = document.getElementById("add-btn");
	const removeSel = document.getElementById("remove-btn-2");
	addBtn.remove();
	if(removeSel){
		removeSel.remove();		
	}

	let outerHtmlString = html.outerHTML;
	
	if(copyNum == ''){
		alert("사업자등록번호를 입력해주세요.");
	}else if(basicName == ''){
		alert("고객명을 입력해주세요.");
		
	}else if(startDate == ''){
		alert("시작일을 입력해주세요.");
		
	}else if(endDate == ''){
		alert("마감일을 입력해주세요.");
		
	}else if(addr == ''){
		alert("시공지 주소를 입력해주세요.");
		
	}else if(range == ''){
		alert("평수를 입력해주세요.");
		
	}else if(tel == ''){
		alert("전화번호를 입력해주세요.");
		
	}else if(estimatePrice == ''){
		alert("예약금을 입력해주세요.");
		
	}else if(sumPrice == ''){
		alert("합계금을 입력해주세요.");
		
	}else{
		console.log("aaaaaaa");
		$.ajax({
			type: "POST",	// method
			url: "/construct/saveConstruct.do",
			data: {
				element: outerHtmlString,
				copyNum: copyNum,
				basicNum: basicNum,
				startDate: startDate,
				endDate: endDate,
				addr: addr,
				range: range,
				tel: tel,
				estimatePrice: estimatePrice,
				sumPrice: sumPrice,
				chatNum: chatNum,
			},	// 전송할 데이터 {키 : 값}
			success: function(data) {
				if (data == 'success') {
					alert("견적서가 저장되었습니다.");
					window.history.back();
				} else {
					alert("저장실패");
	
				}
			},
			error: function() {
				alert("error");
			}
		})
		
	}
	

}

function updateConstruct(){
	const html = document.getElementById("estimateTable");
	const startDate = document.getElementById("start-date").value;
	const endDate = document.getElementById("end-date").value;
	const addr = document.getElementById("addr").value;
	const range = document.getElementById("range").value;
	const estimatePrice = document.getElementById("estimatePrice").value;
	const sumPrice = document.getElementById("sumPrice").value;
	const chatNum = document.getElementById("chat-num").value;
	
	let outerHtmlString = html.outerHTML;
	
	$.ajax({
		type: "POST",	// method
		url: "/construct/updateConstruct.do",
		data: {
			element: outerHtmlString,
			startDate: startDate,
			endDate: endDate,
			addr: addr,
			range: range,
			estimatePrice: estimatePrice,
			sumPrice: sumPrice,
			chatNum: chatNum,
		},	// 전송할 데이터 {키 : 값}
		success: function(data) {
			if (data == 'success') {
				alert("견적서가 수정되었습니다.");
				window.history.back();
			} else {
				alert("수정실패");

			}
		},
		error: function() {
			alert("error");
		}
	})
	
}


















