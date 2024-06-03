package com.gonggu.chatting.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gonggu.chatting.model.dto.ChattingDTO;
import com.gonggu.common.DatabaseConnection;

public class ChattingDAO {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public ChattingDAO() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

	public int setChatting(ChattingDTO chattingDto) {
		String query = "INSERT INTO CONSTRUCT_CHATTING cc"
					+ " VALUES ("
					+ "	 chatting_seq.NEXTVAL, ?, ?, NULL, DEFAULT, DEFAULT"
					+ " )";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, chattingDto.getCopyNum());
			pstmt.setInt(2, chattingDto.getUserNum());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int duplicateCheck(ChattingDTO chattingDto) {
		String query = "SELECT COUNT(CHATTING_NO) AS CNT"
					+ " FROM CONSTRUCT_CHATTING cc "
					+ " WHERE USER_NO = ?"
					+ "	AND COPY_NO = ?"
					+ "	AND END_CHECK = 'N'";
		
		try {
			pstmt  = con.prepareStatement(query);
			
			pstmt.setInt(1, chattingDto.getUserNum());
			pstmt.setString(2, chattingDto.getCopyNum());
			
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
	
	public int submitMsg(ChattingDTO chattingDto) {
		String query = "INSERT INTO CONSTRUCT_CHATTING VALUES("
					+ " COPYNO,"
					+ " USERNO,"
					+ " ?,"
					+ " DEFAULT,"
					+ " DEFAULT"
					+ ")";
		
		try {
			pstmt = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
