package com.gonggu.constructExam.model.service;

import java.util.ArrayList;
import java.util.List;

import com.gonggu.common.PageInfo;
import com.gonggu.constructExam.model.dto.ConstructDto;
import com.gonggu.constructExam.model.dto.ConstructDtoImpl;

public interface ConstructService {
	
	public ArrayList<ConstructDtoImpl> getList(String copyNum);

	public int enroll(ConstructDtoImpl ConstructDto);
	
	public List<ConstructDto> getConstructList(PageInfo pi);
	public int getListCount();
	
	public ConstructDtoImpl getDeteil(int examNo);

	public int listDelete(int examNo);
	
	public int fileDelete(int fileNo);
	
	public int setEdit(ConstructDtoImpl constructDto);
	
	public int fileUpload(ConstructDtoImpl constructDto);
	
	public int fileEdit(ConstructDtoImpl constructDto);
	
	public int getExamNo(ConstructDtoImpl constructDto);
	
	public int selectLike(ConstructDtoImpl constructDto);
	public void insertLike(ConstructDtoImpl constructDto);
	public void deleteLike(ConstructDtoImpl constructDto);
	
	public ArrayList<ConstructDtoImpl> getLike(ConstructDtoImpl constructDto);

//	public ConstructDtoImpl selectNo(ConstructDtoImpl ConstructDto);
//	public int fileUpload(ConstructDtoImpl ConstructDto);
//	public void getFileName(ConstructDtoImpl result);
	
	
}
