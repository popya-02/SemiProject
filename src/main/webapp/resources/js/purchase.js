// 구매자 정보
 var IMP = window.IMP;
 IMP.init("imp67844376");   /* imp~ : 가맹점 식별코드*/
 
 let amount = document.getElementById("amount").value;
 let userName = document.getElementById("name").value;
 let copy = document.getElementById("company").value;
 let goodsName = document.getElementById("goods").value;
 const detailAddr = document.getElementById("detailAddr");
 let addr = document.getElementById("address").value;
 const constNo = document.getElementById("constructNum").value;
 const chatNo = document.getElementById("chattingNum").value;


 $('#money-btn').click(function() {
	console.log("12: " + detailAddr.value)
		if (detailAddr && detailAddr.value == "") {
			alert("상세주소를 입력해 주세요.");
		} else {
		IMP.request_pay({
			pg: 'html5_inicis',
			pay_method: 'card',				 /* 결제 수단방법 */

			P_GOODS: '업체 명',
			name: constNo,
			amount: amount,
            acceptName: "SKIN(#5E2BB8)"
            
		}, function(rsp) {
			
			// 결제가 성공됐을때 complete.do 가 호출되어야함
							
			// 결제가 실패되면 환불.do 가 호출되어야함
			if(rsp.error_msg == null) {
			$.ajax({
                    url: '/complete.do',
                    type: 'POST',
					data: {
						chatNo: chatNo,
						detailAddr: detailAddr.value
					},
					success: function(response) {
						var msg;
                        if (response === 'success') {
                            window.location.href = '/views/etc/complete.jsp';
							msg;
							console.log("결제성공");
							alert(msg);
                        } else {
							msg = '결제에 실패하였습니다.';
							msg += '에러내용 : ' + rsp.error_msg;
							alert(msg);
                        }
                    },
                    error: function() {
                        window.location.href = 'error.jsp';
                    }
				})
			}
  
		});
	}
	});
	
	
	
	
	
    $(document).ready(function() {
    console.log("?");
        console.log($("#datepicker"));
        $( "#datepicker" ).datepicker({
            changeMonth: true, 
            dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
            dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
            monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
            monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
            dateFormat: 'yy년 MM d일'
        });
    });

    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function (data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if (data.userSelectedType === 'R') {
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;

                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    }
    