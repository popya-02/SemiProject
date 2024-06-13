package com.gonggu.purchase.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.purchase.model.dto.PurchaseDto;

public class PurchaseDao {
    private Connection con;
    private DatabaseConnection dc;
    private PreparedStatement pstmt;

    public PurchaseDao() {
        dc = new DatabaseConnection();
        con = dc.connDB();
    }

    public PurchaseDto purchaseInfo(int chattingNo) {
        String query = "SELECT bu.name, bu.phone_num, cd.copy_name, c.construct_price FROM CONSTRUCT_STATUS cs "
        		+ "		FULL JOIN COPY_DETAIL cd ON cd.COPY_NO = cs.COPY_NO"
        		+ "		FULL JOIN BASIC_USER bu ON cs.USER_NO = bu.USER_NO"
        		+ "		FULL JOIN CONSTRUCT c ON c.CHATTING_NO = cs.CHATTING_NO"
        		+ "		where c.chatting_no = 1";
        
        String oid = UUID.randomUUID().toString();

        try {
            pstmt = con.prepareStatement(query);
//            pstmt.setInt(1, chattingNo);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("name");
                String phoneNum = rs.getString("phone_num");
                String copyName = rs.getString("copy_name");
                int price = rs.getInt("construct_price");

                // 값 세팅
                PurchaseDto dto = PurchaseDto.of(userName, phoneNum, copyName, price, oid);
                
                return dto;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    
    
    public int order(PurchaseDto dto) {
    	String query = "insert into purchase"
    			+ "		values(purchase_seq.nextval, sysdate, NULL, ?,  ?, ?)";
    	int result = 0 ;
    	try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getDetailAddr());
			pstmt.setString(2, dto.getOid());
			pstmt.setInt(3, dto.getChattingNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    			
    	return result;
    }
    public int statusUpdate(int chattingNo) {
    	String query = "UPDATE  CONSTRUCT SET PURCHASE_STATUS = 'N'"
    			+ "		WHERE CHATTING_NO = 1";
    	
    	try {
			pstmt = con.prepareStatement(query);
//	    	pstmt.setString(1, chattingNo);
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return 0;
    	
    }
}
