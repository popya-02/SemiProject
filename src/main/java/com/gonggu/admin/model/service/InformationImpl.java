package com.gonggu.admin.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dao.InformationDao;
import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;

public class InformationImpl implements Information {
	
	
	InformationDao infoDao ;
	
	public InformationImpl() {
		infoDao = new InformationDao();
	}
	
	
	@Override
	public ArrayList<InformationDto> getList(PageInfo pi, String category, String searchText) {
	
		System.out.println(infoDao);
		return infoDao.getUserList(pi, category, searchText);
	}
	
	
	@Override
	public int getListCount(String category, String searchText) {
		return infoDao.getListCount(category, searchText);
	}
	
	@Override
	public ArrayList<InformationDto> copyApproveList(PageInfo pi) {
		return infoDao.copyApproveList(pi);
	} 
	
	@Override
	public int copyApproveStatus(InformationDto infoDto) {
		
		return infoDao.copyApproveStatus(infoDto);
	}
	
	

}
