package com.gonggu.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.member.model.dto.MemberDTO;


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


	public int signupUser(MemberDTO memberDto) {
		String query = "INSERT INTO BASIC_USER"
					+ " VALUES(user_seq.nextval, ?, ?, ?, DEFAULT, NULL, ?, ?, ?)";
		// num, id, pwd, name, indate, update, addr, nickname,phone
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserPwd());
			pstmt.setString(3, memberDto.getUserName());
			pstmt.setString(4, memberDto.getUserAddr());
			pstmt.setString(5, memberDto.getNickName());
			pstmt.setString(6, memberDto.getPhoneNum());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public MemberDTO getHashPwdUser(String id) {
		String query = "SELECT USER_NO, PASSWORD, NAME, NICKNAME"
					+ " FROM BASIC_USER"
					+ " WHERE USER_ID = ?";
		
		MemberDTO result = new MemberDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("USER_NO");
				String pwd = rs.getString("PASSWORD");
				String name = rs.getString("NAME");
				String nickname = rs.getString("NICKNAME");
				
				result.setUserNum(num);
				result.setUserPwd(pwd);
				result.setUserName(name);
				result.setNickName(nickname);
				result.setUserType("basicUser");
				
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public MemberDTO getHashPwdCopy(String id) {
		
		String query = "SELECT COPY_NAME, PASSWORD"
				+ " FROM COPY_USER"
				+ " WHERE COPY_NO = ?";
		
		MemberDTO result = new MemberDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				String copyName = rs.getString("COPY_NAME");
				String copyPwd = rs.getString("PASSWORD");
				
				result.setCopyName(copyName);
				result.setCopyNum(id);
				result.setCopyPwd(copyPwd);
				result.setUserType("copyUser");
				
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public int copyIdCheck(String copyId) {
		
		String query = "SELECT COUNT(COPY_NO) AS CNT"
					+ " FROM COPY_USER"
					+ " WHERE COPY_NO = ?";
	
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, copyId);
			
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


	public int signupCopy(MemberDTO memberDto) {
		
		String query = "INSERT INTO COPY_USER cu"
					+ " VALUES (?, ?, ?, DEFAULT, NULL, DEFAULT)";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, memberDto.getCopyNum());
			pstmt.setString(2, memberDto.getCopyName());
			pstmt.setString(3, memberDto.getCopyPwd());
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	public int signupCopyDetail(MemberDTO memberDto) {
		
		String query = "INSERT INTO COPY_DETAIL cd"
					+ " VALUES(?, ?, ?, ?, ?, ?, NULL, DEFAULT)";
		// id(no),name, ceo, tel, area, addr, content, like
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, memberDto.getCopyNum());
			pstmt.setString(2, memberDto.getCopyName());
			pstmt.setString(3, memberDto.getCopyCeoName());
			pstmt.setString(4, memberDto.getCopyTelNum());
			pstmt.setString(5, memberDto.getCopyArea());
			pstmt.setString(6, memberDto.getCopyAddr());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}



































