package com.iris.utils;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.iris.entities.Board;
import com.iris.entities.QBoard;
import com.iris.entities.QReple;
import com.iris.entities.Reple;

@Repository
public class RepleQueryDsl extends QueryDslRepositorySupport {

    public RepleQueryDsl() {
        super(Reple.class);
    }

    public List<Reple> findByContent(String content) {
    	QReple reple = QReple.reple;
        List<Reple> repleList = from(reple).where(reple.content.eq(content)).list(reple);
        return repleList;
    }

}
