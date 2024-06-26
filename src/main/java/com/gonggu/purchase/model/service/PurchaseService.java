package com.gonggu.purchase.model.service;

import com.gonggu.purchase.model.dto.PurchaseDto;


public interface PurchaseService {
	PurchaseDto purchaseInfo(int chattingNo);
		
	String order(PurchaseDto purchaseDto);
	
	PurchaseDto constructInfo(int chattingNo);
	
	int addressUpdate(int chattingNo, String detailAddress);
}
