       package com.gonggu.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.common.PageInfo;
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
	            	+ " default, "	// purchaseStatus 
	            	+ " ?,"
	            	+ " default"	 // deposit 10
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
		String query = """
				SELECT COUNT(*) AS CNT
				FROM CONSTRUCT c 
				JOIN COPY_DETAIL cd ON c.COPY_NO = cd.COPY_NO
				WHERE c.USER_NO = ?
				""";
				
//				"SELECT COUNT(*) AS CNT"
//				+ "     FROM CONSTRUCT c"
//				+ "     JOIN COPY_DETAIL cd"
//				+ "     ON c.COPY_NO = cd.COPY_NO"
//				+ "     WHERE c.USER_NO = ?";
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
		String query = """
						SELECT c.COPY_NO, cp.name, cd.copy_name, c.CONSTRUCT_NO, c.PURCHASE_STATUS FROM CONSTRUCT c
						JOIN COPY_DETAIL cd ON c.COPY_NO = cd.COPY_NO
						FULL JOIN COPY_PHOTO cp ON cp.COPY_NO = c.COPY_NO
						WHERE c.USER_NO = ?
						OFFSET ? ROWS FETCH FIRST ? ROWS ONLY
					""";
		
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
				pageDto.setConstStatus(rs.getString("PURCHASE_STATUS"));
				
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
		String query = "SELECT bu.USER_NO, bu.NAME, bu.PHONE_NUM, c.CONSTRUCT_NO, c.PURCHASE_STATUS"
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
				pageDto.setConstStatus(rs.getString("PURCHASE_STATUS"));
				
				result.add(pageDto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
//	======================== 예약 확인 ===========================
	
	
	// 예약 확인 조회 
	public MyPageDtoImpl reserveCheck(int constructNum) {
		
		String query =  """
						SELECT cd.copy_name, c.CONSTRUCT_NO, bu.ADDR,c.CONSTRUCT_ADDR, bu.PHONE_NUM , c.CONSTRUCT_PRICE, c.CONSTRUCT_DEPOSIT, TO_CHAR(c.CONSTRUCT_START_DATE, 'YYYY-MM-DD') AS 시작, TO_CHAR(c.CONSTRUCT_END_DATE, 'YYYY-MM-DD') AS 끝, c.PURCHASE_STATUS, c.CHATTING_NO
						FROM COPY_DETAIL cd
						FULL JOIN CONSTRUCT c ON cd.COPY_NO = c.COPY_NO
						FULL JOIN BASIC_USER bu ON bu.USER_NO = c.USER_NO
						WHERE c.construct_no  = ?
						""";
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, constructNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String copyName = rs.getString("COPY_NAME");
				int constructNo = rs.getInt("CONSTRUCT_NO");
				String addr = rs.getString("ADDR");
				String phoneNum = rs.getString("PHONE_NUM");
				String userAddr = rs.getString("CONSTRUCT_ADDR");
				String constructPrice = rs.getString("CONSTRUCT_PRICE");
				int deposit = rs.getInt("CONSTRUCT_DEPOSIT");
				String startDate = rs.getString("시작");
				String endDate = rs.getString("끝");
				String status = rs.getString("PURCHASE_STATUS");
				int chattingNo = rs.getInt("CHATTING_NO");
				
				MyPageDtoImpl myDTO = new MyPageDtoImpl();
				
				myDTO.setCopyName(copyName);
				myDTO.setConstructNo(constructNo);
				myDTO.setAddress(addr);
				myDTO.setPhoneNum(phoneNum);
				myDTO.setConstAddr(userAddr);
				myDTO.setEstimatePrice(constructPrice);
				myDTO.setConstDeposit(deposit);
				myDTO.setConstStartDate(startDate);
				myDTO.setConstEndDate(endDate);
				myDTO.setConstStatus(status);
				myDTO.setChattingNum(chattingNo);
				
				return myDTO;
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 결제 요청 
	 */
	public int savePurchaseStatus(int constructNo) {
		String query = """
						SELECT PURCHASE_REQUEST FROM CONSTRUCT c 
						WHERE CONSTRUCT_NO = ?
						AND PURCHASE_STATUS = 'N'
					   """;
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, constructNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String purchaseRequest= rs.getString("PURCHASE_REQUEST");

                    // PURCHASE_REQUEST가 null인 경우 0을 반환
                if ("Y".equals(purchaseRequest)) {
                    result = 1; 
                    // PURCHASE_REQUEST가 'Y'인 경우 1을 반환
                } else {
                	result = 0; 
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 결제 요청시 업데이트 
	public int purchaseReq(int constructNo) {
		String query = """
						UPDATE construct
						SET purchase_Request = 'Y'
						WHERE CONSTRUCT_NO = ?
						""";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, constructNo);
			
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
}
















