package main.webapp.dao.impl;

import main.webapp.dao.api.ConnectionBuilder;
import main.webapp.dao.api.PostCommentDao;
import main.webapp.domain.post.Post;
import main.webapp.domain.post.PostComment;
import main.webapp.domain.user.User;
import main.webapp.domain.user.UserRole;
import main.webapp.exception.dao.PostCommentDaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostCommentDaoImpl implements PostCommentDao {
    private static final String SELECT_BY_POST = "SELECT comment_id, author_id, created, comment_text, post_id " +
            "FROM its_post_comment WHERE post_id=?";
    private static final String INSERT = "INSERT INTO its_post_comment (author_id, created, comment_text, post_id) " +
            "VALUES ?, ?, ?, ?";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    @Override
    public void addComment(PostComment comment) throws PostCommentDaoException {
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(INSERT);
                statement.setInt(1, comment.getAuthor().getId());
                statement.setDate(2, new java.sql.Date(comment.getCreated().getTime()));
                statement.setString(3, comment.getText());
                statement.setInt(4, comment.getPost().getId());
                statement.executeUpdate();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostCommentDaoException(e);
        }
    }

    @Override
    public List<PostComment> getCommentsByPost(Post post) throws PostCommentDaoException {
        List<PostComment> result = new ArrayList<>();
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_POST);
                statement.setInt(1, post.getId());
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    PostComment comment = new PostComment();
                    comment.setId(resultSet.getInt("comment_id"));

                    User author = new User();
                    author.setRole(UserRole.AUTHOR);
                    author.setId(resultSet.getInt("author_id"));
                    comment.setAuthor(author);
                    comment.setCreated(resultSet.getDate("created"));
                    comment.setText(resultSet.getString("comment_text"));
                    comment.setPost(post);
                    result.add(comment);
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostCommentDaoException(e);
        }
        return result;
    }
}
