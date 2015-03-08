package com.iris.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUpdateBoard is a Querydsl query type for UpdateBoard
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUpdateBoard extends EntityPathBase<UpdateBoard> {

    private static final long serialVersionUID = -1890153058;

    public static final QUpdateBoard updateBoard = new QUpdateBoard("updateBoard");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath message = createString("message");

    public final StringPath open = createString("open");

    public final StringPath url = createString("url");

    public final StringPath version = createString("version");

    public QUpdateBoard(String variable) {
        super(UpdateBoard.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QUpdateBoard(Path<? extends UpdateBoard> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QUpdateBoard(PathMetadata<?> metadata) {
        super(UpdateBoard.class, metadata);
    }

}

