
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

	let outerHtmlString = html.outerHTML;
	
	if(copyNum == ''){
		alertSwal("사업자등록번호를 입력해주세요.", "", "warning", "");
	}else if(basicName == ''){
		alertSwal("고객명을 입력해주세요.", "", "warning", "");
	}else if(startDate == ''){
		alertSwal("시작일을 입력해주세요.", "", "warning", "");
	}else if(endDate == ''){
		alertSwal("마감일을 입력해주세요.", "", "warning", "");
	}else if(addr == ''){
		alertSwal("시공지 주소를 입력해주세요.", "", "warning", "");
	}else if(range == ''){
		alertSwal("평수를 입력해주세요.", "", "warning", "");
	}else if(tel == ''){
		alertSwal("전화번호를 입력해주세요.", "", "warning", "");
	}else if(estimatePrice == ''){
		alertSwal("예약금을 입력해주세요.", "", "warning", "");
	}else if(sumPrice == ''){
		alertSwal("합계금을 입력해주세요.", "", "warning", "");
		
	}else{
		
		if(addBtn){
			addBtn.remove();
		}
		
		if(removeSel){
			removeSel.remove();		
		}
		
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
					console.log("d");
					alertSwal("저장 성공", "견적서가 저장되었습니다.", "success", "");
				} else {
					console.log("e");
					alertSwal("저장 실패", "", "success", "");
				}
			},
			error: function() {
				console.log("f");
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
				alertSwal("수정 성공", "견적서가 수정되었습니다.", "success", "");
				window.history.back();
			} else {
				alertSwal("수정 실패", "", "success", "");
			}
		},
		error: function() {
			alert("error");
		}
	})
	
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










