package com.gonggu.admin.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;



public interface Information {
	
	
	public ArrayList<InformationDto> getList(PageInfo pi, String category, String searchText);
	
	
	public int getListCount(String category, String searchText);
	
	
	
	public ArrayList<InformationDto> copyApproveList(PageInfo pi);
	
	
	
	public int copyApproveStatus(InformationDto infoDto);
	
	
	
}
