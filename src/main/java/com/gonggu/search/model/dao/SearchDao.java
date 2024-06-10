package com.gonggu.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.DatabaseConnection;
import com.gonggu.common.PageInfo;
import com.gonggu.search.model.dto.SearchDto;

public class SearchDao {
		private Connection con;
		private DatabaseConnection dc;
		private PreparedStatement pstmt;
		
		public SearchDao() {
			dc = new DatabaseConnection();
			con = dc.connDB();
		}

		public int getSearchListCount(String category, String searchText) {
			String query = "SELECT COUNT(*) AS CNT"
					+ "     FROM COPY_DETAIL cd"
					+ "     JOIN CONSTRUCT c"
					+ "     ON cd.COPY_NO = c.COPY_NO"
					+ "     JOIN CONSTRUCT_EXAM ce"
					+ "     ON c.CONSTRUCT_NO = ce.CONSTRUCT_NO"
					+ "     WHERE DELETE_STATUS = 'N'"
					+ "     AND " + category + " LIKE '%'||?||'%'";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, searchText);
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

		public ArrayList<SearchDto> getSearchList(PageInfo pi, String category, String searchText) {
			ArrayList<SearchDto> result = new ArrayList<>();
			String query = "SELECT * FROM COPY_DETAIL cd"
					+ "     JOIN CONSTRUCT c"
					+ "     ON cd.COPY_NO = c.COPY_NO"
					+ "     JOIN CONST_EXAM ce"
					+ "     ON c.CONSTRUCT_NO = ce.CONSTRUCT_NO"
					+ "     WHERE DELETE_STATUS = 'N'"
					+ "     AND " + category + " LIKE '%'||?||'%'"
					+ "     ORDER BY c.CONSTRUCT_NO DESC"
					+ "     OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, searchText);
				pstmt.setInt(2, pi.getOffSet());
				pstmt.setInt(3, pi.getBoardLimit());
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}


	
}
