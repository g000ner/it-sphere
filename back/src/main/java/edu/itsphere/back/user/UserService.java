package edu.itsphere.back.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;

    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public void registerNewUser(User user) {
        if (this.userRepository.findByLogin(user.getLogin()).isPresent()) {
            throw new IllegalStateException("login taken");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepository.save(user);
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
}
