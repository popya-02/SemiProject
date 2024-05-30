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
        String query = "SELECT COPY_NAME, cd.COPY_NO, NAME, PATH FROM COPY_DETAIL cd"
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


}

