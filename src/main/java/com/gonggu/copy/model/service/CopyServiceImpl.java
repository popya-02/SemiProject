package com.gonggu.copy.model.service;

import java.util.List;

import com.gonggu.copy.model.dao.CopyDao;
import com.gonggu.copy.model.dto.CopyDto;


public class CopyServiceImpl implements CopyService{
	 private CopyDao copyDao = new CopyDao();
	
	 @Override
	    public List<CopyDto> getCompanyList() {
	        return copyDao.getCompanyList();
	    }
}
