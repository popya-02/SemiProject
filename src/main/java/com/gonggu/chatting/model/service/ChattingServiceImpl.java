package com.gonggu.chatting.model.service;

import com.gonggu.chatting.model.dao.ChattingDAO;
import com.gonggu.chatting.model.dto.ChattingDTO;

public class ChattingServiceImpl implements ChattingService{
	
	private ChattingDAO chattingDao;
	
	public ChattingServiceImpl() {
		chattingDao = new ChattingDAO();
	
	}

	@Override
	public int setChatting(ChattingDTO chattingDto) {
		int result = 0;
		int duplicete = 0;
		
		duplicete = chattingDao.duplicateCheck(chattingDto);
		
		
		if(duplicete == 0) {
			result = chattingDao.setChatting(chattingDto);
		}else {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int submitMsg(ChattingDTO chattingDto) {
		return 0;
	}
	

}
