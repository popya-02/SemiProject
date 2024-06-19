package com.gonggu.purchase.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.purchase.model.dao.PurchaseDao;
import com.gonggu.purchase.model.dto.PurchaseDto;

public class PurchaseServiceImpl implements PurchaseService {
	
	
	
	PurchaseDao purchaseDao = new PurchaseDao();
	
	
    @Override
    public PurchaseDto purchaseInfo(int chattingNo) {
        return purchaseDao.purchaseInfo(chattingNo);
    }
    
    
    @Override
    public String order(PurchaseDto purchaseDto) {
    	DatabaseConnection conn = new DatabaseConnection();
    	
    	Connection connection = conn.connDB();
    	try {
    		// transaction 시작
    		connection.setAutoCommit(false);
			
			// 결제 테이블 상태 인입
			purchaseDao.order(purchaseDto); 	

			// 주문테이블 업데이트
			purchaseDao.statusUpdate(purchaseDto.getChattingNo());
			
			// transaction 커밋
			connection.commit();
			
			return "success";
		} catch (SQLException e) {
			if (conn != null) {
                try {
                    conn.connDB().rollback(); // 예외 발생 시 롤백
                    return "error";
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
		}
    	return "error";
    	
		} catch (Exception e) { 
			if (conn != null) {
                try {
                    conn.connDB().rollback(); // 예외 발생 시 롤백
                    return "error";
                } catch (SQLException ex) {
                    e.printStackTrace();
                }
			}
		}
    	return "error";
    }
    
    @Override
    public PurchaseDto constructInfo(int chattingNo) {
    	return purchaseDao.constructInfo(chattingNo);
    }
    
    @Override
    public int addressUpdate(int chattingNo, String detailAddress) {
    	return purchaseDao.addressUpdate(chattingNo, detailAddress);
    }
 }
