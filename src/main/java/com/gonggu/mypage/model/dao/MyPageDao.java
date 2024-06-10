       package com.gonggu.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.mypage.model.dto.MyPageDto;
import com.gonggu.common.PageInfo;
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

	// 새로운 이미지 업로드 하기위해 삭제
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

	
		
//	유저 관심 업체 
	public int getLikeListCount(MyPageDtoImpl myDto) {
		String query = "SELECT COUNT(*) AS CNT"
				+ "     FROM LIKE_COPY lc"
				+ "     JOIN COPY_DETAIL cd"
				+ "     ON lc.COPY_NO = cd.COPY_NO"
				+ "     WHERE lc.USER_NO = ?";
		   try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, myDto.getUserNo());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

//	유저 관심 업체 
	public ArrayList<MyPageDtoImpl> getLikeList(PageInfo pi, MyPageDtoImpl myDto) {
		ArrayList<MyPageDtoImpl> result = new ArrayList<>();
		String query = "SELECT cd.COPY_NO, cp.NAME, cd.COPY_NAME, cd.TEL_NUM, cd.COPY_ADDR"
				+ "     FROM COPY_DETAIL cd"
				+ "     JOIN COPY_PHOTO cp"
				+ "     ON cp.COPY_NO = cd.COPY_NO"
				+ "     WHERE cd.COPY_NO IN (SELECT COPY_NO"
				+ "                         FROM LIKE_COPY lc"
				+ "                         WHERE USER_NO = ?)"
				+ "     ORDER BY cd.COPY_NO DESC"
				+ "     OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, myDto.getUserNo());
			pstmt.setInt(2, pi.getOffSet());
	        pstmt.setInt(3, pi.getBoardLimit());  
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MyPageDtoImpl pageDto = new MyPageDtoImpl();
				pageDto.setCopyNo(rs.getString("COPY_NO"));
				pageDto.setPictureName(rs.getString("NAME"));
				pageDto.setCopyName(rs.getString("COPY_NAME"));
				pageDto.setTelNum(rs.getString("TEL_NUM"));
				pageDto.setCopyAddr(rs.getString("COPY_ADDR"));
				
				result.add(pageDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
//  나의 견적/공사 내역
	public int getUserEstimateListCount(MyPageDtoImpl myDto) {
		String query = "SELECT COUNT(*) AS CNT"
				+ "     FROM CONSTRUCT c"
				+ "     JOIN COPY_DETAIL cd"
				+ "     ON c.COPY_NO = cd.COPY_NO"
				+ "     WHERE c.USER_NO = ?";
		   try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, myDto.getUserNo());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

//  나의 견적/공사 내역
	public ArrayList<MyPageDtoImpl> getUserEstimateList(PageInfo pi, MyPageDtoImpl myDto) {
		ArrayList<MyPageDtoImpl> result = new ArrayList<>();
		String query = "SELECT cd.COPY_NO, NAME, COPY_NAME, CONSTRUCT_NO"
				+ "     FROM COPY_DETAIL cd"
				+ "     FULL JOIN COPY_PHOTO cp"
				+ "        ON cd.COPY_NO = cp.COPY_NO"
				+ "     FULL JOIN CONSTRUCT c"
				+ "        ON c.COPY_NO = cd.COPY_NO"
				+ "     WHERE c.USER_NO = ?"
				+ "     OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
		
		   try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1 , myDto.getUserNo());
			pstmt.setInt(2, pi.getOffSet());
	        pstmt.setInt(3, pi.getBoardLimit());  
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MyPageDtoImpl pageDto = new MyPageDtoImpl();
				pageDto.setCopyNo(rs.getString("COPY_NO"));
				pageDto.setPictureName(rs.getString("NAME"));
				pageDto.setCopyName(rs.getString("COPY_NAME"));
				pageDto.setConstructNo(rs.getInt("CONSTRUCT_NO"));
				
				result.add(pageDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

//  업체 견적/공사 내역
	public int getCopyEstimateListCount(MyPageDtoImpl myDto) {
		String query = "SELECT COUNT(*) AS CNT"
				+ "     FROM CONSTRUCT c"
				+ "     JOIN BASIC_USER bu"
				+ "     ON c.USER_NO = bu.USER_NO"
				+ "     WHERE c.COPY_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, myDto.getCopyNo());
            ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


//  업체 견적/공사 내역
	public ArrayList<MyPageDtoImpl> getCopyEstimateList(PageInfo pi, MyPageDtoImpl myDto) {
		ArrayList<MyPageDtoImpl> result = new ArrayList<>();
		String query = "SELECT bu.USER_NO, bu.NAME, bu.PHONE_NUM, c.CONSTRUCT_NO"
				+ "     FROM CONSTRUCT c"
				+ "     FULL JOIN BASIC_USER bu"
				+ "        ON c.USER_NO = bu.USER_NO"
				+ "     WHERE c.COPY_NO = ?"
				+ "     OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, myDto.getCopyNo());
			pstmt.setInt(2, pi.getOffSet());
	        pstmt.setInt(3, pi.getBoardLimit());  
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MyPageDtoImpl pageDto = new MyPageDtoImpl();
				pageDto.setUserNo(rs.getInt("USER_NO"));
				pageDto.setName(rs.getString("NAME"));
				pageDto.setPhoneNum(rs.getString("PHONE_NUM"));
				pageDto.setConstructNo(rs.getInt("CONSTRUCT_NO"));
				
				result.add(pageDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
//	======================== 예약 확인 ===========================
	
	
	public MyPageDto reserveCheck(int constructNum) {
		
		String query = "SELECT cd.copy_name, c.CONSTRUCT_NO, bu.ADDR,c.CONSTRUCT_ADDR , c.CONSTRUCT_PRICE, c.CONSTRUCT_START_DATE "
				+ "		FROM COPY_DETAIL cd"
				+ "		FULL JOIN CONSTRUCT c ON cd.COPY_NO = c.COPY_NO "
				+ "		FULL JOIN BASIC_USER bu ON bu.USER_NO = c.USER_NO"
				+ "		WHERE c.construct_no  = ?";
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, constructNum);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("tttttttttttt" + constructNum);
			while(rs.next()) {
				
				String copyName = rs.getString("COPY_NAME");
				int constructNo = rs.getInt("CONSTRUCT_NO");
				String addr = rs.getString("ADDR");
				String userAddr = rs.getString("CONSTRUCT_ADDR");
				String constructPrice = rs.getString("CONSTRUCT_PRICE");
				String startDate = rs.getString("CONSTRUCT_START_DATE");
				System.out.println("=======================" + copyName);
				System.out.println("=======================" + constructNo);
				
				MyPageDtoImpl myDTO = new MyPageDtoImpl();
				
				myDTO.setCopyName(copyName);
				myDTO.setConstructNo(constructNo);
				myDTO.setAddress(addr);
				myDTO.setConstructArea(userAddr);
				myDTO.setConstructPrice(constructPrice);
				myDTO.setConstructStartDate(startDate);
				
				return myDTO;
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
















