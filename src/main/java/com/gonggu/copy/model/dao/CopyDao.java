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
		String query = "SELECT COPY_NAME, cd.COPY_NO, PATH"
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
				dto.setCopyNo(rs.getString("COPY_NO"));
				dto.setCopyPhoto(rs.getString("PATH"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<CopyDto> getCopyDetail(String copyNo) {
	        String query = "SELECT cd.COPY_NO,cd.COPY_NAME,cd.CONTENT,cd.COPY_ADDR,cd.TEL_NUM,cp.NAME AS CP_P_NAME,c.CONSTRUCT_NO,ce.exam_no,ce.TITLE,ep.NAME as EX_P_NAME,bu.user_id"
	        	   +"       FROM COPY_DETAIL cd"
	        	   +"       INNER JOIN COPY_PHOTO cp"
	        	   +"   	ON cd.COPY_NO = cp.COPY_NO"
	        	   +"       INNER JOIN CONSTRUCT c"
	        	   +"       ON c.COPY_NO = cd.COPY_NO"
	        	   +"       INNER JOIN CONST_EXAM ce"
	        	   +"       ON ce.CONSTRUCT_NO = c.CONSTRUCT_NO"
	               +"	    INNER JOIN EXAM_PICTURE ep"
	        	   +"		ON ep.EXAM_NO = ce.EXAM_NO"
	        	   +"	    INNER JOIN BASIC_USER bu"
	       		   +"	    ON bu.USER_NO  = c.USER_NO"
	       		   +"	    WHERE cd.COPY_NO  = ?";
        ArrayList<CopyDto> list = new ArrayList<>();
        
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, copyNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	CopyDto dto = new CopyDto();
                dto.setCopyName(rs.getString("COPY_NAME"));
                dto.setCopyNo(rs.getString("COPY_NO"));
                dto.setCopyPhoto(rs.getString("CP_P_NAME"));
                dto.setCopyContent(rs.getString("CONTENT"));
                dto.setCopyAddress(rs.getString("COPY_ADDR"));
                dto.setCopyNumber(rs.getString("TEL_NUM"));
                dto.setExamTitle(rs.getString("TITLE"));
                dto.setExamNo(rs.getInt("EXAM_NO"));
                dto.setUserId(rs.getString("USER_ID"));
                dto.setConstructNo(rs.getString("CONSTRUCT_NO"));
                dto.setExamPhoto(rs.getString("EX_P_NAME"));
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
			pstmt.setString(1, copyDto.getCopyNo());
			pstmt.setString(2, copyDto.getReview());
			pstmt.setInt(3, copyDto.getUserNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}