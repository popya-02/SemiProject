package com.gonggu.mypage.model.service;

import java.util.ArrayList;

import com.gonggu.common.PageInfo;
import com.gonggu.mypage.model.dao.MyPageDao;
import com.gonggu.mypage.model.dto.MyPageDto;
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
	public MyPageDto reserveCheck(int constructNum) {
		return myPageDao.reserveCheck(constructNum);
	}
	
	@Override
	public ArrayList<MyPageDtoImpl> getLikeList(PageInfo pi, MyPageDtoImpl myDto) {
		return myPageDao.getLikeList(pi, myDto);
	}

	@Override
	public int getLikeListCount(MyPageDtoImpl myDto) {
		return myPageDao.getLikeListCount(myDto);
	}
	
	@Override
	public ArrayList<MyPageDtoImpl> getUserEstimateList(PageInfo pi, MyPageDtoImpl myDto) {
		return myPageDao.getUserEstimateList(pi, myDto);
	}

	@Override
	public int getUserEstimateListCount(MyPageDtoImpl myDto) {
		return myPageDao.getUserEstimateListCount(myDto);
	}

	@Override
	public ArrayList<MyPageDtoImpl> getCopyEstimateList(PageInfo pi, MyPageDtoImpl myDto) {
		return myPageDao.getCopyEstimateList(pi, myDto);
	}
	
	@Override
	public int getCopyEstimateListCount(MyPageDtoImpl myDto) {
		return myPageDao.getCopyEstimateListCount(myDto);
	}



>>>>>>> branch 'master' of https://github.com/popya-02/SemiProject.git

}
