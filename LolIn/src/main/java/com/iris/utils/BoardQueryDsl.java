package com.iris.utils;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.iris.entities.Board;
import com.iris.entities.QBoard;

@Repository
public class BoardQueryDsl extends QueryDslRepositorySupport {

    public BoardQueryDsl() {
        super(Board.class);
    }

    public List<Board> findByName(String title) {
    	QBoard board = QBoard.board;
        List<Board> bookList = from(board).where(board.title.eq(title)).list(board);
        return bookList;
    }

}
