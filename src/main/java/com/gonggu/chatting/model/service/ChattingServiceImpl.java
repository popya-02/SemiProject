package com.gonggu.chatting.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.gonggu.chatting.model.dao.ChattingDAO;
import com.gonggu.chatting.model.dto.ChattingDTO;
import com.gonggu.common.PageInfo;

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
		
		if(Objects.isNull(duplicete)) {
			result = chattingDao.setChatting(chattingDto);
			} else {
			if(duplicete.getEndCheck().equals("Y")) {
				result = chattingDao.setChatting(chattingDto);
			}else {
				result = 1;
			}
			
			
		}
		else  {
			if(duplicete.getEndCheck().equals("Y")) {

				result = chattingDao.setChatting(chattingDto);
			}else {
				result = 1;
			}
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

	@Override
	public int getListCount(String copyNum) {
		return chattingDao.getListCount(copyNum);
	}

	@Override
	public List<ChattingDTO> getCopyChattingList(PageInfo pi, String sessionCopyNum) {
		return chattingDao.getCopyChattingList(pi,sessionCopyNum);
	}
	
}
