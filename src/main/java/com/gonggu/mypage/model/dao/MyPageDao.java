       package com.gonggu.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.mypage.model.dto.MyPageDto;
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
				+ "		JOIN COPY_USER cu"
				+ "			ON c.COPY_NO = cu.COPY_NO"
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

	public int saveConstElement(MyPageDto constDto) {
	    String query = "INSERT INTO CONSTRUCT VALUES("
	            	+ " CONSTRUCT_SEQ.NEXTVAL,"
	            	+ " ?,"  // copt_no 1
	            	+ " ?,"  // user_no 2
	            	+ " TO_DATE(?, 'YYYY-MM-DD'),"  // start 3
	            	+ " TO_DATE(?, 'YYYY-MM-DD'),"  // end 4
	            	+ " ?,"  // addr 5
	            	+ " ?,"  // range 6
	            	+ " ?,"  // sumprice 7
	            	+ " ?,"  // chatNum 8
	            	+ " ?,"  // element 9
	            	+ " ?"  // deposit 10
	            	+ ")";

//	    System.out.println(constDto.getConstructElement());
//	    System.out.println(constDto.getConstStartDate());
//	    System.out.println(constDto.getConstEndDate());
//	    System.out.println(constDto.getSumPrice());
//	    System.out.println(constDto.getEstimatePrice());
//	    System.out.println(constDto.getConstAddr());
//	    System.out.println(constDto.getConstRange());
//	    System.out.println(constDto.getCopyNo());
//	    System.out.println(constDto.getUserNo());
	    
	    try {
	        pstmt = con.prepareStatement(query);
	        
	        
	        pstmt.setString(1, constDto.getCopyNo());
	        pstmt.setInt(2, constDto.getUserNo());
	        pstmt.setString(3, constDto.getConstStartDate());
	        pstmt.setString(4, constDto.getConstEndDate());
	        pstmt.setString(5, constDto.getConstAddr());
	        pstmt.setInt(6, constDto.getConstRange());
	        pstmt.setString(7, constDto.getSumPrice());
	        pstmt.setInt(8, constDto.getChattingNum());
	        pstmt.setString(9, constDto.getConstructElement());
	        pstmt.setString(10, constDto.getEstimatePrice());
	        
	        int result = pstmt.executeUpdate();
	        
	        return result;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return 0;
	}

	public MyPageDto getConstructDetail(int chattingNum) {
		String query = "SELECT * FROM CONSTRUCT c"
					+ " JOIN BASIC_USER bu "
					+ "		ON c.USER_NO = bu.USER_NO"
					+ " JOIN COPY_DETAIL cd"
					+ "		ON c.COPY_NO = cd.COPY_NO"
					+ " WHERE CHATTING_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, chattingNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int constNum = rs.getInt("CONSTRUCT_NO");
				int basicUserNum = rs.getInt("USER_NO");
				String startDateSub = rs.getString("CONSTRUCT_START_DATE");
				String endDateSub = rs.getString("CONSTRUCT_END_DATE");
				String addr = rs.getString("CONSTRUCT_ADDR");
				int range = rs.getInt("CONSTRUCT_RANGE");
				String price = rs.getString("CONSTRUCT_PRICE");
				String element = rs.getString("CONSTRUCT_TABLE");
				String estimatePrice = rs.getString("CONSTRUCT_DEPOSIT");
				String userName = rs.getString("NAME");
				String copyTel = rs.getString("TEL_NUM");
				
				String startDate = startDateSub.substring(0, startDateSub.length()-9);
				String endDate = endDateSub.substring(0, endDateSub.length()-9);
				
				MyPageDto dto = new MyPageDto();
				dto.setConstructNo(constNum);
				dto.setUserNo(basicUserNum);
				dto.setConstStartDate(startDate);
				dto.setConstEndDate(endDate);
				dto.setAddress(addr);
				dto.setConstRange(range);
				dto.setSumPrice(price);
				dto.setEstimatePrice(estimatePrice);
				dto.setConstructElement(element);
				dto.setName(userName);
				dto.setTelNum(copyTel);
				dto.setChattingNum(chattingNum);
				
				return dto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public int updateConstElement(MyPageDto constDto) {
		
		String query = "UPDATE CONSTRUCT"
					+ " SET CONSTRUCT_START_DATE = TO_DATE(?, 'YYYY-MM-DD'), "
					+ "		CONSTRUCT_END_DATE = TO_DATE(?, 'YYYY-MM-DD'), "
					+ "		CONSTRUCT_ADDR = ?, "
					+ "		CONSTRUCT_RANGE = ?, "
					+ "		CONSTRUCT_PRICE = ?, "
					+ "		CONSTRUCT_TABLE = ?, "
					+ "		CONSTRUCT_DEPOSIT = ? "
					+ " WHERE CHATTING_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, constDto.getConstStartDate());
			pstmt.setString(2, constDto.getConstEndDate());
			pstmt.setString(3, constDto.getConstAddr());
			pstmt.setInt(4, constDto.getConstRange());
			pstmt.setString(5, constDto.getSumPrice());
			pstmt.setString(6, constDto.getConstructElement());
			pstmt.setString(7, constDto.getEstimatePrice());
			pstmt.setInt(8, constDto.getChattingNum());
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}



}
















