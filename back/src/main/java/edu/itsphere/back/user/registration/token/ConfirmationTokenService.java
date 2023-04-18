package edu.itsphere.back.user.registration.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenService {
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
//    private FakeConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        this.confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getConfirmationToken(String token) {
        return this.confirmationTokenRepository.findByToken(token);
    }

    public void setConfirmedAt(String token) {
        this.confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
