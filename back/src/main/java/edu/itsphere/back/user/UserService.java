package edu.itsphere.back.user;

import edu.itsphere.back.user.registration.token.ConfirmationToken;
import edu.itsphere.back.user.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private static final String USER_NOT_FOUND_BY_LOGIN_MSG = "user with login %s not found";

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public String registerNewUser(User user) {
        if (this.userRepository.findByLogin(user.getLogin()).isPresent()) {
            throw new IllegalStateException("login taken");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepository.save(user);

            String token = UUID.randomUUID().toString();
            ConfirmationToken confirmationToken = new ConfirmationToken(token,
                    LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), user);

            this.confirmationTokenService.saveConfirmationToken(confirmationToken);
            return token;
        }
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }

    @Transactional
    public void updateUser(Long id, String newLogin, String newPassword,
                           UserRole newRole, String newAvatarUrl, String newName, String newAbout, Integer newPostCount) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "user with id " + id + " does not exists"));

        Optional<User> userByLoginOptional = this.userRepository.findByLogin(newLogin);
        if (userByLoginOptional.isPresent()) {
            throw new IllegalStateException("login taken");
        }

        user.setLogin(newLogin);
        user.setPassword(newPassword);
        user.setRole(newRole);
        user.setAvatarUrl(newAvatarUrl);
        user.setName(newName);
        user.setAbout(newAbout);
        user.setPostCount(newPostCount);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByLogin(username).orElseThrow(
                () -> new UsernameNotFoundException(USER_NOT_FOUND_BY_LOGIN_MSG));
    }

    public void enableUser(String login) {
        this.userRepository.updateEnabled(true, login);
    }
}
