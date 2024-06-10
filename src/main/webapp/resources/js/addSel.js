
function addSelFunc() {
	const table = document.getElementById('estimateTable').getElementsByTagName('tbody')[0];
	const newRow = table.insertRow(table.rows.length - 2);

	for (let i = 0; i < 6; i++) {
		const newCell = newRow.insertCell();
		const input = document.createElement('input');
		input.setAttribute("onInput", "this.setAttribute('value', this.value);");
		input.type = 'text';
		newCell.appendChild(input);
	}
}

function saveConstruct() {
	const html = document.getElementById("estimateTable");
	const copyNum = document.getElementById("copyNum").value;
	const basicNum = document.getElementById("basicNum").value;
	const startDate = document.getElementById("start-date").value;
	const endDate = document.getElementById("end-date").value;
	const addr = document.getElementById("addr").value;
	const range = document.getElementById("range").value;
	const tel = document.getElementById("tel").value;
	const estimatePrice = document.getElementById("estimatePrice").value;
	const sumPrice = document.getElementById("sumPrice").value;
	const chatNum = document.getElementById("chat-num").value;

	let outerHtmlString = html.outerHTML;

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


















