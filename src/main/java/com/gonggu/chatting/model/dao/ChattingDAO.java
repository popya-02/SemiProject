package com.gonggu.chatting.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gonggu.chatting.model.dto.ChattingDTO;
import com.gonggu.common.DatabaseConnection;
import com.gonggu.common.PageInfo;
import com.gonggu.mypage.model.dto.MyPageDto;

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
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ChattingDTO duplicateCheck(ChattingDTO chattingDto) {
		String query = "SELECT CHATTING_NO, END_CHECK AS "
					+ " FROM CONSTRUCT_STATUS cc "
					+ " WHERE USER_NO = ?"
					+ "	AND COPY_NO = ?"
					+ " AND END_CHECK = 'N'";
		
		
		try {
			pstmt  = con.prepareStatement(query);
			
			pstmt.setInt(1, chattingDto.getUserNum());
			pstmt.setString(2, chattingDto.getCopyNum());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int chatResult = rs.getInt("CHATTING_NO");
				String endCheck = rs.getString("END_CHECK");
				
				ChattingDTO chattingDto2 = new ChattingDTO();
				chattingDto2.setChattingNum(chatResult);
				chattingDto2.setEndCheck(endCheck);
				
				return chattingDto2;
				
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
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
			
			pstmt.close();
			con.close();
			
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
			
			pstmt.close();
			con.close();
			
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

	public int deleteLog(int chatNum) {
		String query = "DELETE FROM CHATTING_LOG"
					+ " WHERE CHATTING_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, chatNum);
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int changeChattingState(int chatNum) {
		
		String query = "UPDATE CONSTRUCT_STATUS"
					+ " SET END_CHECK = 'Y'"
					+ " WHERE CHATTING_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, chatNum);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ChattingDTO getUserName(ChattingDTO result) {
		
		String query = "SELECT bu.NICKNAME ,bu.USER_ID"
					+ " FROM CONSTRUCT_STATUS cs"
					+ " JOIN BASIC_USER bu "
					+ "	ON cs.USER_NO = bu.USER_NO"
					+ " WHERE cs.CHATTING_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, result.getChattingNum());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String nickName = rs.getString("NICKNAME");
				String userId = rs.getString("USER_ID");
				
				result.setUserNickName(nickName);
				result.setUserId(userId);
				
				return result;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ChattingDTO getCopyName(ChattingDTO userResult) {
		
		String query = "SELECT cu.COPY_NAME"
				+ " FROM CONSTRUCT_STATUS cs"
				+ " JOIN COPY_USER cu "
				+ "	ON cs.COPY_NO = cu.COPY_NO"
				+ " WHERE cs.CHATTING_NO = ?";
	
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userResult.getChattingNum());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String copyName = rs.getString("COPY_NAME");
				
				userResult.setCopyName(copyName);
				
				return userResult;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	public int getListCount(String copyNum) {
		
		String query = "SELECT COUNT(COPY_NO) AS CNT"
					+ " FROM CONSTRUCT_STATUS cs "
					+ " WHERE COPY_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, copyNum);
			
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

	public List<ChattingDTO> getCopyChattingList(PageInfo pi, String sessionCopyNum) {								// 예약금 
		
		String query = "SELECT cs.CHATTING_NO , cs.COPY_NO , cs.USER_NO , cs.CREATE_DATE , cs.END_CHECK , bu.NAME, c.CONSTRUCT_DEPOSIT, c.CONSTRUCT_NO"
					+ " FROM CONSTRUCT_STATUS cs"
					+ " JOIN BASIC_USER bu"
					+ "		ON cs.USER_NO = bu.USER_NO "
					+ "	FULL JOIN CONSTRUCT c"						// price의 값이 null 인 값도 가져오게
					+ "     ON cs.CHATTING_NO  = c.CHATTING_NO"
					+ " WHERE cs.COPY_NO = ?"
					+ " ORDER BY CREATE_DATE DESC"
					+ " OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
		
		List<ChattingDTO> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, sessionCopyNum);
			pstmt.setInt(2, pi.getOffSet());
			pstmt.setInt(3, pi.getBoardLimit());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ChattingDTO dto = new ChattingDTO();
				dto.setChattingNum(rs.getInt("CHATTING_NO"));
				dto.setCopyNum(rs.getString("COPY_NO"));
				dto.setUserNum(rs.getInt("USER_NO"));
				dto.setUserName(rs.getString("NAME"));
				dto.setChattingIndate(rs.getString("CREATE_DATE"));
				dto.setEndCheck(rs.getString("END_CHECK"));
				dto.setEstimatePrice(rs.getString("CONSTRUCT_DEPOSIT"));
				dto.setConstNo(rs.getInt("CONSTRUCT_NO"));

				list.add(dto);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	public ChattingDTO setEndChatSet(int chatNum) {
		
		String query = "SELECT END_CHECK, cs.USER_NO, USER_ID, NICKNAME "
					+ " FROM CONSTRUCT_STATUS cs "
					+ " JOIN BASIC_USER bu "
					+ "		ON cs.USER_NO = bu.USER_NO "
					+ " WHERE CHATTING_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, chatNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ChattingDTO dto = new ChattingDTO();
				dto.setEndCheck(rs.getString("END_CHECK"));
				dto.setUserNum(rs.getInt("USER_NO"));
				dto.setUserId(rs.getString("USER_ID"));
				dto.setUserNickName(rs.getString("NICKNAME"));
				
				return dto;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
