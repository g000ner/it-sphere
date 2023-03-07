package main.webapp.dao.api;

import main.webapp.domain.post.Post;
import main.webapp.domain.post.PostStatus;
import main.webapp.domain.user.User;
import main.webapp.exception.dao.PostDaoException;

import java.util.List;

public interface PostDao {
    List<Post> getPostList() throws PostDaoException;
    Post getPostById(Integer id) throws PostDaoException;
    List<Post> getPostListByUser(User user) throws PostDaoException;
    void addPost(Post post) throws PostDaoException;
    void changePostStatus(Integer postId, PostStatus newStatus) throws PostDaoException;
}
