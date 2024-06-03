package com.gonggu.chatting.model.service;

import com.gonggu.chatting.model.dto.ChattingDTO;

public interface ChattingService {
	
	public int setChatting(ChattingDTO chattingDto);
	
	public int submitMsg(ChattingDTO chattingDto);

}
