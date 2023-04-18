package edu.itsphere.back.user.fake;

import edu.itsphere.back.post.Post;
import edu.itsphere.back.user.User;
import edu.itsphere.back.user.UserRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class FakeUserRepositoryImpl implements FakeUserRepository<User, Long>{
    private  List<User> data= new ArrayList<>();
    private Long idSequence = 1L;

    public FakeUserRepositoryImpl() {
        data.add(new User(
                idSequence++,
                "login",
                "password",
                UserRole.READ_AND_COMMENT,
                "avatarUrl",
                "name",
                "about",
                0,
                true,
                false,
                new ArrayList<Post>()
        ));
        data.add(new User(
                idSequence++,
                "login2",
                "password",
                UserRole.READ_AND_COMMENT,
                "avatarUrl",
                "name2",
                "about2",
                12,
                true,
                false,
                new ArrayList<Post>()
        ));
    }

    @Override
    public List<User> findAll() {
        return this.data;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return this.data.stream().
                filter((item) -> Objects.equals(item.getLogin(), login)).findFirst();
    }

    @Override
    public void save(User user) {
        user.setId(idSequence++);
        this.data.add(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.data.stream().
                filter((item) -> Objects.equals(item.getId(), id)).findFirst();
    }

    @Override
    public void update(User user) {
        User oldUSer = this.findById(user.getId()).get();
        oldUSer.setName(user.getName());
        oldUSer.setPassword(user.getPassword());
        oldUSer.setPostCount(user.getPostCount());
        oldUSer.setRole(user.getRole());
        oldUSer.setLogin(user.getLogin());
        oldUSer.setAvatarUrl(user.getAvatarUrl());
        oldUSer.setAbout(user.getAbout());
        oldUSer.setEnabled(user.getEnabled());
        oldUSer.setLocked(user.getLocked());
        //oldUSer.setPosts();
    }

    @Override
    public void updateEnabled(boolean enabled, String login) {
        User user = this.findByLogin(login).get();
        user.setEnabled(enabled);
    }
}
