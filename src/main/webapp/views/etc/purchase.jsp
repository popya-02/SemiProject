<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <link href="/resources/css/purchase.css" rel="stylesheet">
	    <%@ include file="/views/common/head.jsp"%>
        <title>GONGGU</title>
        <!-- Template Stylesheet -->
        <link href="/resources/css/style.css" rel="stylesheet">
        <link href="/resources/css/signup.css" rel="stylesheet">
        
    </head>
    <body>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<script src="https://cdn.iamport.kr/v1/iamport.js"></script> -->
    <!-- <script>
    	var IMP = window.INP;
    	IMP.init('imp67844376');
    	IMP.request_pay({
    		pg: "{PG사 코드}.{상점 ID}",
    	    pay_method: "card",
    	    merchant_uid: `payment-${crypto.randomUUID()}`, // 주문 고유 번호
    	    name: "노르웨이 회전 의자",
    	    amount: 64900,
    	    buyer_email: "gildong@gmail.com",
    	    buyer_name: "홍길동",
    	    buyer_tel: "010-4242-4242",
    	    buyer_addr: "서울특별시 강남구 신사동",
    	    buyer_postcode: "01181",
    	    
    	}), function(rsp) {
    	    if ( rsp.success ) {
    	        var msg = '결제가 완료되었습니다.';
    	        msg += '고유ID : ' + rsp.imp_uid;
    	        msg += '상점 거래ID : ' + rsp.merchant_uid;
    	        msg += '결제 금액 : ' + rsp.paid_amount;
    	        msg += '카드 승인번호 : ' + rsp.apply_num;
    	           
    	        pay_info(rsp);
    	        
    	    } else {
    	        var msg = '결제에 실패하였습니다.';
    	        msg += '에러내용 : ' + rsp.error_msg;
    	        
    	        location.href="goods_pay_fail.do?error_msg="+rsp.error_msg;
    	    }
    	});
    	
    	/* ============ 비공개 방식으로 결제정보 전달 =============== */
    	function pay_info(rsp){
    	      var form = document.createElement('form');
    	      var objs;
    	 
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buyer_name');
    	      objs.setAttribute('value', rsp.buyer_name);
    	      form.appendChild(objs);
    	 
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buyer_phone');
    	      objs.setAttribute('value', rsp.buyer_tel);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'member_email');
    	      objs.setAttribute('value', rsp.buyer_email);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buy_addr');
    	      objs.setAttribute('value', rsp.buyer_addr);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buy_product_name');
    	      objs.setAttribute('value', rsp.name);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buyer_buyid');
    	      objs.setAttribute('value', rsp.imp_uid);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buyer_merid');
    	      objs.setAttribute('value', rsp.merchant_uid);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'amount');
    	      objs.setAttribute('value', rsp.paid_amount);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buyer_card_num');
    	      objs.setAttribute('value', rsp.apply_num);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buyer_pay_ok');
    	      objs.setAttribute('value', rsp.success);
    	      form.appendChild(objs);
    	      
    	      objs = document.createElement('input');
    	      objs.setAttribute('type', 'hidden');
    	      objs.setAttribute('name', 'buyer_postcode');
    	      objs.setAttribute('value', rsp.buyer_postcode);
    	      form.appendChild(objs);
    	 
    	      
    	      
    	      form.setAttribute('method', 'post');
    	      form.setAttribute('action', "goods_pay_success.do");
    	      document.body.appendChild(form);
    	      form.submit();
    	};
    	
    	/* ============ 결제 결과 처리 =============== */
    	IMP.request_pay(
    			  {
    			    /* 파라미터 생략 */
    			  },
    			  async (response) => {
    			    if (response.error_code != null) {
    			      return alert(`결제에 실패하였습니다. 에러 내용: ${response.error_msg}`);
    			    }

    			    // 고객사 서버에서 /payment/complete 엔드포인트를 구현해야 합니다.
    			    // (다음 목차에서 설명합니다)
    			    const notified = await fetch(`${SERVER_BASE_URL}/payment/complete`, {
    			      method: "POST",
    			      headers: { "Content-Type": "application/json" },
    			      // imp_uid와 merchant_uid, 주문 정보를 서버에 전달합니다
    			      body: JSON.stringify({
    			        imp_uid: response.imp_uid,
    			        merchant_uid: response.merchant_uid,
    			        // 주문 정보...
    			      }),
    			    });
    			  },
    			);

    	
    </script> -->
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		    <div style="margin-top: 120px; padding: 50px;">
        <div>
            <h3 class="center">결제 화면</h3>
        </div>
    </div>
    <div class="container-box container">
        <form>
            <div class="form-group">
                <label for="name">이름</label><br>
                <input type="text" id="name" value="" readonly class="readonly-input">
            </div>
            <div class="form-group">
                <label for="phone">전화번호</label><br>
                <input type="tel" id="phone" value="" readonly class="readonly-input">
            </div>
            <div class="form-group">
                <label for="company">업체명</label><br>
                <input type="text" id="company" value="" readonly class="readonly-input">
            </div>
            <div class="form-group">
                <label for="amount">결제 금액</label><br>
                <input type="number" id="amount" value="" readonly class="readonly-input">
            </div>
            <div class="form-group center-input location-box">
                <label for="location">주소</label><br>
                <input type="text" id="postcode" placeholder="우편번호">
                <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                <input type="text" id="address" placeholder="주소" style="width: 225px;"><br>
                <input type="text" id="detailAddress" placeholder="상세주소" required>
                <input type="text" id="extraAddress" placeholder="참고항목">
            </div>
            <div class="form-group center-input location-box">
                <label for="datepicker">날짜</label><br>
                <input type="text" id="datepicker" name="date" style="width: 225px; text-align: center; color: rgb(73, 73, 73);" value="날짜 선택" required>
            </div>  
            <button type="submit" class="btn" onclick="kgPay()" >결제하기</button>
        </form>
    </div>

        <!-- Footer Start -->
       	<%@ include file="/views/common/footer.jsp"%>
        <!-- Copyright End -->
        
        <!-- Back to Top -->
        <a href="#" class="btn btn-point border-3 rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>   

        
    <!-- JavaScript Libraries -->
    <%@ include file="/views/common/jsLib.jsp"%>

    <!-- Template Javascript -->
    <script src="/resources/js/main.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/resources/js/purchase.js"></script>    
   
    </body>

</html>