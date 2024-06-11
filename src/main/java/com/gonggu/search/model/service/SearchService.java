package com.gonggu.search.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;
import com.gonggu.search.model.dto.SearchDto;
import com.gonggu.search.model.dto.SearchDtoImpl;

public interface SearchService {

	public int getConstSearchListCount(String category, String searchText);

	public ArrayList<SearchDtoImpl> getConstSearchList(PageInfo pi, String category, String searchText);

	public int getCopySearchListCount(String category, String searchText);

	public ArrayList<SearchDtoImpl> getCopySearchList(PageInfo pi, String category, String searchText);


}
