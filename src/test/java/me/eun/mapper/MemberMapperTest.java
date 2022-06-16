package me.eun.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.eun.Test.AppTest;
import me.eun.model.Member;

public class MemberMapperTest extends AppTest {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void setUp() throws IOException, SQLException {
		Reader reader = Resources.getResourceAsReader("sql/sql_0615.sql");
		ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
		runner.runScript(reader);
	}
	
	@Test
	@Ignore
	public void getListTest() {
		List<Member> list = memberMapper.getList();
		assertEquals(4, list.size());
	}
	@Ignore
	@Test
	public void insertTest() {
		Member member = new Member();
		member.setUserName("이름테스트");
		member.setEmail("이메일테스트");
		member.setPassword("비밀번호테스트");
		memberMapper.insert(member);
		Member getMember = memberMapper.get(5L);
		assertEquals(member.getUserName(),getMember.getUserName());
		assertEquals(member.getEmail(), getMember.getEmail());
		assertEquals(member.getPassword(),getMember.getPassword());
		
	}
	@Ignore
	@Test
	public void updateTest () {
		Member member = memberMapper.get(1L);
		member.setUserName("조진현");	
		member.setEmail("진현@example.com");
		memberMapper.update(member);
		assertEquals("조진현",member.getUserName());
		assertEquals("진현@example.com",member.getEmail());
		
	}
	
	@Test
	public void deleteTest() {
		memberMapper.delete(1L);
		Member member1 = memberMapper.get(1L);
		Member member2 = memberMapper.get(2L);
		assertNull(member1);
		assertNotNull(member2);
		
	}
}


