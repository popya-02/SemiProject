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

	//시공예시 등록에서 시공내역 리스트뽑기
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
		String query = "INSERT INTO CONST_EXAM VALUES(exam_seq.nextval, ?, ?, ?, ?, default, null, ?)";
		int result = 0;
		
		/* int result = SELECT MAX(EXAM_NO) FROM CONST_EXAM where */

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, constructDto.getConstructList());
			pstmt.setInt(2, constructDto.getCategoryNo());
			pstmt.setString(3, constructDto.getTitle());
			pstmt.setString(4, constructDto.getContent());
			pstmt.setString(5, constructDto.getTagRemoveContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<ConstructDto> getConstructList(PageInfo pi) {
		
		
		List<ConstructDto> list = new ArrayList<>();
		
		String	query = "SELECT ce.DELETE_STATUS,cu.copy_name, ce.title, ce.exam_no, ep.path, ep.name, ep.EXAM_PICTURE_NO, ce.CATEGORY_NO"
					+ "		FROM COPY_USER cu"
					+ "     FULL JOIN CONSTRUCT c ON cu.COPY_NO = c.COPY_NO"
					+ "     FULL JOIN CONST_EXAM ce ON c.CONSTRUCT_NO = ce.CONSTRUCT_NO"
					+ "     FULL JOIN EXAM_PICTURE ep ON ce.EXAM_NO = ep.EXAM_NO"
					+ "     WHERE ce.DELETE_STATUS = 'N'"
					+ "     ORDER BY ce.exam_no DESC"
					+ "		OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
			

			try {

				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, pi.getOffSet());
				pstmt.setInt(2, pi.getBoardLimit());
				ResultSet rs = pstmt.executeQuery();

				rs = pstmt.executeQuery();

				while (rs.next()) {
					ConstructDto dto = new ConstructDto();
					dto.setCopyName(rs.getString("COPY_NAME"));
					dto.setTitle(rs.getString("title"));
					dto.setExamNo(rs.getInt("exam_no"));
					dto.setFilePath(rs.getString("PATH"));
					dto.setFileName(rs.getString("NAME"));
					dto.setFileNo(rs.getInt("EXAM_PICTURE_NO"));
					dto.setCategoryNo(rs.getInt("CATEGORY_NO"));
					dto.setDeleteStatus(query);
					list.add(dto);
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
			

		return list;
	}

	public int getListCount() {

		String query = "SELECT COUNT(ce.EXAM_NO) AS CNT" 
		    + "         FROM CONST_EXAM ce" 
		    + "         FULL JOIN EXAM_PICTURE ep"
			+ "     	ON ce.EXAM_NO = ep.EXAM_NO";

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
		String query = "select ep.NAME as PICTURE_NAME,ce.EXAM_NO,c.CONSTRUCT_START_DATE,c.CONSTRUCT_END_DATE,c.CONSTRUCT_ADDR,c.CONSTRUCT_RANGE,c.CONSTRUCT_PRICE,"
				+ "     cu.COPY_NAME,cg.CATEGORY_NO ,cg.NAME AS category_name,ce.content,ep.PATH,ce.title, cu.COPY_NO"
				+ "     from construct c" 
	            + "     full join const_exam ce"
				+ "     on c.construct_no = ce.construct_no"
	            + "     full join exam_picture ep"
				+ "     on ce.exam_no = ep.exam_no"
	            + "     full join copy_user cu" 
				+ "     on cu.copy_no = c.copy_no"
				+ "     full join copy_photo cp"
				+ "     on cp.copy_no = c.copy_no"
				+ "     full join category cg"
				+ "     on cg.category_no = ce.category_no"
				+ "     where ce.exam_no = ?";
		ConstructDtoImpl detail = new ConstructDtoImpl();

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, examNo);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ConstructDtoImpl dto = new ConstructDtoImpl();
				
				String startDateSub = rs.getString("CONSTRUCT_START_DATE");
				String endDateSub = rs.getString("CONSTRUCT_END_DATE");
				
				String startDate = startDateSub.substring(0, startDateSub.length()-9);
				String endDate = endDateSub.substring(0, endDateSub.length()-9);
				
				dto.setConstructStartDate(startDate);//시작
				dto.setConstructEndDate(endDate);	//마감
				dto.setConstructAddr(rs.getString("CONSTRUCT_ADDR"));
				dto.setConstructRange(rs.getString("CONSTRUCT_RANGE"));
				dto.setConstructPrice(rs.getString("CONSTRUCT_PRICE"));
				dto.setCopyName(rs.getString("COPY_NAME"));
				dto.setCategoryNo(rs.getInt("CATEGORY_NO"));
				dto.setCategory(rs.getString("category_name"));
				dto.setContent(rs.getString("content"));
				dto.setFilePath(rs.getString("PATH"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setExamNo(rs.getInt("EXAM_NO"));
				dto.setFileName(rs.getString("PICTURE_NAME"));
				dto.setCopyNo(rs.getString("COPY_NO"));
				return dto;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public int listDelete(int examNo) {
		String query = "UPDATE CONST_EXAM ce"
				+ "		SET DELETE_DATE = SYSDATE,"
				+ "			DELETE_STATUS = 'Y'"
				+ "		WHERE EXAM_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, examNo);
			
			int result = pstmt.executeUpdate();
//			pstmt.close();
//			con.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public int fileDelete(int fileNo) {
		String query = "DELETE FROM EXAM_PICTURE ep"
				+"      WHERE EXAM_PICTURE_NO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, fileNo);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int setEdit(ConstructDtoImpl constructDto) {
	    String query = "UPDATE CONST_EXAM ce"  
	            +"      SET CATEGORY_NO=?,"
	            +"      TITLE=?,"
	            +"      CONTENT=?"
	            +"      WHERE EXAM_NO=?"; 
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, constructDto.getCategoryNo());
			pstmt.setString(2, constructDto.getTitle());
			pstmt.setString(3, constructDto.getContent());
			pstmt.setInt(4, constructDto.getExamNo());
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	 public int fileUpload(ConstructDtoImpl constructDto) {
	        String query = "INSERT INTO EXAM_PICTURE (EXAM_PICTURE_NO, EXAM_NO, NAME, PATH) VALUES (exam_picture_seq.nextval, ?, ?, ?)";
	        int result = 0;
	        
	        try {
	            pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, constructDto.getExamNo());
	            pstmt.setString(2, constructDto.getFileName());
	            pstmt.setString(3, constructDto.getUploadDirectory());
	            
	            result = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return result;
	    }
	 
	 public int getExamNo(ConstructDtoImpl constructDto) {
		 String query = "SELECT MAX(EXAM_NO) AS MAX FROM CONST_EXAM";
		
		 try {
				pstmt = con.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					int no = rs.getInt("MAX");
					constructDto.setExamNo(no);
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return 0;
		}

	public List<ConstructDto> getCategory() {
		
		String query = "SELECT * FROM CATEGORY";
		
		List<ConstructDto> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ConstructDto conDto = new ConstructDto();
				
				int categoryNum = rs.getInt("CATEGORY_NO");
				String categoryName = rs.getString("NAME");
				
				conDto.setCategoryNo(categoryNum);
				conDto.setCategory(categoryName);
				
				list.add(conDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ConstructDto> getConstructCategoryList(PageInfo pi, int categoryNum) {
		
		List<ConstructDto> list = new ArrayList<>();
		
		String	query = "SELECT ce.DELETE_STATUS,cu.copy_name, ce.title, ce.exam_no, ep.path, ep.name, ep.EXAM_PICTURE_NO, ce.CATEGORY_NO"
				+ "		FROM COPY_USER cu"
				+ "     FULL JOIN CONSTRUCT c ON cu.COPY_NO = c.COPY_NO"
				+ "     FULL JOIN CONST_EXAM ce ON c.CONSTRUCT_NO = ce.CONSTRUCT_NO"
				+ "     FULL JOIN EXAM_PICTURE ep ON ce.EXAM_NO = ep.EXAM_NO"
				+ "		WHERE ce.DELETE_STATUS = 'N'";
			if(categoryNum != 0) {
				query += "	AND CATEGORY_NO = ?";
			}
			query += "     ORDER BY ce.exam_no DESC"
				   + "		OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";

		try {

			pstmt = con.prepareStatement(query);
			
			if(categoryNum != 0) {
				pstmt.setInt(1, categoryNum);
				pstmt.setInt(2, pi.getOffSet());
				pstmt.setInt(3, pi.getBoardLimit());
				
			}else {
				pstmt.setInt(1, pi.getOffSet());
				pstmt.setInt(2, pi.getBoardLimit());

			}
			ResultSet rs = pstmt.executeQuery();

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ConstructDto dto = new ConstructDto();
				dto.setCopyName(rs.getString("COPY_NAME"));
				dto.setTitle(rs.getString("title"));
				dto.setExamNo(rs.getInt("exam_no"));
				dto.setFilePath(rs.getString("PATH"));
				dto.setFileName(rs.getString("NAME"));
				dto.setFileNo(rs.getInt("EXAM_PICTURE_NO"));
				dto.setCategoryNo(rs.getInt("CATEGORY_NO"));
				dto.setDeleteStatus(query);
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		
		return list;
	}

	public int getListCategoryCount(int categoryNum) {
		String query = "SELECT COUNT(ce.EXAM_NO) AS CNT" 
			    + "         FROM CONST_EXAM ce"; 
	    if(categoryNum != 0) {
	    	query += "	AND CATEGORY_NO = ?";
	    }
	    query += "         FULL JOIN EXAM_PICTURE ep"
			   + "     	ON ce.EXAM_NO = ep.EXAM_NO";

		try {
			pstmt = con.prepareStatement(query);
			
			if(categoryNum != 0) {
				pstmt.setInt(1, categoryNum);
			}

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
}
