package com.iris.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.iris.dao.RepleDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
@Transactional
@WebAppConfiguration
public class GCMControllerTest {

	 private MockMvc mockMvc;

	    @Autowired
	    WebApplicationContext context;
	    
	    @Autowired
	    RepleDao repleDao;

	    @Before
	    public void setUp() {
	        mockMvc = webAppContextSetup(context).build();
	    }
	    
	    @Test
	    public void sendPush() throws Exception {

	        MockHttpSession session = new MockHttpSession();

	        mockMvc.perform(get("/gcm/sendReple")
	        		.param("os", "android")
	        		.param("regId", "APA91bEo4wLfiybUbYbFoELKzDwhx6A_QdCeJXsoT7FdCyLpaT4GdwZ12dVoHn3GVRj4nzAKjtpej1Cj1JFeseqd77IvAjKhny1Bv-OnsiT5PACOgnip0iIUQ2bzwQEAi16GvqMP1qRKDgY-ibIqaRBJ8v6S0tO6cQ")
	        		.param("reple", "제발 가라 제발@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
	        		.session(session)).andExpect(status().isOk())
	                .andDo(print())
	                .andReturn();
	    }
}
