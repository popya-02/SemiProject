package com.gonggu.copy.model.service;

import java.util.ArrayList;

import com.gonggu.common.PageInfo;
import com.gonggu.copy.model.dao.CopyDao;
import com.gonggu.copy.model.dto.CopyDto;
import com.gonggu.copy.model.dto.CopyDtoImpl;

public class CopyServiceImpl implements CopyService {
	private CopyDao copyDao;

	public CopyServiceImpl() {
		copyDao = new CopyDao();

	}

	@Override
	public ArrayList<CopyDto> getCompanyList(PageInfo pi) {
		return copyDao.getCompanyList(pi);
	}

	@Override
	public ArrayList<CopyDto> getCopyDetail(String copyNo) {
		return copyDao.getCopyDetail(copyNo);
	}

	@Override
	public int getListCount() {
		return copyDao.getListCount();
	}
	
	@Override
	public int reviewUpload(CopyDtoImpl copyDto) {
		return copyDao.reviewUpload(copyDto);
	};
	
	@Override
	public ArrayList<CopyDto> getReview(String copyNo){
		return copyDao.getReview(copyNo);
	};
}
