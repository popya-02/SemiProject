package com.gonggu.myPage.model.service;

import com.gonggu.myPage.model.dto.MyPageDtoImpl;

public interface MyPageService {
	
	int setEdit(MyPageDtoImpl myDto);

	public MyPageDtoImpl getEditForm(String userNo);

	public MyPageDtoImpl getMypageEstimate(int userNo);

	public MyPageDtoImpl getMyCopyEstimate(String copyNo);

	public int setCopyEdit(MyPageDtoImpl myDto);

}
