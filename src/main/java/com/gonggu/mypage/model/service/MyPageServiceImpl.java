package com.gonggu.mypage.model.service;

import com.gonggu.mypage.model.dao.MyPageDao;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;

public class MyPageServiceImpl implements MyPageService {
	MyPageDao myPageDao;
	
	public MyPageServiceImpl() {
		myPageDao = new MyPageDao();
	}

	@Override
	public int setUserEdit(MyPageDtoImpl myDto) {
		return myPageDao.setUserEdit(myDto);
	}
	
	@Override
	public MyPageDtoImpl getUserDetail(int userNo) {
		MyPageDtoImpl result = myPageDao.getUserDetail(userNo);
		
		return result;
	}

	@Override
	public MyPageDtoImpl getUserEstimate(int userNo) {
		MyPageDtoImpl result = myPageDao.getUserEstimate(userNo);
		
		return result;
	}

	@Override
	public MyPageDtoImpl getCopyEstimate(String copyNo) {
		MyPageDtoImpl result = myPageDao.getCopyEstimate(copyNo);
		
		return result;
	}

	@Override
	public int setCopyEdit(MyPageDtoImpl myDto) {
		return myPageDao.setCopyEdit(myDto);
	}

	@Override
	public MyPageDtoImpl getCopyDetail(String copyNo) {
		MyPageDtoImpl result = myPageDao.getCopyDetail(copyNo);
		
		return result;
		
	}

	@Override
	public int pictureUpload(MyPageDtoImpl myDto) {
		return myPageDao.pictureUpload(myDto);
	}

	@Override
	public void getPictureName(MyPageDtoImpl result) {
		myPageDao.getPictureName(result);
	}

	@Override
	public int setDelete(String copyNo) {
		return myPageDao.setDelete(copyNo);
	}
	
	@Override
	public int reserveCheck(int userNo) {
		return myPageDao.reserveCheck(userNo);
	}

}
