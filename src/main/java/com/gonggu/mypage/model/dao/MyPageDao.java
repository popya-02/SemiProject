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

	// UserMyPage 정보 수정
	public int setUserEdit(MyPageDtoImpl myDto) {
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

	// UserMyPage 조회
	public MyPageDtoImpl getUserDetail(int userNo) {
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
	
	// 나의 예약조회
	public MyPageDtoImpl getUserEstimate(int userNo) {
		String query = "SELECT * FROM CONSTRUCT"
				+ "     WHERE USER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int constructNo = rs.getInt("CONSTRUCT_NO");
				String copyName = rs.getString("COPY_NAME");
				
				MyPageDtoImpl myDto = new MyPageDtoImpl();
				myDto.setUserNo(userNo);
				myDto.setConstructNo(constructNo);
				myDto.setCopyName(copyName);
				
				return myDto;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// CopyEatimate
	public MyPageDtoImpl getCopyEstimate(String copyNo) {
		String query = "SELECT * FROM CONSTRUCT c"
				+ "     JOIN BASIC_USER bu"
				+ "     ON c.USER_NO = bu.USER_NO"
				+ "     WHERE c.COPY_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, copyNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int constructNo = rs.getInt("CONSTRUCT_NO");
				String userName = rs.getString("NAME");
				String copyName = rs.getString("COPY_NAME");
				
				MyPageDtoImpl myDto = new MyPageDtoImpl();
				myDto.setConstructNo(constructNo);
				myDto.setName(userName);
				myDto.setCopyName(copyName);
				
				return myDto;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// CopyMyPage 정보 수정
	public int setCopyEdit(MyPageDtoImpl myDto) {
			String query = "UPDATE COPY_DETAIL SET TEL_NUM = ?,"
					                    + " COPY_ADDR = ?,"
					                    + " CONSTRUCT_AREA = ?,"
					                    + " CONTENT = ?"
					                    + " WHERE COPY_NO = ?";
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, myDto.getTelNum());
				pstmt.setString(2, myDto.getCopyAddr());
				pstmt.setString(3, myDto.getConstructArea());
				pstmt.setString(4, myDto.getContent());
				pstmt.setString(5, myDto.getCopyNo());

				int result = pstmt.executeUpdate();
				
				return result;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return 0;
		}
	
	// CopyMyPage 조회
	public MyPageDtoImpl getCopyDetail(String copyNo) {
		String query = "SELECT * FROM COPY_DETAIL"
				+ "     WHERE COPY_NO = ?";
				
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, copyNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String copyName = rs.getString("COPY_NAME");
				String tellNum = rs.getString("TEL_NUM");
				String copyAddr = rs.getString("COPY_ADDR");
				String constructArea = rs.getString("CONSTRUCT_AREA");
				String content = rs.getString("CONTENT");
				
				MyPageDtoImpl myDto = new MyPageDtoImpl();
				myDto.setCopyNo(copyNo);
				myDto.setCopyName(copyName);
				myDto.setTelNum(tellNum);
				myDto.setCopyAddr(copyAddr);
				myDto.setConstructArea(constructArea);
				myDto.setContent(content);
				
				return myDto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	// 이미지 업로드
	public int pictureUpload(MyPageDtoImpl myDto) {
		String query = "INSERT INTO COPY_PHOTO"
				+ "     VALUES(copy_picture_seq.nextval, ?, ?, ?)";
		System.out.println("a: " + myDto.getPictureName());
	
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, myDto.getCopyNo());
			pstmt.setString(2, myDto.getPictureName());
			pstmt.setString(3, myDto.getPicturePath());
			
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 업로드한 이미지 조회
	public void getPictureName(MyPageDtoImpl result) {	
		String query = "SELECT COPY_PICTURE_NO, NAME FROM COPY_PHOTO"
				+ "     WHERE COPY_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, result.getCopyNo());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int PictureNo = rs.getInt("COPY_PICTURE_NO");
				String PictureName = rs.getString("NAME");
				
				result.setCopyPictureNo(PictureNo);
				result.setPictureName(PictureName);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int setDelete(String copyNo) {
		String query = "DELETE FROM COPY_PHOTO"
				+ "    WHERE COPY_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, copyNo);
			
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


}
















