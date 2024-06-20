package com.gonggu.search.model.service;

import java.util.ArrayList;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.common.PageInfo;
import com.gonggu.search.model.dto.SearchDto;
import com.gonggu.search.model.dto.SearchDtoImpl;

public interface SearchService {

	public ArrayList<SearchDto> getSearchExamList(String searchText);

	public ArrayList<SearchDto> getSearchCopyList(String searchText);
}
