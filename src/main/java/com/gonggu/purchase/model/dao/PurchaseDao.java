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
        		+ "		where c.chatting_no = ?";

        String oid = UUID.randomUUID().toString();

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, chattingNo);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String phoneNum = rs.getString("phone_num");
                String copyName = rs.getString("copy_name");
                int price = rs.getInt("construct_price");

                // 값 세팅
                PurchaseDto dto = PurchaseDto.of(name, phoneNum, copyName, price, oid);
                
                return dto;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
