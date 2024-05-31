package com.gonggu.mypage.model.service;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;

public interface MyPageService {

	int setEdit(MyPageDtoImpl myDto);

	public MyPageDtoImpl getEditForm(String userNo);

	public MyPageDtoImpl getMypageEstimate(int userNo);

	public MyPageDtoImpl getMyCopyEstimate(String copyNo);

	public int setCopyEdit(MyPageDtoImpl myDto);

}
