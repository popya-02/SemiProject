package com.gonggu.mypage.model.service;

import com.gonggu.mypage.model.dao.MyPageDao;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;

public class MyPageServiceImpl implements MyPageService {
	MyPageDao myPageDao;
	
	public MyPageServiceImpl() {
		myPageDao = new MyPageDao();
	}

	@Override
	public int setEdit(MyPageDtoImpl myDto) {
		return myPageDao.setEdit(myDto);
	}
	
	@Override
	public MyPageDtoImpl getEditForm(int userNo) {
		MyPageDtoImpl result = myPageDao.getDetail(userNo);
		
		return result;
	}

}
