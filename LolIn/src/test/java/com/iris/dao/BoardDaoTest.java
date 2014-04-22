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

    @Test
    public void selectAll() {
    	List<Board> boardList = boardDao.findAll();
    	
    	for (Board board : boardList) {
			
    		System.err.println("@@@@@@@@@@@   :  " + board);
		}
    	
    }
    
    @Test
    public void save(){
    	
    	Board board = new Board();
    	board.setTitle("실버 서폿 구합니다 .");
    	board.setContent("블랭 , 말파 등 3종류 캐릭 할줄 아시는 분 구합니다.");
    	board.setRank("실버");
    	board.setSummonerName("dlsdnd345");
    	board.setWriteTime(new Date());
    	board.setPlayTime(new Date());
    	board.setPosition("서폿");
    	
    	boardDao.save(board);
    }

    @Test
    public void findByName() {
        List<Board> boardList = bookQueryDsl.findByName("실버 서폿 구합니다 .");
        
        assertThat(boardList.get(0).getTitle(), is("실버 서폿 구합니다 ."));
        
    }
}
