package com.gonggu.admin.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dao.InformationDao;
import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;

public class InformationImpl implements Information {
	
	
	InformationDao infoDao;
	
	
	@Override
	public ArrayList<InformationDto> getList(PageInfo pi, String category, String searchText) {
	
		return infoDao.getUserList(pi, category, searchText);
	}

}
