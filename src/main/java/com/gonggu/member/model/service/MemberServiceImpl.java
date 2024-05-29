package com.gonggu.member.model.service;

import com.gonggu.member.model.dao.MemberDAO;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDAO();
	}
	
	@Override
	public int idCheck(String userId) {
		int result = memberDao.idCheck(userId);
		
		return result;
	}


}
