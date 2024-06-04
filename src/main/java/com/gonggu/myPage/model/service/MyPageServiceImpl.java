package com.gonggu.myPage.model.service;

import com.gonggu.myPage.model.dao.MyPageDao;
import com.gonggu.myPage.model.dto.MyPageDtoImpl;

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
	public MyPageDtoImpl getEditForm(String userNo) {
		MyPageDtoImpl result = myPageDao.getDetail(userNo);
		
		return result;
	}

	@Override
	public MyPageDtoImpl getMypageEstimate(int userNo) {
		MyPageDtoImpl result = myPageDao.getUserMyPage(userNo);
		
		return result;
	}

	@Override
	public MyPageDtoImpl getMyCopyEstimate(String copyNo) {
		MyPageDtoImpl result = myPageDao.getCopyPage(copyNo);
		
		return result;
	}

	@Override
	public int setCopyEdit(MyPageDtoImpl myDto) {
		return myPageDao.setCopyEdit(myDto);
	}

}
