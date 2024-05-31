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
	public ArrayList<InformationDto> getUserList(PageInfo pi, String category, String searchText) {
	
		System.out.println(infoDao);
		return infoDao.getUserList(pi, category, searchText);
	}
	
	@Override
	public ArrayList<InformationDto> getCopyList(PageInfo pi, String category, String searchText) {
		
		System.out.println(infoDao);
		return infoDao.getCopyList(pi, category, searchText);
	}
	
	
	@Override
	public int getUserListCount(String category, String searchText) {
		return infoDao.getUserListCount(category, searchText);
	}
	
	@Override
	public int getCopyListCount(String category, String searchText) {
		return infoDao.getCopyListCount(category, searchText);
	}
	
	@Override
	public ArrayList<InformationDto> copyApproveList(PageInfo pi, String category, String searchText) {
		return infoDao.copyApproveList(pi, category, searchText);
	} 
	@Override
	public int copyApproveListCount(String category, String searchText) {
		return infoDao.copyApproveListCount(category, searchText);
	}
	
	@Override
	public int copyApproveStatus(InformationDto infoDto) {
		
		return infoDao.copyApproveStatus(infoDto);
	}
	
	

}
