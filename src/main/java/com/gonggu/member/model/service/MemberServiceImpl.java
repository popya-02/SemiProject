package com.gonggu.member.model.service;

import java.util.Objects;

import com.gonggu.member.model.dao.MemberDAO;
import com.gonggu.member.model.dto.MemberDTO;

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

	@Override
	public int signupUser(MemberDTO memberDto) {
		return memberDao.signupUser(memberDto);
	}

	@Override
	public MemberDTO getHashPwd(String id) {
		MemberDTO result = memberDao.getHashPwdUser(id);
		
		if(Objects.isNull(result)) {
			result = memberDao.getHashPwdCopy(id);
			
			return result;
		}
		
		return result;
	}

	@Override
	public int copyIdCheck(String copyId) {
		return memberDao.copyIdCheck(copyId);
	}

	@Override
	public int signupCopy(MemberDTO memberDto) {
		int result = 0;
		
		result = memberDao.signupCopy(memberDto);
		
		if(result == 1) {
			result = memberDao.signupCopyDetail(memberDto);
		}else {
			result = 0;
		}
		
		return result;
	}

	

}
