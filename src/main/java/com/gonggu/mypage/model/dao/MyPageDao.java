package com.gonggu.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;


public class MyPageDao {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public MyPageDao() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

	public int setEdit(MyPageDtoImpl myDto) {
		String query = "UPDATE BASIC_USER SET NICKNAME = ?,"
				                    + " ADDR = ? "
				                    + " WHERE USER_NO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, myDto.getNickName());
			pstmt.setString(2, myDto.getAddress());
			pstmt.setInt(3, myDto.getUserNo());
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public MyPageDtoImpl getDetail(int userNo) {
		String query = "SELECT * FROM BASIC_USER"
				+ "     WHERE USER_NO = ?";
				
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String userId = rs.getString("USER_ID");
				String name = rs.getString("NAME");
				String nickname = rs.getString("NICKNAME");
				String addr = rs.getString("ADDR");
				
				MyPageDtoImpl myDto = new MyPageDtoImpl();
				myDto.setUserNo(userNo);
				myDto.setUserId(userId);
				myDto.setName(name);
				myDto.setNickName(nickname);
				myDto.setAddress(addr);
				
				return myDto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

}
















