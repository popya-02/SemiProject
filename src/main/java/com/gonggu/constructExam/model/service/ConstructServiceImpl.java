package com.gonggu.constructExam.model.service;

import java.util.ArrayList;
import java.util.List;

import com.gonggu.common.PageInfo;
import com.gonggu.constructExam.model.dao.ConstructDao;
import com.gonggu.constructExam.model.dto.ConstructDto;
import com.gonggu.constructExam.model.dto.ConstructDtoImpl;

public class ConstructServiceImpl implements ConstructService {
	ConstructDao constructDao;

	public ConstructServiceImpl() {
		constructDao = new ConstructDao();
	}
	
	@Override
	public ArrayList<ConstructDtoImpl> getList(String copyNum){
		return constructDao.getList(copyNum);
	}
	

	@Override
	public int enroll(ConstructDtoImpl constructDto) {
		return constructDao.enroll(constructDto);
	}
	
	
	@Override

	public ConstructDtoImpl getDeteil(int examNo){
		return constructDao.getDetail(examNo);
	};
	
	@Override
	public int listDelete(int examNo) {
		return constructDao.listDelete(examNo);
	};
	
	@Override
	public int fileDelete(int fileNo) {
		return constructDao.fileDelete(fileNo);
	};
	
	@Override
	public int setEdit(ConstructDtoImpl constructDto) {
		return constructDao.setEdit(constructDto);
	};
	
	@Override
	public int fileUpload(ConstructDtoImpl constructDto) {
	        return constructDao.fileUpload(constructDto);
    }
	 
	@Override
	public int fileEdit(ConstructDtoImpl constructDto) {
		 return constructDao.fileEdit(constructDto);
	}
	 
	@Override
	public int getExamNo(ConstructDtoImpl constructDto) {
		return constructDao.getExamNo(constructDto);
	}
	 
	@Override
	public int selectLike(ConstructDtoImpl constructDto) {
	       return constructDao.selectLike(constructDto);
	}

	@Override
	public List<ConstructDto> getCategory() {
		return constructDao.getCategory();
	}

	 @Override
	public List<ConstructDto> getConstructCategoryList(PageInfo pi, int categoryNum) {
		return constructDao.getConstructCategoryList(pi, categoryNum);
	}

	@Override
	public int getListCategoryCount(int categoryNum) {
		return constructDao.getListCategoryCount(categoryNum);
	}

    @Override
    public void insertLike(ConstructDtoImpl constructDto) {
        constructDao.insertLike(constructDto);
    }

    @Override
    public void deleteLike(ConstructDtoImpl constructDto) {
        constructDao.deleteLike(constructDto);
    }	

   @Override
   public ArrayList<ConstructDtoImpl> getLike(ConstructDtoImpl constructDto) {
	   return constructDao.getLike(constructDto);
   }
	
//	@Override
//	public ConstructDtoImpl selectNo(ConstructDtoImpl constructDto) {
//		return constructDao.selectNo(constructDto);
//	}

//	@Override
//	public int fileUpload(ConstructDtoImpl constructDto) {
//		return constructDao.fileUpload(constructDto);
//	}
//
//	@Override
//	public void getFileName(ConstructDtoImpl result) {
//		ConstructDao.getFileName(result);
//	}


}
