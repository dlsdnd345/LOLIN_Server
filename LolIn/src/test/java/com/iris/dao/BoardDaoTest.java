package com.iris.dao;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.iris.entities.Board;
import com.iris.entities.User;
import com.iris.utils.BoardQueryDsl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
//@ContextConfiguration(classes=BookConfiguration.class)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class BoardDaoTest {

    @Autowired
    BoardDao boardDao;
    @Autowired
    BoardQueryDsl bookQueryDsl;
    @Autowired
    UserDao userDao;

    @Test
    public void selectAll() {
    	List<Board> boardList = boardDao.findAll();
    	
    	for (Board board : boardList) {
    		System.err.println("@@@@@@@@@@@   :  " + board);
		}
    	
    }
    
    @Test
    public void save(){
    	
    	List<User> userList = userDao.findAll();
    	
    	Board board = new Board();
    	board.setTitle("언랭이 같이 할 듀오 구합니다.");
    	board.setContent("언랭이지만 실력은 남들 못지 않습니다 . 같이 즐겜 하실 유저분 구합니다.");
    	board.setRank("unrank");
    	board.setWriteTime(new Date());
    	board.setPlayTime("오후");
    	board.setPosition("미드");
    	board.setAddUsers(userList.get(0));
    	
    	boardDao.save(board);
    }

    @Test
    public void findByName() {
        List<Board> boardList = bookQueryDsl.findByName("실버 서폿 구합니다 .");
        assertThat(boardList.get(0).getTitle(), is("실버 서폿 구합니다 ."));
        
    }
}
