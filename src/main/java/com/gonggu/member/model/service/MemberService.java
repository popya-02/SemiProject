package com.gonggu.member.model.service;

import com.gonggu.member.model.dto.MemberDTO;

public interface MemberService {
	
	public int idCheck(String userId);

	public int signupUser(MemberDTO memberDto);
	
	public MemberDTO getHashPwd(String id);
	
	public int copyIdCheck(String copyId);
	
	public int signupCopy(MemberDTO memberDto);
	
	public MemberDTO getHashPwdAdmin(String adminId);
}
