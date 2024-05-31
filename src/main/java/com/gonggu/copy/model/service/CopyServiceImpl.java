package com.gonggu.copy.model.service;

import java.util.List;

import com.gonggu.common.PageInfo;
import com.gonggu.copy.model.dao.CopyDao;
import com.gonggu.copy.model.dto.CopyDto;

public class CopyServiceImpl implements CopyService {
	private CopyDao copyDao;

	public CopyServiceImpl() {
		copyDao = new CopyDao();

	}

	@Override
	public List<CopyDto> getCompanyList(PageInfo pi) {
		return copyDao.getCompanyList(pi);
	}

	@Override
	public CopyDto getCopyDetail(String copyNo) {
		return copyDao.getCopyDetail(copyNo);
	}

	@Override
	public int getListCount() {
		return copyDao.getListCount();
	}
}
