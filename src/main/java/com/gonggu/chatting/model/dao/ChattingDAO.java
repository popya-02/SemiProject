package com.gonggu.chatting.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		String query = "INSERT INTO CONSTRUCT_STATUS cc"
					+ " VALUES ("
					+ "	 chatting_seq.NEXTVAL, ?, ?, DEFAULT, DEFAULT"
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
		String query = "SELECT CHATTING_NO AS "
					+ " FROM CONSTRUCT_STATUS cc "
					+ " WHERE USER_NO = ?"
					+ "	AND COPY_NO = ?"
					+ "	AND END_CHECK = 'N'";
		
		try {
			pstmt  = con.prepareStatement(query);
			
			pstmt.setInt(1, chattingDto.getUserNum());
			pstmt.setString(2, chattingDto.getCopyNum());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int chatResult = rs.getInt("CHATTING_NO");
				
				return chatResult;
				
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ChattingDTO getUserType(ChattingDTO chattingDto) {
		
		String query = "SELECT USER_NO FROM BASIC_USER bu"
					+ " WHERE USER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, chattingDto.getUserNum());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int userNum = rs.getInt("USER_NO");
				
				ChattingDTO chatDto = new ChattingDTO();
				chatDto.setUserNum(userNum);
				chatDto.setUserType("basicUser");
				
				return chatDto;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ChattingDTO getCopyType(ChattingDTO chattingDto) {
		
		String query = "SELECT COPY_NO  FROM COPY_USER cu"
					+ " WHERE COPY_NO = ?";
	
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, chattingDto.getCopyNum());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String copyNum = rs.getString("COPY_NO");
				
				ChattingDTO chatDto = new ChattingDTO();
				chatDto.setCopyNum(copyNum);
				chatDto.setUserType("copyUser");
				
				return chatDto;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int insertMsg(ChattingDTO chattingDto) {
		
		String query = "INSERT INTO CHATTING_LOG cl VALUES("
					+ "	?,"
					+ "	DEFAULT,"
					+ "	?,"
					+ "	?"
					+ ")";
		
		try {
			pstmt  = con.prepareStatement(query);
			
			pstmt.setInt(1, chattingDto.getChattingNum());
			pstmt.setString(2, chattingDto.getMessage());
			pstmt.setString(3, chattingDto.getUserType());
			
			int result = pstmt.executeUpdate();
			
			return result;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<ChattingDTO> getList(int chattingNum) {
		
		ArrayList<ChattingDTO> result = new ArrayList<>();
		
		String query = "SELECT cl.CHATTING_NO,INDATE ,CONTENT, USER_TYPE, cs.USER_NO ,cs.COPY_NO"
					+ " FROM CHATTING_LOG cl"
					+ "	FULL JOIN CONSTRUCT_STATUS cs"
					+ "	ON cl.CHATTING_NO = cs.CHATTING_NO"
					+ " WHERE cl.CHATTING_NO = ?"
					+ " ORDER BY INDATE  ASC";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, chattingNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int chatNum = rs.getInt("CHATTING_NO");
				int userNumli = rs.getInt("USER_NO");
				String copyNumli = rs.getString("COPY_NO");
				String content = rs.getString("CONTENT");
				String type = rs.getString("USER_TYPE");
				
				ChattingDTO chattingDto = new ChattingDTO();
				chattingDto.setChattingNum(chatNum);
				chattingDto.setUserNum(userNumli);
				chattingDto.setCopyNum(copyNumli);
				chattingDto.setMessage(content);
				chattingDto.setUserType(type);
				
				result.add(chattingDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
