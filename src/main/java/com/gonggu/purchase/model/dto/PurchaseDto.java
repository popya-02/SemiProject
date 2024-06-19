package com.gonggu.purchase.model.dto;

public class PurchaseDto {

    private String userName;
    private String phoneNum;
    private String copyName;
    private String deposit;
    
    private String detailAddr;
    private String purchaseStatus;
    private String constructStartDate;
    private String constructEndDate;
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
	
	

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getConstructStartDate() {
		return constructStartDate;
	}

	public void setConstructStartDate(String constructStartDate) {
		this.constructStartDate = constructStartDate;
	}

	public String getConstructEndDate() {
		return constructEndDate;
	}

	public void setConstructEndDate(String constructEndDate) {
		this.constructEndDate = constructEndDate;
	}

	public int getChattingNo() {
		return chattingNo;
	}
	
	public void setChattingNo(int chattingNo) {
		this.chattingNo = chattingNo;
	}
	
	
	// 결제 정보 불러오기 
	


	public PurchaseDto(String userName, String phoneNum, String copyName, String deposit) {
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.copyName = copyName;
        this.deposit = deposit;
    }
	
	public PurchaseDto(int chattingNo, String goodsName, String detailAddress, String deposit) {
		this.chattingNo = chattingNo;
		this.goodsName = goodsName;
		this.detailAddr = detailAddress;
        this.deposit = deposit;
    }
	
	public PurchaseDto(String constructStartDate, String constructEndDate, String addr) {
		this.constructStartDate = constructStartDate;
		this.constructEndDate = constructEndDate;
		this.detailAddr = addr;
    }
    
    public PurchaseDto() {
		super();
	}

	public static PurchaseDto of(String userName, String phoneNum, String copyName, String deposit) {
        return new PurchaseDto(userName, phoneNum, copyName, deposit);
    }
	
	public static PurchaseDto of(int chattingNo, String goodsName, String detailAddress, String deposit) {
		return new PurchaseDto(chattingNo, goodsName, detailAddress, deposit);
	}
	
	public static PurchaseDto of(String constructStartDate, String constructEndDate, String addr) {
		return new PurchaseDto(constructStartDate, constructEndDate, addr);
	}
}
