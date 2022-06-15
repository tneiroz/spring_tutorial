package me.eun.mapper;

import java.util.List;

import me.eun.model.Member;

public interface MemberMapper {
	
		List<Member> getList();
		void insert (Member member);
		void update(Member member);
		void delete (Member member);
		
}
