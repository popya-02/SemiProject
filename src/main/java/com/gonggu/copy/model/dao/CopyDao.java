package com.gonggu.copy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.common.PageInfo;
import com.gonggu.copy.model.dto.CopyDto;


public class CopyDao {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public CopyDao(){
		dc = new DatabaseConnection();																					
		con = dc.connDB();
	}
	public List<CopyDto> getCompanyList(PageInfo pi) {
		
        String query = "SELECT COPY_NAME, cd.COPY_NO, PATH"
        			+ " FROM COPY_DETAIL cd"
        			+ " FULL JOIN COPY_PHOTO cp"
        			+ " 	ON cd.COPY_NO = cp.COPY_NO"
        			+ " WHERE cd.COPY_NO = (SELECT COPY_NO"
        			+ "						FROM COPY_USER cu"
        			+ "						WHERE APPROVE = 'Y')"
        			+ " ORDER BY COPY_NAME DESC"
        			+ " OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
        
        List<CopyDto> list = new ArrayList<>();
        
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

	public CopyDto getCopyDetail(String copyNo) {
        String query = "SELECT cd.COPY_NO, PATH , COPY_NAME , CONTENT , COPY_ADDR , TEL_NUM"
        			+ " FROM COPY_DETAIL cd"
        			+ " FULL JOIN COPY_PHOTO cp"
        			+ " ON cd.COPY_NO = cp.COPY_NO"
        			+ " WHERE cd.COPY_NO = ?";
        CopyDto dto = null;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, copyNo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new CopyDto();
                dto.setCopyName(rs.getString("COPY_NAME"));
                dto.setCopyNo(rs.getString("COPY_NO"));
                dto.setCopyPhoto(rs.getString("PATH"));
                dto.setCopyContent(rs.getString("CONTENT"));
                dto.setCopyAddress(rs.getString("COPY_ADDR"));
                dto.setCopyNumber(rs.getString("TEL_NUM"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
	
	public int getListCount() {
		
        String query = "SELECT COUNT(cd.COPY_NO) AS CNT"
        			+ " FROM COPY_DETAIL cd"
        			+ " FULL JOIN COPY_PHOTO cp"
        			+ " 	ON cd.COPY_NO = cp.COPY_NO"
        			+ " WHERE cd.COPY_NO = (SELECT COPY_NO"
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
}



