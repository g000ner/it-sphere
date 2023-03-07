package main.webapp.dao.impl;

import main.webapp.dao.api.ConnectionBuilder;
import main.webapp.dao.api.PostDao;
import main.webapp.domain.post.Post;
import main.webapp.domain.post.PostStatus;
import main.webapp.domain.user.User;
import main.webapp.exception.dao.PostDaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements PostDao {
    private static final String SELECT_ONE = "SELECT " +
            "post_id, post_title, post_preview, post_text, author_id, post_status, published, created FROM its_post " +
            "WHERE post_id=?";
    private static final String SELECT_ALL = "SELECT " +
            "post_id, post_title, post_preview, post_text, author_id, post_status, published, created FROM its_post";

    private static final String SELECT_FOR_USER = "SELECT " +
            "post_id, post_title, post_preview, post_text, author_id, post_status, published, created FROM its_post " +
            "WHERE author_id=?";

    private static final String INSERT = "INSERT INTO its_post " +
            "(post_title, post_preview, post_text, author_id, post_status, published, created) " +
            "VALUES ?, ?, ?, ?, ?, ?, ?";

    private static final String UPDATE_STATUS = "UPDATE its_post SET post_status=? WHERE post_id=?";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    @Override
    public List<Post> getPostList() throws PostDaoException {
        List<Post> result = new ArrayList<>();
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Post post = new Post();
                    post.setId(resultSet.getInt("post_id"));
                    post.setTitle(resultSet.getString("post_title"));
                    post.setPreview(resultSet.getString("post_preview"));
                    post.setText(resultSet.getString("post_text"));
                    User author = new User();
                    author.setId(resultSet.getInt("author_id"));
                    post.setAuthor(author);
                    post.setStatus(PostStatus.valueOf(resultSet.getString("post_status")));
                    post.setPublished(resultSet.getDate("published"));
                    post.setCreated(resultSet.getDate("created"));
                    result.add(post);
                }
                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostDaoException(e);
        }
        return result;
    }

    @Override
    public Post getPostById(Integer id) throws PostDaoException {
        Post post = new Post();
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(SELECT_ONE);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    post.setId(resultSet.getInt("post_id"));
                    post.setTitle(resultSet.getString("post_title"));
                    post.setPreview(resultSet.getString("post_preview"));
                    post.setText(resultSet.getString("post_text"));
                    User author = new User();
                    author.setId(resultSet.getInt("author_id"));
                    post.setAuthor(author);
                    post.setStatus(PostStatus.valueOf(resultSet.getString("post_status")));
                    post.setPublished(resultSet.getDate("published"));
                    post.setCreated(resultSet.getDate("created"));
                    statement.close();
                }
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostDaoException(e);
        }
        return post;
    }

    @Override
    public List<Post> getPostListByUser(User user) throws PostDaoException {
        List<Post> result = new ArrayList<>();
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(SELECT_FOR_USER);
                statement.setInt(1, user.getId());
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Post post = new Post();
                    post.setId(resultSet.getInt("post_id"));
                    post.setTitle(resultSet.getString("post_title"));
                    post.setPreview(resultSet.getString("post_preview"));
                    post.setText(resultSet.getString("post_text"));
                    User author = new User();
                    author.setId(resultSet.getInt("author_id"));
                    post.setAuthor(author);
                    post.setStatus(PostStatus.valueOf(resultSet.getString("post_status")));
                    post.setPublished(resultSet.getDate("published"));
                    post.setCreated(resultSet.getDate("created"));
                    result.add(post);
                }
                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostDaoException(e);
        }
        return result;
    }

    @Override
    public void addPost(Post post) throws PostDaoException {
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(INSERT);
                statement.setString(1, post.getTitle());
                statement.setString(2, post.getPreview());
                statement.setString(3, post.getText());
                statement.setInt(4, post.getAuthor().getId());
                statement.setString(5, post.getStatus().name());
                statement.setDate(6, new java.sql.Date(post.getPublished().getTime())); // TODO намудрил с датами, проверить
                statement.setDate(7, new java.sql.Date(post.getCreated().getTime()));  // TODO что работает
                statement.executeUpdate();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostDaoException(e);
        }
    }

    @Override
    public void changePostStatus(Integer postId, PostStatus newStatus) throws PostDaoException {
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS);
                statement.setString(1, newStatus.name());
                statement.setInt(2, postId);
                statement.executeUpdate();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PostDaoException(e);
        }
    }
}
