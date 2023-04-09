package edu.itsphere.back.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.login=?1")
    Optional<User> findByLogin(String login);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.enabled=?1 WHERE u.login=?2")
    void updateEnabled(boolean enabled, String login);
}
