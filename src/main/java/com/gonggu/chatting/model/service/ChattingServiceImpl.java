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
		ChattingDTO duplicete;
		
		duplicete = chattingDao.duplicateCheck(chattingDto);
		
		
		if(duplicete.getEndCheck().equals("Y")) {
			result = chattingDao.setChatting(chattingDto);
		}else {
			result = 1;
		}
		
		return result;
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
	public ChattingDTO setChatnum(ChattingDTO chattingDto) {
		ChattingDTO result = chattingDao.duplicateCheck(chattingDto);
		ChattingDTO userResult = null;
		
		if(result != null) {
			userResult = chattingDao.getUserName(result);
			
			ChattingDTO copyResult = chattingDao.getCopyName(userResult);
			
			return copyResult;
			
		}else {
			return result;
		}
		
	}
	
	@Override
	public int insertMsg(ChattingDTO chattingDto) {
		return chattingDao.insertMsg(chattingDto);
	}
	
	@Override
	public ArrayList<ChattingDTO> getList(int chattingNum) {
		return chattingDao.getList(chattingNum);
	}

	@Override
	public int chatLogDelete(int chatNum) {
//		int result = chattingDao.deleteLog(chatNum);
		
//		if(result == 1) {
//			result = chattingDao.changeChattingState(chatNum);
//		}
		int result = chattingDao.changeChattingState(chatNum);
		
		return result;
	}


}