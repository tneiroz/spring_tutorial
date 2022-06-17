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

	@Override
	public Member findById(Long id) {
		return mapper.get(id);
	}

	@Override
	public void insert(Member member) {
		mapper.insert(member);
			}

	@Override
	public void update(Member member) {
		mapper.update(member);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

}
