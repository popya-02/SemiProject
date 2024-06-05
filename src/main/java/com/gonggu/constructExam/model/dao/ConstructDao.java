package com.gonggu.constructExam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gonggu.common.DatabaseConnection;
import com.gonggu.common.PageInfo;
import com.gonggu.constructExam.model.dto.ConstructDto;
import com.gonggu.constructExam.model.dto.ConstructDtoImpl;


public class ConstructDao {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;

	public ConstructDao() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}

	public ArrayList<ConstructDtoImpl> getList(String copyNum) {

		ArrayList<ConstructDtoImpl> result = new ArrayList<>();
		String query = "SELECT * FROM CONSTRUCT" + "  WHERE copy_no = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, copyNum);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String constructAddr = rs.getString("CONSTRUCT_ADDR"); // 시공지 주소
				String constructRange = rs.getString("CONSTRUCT_RANGE"); // 시공평수
				String constructPrice = rs.getString("CONSTRUCT_PRICE"); // 시공 가격
				int constructNo = rs.getInt("CONSTRUCT_NO");
				ConstructDtoImpl constructDto = new ConstructDtoImpl();
				constructDto.setConstructAddr(constructAddr);
				constructDto.setConstructRange(constructRange);
				constructDto.setConstructPrice(constructPrice);
				constructDto.setConstructNo(constructNo);

				result.add(constructDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int enroll(ConstructDtoImpl constructDto) {
		String query = "INSERT INTO CONST_EXAM VALUES(exam_seq.nextval, ?, ?, ?, ?)";
		int result = 0;

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, constructDto.getConstructList());
			pstmt.setInt(2, constructDto.getCategoryNo());
			pstmt.setString(3, constructDto.getTitle());
			pstmt.setString(4, constructDto.getContent());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<ConstructDto> getConstructList(PageInfo pi) {
		String query = "SELECT copy_name, ce.title, ce.exam_no, ep.path FROM COPY_USER cu"
				+ "     FULL JOIN CONSTRUCT c ON cu.COPY_NO = c.COPY_NO"
				+ "     FULL JOIN CONST_EXAM ce ON c.CONSTRUCT_NO = ce.CONSTRUCT_NO"
				+ "     FULL JOIN EXAM_PICTURE ep ON ce.EXAM_NO = ep.EXAM_NO";

		List<ConstructDto> list = new ArrayList<>();

		try {

			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ConstructDto dto = new ConstructDto();
				dto.setCopyName(rs.getString("COPY_NAME"));
				dto.setTitle(rs.getString("title"));
				dto.setExamNo(rs.getInt("exam_no"));
				dto.setFilePath(rs.getString("PATH"));
				list.add(dto);
				System.out.println(dto.getCopyName());
				System.out.println(dto.getFilePath());
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	public int getListCount() {

		String query = "SELECT COUNT(ce.EXAM_NO) AS CNT" + " FROM CONST_EXAM ce" + " FULL JOIN EXAM_PICTURE ep"
				+ " 	ON ce.EXAM_NO = ep.EXAM_NO";

		try {
			pstmt = con.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int result = rs.getInt("CNT");

				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public ConstructDtoImpl getDetail(int examNo) {
String query = "select * from construct c"
            +"  full join const_exam ce"
		    +"  on c.construct_no = ce.construct_no"
            +"  full join exam_picture ep"
		    +"  on ce.exam_no = ep.exam_no"
            +"  full join copy_user cu"
		    +"  on cu.copy_no = c.copy_no"
            +"  full join copy_photo cp"
		    +"  on cp.copy_no = c.copy_no"
            +"  where ce.exam_no = ?";
ConstructDtoImpl detail = new ConstructDtoImpl();

try {
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1, examNo);
	ResultSet rs = pstmt.executeQuery();
	System.out.println("a : " + examNo);
	
	
	while(rs.next()) {
		ConstructDtoImpl dto = new ConstructDtoImpl();
		dto.setConstructStartDate(rs.getString("CONSTRUCT_START_DATE"));
		dto.setConstructEndDate(rs.getString("CONSTRUCT_END_DATE"));
		dto.setConstructAddr(rs.getString("CONSTRUCT_ADDR"));
		dto.setConstructRange(rs.getString("CONSTRUCT_RANGE"));
		dto.setConstructPrice(rs.getString("CONSTRUCT_PRICE"));
		dto.setCopyName(rs.getString("COPY_NAME"));
		dto.setCategoryNo(rs.getInt("CATEGORY_NO"));
		dto.setContent(rs.getString("content"));
		dto.setFilePath(rs.getString("PATH"));
//		dto.setFilePath("PATH");
		return dto;
		
	}
} catch (SQLException e) {
	e.printStackTrace();
}

		return null;
	}
}
