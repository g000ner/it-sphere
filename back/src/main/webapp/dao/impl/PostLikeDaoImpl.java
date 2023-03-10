package main.webapp.dao.impl;

import main.webapp.dao.api.ConnectionBuilder;
import main.webapp.dao.api.PostLikeDao;
import main.webapp.domain.post.Post;
import main.webapp.domain.post.PostComment;
import main.webapp.domain.post.PostLike;
import main.webapp.domain.user.User;
import main.webapp.exception.dao.PostLikeDaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostLikeDaoImpl implements PostLikeDao {
    private static final String SELECT_BY_POST = "SELECT like_id, author_id, post_id FROM its_post_like WHERE post_id=?";
    private static final String INSERT = "INSERT INTO its_post_like (author_id, post_id) VALUES ?, ?";
    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    @Override
    public void addLike(PostLike like) throws PostLikeDaoException {
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(INSERT);
                statement.setInt(1, like.getAuthor().getId());
                statement.setInt(2, like.getPost().getId());
                statement.executeUpdate();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostLikeDaoException(e);
        }
    }

    @Override
    public List<PostLike> getCommentsByPost(Post post) throws PostLikeDaoException {
        List<PostLike> result = new ArrayList<>();
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_POST);
                statement.setInt(1, post.getId());
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    PostLike like = new PostLike();
                    like.setPost(post);
                    like.setId(resultSet.getInt("like_id"));
                    User author = new User();
                    author.setId(resultSet.getInt("author_id"));
                    like.setAuthor(author);
                    result.add(like);
                }
                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostLikeDaoException(e);
        }
        return result;
    }
}
