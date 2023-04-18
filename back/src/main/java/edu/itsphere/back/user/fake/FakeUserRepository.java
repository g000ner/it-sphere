package edu.itsphere.back.user.fake;

import edu.itsphere.back.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FakeUserRepository<EntityClass, IdClass> {
    List<User> findAll();
    Optional<EntityClass> findByLogin(String login);
    void save(User user);
    Optional<EntityClass> findById(IdClass id);
    void update(User user);
    void updateEnabled(boolean enabled, String login);
}
