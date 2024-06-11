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
	public int getConstSearchListCount(String category, String searchText) {
		return searchDao.getConstSearchListCount(category, searchText);
	}

	@Override
	public ArrayList<SearchDtoImpl> getConstSearchList(PageInfo pi, String category, String searchText) {
		return searchDao.getConstSearchList(pi, category, searchText);
	}

	@Override
	public int getCopySearchListCount(String category, String searchText) {
		return searchDao.getCopySearchListCount(category, searchText);
	}

	@Override
	public ArrayList<SearchDtoImpl> getCopySearchList(PageInfo pi, String category, String searchText) {
		return searchDao.getCopySearchList(pi, category, searchText);
	}

}
