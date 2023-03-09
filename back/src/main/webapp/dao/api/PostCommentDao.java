package main.webapp.dao.api;

import main.webapp.domain.post.Post;
import main.webapp.domain.post.PostComment;
import main.webapp.exception.dao.PostCommentDaoException;

import java.util.List;

public interface PostCommentDao {
    void addComment(PostComment comment) throws PostCommentDaoException;
    List<PostComment> getCommentsByPost(Post post) throws PostCommentDaoException;
}
