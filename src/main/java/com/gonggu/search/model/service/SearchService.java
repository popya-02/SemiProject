package com.gonggu.search.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;
import com.gonggu.search.model.dto.SearchDto;

public interface SearchService {

	public int getSearchListCount(String category, String searchText);

	public ArrayList<SearchDto> getSearchList(PageInfo pi, String category, String searchText);


}
