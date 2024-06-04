package com.gonggu.admin.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;



public interface Information {
	
	
	public ArrayList<InformationDto> getUserList(PageInfo pi, String category, String searchText);
	
	public ArrayList<InformationDto> getCopyList(PageInfo pi, String category, String searchText);
	
	
	public int getUserListCount(String category, String searchText);
	public int getCopyListCount(String category, String searchText);
	
	
	
	public ArrayList<InformationDto> copyApproveList(PageInfo pi);
	
	public int copyApproveListCount();
	
	
	public int updateCopyApproveStatus(InformationDto infoDto);
	
	public int saveCopyStatus(String copyNo, String approve); 
	
	public String getUserApprovalStatus(String copyNo);
	
	
	
}
