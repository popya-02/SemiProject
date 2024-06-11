package com.gonggu.purchase.model.dto;

public class PurchaseDto {

    private String userName;
    private String phoneNum;
    private String copyName;
    private int constructPrice;
    private String oid;                // 주문 번호

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

    public PurchaseDto(String userName, String phoneNum, String copyName, int constructPrice, String oid) {
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.copyName = copyName;
        this.constructPrice = constructPrice;
        this.oid = oid;
    }

    public static PurchaseDto of(String userName, String phoneNum, String copyName, int constructPrice, String oid) {
        return new PurchaseDto(userName, phoneNum, copyName, constructPrice, oid);
    }
}
