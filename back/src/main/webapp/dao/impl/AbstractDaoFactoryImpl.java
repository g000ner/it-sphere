package main.webapp.dao.impl;

import main.webapp.dao.api.AbstractDaoFactory;
import main.webapp.dao.api.ConnectionBuilder;
import main.webapp.dao.api.ConnectionBuilderFactory;
import main.webapp.dao.api.UserDao;

public class AbstractDaoFactoryImpl implements AbstractDaoFactory {
    @Override
    public UserDao getUserDao() {
        UserDaoImpl dao = new UserDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }

    @Override
    public PostDaoImpl getPostDao() {
        PostDaoImpl dao = new PostDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }

    @Override
    public PostCommentDaoImpl getPostCommentDao() {
        PostCommentDaoImpl dao = new PostCommentDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }

    @Override
    public PostLikeDaoImpl getPostLikeDao() {
        PostLikeDaoImpl dao = new PostLikeDaoImpl();
        ConnectionBuilder cb = ConnectionBuilderFactory.getConnectionBuilder();
        dao.setConnectionBuilder(cb);
        return dao;
    }
}
