package com.iris.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class RepleServiceImplTest {

	@Autowired
	RepleService repleService;
	
	@Test
	public void findAll() {
		repleService.findAll();
	}
}
