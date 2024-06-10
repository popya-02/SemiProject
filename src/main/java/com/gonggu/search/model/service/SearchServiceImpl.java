package com.gonggu.search.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;
import com.gonggu.search.model.dao.SearchDao;
import com.gonggu.search.model.dto.SearchDto;

public class SearchServiceImpl implements SearchService{
	SearchDao searchDao;

	public SearchServiceImpl() {
		searchDao = new SearchDao();
	}
	
	@Override
	public int getSearchListCount(String category, String searchText) {
		return searchDao.getSearchListCount(category, searchText);
	}

	@Override
	public ArrayList<SearchDto> getSearchList(PageInfo pi, String category, String searchText) {
		return searchDao.getSearchList(pi, category, searchText);
	}

}
