package com.gonggu.mypage.model.service;

import com.gonggu.mypage.model.dao.MyPageDao;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;

public class MyPageServiceImpl implements MyPageService {
	MyPageDao myPageDao;
	
	public MyPageServiceImpl() {
		myPageDao = new MyPageDao();
	}

	public int setEdit(MyPageDtoImpl myDto) {
		return myPageDao.setEdit(myDto);
	}

}
