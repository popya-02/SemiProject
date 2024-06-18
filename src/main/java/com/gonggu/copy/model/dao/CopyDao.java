package com.gonggu.copy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.common.PageInfo;
import com.gonggu.copy.model.dto.CopyDto;
import com.gonggu.copy.model.dto.CopyDtoImpl;


public class CopyDao {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CopyDao(){
		dc = new DatabaseConnection();																					
		con = dc.connDB();
	}

	public ArrayList<CopyDto> getCompanyList(PageInfo pi) {
		String query = "SELECT COPY_NAME, cd.COPY_NO, cp.NAME"
				+ " FROM COPY_DETAIL cd"
				+ " FULL JOIN COPY_PHOTO cp"
				+ " 	ON cd.COPY_NO = cp.COPY_NO"
				+ " WHERE cd.COPY_NO IN (SELECT COPY_NO"
				+ "						FROM COPY_USER cu"
				+ "						WHERE APPROVE = 'Y')"
				+ " ORDER BY COPY_NAME DESC"
				+ " OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";

		ArrayList<CopyDto> list = new ArrayList<>();

		try {

			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, pi.getOffSet());
			pstmt.setInt(2, pi.getBoardLimit());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CopyDto dto = new CopyDto();
				dto.setCopyName(rs.getString("COPY_NAME"));
				dto.setCopyNum(rs.getString("COPY_NO"));
				dto.setCopyPhoto(rs.getString("NAME"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<CopyDto> getCopyDetail(String copyNo) {
	        String query = "SELECT cd.COPY_NO,cd.COPY_NAME,cd.CONTENT,cd.COPY_ADDR,cd.TEL_NUM,cp.NAME AS CP_P_NAME"
	        	   +"       FROM COPY_DETAIL cd"
	        	   +"       FULL JOIN COPY_PHOTO cp"
	        	   +"   	ON cd.COPY_NO = cp.COPY_NO"
	        	   +"       FULL JOIN CONSTRUCT c"
	        	   +"       ON cd.COPY_NO  = c.COPY_NO"
	               +"       FULL JOIN CONST_EXAM ce"
	        	   +"       ON ce.CONSTRUCT_NO = c.CONSTRUCT_NO"

	       	   	   +"	    WHERE cd.COPY_NO  = ?";

	        
        ArrayList<CopyDto> list = new ArrayList<>();
        
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, copyNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	CopyDto dto = new CopyDto();
            	dto.setCopyNum(rs.getString("COPY_NO"));
                dto.setCopyName(rs.getString("COPY_NAME"));
                dto.setCopyContent(rs.getString("CONTENT"));
                dto.setCopyAddress(rs.getString("COPY_ADDR"));
                dto.setCopyNumber(rs.getString("TEL_NUM"));
                dto.setCopyPhoto(rs.getString("CP_P_NAME"));
				
                list.add(dto);
                
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
	}
        
        public ArrayList<CopyDto> getCopyDetailEx(String copyNo) {
        	String query = "SELECT ce.TITLE,ce.EXAM_NO,ce.CONSTRUCT_NO,EP.NAME FROM CONST_EXAM ce" 
	        	   +"       FULL JOIN EXAM_PICTURE ep"
	        	   +"       ON ce.EXAM_NO = ep.EXAM_NO"
	        	   +"       FULL JOIN CONSTRUCT c"
	        	   +"       ON c.CONSTRUCT_NO = ce.CONSTRUCT_NO"
	        	   +"       FULL JOIN COPY_DETAIL cd"
	        	   +"       ON cd.COPY_NO = c.COPY_NO"
	        	   +"       WHERE cd.COPY_NO = ? AND ce.DELETE_STATUS = 'N'";
        	
        	ArrayList<CopyDto> list = new ArrayList<>();
        	
        	try {
        		pstmt = con.prepareStatement(query);
        		pstmt.setString(1, copyNo);
        		ResultSet rs = pstmt.executeQuery();
        		while (rs.next()) {
        			CopyDto dto = new CopyDto();
        			
        			 dto.setExamTitle(rs.getString("TITLE"));
        			 dto.setExamNo(rs.getInt("EXAM_NO"));
        			 dto.setConstructNo(rs.getString("CONSTRUCT_NO"));
        			 dto.setExamPhoto(rs.getString("NAME"));
        			 list.add(dto);
        			
        			
        		}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        	return list;
        
	}
        public ArrayList<CopyDto> getReview(String copyNo){
        	String query = "SELECT * FROM COPY_REVIEW cr"
        			   + "  JOIN BASIC_USER bu ON cr.USER_NO = bu.USER_NO"
        			   + "  where copy_no = ?" 
        			   + "  ORDER BY REVIEW_NO DESC";
        	ArrayList<CopyDto> list = new ArrayList<>();	
        	try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, copyNo);
	            ResultSet rs = pstmt.executeQuery();
	            
	           while(rs.next()){
	        	   CopyDto dto = new CopyDto();
	        	   dto.setUserId(rs.getString("USER_ID"));
	        	   dto.setReview(rs.getString("REVIEW_CONTENT"));
	        	   list.add(dto);
	           }
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	return list;
        }
	
	public int getListCount() {
		
        String query = "SELECT COUNT(cd.COPY_NO) AS CNT"
        			+ " FROM COPY_DETAIL cd"
        			+ " FULL JOIN COPY_PHOTO cp"
        			+ " 	ON cd.COPY_NO = cp.COPY_NO"
        			+ " WHERE cd.COPY_NO IN (SELECT COPY_NO"
        			+ "						FROM COPY_USER cu"
        			+ "						WHERE APPROVE = 'Y')";
		
		try {
			pstmt = con.prepareStatement(query);
			
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
	
	public int reviewUpload(CopyDtoImpl copyDto) {
		String query = "INSERT INTO COPY_REVIEW cr"
				   +"   VALUES(review_seq.nextval, ?, ?, ?)";
		int result=0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, copyDto.getCopyNum());
			pstmt.setString(2, copyDto.getReview());
			pstmt.setInt(3, copyDto.getUserNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}