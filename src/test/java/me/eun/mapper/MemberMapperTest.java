package me.eun.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.eun.Test.AppTest;
import me.eun.model.Member;

public class MemberMapperTest extends AppTest {

	@Autowired
	MemberMapper memberMapper;
	
	@Test
	public void getListTest() {
		List<Member> list = memberMapper.getList();
		assertEquals(4, list.size());
	}
}


