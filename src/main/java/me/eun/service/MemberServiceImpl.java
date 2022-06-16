package me.eun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.eun.mapper.MemberMapper;
import me.eun.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper; 
	
	@Override
	public List<Member> getList() {
		return mapper.getList();
	}

}
