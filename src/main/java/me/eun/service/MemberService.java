package me.eun.service;

import java.util.List;

import me.eun.model.Member;

public interface MemberService {
	List<Member> getList();
	
	Member findById(Long id);
	void insert (Member member);
	void update(Member member);
	void delete (Long id);		
	
}
