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
import com.iris.entities.Reple;
import com.iris.utils.RepleQueryDsl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
//@ContextConfiguration(classes=BookConfiguration.class)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class RepleDaoTest {

    @Autowired
    RepleDao repleDao;
    @Autowired
    BoardDao boardDao;
    @Autowired
    RepleQueryDsl repleQueryDsl;

    @Test
    public void selectAll() {
    	repleDao.findAll();
    }
    
    @Test
    public void save(){
    	
    	Reple reple = new Reple();
    	reple.setContent("dlsdnd345 친추");
    	
    	Board board = new Board();
    	List<Board> boardList = boardDao.findAll();
    	board.setId(boardList.get(0).getId());
    	
    	reple.setAddBoards(board);
    	reple.setUserName("dlsdnd345");
    	reple.setWriteTime(new Date());
    	
    	repleDao.save(reple);
    }

    
    @Test
    public void findByContent() {
        List<Reple> repleList = repleQueryDsl.findByContent("dlsdnd345 친추");
        assertThat(repleList.get(0).getContent(), is("dlsdnd345 친추"));
        
    }
}
