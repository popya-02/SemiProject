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
				+ " 	ORDER BY fb_indate desc"
				+ " 	offset ? rows fetch first ? rows only";

			
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pi.getOffset());
			pstmt.setInt(2, pi.getBoardLimit());
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				int no = rs.getInt("USER_NO");
				String name = rs.getString("NAME");
				String addr = rs.getString("ADDR");

				InformationDto infoDto = new InformationDto();
				infoDto.setUserNo(no);
				infoDto.setUserName(name);
				infoDto.setAddr(addr);

				result.add(infoDto);
			}

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	public int getListCount(String category, String searchText) {
		
		String query = "SELECT COUNT(*) as cnt FROM basic_name"
				+ "		AND " + category + " like '%' || ? || '%' ";
		

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

}
