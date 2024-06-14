package com.gonggu.chatting.model.service;

import java.util.ArrayList;
import java.util.List;

import com.gonggu.chatting.model.dto.ChattingDTO;
import com.gonggu.common.PageInfo;

public interface ChattingService {
	
	public int setChatting(ChattingDTO chattingDto);
	
	public ChattingDTO getUserType(ChattingDTO chattingDto);
	
	public ChattingDTO getCopyType(ChattingDTO chattingDto);
	
	public ChattingDTO setChatnum(ChattingDTO chattingDto);
	
	public int insertMsg(ChattingDTO chattingDto);
	
	public ArrayList<ChattingDTO> getList(int chattingNum);
	
	public int chatLogDelete(int chatNum);

	int getListCount(String copyNum);

	List<ChattingDTO> getCopyChattingList(PageInfo pi, String sessionCopyNum);
	
	public ChattingDTO setEndChatSet(int chatNum);
}
