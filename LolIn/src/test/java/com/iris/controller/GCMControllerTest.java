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

import com.iris.config.Config;
import com.iris.dao.RepleDao;
import com.iris.utils.SignatureUtil;

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

	        String os = "android";
	        String boardId = "37";
	        String summernerName = "dlsdnd345";
	        String facebookId = "611386895643416";
	        String reple = "dlsdnd345 친추 하고 연락 주세요.";
	        
	        String hash = SignatureUtil.getHash(os+ boardId + summernerName + facebookId + reple + Config.KEY.SECRET);
	        
	        mockMvc.perform(get("/gcm/sendReple")
	        		.param("os", os)
	        		.param("boardId", boardId)
	        		.param("summernerName", summernerName)
	        		.param("reple", reple)
	        		.param("facebookId", facebookId)
	        		.param("hash", hash)
	        		.session(session)).andExpect(status().isOk())
	                .andDo(print())
	                .andReturn();
	    }
}
