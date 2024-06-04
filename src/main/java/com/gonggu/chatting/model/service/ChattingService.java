package com.gonggu.chatting.model.service;

import java.util.ArrayList;

import com.gonggu.chatting.model.dto.ChattingDTO;

public interface ChattingService {
	
	public int setChatting(ChattingDTO chattingDto);
	
	public int submitMsg(ChattingDTO chattingDto);
	
	public ChattingDTO getUserType(ChattingDTO chattingDto);
	
	public ChattingDTO getCopyType(ChattingDTO chattingDto);
	
	public int setChatnum(ChattingDTO chattingDto);
	
	public int insertMsg(ChattingDTO chattingDto);
	
	public ArrayList<ChattingDTO> getList(int chattingNum);
}
