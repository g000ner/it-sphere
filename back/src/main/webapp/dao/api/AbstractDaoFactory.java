package main.webapp.dao.api;

import main.webapp.dao.impl.PostCommentDaoImpl;
import main.webapp.dao.impl.PostDaoImpl;
import main.webapp.dao.impl.PostLikeDaoImpl;
import main.webapp.dao.impl.UserDaoImpl;

public interface AbstractDaoFactory {
    UserDao getUserDao();
    PostDao getPostDao();
    PostCommentDao getPostCommentDao();
    PostLikeDao getPostLikeDao();
}
