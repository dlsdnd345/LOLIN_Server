package com.iris.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAdmin is a Querydsl query type for Admin
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAdmin extends EntityPathBase<Admin> {

    private static final long serialVersionUID = 785353232;

    public static final QAdmin admin = new QAdmin("admin");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath password = createString("password");

    public final StringPath userId = createString("userId");

    public QAdmin(String variable) {
        super(Admin.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QAdmin(Path<? extends Admin> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QAdmin(PathMetadata<?> metadata) {
        super(Admin.class, metadata);
    }

}

