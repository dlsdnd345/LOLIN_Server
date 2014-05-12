package com.iris.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.iris.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
//@ContextConfiguration(classes=BookConfiguration.class)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserDaoTest {

	@Autowired
	UserDao userDao;
	
	@Test
	public void findAll(){
		userDao.findAll();
	}
	
	@Test
	public void save(){
		
		User user = new User();
		user.setFacebookId("149471045");
		user.setWriteTime(new Date());
		userDao.save(user);
	}
	
}
