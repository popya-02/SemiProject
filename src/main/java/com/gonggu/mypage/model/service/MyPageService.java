package com.gonggu.mypage.model.service;

import com.gonggu.mypage.model.dto.MyPageDto;
import java.util.ArrayList;

import com.gonggu.common.PageInfo;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;

public interface MyPageService {

	public int setUserEdit(MyPageDtoImpl myDto);

	public MyPageDtoImpl getUserDetail(int userNo);

	public int setCopyEdit(MyPageDtoImpl myDto);
	
	public MyPageDtoImpl getCopyDetail(String copyNo);

	public int pictureUpload(MyPageDtoImpl myDto);
	
	public void getPictureName(MyPageDtoImpl result);
	
	public int setDelete(String copyNo);
	
	
	public MyPageDto reserveCheck(int constructNum);

	public ArrayList<MyPageDtoImpl> getLikeList(PageInfo pi, MyPageDtoImpl myDto);

	public int getLikeListCount(MyPageDtoImpl myDto);

	public ArrayList<MyPageDtoImpl> getUserEstimateList(PageInfo pi, MyPageDtoImpl myDto);

	public int getUserEstimateListCount(MyPageDtoImpl myDto);

	public ArrayList<MyPageDtoImpl> getCopyEstimateList(PageInfo pi, MyPageDtoImpl myDto);

	public int getCopyEstimateListCount(MyPageDtoImpl myDto);

}
