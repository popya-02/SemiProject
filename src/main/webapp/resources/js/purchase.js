// 구매자 정보
 var IMP = window.IMP;
 IMP.init("imp67844376");   /* imp~ : 가맹점 식별코드*/
 
 let amount = document.getElementById("amount").value
 let userName = document.getElementById("name").value
 let copy = document.getElementById("company").value
 let goodsName = document.getElementById("goods").value
 


// $.ajax({
//				type: "POST",
//				url: "/payment/complete.do",
//				data: { priceArr : priceArr[0],
//						objectTitle : objectTitle,
//						objectCeller : objectCeller,
//					   },
//				success: function(success){
//					window.location.href='/views/payment/completeOrder.jsp';
//				},
//				error: function(error){
//					console.log("실패");
//				}
//			});

 $('#money-btn').click(function() {
		IMP.request_pay({
			pg: 'html5_inicis',
			pay_method: 'card',				 /* 결제 수단방법 */


			name: "상품 명",					// 상품 명 
			amount: amount,
			goods_name: "카테고리 명",
            buyer_name: "sdfsdds",
            acceptName: "SKIN(#5E2BB8)"
            
		}, function(rsp) {
			debugger;
			console.log(rsp);
			 $.ajax({
				type: "POST",
				url: "/complete.do",
			});
			 //결제 성공 시
			if (rsp.success) {
				var msg;
				console.log("결제성공");
			//    $.ajax({
//		type: "POST",
//		url: "/complete.do",
//		data: { amount: amount,			// 금액 
//				goodsName: goodsName,			// 상품명 
//				userName: userName,			// 주문자 
//			   },
//		success: function(success){
//			window.location.href='/views/etc/success.jsp';
//			msg = '결제가 완료되었습니다.';
//		},
//		error: function(error){
//			console.log("실패");
//		}
//	});
			} else if(rsp.success == false) {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}

			alert(msg);
		});
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
    