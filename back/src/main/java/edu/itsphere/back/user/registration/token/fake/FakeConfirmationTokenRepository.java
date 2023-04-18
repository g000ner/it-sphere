package edu.itsphere.back.user.registration.token.fake;

import edu.itsphere.back.user.registration.token.ConfirmationToken;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface FakeConfirmationTokenRepository<EntityClass, idClass> {
    void save(ConfirmationToken token);
    Optional<EntityClass> findByToken(String token);
    void updateConfirmedAt(String token, LocalDateTime confirmedAt);
}
