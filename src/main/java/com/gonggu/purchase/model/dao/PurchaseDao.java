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
        String query = "SELECT bu.name, bu.phone_num, cd.copy_name, c.construct_deposit FROM CONSTRUCT_STATUS cs "
        		+ "		FULL JOIN COPY_DETAIL cd ON cd.COPY_NO = cs.COPY_NO"
        		+ "		FULL JOIN BASIC_USER bu ON cs.USER_NO = bu.USER_NO"
        		+ "		FULL JOIN CONSTRUCT c ON c.CHATTING_NO = cs.CHATTING_NO"
        		+ "		where c.chatting_no = ?";
        
        String oid = UUID.randomUUID().toString();

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, chattingNo);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("name");
                String phoneNum = rs.getString("phone_num");
                String copyName = rs.getString("copy_name");
                int deposit = rs.getInt("construct_deposit");

                // 값 세팅
                PurchaseDto dto = PurchaseDto.of(userName, phoneNum, copyName, deposit);
                
                return dto;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    
    
    public void order(PurchaseDto dto) throws SQLException {
    	String query = "insert into purchase"
    			+ "		values(purchase_seq.nextval, sysdate, NULL, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, dto.getChattingNo());
			
			pstmt.executeUpdate();
    }
    public int statusUpdate(int chattingNo) {
    	String query = "UPDATE  CONSTRUCT SET PURCHASE_STATUS = 'Y'"
    			+ "		WHERE CHATTING_NO = ?";
    	
    	try {
			pstmt = con.prepareStatement(query);
	    	pstmt.setInt(1, chattingNo);
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return 0;
    }
    
    public PurchaseDto constructInfo(int chattingNo) {
    	String query = """
    					SELECT
					    TO_CHAR(CONSTRUCT_START_DATE, 'YYYY-MM-DD') AS 시공시작, 
					    TO_CHAR(CONSTRUCT_END_DATE, 'YYYY-MM-DD')  AS 시공끝,
					    CONSTRUCT_ADDR 
    					FROM CONSTRUCT c 
    					WHERE CHATTING_NO = ?
    				   """;
    	
    	try {
			pstmt = con.prepareStatement(query);
	    	pstmt.setInt(1, chattingNo);
	    	ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
                String startDate = rs.getString("시공시작");
                String endDate = rs.getString("시공끝");
                String addr = rs.getString("CONSTRUCT_ADDR");

                PurchaseDto dto = PurchaseDto.of(startDate, endDate, addr);
                
                return dto;

            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    
    public int addressUpdate(int chattingNo, String detailAddress) {
    	String query = """
    					UPDATE CONSTRUCT SET CONSTRUCT_ADDR = ?
    					WHERE CHATTING_NO = ?
    				   """;
    	
    	try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, detailAddress);
			pstmt.setInt(2, chattingNo);
			int result = pstmt.executeUpdate(); 
			System.out.println("" + result);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return 0;
    }
}
