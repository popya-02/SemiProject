package com.gonggu.search.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;
import com.gonggu.search.model.dao.SearchDao;
import com.gonggu.search.model.dto.SearchDto;
import com.gonggu.search.model.dto.SearchDtoImpl;

public class SearchServiceImpl implements SearchService{
	SearchDao searchDao;

	public SearchServiceImpl() {
		searchDao = new SearchDao();
	}

	@Override
	public ArrayList<SearchDto> getSearchExamList(String searchText) {
		return searchDao.gerSearchExamList(searchText);
	}

	@Override
	public ArrayList<SearchDto> getSearchCopyList(String searchText) {
		return searchDao.getSearchCopyList(searchText);
	}


}
