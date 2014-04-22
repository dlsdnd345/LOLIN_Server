package com.iris.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 786593191;

    public static final QBoard board = new QBoard("board");

    public final ListPath<Reple, QReple> addReple = this.<Reple, QReple>createList("addReple", Reple.class, QReple.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.util.Date> playTime = createDateTime("playTime", java.util.Date.class);

    public final StringPath position = createString("position");

    public final StringPath rank = createString("rank");

    public final StringPath summonerName = createString("summonerName");

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> writeTime = createDateTime("writeTime", java.util.Date.class);

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QBoard(Path<? extends Board> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata<?> metadata) {
        super(Board.class, metadata);
    }

}

