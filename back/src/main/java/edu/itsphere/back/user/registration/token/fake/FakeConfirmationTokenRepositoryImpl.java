package edu.itsphere.back.user.registration.token.fake;

import edu.itsphere.back.user.User;
import edu.itsphere.back.user.registration.token.ConfirmationToken;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class FakeConfirmationTokenRepositoryImpl implements FakeConfirmationTokenRepository<ConfirmationToken, Long>{
    private List<ConfirmationToken> data= new ArrayList<>();
    private Long idSequence = 1L;

    @Override
    public void save(ConfirmationToken token) {
        token.setId(idSequence++);
        this.data.add(token);
    }

    @Override
    public Optional<ConfirmationToken> findByToken(String token) {
        Optional<ConfirmationToken> confirmationTokenOptional = this.data.stream().
                filter((item) -> Objects.equals(item.getToken(), token)).findFirst();
        return confirmationTokenOptional;
    }

    @Override
    public void updateConfirmedAt(String token, LocalDateTime confirmedAt) {
        ConfirmationToken confirmationToken = this.findByToken(token).get();
        confirmationToken.setConfirmedAt(confirmedAt);
    }
}
