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
        rs = pstmt.executeQuery();
        
        while(rs.next()) {
        	CopyDto dto = new CopyDto();
            dto.setCopyName(rs.getString("COPY_NAME"));
            dto.setCopyNo(rs.getString("COPY_NO"));
            dto.setCopyPhoto(rs.getString("PATH"));
            list.add(dto);          
        } 
		}catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	public ArrayList<CopyDto> getCopyDetail(String copyNo) {
        String query = "SELECT REVIEW_CONTENT,c.CONSTRUCT_NO,bu.user_id,ce.exam_no,TITLE,cd.COPY_NO, cp.PATH AS COPY_PATH, ep.PATH AS EXAM_PATH , COPY_NAME , cd.CONTENT , COPY_ADDR , TEL_NUM"
        			+ " FROM COPY_DETAIL cd"
        			+ " FULL JOIN COPY_PHOTO cp"
        			+ " ON cd.COPY_NO = cp.COPY_NO"
        			+ " FULL JOIN COPY_REVIEW cr"
        			+ " ON cd.COPY_NO = cr.COPY_NO"
        			+ " FULL JOIN CONSTRUCT c"
        			+ " ON c.COPY_NO = cd.COPY_NO"
        			+ " FULL JOIN CONST_EXAM ce"
        			+ " ON ce.CONSTRUCT_NO = c.CONSTRUCT_NO"
        			+ " FULL JOIN EXAM_PICTURE ep"
        			+ " ON ep.EXAM_NO = ce.EXAM_NO"
        			+ " FULL JOIN CATEGORY cg"
        			+ " ON ce.CATEGORY_NO = cg.CATEGORY_NO"
        			+ " FULL JOIN BASIC_USER bu" 
       			    + " ON bu.USER_NO  = c.USER_NO" 
        			+ " WHERE cd.COPY_NO = ?";
        
        ArrayList<CopyDto> list = new ArrayList<>();
        
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, copyNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	CopyDto dto = new CopyDto();
                dto.setCopyName(rs.getString("COPY_NAME"));
                dto.setCopyNo(rs.getString("COPY_NO"));
                dto.setCopyPhoto(rs.getString("COPY_PATH"));
                dto.setExamPhoto(rs.getString("EXAM_PATH"));
                dto.setCopyContent(rs.getString("CONTENT"));
                dto.setCopyAddress(rs.getString("COPY_ADDR"));
                dto.setCopyNumber(rs.getString("TEL_NUM"));
                dto.setExamTitle(rs.getString("TITLE"));
                dto.setExamNo(rs.getInt("EXAM_NO"));
                dto.setUserId(rs.getString("USER_ID"));
                dto.setReview(rs.getString("REVIEW_CONTENT"));
                dto.setConstructNo(rs.getString("CONSTRUCT_NO"));
                list.add(dto);
                
                System.out.println("copyNo:"+dto.getCopyNo());
                System.out.println("constructNo:"+dto.getConstructNo());
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