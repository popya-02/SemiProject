<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
	<button id="money-btn">Pay now!</button>
	
 <script>
 var IMP = window.IMP;
 IMP.init("imp67844376");   /* imp~ : 가맹점 식별코드*/
 
 
 $('#money-btn').click(function() {
		IMP.request_pay({
			pg: 'html5_inicis',
			pay_method: 'card',
			merchant_uid: '0200203-19292',

			name: ${},
			amount: "2000000000",
			buyer_email: "test1212@gmail.com",  
			buyer_name: "asdasd",
		}, function(rsp) {
			console.log(rsp);
			
			 //결제 성공 시
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				console.log("결제성공 ");

				
			
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
		});
	});
	</script>
</body>
</html> 