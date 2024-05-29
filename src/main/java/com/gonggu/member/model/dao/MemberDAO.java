package com.gonggu.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gonggu.common.DatabaseConnection;


public class MemberDAO {

	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	
	// id 중복검사
	public int idCheck(String userId) {
		String query = "SELECT COUNT(USER_ID) AS CNT"
					+ " FROM BASIC_USER"
					+ " WHERE USER_ID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cntResult = rs.getInt("CNT");
				
				return cntResult;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

}
