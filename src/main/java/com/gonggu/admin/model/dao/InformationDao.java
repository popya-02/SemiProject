package com.gonggu.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.DatabaseConnection;
import com.gonggu.common.PageInfo;


public class InformationDao {
	
	
	
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;

	public InformationDao() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
		
		
		
		
	
	public ArrayList<InformationDto> getUserList(PageInfo pi, String category, String searchText) {
		
		ArrayList<InformationDto> result = new ArrayList<>();
		String query = "SELECT USER_NO, NAME, USER_ID, ADDR FROM basic_user"
				+ " where " + category + " Like '%' || ? || '%' "
				+ " ORDER BY user_no desc"
				+ " offset ? rows fetch first ? rows only";

			
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchText);
			pstmt.setInt(2, pi.getOffSet());
			pstmt.setInt(3, pi.getBoardLimit());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("USER_NO");
				String name = rs.getString("NAME");
				String id = rs.getString("USER_ID");
				String addr = rs.getString("ADDR");

				InformationDto infoDto = new InformationDto();
				infoDto.setUserNo(no);
				infoDto.setUserName(name);
				infoDto.setUserId(id);
				infoDto.setAddr(addr);
				

				result.add(infoDto);
//				System.out.println(infoDto.getUserId());
//				System.out.println(infoDto.getUserName());
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public ArrayList<InformationDto> getCopyList(PageInfo pi, String category, String searchText) {
		
		ArrayList<InformationDto> result = new ArrayList<>();
		String query = "SELECT cu.COPY_NO, cu.COPY_NAME, cd.CEO_NAME, cd.COPY_ADDR, cu.APPROVE FROM COPY_USER cu "
				+ "		JOIN COPY_DETAIL cd ON cu.COPY_NO = cd.COPY_NO"
				+ "	 	where " + category + " Like '%' || ? || '%' "
				+ " 	ORDER BY cu.INDATE desc"
				+ " 	offset ? rows fetch first ? rows only";
		
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchText);
			pstmt.setInt(2, pi.getOffSet());
			pstmt.setInt(3, pi.getBoardLimit());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString("COPY_NO");
//				System.out.println(no);
				String copyName = rs.getString("COPY_NAME");
				String ceo = rs.getString("CEO_NAME");
				String addr = rs.getString("COPY_ADDR");
				String approve = rs.getString("APPROVE");
				
				InformationDto infoDto = new InformationDto();
				infoDto.setCopyNo(no);
				infoDto.setCopyName(copyName);
				infoDto.setCeoName(ceo);
				infoDto.setCopyAddr(addr);
				infoDto.setApprove(approve);
				
				
				result.add(infoDto);
//				System.out.println(infoDto.getCopyNo());
//				System.out.println(infoDto.getCopyName());
//				System.out.println(infoDto.getCopyAddr());
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public int getUserListCount(String category, String searchText) {
		
		String query = "SELECT COUNT(*) as cnt FROM basic_user"
				+ "		where " + category + " like '%' || ? || '%' ";
		
		try	{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchText);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	public int getCopyListCount(String category, String searchText) {
		
		String query = "SELECT COUNT(*) as cnt FROM copy_user cu"
				+ "		JOIN copy_detail cd ON cu.copy_no = cd.copy_no"
				+ "		where " + category + " like '%' || ? || '%' ";
		
//	System.out.println(query);
	
	
	
		try	{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchText);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	public ArrayList<InformationDto> copyApproveList(PageInfo pi) {
		
		String query = "SELECT cu.COPY_NO, cu.COPY_NAME, cd.CEO_NAME, cd.COPY_ADDR, cu.APPROVE FROM COPY_USER cu"
				+ "		JOIN COPY_DETAIL cd ON cu.COPY_NO = cd.COPY_NO"
				+ "		where cu.APPROVE = 'N' ";
		
		ArrayList<InformationDto>  result = new ArrayList<InformationDto>();
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String no = rs.getString("COPY_NO");
				String copyName = rs.getString("COPY_NAME");
				String ceo = rs.getString("CEO_NAME");
				String addr = rs.getString("COPY_ADDR");
				String approve = rs.getString("APPROVE");
				
				InformationDto infoDto = new InformationDto();
				infoDto.setCopyNo(no);
				infoDto.setCopyName(copyName);
				infoDto.setCeoName(ceo);
				infoDto.setCopyAddr(addr);
				infoDto.setApprove(approve);
				
				result.add(infoDto);
//				System.out.println(infoDto.getCopyNo());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
public int copyApproveListCount() {
		
		String query = "SELECT COUNT(*) as cnt FROM copy_user cu"
				+ "		JOIN copy_detail cd ON cu.copy_no = cd.copy_no";
		
//	System.out.println(query);
	
	
	
		try	{
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

// TODO : 업체 정보 불러오기 ApproveList 

	public int updateCopyApproveStatus(InformationDto infoDto) {
		
		String query = "UPDATE COPY_USER SET APPROVE = 'Y' WHERE copy_no = ?";
		
		
		int result = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, infoDto.getCopyNo());
			result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	public int saveCopyStatus(String copyNo, String approve) {
		 String query = "SELECT approve from copy_user"
		 		+ "		 where copy_no = ?"
		 		+ "		 AND approve = 'Y' ";
		 
		 try {
			pstmt = con.prepareStatement(query);
	        pstmt.setObject(1, copyNo);
	        int result = pstmt.executeUpdate();
	        
	        if (result == 0) {
	        } else {
	        	return result;
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return 0;
	}
	
	public String getUserApprovalStatus(String copyNo) {
		String approvalStatus = null;
		
		
		String query = "SELECT approve FROM users "
				+ "		WHERE copy_no= ? ";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, copyNo);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				approvalStatus = rs.getString("approve");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return approvalStatus;
		
	}

	
}
