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
		String query = "SELECT USER_NO, NAME, ADDR FROM basic_user"
				+ " where " + category + " Like '%' || ? || '%' "
				+ " ORDER BY user_no desc"
				+ " offset ? rows fetch first ? rows only";

		System.out.println("gd22");
			
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchText);
			pstmt.setInt(2, pi.getOffset());
			pstmt.setInt(3, pi.getBoardLimit());
			ResultSet rs = pstmt.executeQuery();
			System.out.println("gd");
			while(rs.next()) {
				int no = rs.getInt("USER_NO");
				String name = rs.getString("NAME");
				String addr = rs.getString("ADDR");

				InformationDto infoDto = new InformationDto();
				infoDto.setUserNo(no);
				infoDto.setUserName(name);
				infoDto.setAddr(addr);
				

				result.add(infoDto);
				System.out.println(infoDto.getUserName());
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public int getListCount(String category, String searchText) {
		
		String query = "SELECT COUNT(*) as cnt FROM basic_user"
				+ "		where " + category + " like '%' || ? || '%' ";
		
		try	{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchText);
			System.out.println("aaaaaaaaaaa");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("bbbbbbbbbbb");

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
		
		String query = "SELECT cu.COPY_NO, cu.COPY_NAME, COPY_ADDR from COPY_USER cu"
				+ "		JOIN COPY_DETAIL cd ON cu.COPY_NO = cd.COPY_NO";
		
		ArrayList<InformationDto>  result = new ArrayList<InformationDto>();
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int no = rs.getInt("COPY_NO");
				String name = rs.getString("COPY_NAME");
				String addr = rs.getString("COPY_ADDR");
				
				InformationDto infoDto = new InformationDto();
				infoDto.setCopyNo(no);
				infoDto.setCopyName(name);
				infoDto.setCopyAddr(addr);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int copyApproveStatus(InformationDto infoDto) {
		
		String query = "UPDATE COPY_USER SET APPROVE = 'Y' WHERE copy_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, infoDto.getCopyNo());
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
