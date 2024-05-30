package com.gonggu.copy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.copy.model.dto.CopyDto;


public class CopyDao {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CopyDao(){
		dc = new DatabaseConnection();																					
		con = dc.connDB();
	}
	public List<CopyDto> getCompanyList() {
        String query = "SELECT COPY_NAME, cd.COPY_NO, PATH FROM COPY_DETAIL cd"
        		+"      JOIN COPY_PHOTO cp ON cd.COPY_NO = cp.COPY_NO";
        List<CopyDto> list = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CopyDto dto = new CopyDto();
                dto.setCopyName(rs.getString("COPY_Name"));
                dto.setCopyNo(rs.getInt("COPY_NO"));
                dto.setCopyPhoto(rs.getString("PATH"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        return list;
    }

	public CopyDto getCopyDetail(int copyNo) {
        String query = "SELECT cd.COPY_NO, PATH , COPY_NAME , CONTENT , COPY_ADDR , TEL_NUM FROM COPY_DETAIL cd"
        		+ "     JOIN COPY_PHOTO cp"
        		+ "     ON cd.COPY_NO = cp.COPY_NO"
        		+ "     WHERE cd.COPY_NO = ?";
        CopyDto dto = null;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, copyNo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new CopyDto();
                dto.setCopyName(rs.getString("COPY_NAME"));
                dto.setCopyNo(rs.getInt("COPY_NO"));
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
}



