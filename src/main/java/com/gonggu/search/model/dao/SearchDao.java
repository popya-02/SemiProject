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
import com.gonggu.search.model.dto.SearchDtoImpl;

public class SearchDao {
		private Connection con;
		private DatabaseConnection dc;
		private PreparedStatement pstmt;
		
		public SearchDao() {
			dc = new DatabaseConnection();
			con = dc.connDB();
		}

		public int getConstSearchListCount(String category, String searchText) {
			String query = "SELECT COUNT(*) AS CNT"
					+ "     FROM CONST_EXAM"
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

		public ArrayList<SearchDtoImpl> getConstSearchList(PageInfo pi, String category, String searchText) {
			ArrayList<SearchDtoImpl> result = new ArrayList<>();
			String query = "SELECT ce.EXAM_NO, TITLE, CONTENT, ep.NAME"
					+ "     FROM CONST_EXAM ce"
					+ "     JOIN EXAM_PICTURE ep"
					+ "     ON ce.EXAM_NO = ep.EXAM_NO"
					+ "     WHERE DELETE_STATUS = 'N'"
					+ "     AND " + category + " LIKE '%'||?||'%'"
					+ "     ORDER BY ce.EXAM_NO DESC"
					+ "     OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, searchText);
				pstmt.setInt(2, pi.getOffSet());
				pstmt.setInt(3, pi.getBoardLimit());
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					SearchDtoImpl searchDto = new SearchDtoImpl();
					searchDto.setExamNo(rs.getInt("EXAM_NO"));
					searchDto.setExamTitle(rs.getString("TITLE"));
					searchDto.setExamContent(rs.getString("CONTENT"));
					searchDto.setExamPictureName(rs.getString("NAME"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}

		public int getCopySearchListCount(String category, String searchText) {
			String query = "SELECT COUNT(*) AS CNT"
					+ "     FROM COPY_DETAIL"
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

		public ArrayList<SearchDtoImpl> getCopySearchList(PageInfo pi, String category, String searchText) {
		       ArrayList<SearchDtoImpl> result = new ArrayList<>();
			String query = "SELECT COPY_NO, COPY_NAME, NAME"
					+ "     FROM COPY_DETAIL"
					+ "     JOIN COPY_PHOTO"
					+ "     ON COPY_NO = COPY_NO"
					+ "     AND " + category +" LIKE '%'||?||'%'"
					+ "     ORDER BY ce.EXAM_NO DESC";
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, searchText);
				pstmt.setInt(2, pi.getOffSet());
				pstmt.setInt(3, pi.getBoardLimit());
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					SearchDtoImpl searchDto = new SearchDtoImpl();
					searchDto.setCopyNo(rs.getString("COPY_NO"));
					searchDto.setCopyName(rs.getString("COPY_NAME"));
					searchDto.setPictureName(rs.getString("NAME"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
}
