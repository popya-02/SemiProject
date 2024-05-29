package com.gonggu.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		String query = "UPDATE USER SET USER_NAME = ?,"
				                    + " USER_ID = ?,"
				                    + " ADDR = ? "
				                    + " WHERE USER_NO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, myDto.getName());
			pstmt.setNString(2, myDto.getUserId());
			pstmt.setString(3, myDto.getAddress());
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
