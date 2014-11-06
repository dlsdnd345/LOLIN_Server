package com.iris.utils;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.iris.entities.Board;
import com.iris.entities.QBoard;
import com.mysema.query.types.expr.BooleanExpression;

@Repository
public class BoardQueryDsl extends QueryDslRepositorySupport {

    public BoardQueryDsl() {
        super(Board.class);
    }

	public List<Board> findAll(String rank , String position , String playTime , int page , int pageSize) {
    	QBoard board = QBoard.board;
    	
    	  BooleanExpression conditions = board.id.isNotNull();
    	
    	if(!rank.equals("")){
    		conditions = conditions
    				.and(board.rank.eq(rank));
    	}
    	if(!position.equals("")){
    		conditions = conditions
    				.and(board.position.eq(position));
    	}
    	if(!playTime.equals("")){
    		conditions = conditions
    				.and(board.playTime.eq(playTime));
    	}
    	
        List<Board> bookList = from(board).where(conditions)
        					   .offset((page-1)*pageSize)
        					   .limit(pageSize)
        					   .orderBy(board.id.desc())
        					   .list(board);

        
        return bookList;
    }
    
    public List<Board> findByName(String title) {
    	QBoard board = QBoard.board;
        List<Board> bookList = from(board).where(board.title.eq(title)).list(board);
        return bookList;
    }

}
