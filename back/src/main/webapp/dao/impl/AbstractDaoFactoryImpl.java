package main.webapp.dao.impl;

import main.webapp.dao.api.*;

public class AbstractDaoFactoryImpl implements AbstractDaoFactory {
    @Override
    public UserDao getUserDao() {
        UserDaoImpl dao = new UserDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }

    @Override
    public PostDao getPostDao() {
        PostDaoImpl dao = new PostDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }

    @Override
    public PostCommentDao getPostCommentDao() {
        PostCommentDaoImpl dao = new PostCommentDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }

    @Override
    public PostLikeDao getPostLikeDao() {
        PostLikeDaoImpl dao = new PostLikeDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }
}
