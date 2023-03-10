package main.webapp.dao.impl;

import main.webapp.dao.api.ConnectionBuilder;
import main.webapp.dao.api.UserDao;
import main.webapp.domain.user.User;
import main.webapp.domain.user.UserRole;
import main.webapp.exception.dao.UserDaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String SELECT_ONE = "SELECT " +
            "user_id, user_login, user_password, user_role, avatar_url, user_name, about, post_count FROM its_user " +
            "WHERE user_id=?";
    private static final String SELECT_ALL = "SELECT " +
            "user_id, user_login, user_password, user_role, avatar_url, user_name, about, post_count FROM its_user";

    private static final String INSERT = "INSERT INTO its_user " +
            "(user_login, user_password,  user_role, avatar_url, user_name, about, post_count) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_ROLE = "UPDATE its_user SET user_role=? WHERE user_id=?";
    private static final String UPDATE = "UPDATE its_user SET " +
            "user_login=?, user_password=?, user_role=?, avatar_url=?, user_name=?, about=?, post_count=? WHERE user_id=?";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }

    @Override
    public void addUser(User user) throws UserDaoException {
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(INSERT);
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword()); // TODO сделать хеширование паролей
                statement.setString(3, user.getRole().name());
                statement.setString(4, user.getAvatarUrl());
                statement.setString(5, user.getName());
                statement.setString(6, user.getAbout());
                statement.setInt(7, user.getPostCount());
                statement.executeUpdate();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDaoException(e);
        }
    }

    @Override
    public List<User> getUserList() throws UserDaoException {
        List<User> result = new ArrayList<>();
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    User user = new User();

                    user.setId(resultSet.getInt("user_id"));
                    user.setLogin(resultSet.getString("user_login"));
                    user.setPassword(resultSet.getString("user_password"));
                    user.setRole(UserRole.valueOf(resultSet.getString("user_role")));
                    user.setAvatarUrl(resultSet.getString("avatar_url"));
                    user.setName(resultSet.getString("user_name"));
                    user.setAbout(resultSet.getString("about"));
                    user.setPostCount(resultSet.getInt("post_count"));

                    result.add(user);
                }
                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDaoException(e);
        }
        return result;
    }

    @Override
    public User getUserById(Integer id) throws UserDaoException {
        User user = null;
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(SELECT_ONE);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    user.setId(resultSet.getInt("user_id"));
                    user.setLogin(resultSet.getString("user_login"));
                    user.setPassword(resultSet.getString("user_password"));
                    user.setRole(UserRole.valueOf(resultSet.getString("user_role")));
                    user.setAvatarUrl(resultSet.getString("avatar_url"));
                    user.setName(resultSet.getString("user_name"));
                    user.setAbout(resultSet.getString("about"));
                    user.setPostCount(resultSet.getInt("post_count"));
                }
                resultSet.close();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDaoException(e);
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws UserDaoException {
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(UPDATE);
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getRole().name());
                statement.setString(4, user.getAvatarUrl());
                statement.setString(5, user.getName());
                statement.setString(6, user.getAbout());
                statement.setInt(7, user.getPostCount());
                statement.setInt(8, user.getId());
                statement.executeUpdate();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDaoException();
        }
    }

    @Override
    public void changeUserRole(Integer userId, UserRole newRole) throws UserDaoException {
        try {
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement(UPDATE_ROLE);
                statement.setString(1, newRole.name());
                statement.setInt(2, userId);
                statement.executeUpdate();
                statement.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDaoException(e);
        }
    }
}
