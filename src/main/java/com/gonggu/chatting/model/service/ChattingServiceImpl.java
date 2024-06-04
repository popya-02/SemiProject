package com.gonggu.chatting.model.service;

import java.util.ArrayList;

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

	@Override
	public ChattingDTO getUserType(ChattingDTO chattingDto) {
		return chattingDao.getUserType(chattingDto);
		
	}
	
	@Override
	public ChattingDTO getCopyType(ChattingDTO chattingDto) {
		return chattingDao.getCopyType(chattingDto);
	}

	@Override
	public int setChatnum(ChattingDTO chattingDto) {
		return chattingDao.duplicateCheck(chattingDto);
	}
	
	@Override
	public int insertMsg(ChattingDTO chattingDto) {
		return chattingDao.insertMsg(chattingDto);
	}
	
	@Override
	public ArrayList<ChattingDTO> getList(int chattingNum) {
		return chattingDao.getList(chattingNum);
	}


}
