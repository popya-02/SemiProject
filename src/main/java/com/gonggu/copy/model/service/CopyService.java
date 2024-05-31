package com.gonggu.copy.model.service;

import java.util.List;

import com.gonggu.common.PageInfo;
import com.gonggu.copy.model.dto.CopyDto;


public interface CopyService {
	
	public List<CopyDto> getCompanyList(PageInfo pi);
	
	public CopyDto getCopyDetail(String copyNo);

	public int getListCount();
}
