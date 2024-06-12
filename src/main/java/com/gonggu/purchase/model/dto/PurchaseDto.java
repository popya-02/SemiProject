package com.gonggu.purchase.model.dto;

public class PurchaseDto {

    private String userName;
    private String phoneNum;
    private String copyName;
    private int constructPrice;
    private String oid;                // 주문 번호
    
    private String detailAddr;
    private String purchaseStatus;
    private String constructDate;
    private String goodsName;
    private String refundDate;
    private int chattingNo;
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCopyName() {
        return copyName;
    }

    public void setCopyName(String copyName) {
        this.copyName = copyName;
    }

    public int getConstructPrice() {
        return constructPrice;
    }

    public void setConstructPrice(int constructPrice) {
        this.constructPrice = constructPrice;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
    
    

    public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}
	
	public String getConstructDate() {
		return constructDate;
	}
	
	public void setConstructDate(String constructDate) {
		this.constructDate = constructDate;
	}

	public int getChattingNo() {
		return chattingNo;
	}
	
	public void setChattingNo(int chattingNo) {
		this.chattingNo = chattingNo;
	}
	
	
	// 결제 정보 불러오기 
	


	public PurchaseDto(String userName, String phoneNum, String copyName, int constructPrice, String oid) {
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.copyName = copyName;
        this.constructPrice = constructPrice;
        this.oid = oid;
    }
    
    
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

    public PurchaseDto() {
		super();
	}

	public static PurchaseDto of(String userName, String phoneNum, String copyName, int constructPrice, String oid) {
        return new PurchaseDto(userName, phoneNum, copyName, constructPrice, oid);
    }
}
