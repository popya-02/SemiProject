package com.gonggu.mypage.model.service;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;

public interface MyPageService {

	public int setUserEdit(MyPageDtoImpl myDto);

	public MyPageDtoImpl getUserDetail(int userNo);

	public MyPageDtoImpl getUserEstimate(int userNo);

	public MyPageDtoImpl getCopyEstimate(String copyNo);

	public int setCopyEdit(MyPageDtoImpl myDto);
	
	public MyPageDtoImpl getCopyDetail(String copyNo);

	public int pictureUpload(MyPageDtoImpl myDto);
	
	public void getPictureName(MyPageDtoImpl result);
	
	public int setDelete(String copyNo);
	
	
	public int reserveCheck(int userNo);

}
