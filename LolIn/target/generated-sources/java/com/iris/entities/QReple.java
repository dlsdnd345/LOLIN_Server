package com.iris.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QReple is a Querydsl query type for Reple
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QReple extends EntityPathBase<Reple> {

    private static final long serialVersionUID = 801085847;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReple reple = new QReple("reple");

    public final QBoard addBoards;

    public final StringPath content = createString("content");

    public final StringPath facebookId = createString("facebookId");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath os = createString("os");

    public final StringPath userName = createString("userName");

    public final DateTimePath<java.util.Date> writeTime = createDateTime("writeTime", java.util.Date.class);

    public QReple(String variable) {
        this(Reple.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QReple(Path<? extends Reple> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QReple(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QReple(PathMetadata<?> metadata, PathInits inits) {
        this(Reple.class, metadata, inits);
    }

    public QReple(Class<? extends Reple> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.addBoards = inits.isInitialized("addBoards") ? new QBoard(forProperty("addBoards"), inits.get("addBoards")) : null;
    }

}

