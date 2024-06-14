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

		public ArrayList<SearchDto> gerSearchExamList(String searchText) {
			ArrayList<SearchDto> result = new ArrayList<>();
			String query = "SELECT ce.EXAM_NO, ce.TITLE, ce.TAG_REMOVE_CONTENT, ep.NAME, cu.COPY_NAME, ce.CATEGORY_NO, cg.NAME AS CATEGORY_NAME"
					+ "     FROM CONST_EXAM ce"
					+ "     FULL JOIN CATEGORY cg"
					+ "     ON ce.CATEGORY_NO = cg.CATEGORY_NO"
					+ "     FULL JOIN CONSTRUCT c"
					+ "     ON ce.CONSTRUCT_NO = c.CONSTRUCT_NO"
					+ "     FULL JOIN COPY_USER cu"
					+ "     ON c.COPY_NO = cu.COPY_NO"
					+ "     FULL JOIN EXAM_PICTURE ep"
					+ "     ON ce.EXAM_NO = ep.EXAM_NO"
					+ "     WHERE (LOWER(cu.COPY_NAME) LIKE LOWER('%' || ? || '%')"
					+ "     OR LOWER(ce.TITLE) LIKE LOWER('%' || ? || '%')"
					+ "     OR LOWER(ce.TAG_REMOVE_CONTENT) LIKE LOWER('%' || ? || '%')"
					+ "     OR LOWER(cg.NAME) LIKE LOWER('%' || ? || '%'))"
					+ "     AND ce.DELETE_STATUS = 'N'"
					+ "     ORDER BY ce.EXAM_NO desc";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, searchText);
				pstmt.setString(2, searchText);
				pstmt.setString(3, searchText);
				pstmt.setString(4, searchText);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					SearchDtoImpl examDto = new SearchDtoImpl();
					examDto.setExamNo(rs.getInt("EXAM_NO"));
					examDto.setCopyName(rs.getString("COPY_NAME"));
					examDto.setExamTitle(rs.getString("TITLE"));
					examDto.setExamContent(rs.getString("TAG_REMOVE_CONTENT"));
					examDto.setExamPictureName(rs.getString("NAME"));
					examDto.setCategoryNo(rs.getInt("CATEGORY_NO"));
					examDto.setCategoryName(rs.getString("CATEGORY_NAME"));
					
					result.add(examDto);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}

		public ArrayList<SearchDto> getSearchCopyList(String searchText) {
			ArrayList<SearchDto> result = new ArrayList<>();
			String query = "SELECT cd.COPY_NO, cd.COPY_NAME, cp.NAME"
					+ "     FROM COPY_DETAIL cd"
					+ "     FULL JOIN COPY_PHOTO cp"
					+ "     ON cd.COPY_NO = cp.COPY_NO"
					+ "     WHERE cd.COPY_NAME LIKE '%' || ? || '%'"
					+ "     ORDER BY cd.COPY_NO desc";
			
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, searchText);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					SearchDtoImpl copyDto = new SearchDtoImpl();
					copyDto.setCopyNo(rs.getString("COPY_NO"));
					copyDto.setCopyName(rs.getString("COPY_NAME"));
					copyDto.setPictureName(rs.getString("NAME"));
					
					result.add(copyDto);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}

	}

