package com.gonggu.mypage.model.service;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;

public interface MyPageService {

	int setEdit(MyPageDtoImpl myDto);

	public MyPageDtoImpl getEditForm(int userNo);

}
