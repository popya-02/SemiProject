package com.gonggu.purchase.model.service;

import java.sql.SQLException;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.purchase.model.dao.PurchaseDao;
import com.gonggu.purchase.model.dto.PurchaseDto;

public class PurchaseServiceImpl implements PurchaseService {
	
	
	
	PurchaseDao dao = new PurchaseDao();
	
	
    @Override
    public PurchaseDto purchaseInfo(int chattingNo) {
        return dao.purchaseInfo(chattingNo);
    }
    
    
    @Override
    public String order() {
    	
    	DatabaseConnection conn = new DatabaseConnection();
    	PurchaseDto dto = new PurchaseDto();
    	// DB 저장 
    	// 주문 테이블 업데이트 (시간) 
    	// 결제 테이블 (시간) 
    	
    	try {
			conn.connDB().setAutoCommit(false);
			dao.order(dto);							// 결제 테이블 상태 인입 	
			dao.statusUpdate();						// 주문테이블 업데이트
			return "success";
		} catch (SQLException e) {
			if (conn != null) {
                try {
                    conn.connDB().rollback(); // 예외 발생 시 롤백
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
		} 
    	return "error";
		}
    }
 }
