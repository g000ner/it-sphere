package main.webapp.dao.api;

import main.webapp.domain.post.Post;
import main.webapp.domain.post.PostComment;
import main.webapp.domain.post.PostLike;
import main.webapp.domain.user.User;
import main.webapp.exception.dao.PostLikeDaoException;

import java.util.List;

public interface PostLikeDao {
    void addLike(PostLike like) throws PostLikeDaoException;
    List<PostLike> getCommentsByPost(Post post) throws PostLikeDaoException;
}
