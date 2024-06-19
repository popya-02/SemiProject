package com.gonggu.copy.model.service;

import java.util.ArrayList;

import com.gonggu.common.PageInfo;
import com.gonggu.copy.model.dto.CopyDto;
import com.gonggu.copy.model.dto.CopyDtoImpl;


public interface CopyService {
	
	public ArrayList<CopyDto> getCompanyList(PageInfo pi);
	
	public ArrayList<CopyDto> getCopyDetail(String copyNo);
	public ArrayList<CopyDto> getCopyDetailEx(String copyNo);
	public ArrayList<CopyDto> getReview(String copyNo);

	public int getListCount();
	
	public int reviewUpload(CopyDtoImpl copyDto);
	
	public int reviewDelete(int userNum);
	
	
}
