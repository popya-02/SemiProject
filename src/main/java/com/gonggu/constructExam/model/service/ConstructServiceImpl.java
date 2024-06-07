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
	public List<ConstructDto> getConstructList(PageInfo pi){
		return constructDao.getConstructList(pi);
	};
	
	@Override
	public int getListCount() {
		return constructDao.getListCount();
	};
	
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
