<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button>Pay now!</button>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="http://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script>
	
		const IMP = window.IMP;
		IMP.init("imp67844376");
	
		const button = document.querySelector("button");
	
		const onClickPay = async () => {
			IMP.request_pay({
				pg: "html5_inicis.INIBillTst",
				pay_method: "card",
				amount: "60000",
				name: "우소우소짱",
				merchant_uid: "ORD20240604-00000001",
			});
			
		};
	
		button.addEventListener("click", onClickPay);
	</script>
</body>
</html> 