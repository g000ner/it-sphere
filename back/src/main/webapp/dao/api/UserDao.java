package main.webapp.dao.api;

import main.webapp.domain.user.User;
import main.webapp.domain.user.UserRole;
import main.webapp.exception.dao.UserDaoException;

import java.util.List;

public interface UserDao {
    void addUser(User user) throws UserDaoException;
    List<User> getUserList() throws UserDaoException;
    User getUserById(Integer id) throws UserDaoException;
    void updateUser(User user) throws UserDaoException;

    void changeUserRole(Integer userId, UserRole newRole) throws UserDaoException;
}
