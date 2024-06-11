package com.gonggu.purchase.model.service;

import com.gonggu.purchase.model.dao.PurchaseDao;
import com.gonggu.purchase.model.dto.PurchaseDto;

public class PurchaseServiceImpl implements PurchaseService {
	
	
	
	PurchaseDao dao = new PurchaseDao();
	
	
    @Override
    public PurchaseDto purchaseInfo(int chattingNo) {
        return dao.purchaseInfo(chattingNo);
    }
    
    
    @Override
    public PurchaseDto order(PurchaseDto dto) {
    	return dao.order(dto);
    }


}
