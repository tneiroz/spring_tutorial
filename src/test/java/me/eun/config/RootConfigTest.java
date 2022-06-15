package me.eun.config;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;


import me.eun.Test.AppTest;
import me.eun.mapper.MemberMapper;


public class RootConfigTest extends AppTest{

	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void dataSourceTest() {
		assertNotNull(dataSource);
	
	}

}
