package com.gonggu.copy.model.service;

import java.util.ArrayList;

import com.gonggu.common.PageInfo;
import com.gonggu.copy.model.dto.CopyDto;


public interface CopyService {
	
	public ArrayList<CopyDto> getCompanyList(PageInfo pi);
	
	public CopyDto getCopyDetail(String copyNo);

	public int getListCount();
}
