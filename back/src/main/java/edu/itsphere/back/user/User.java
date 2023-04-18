package edu.itsphere.back.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.itsphere.back.post.Post;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String avatarUrl = "";
    private String name;
    private String about;
    private Integer postCount = 0; // TODO сделать это поле transient
    private Boolean enabled = false;
    private Boolean locked = false;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Post> posts;

    public User() {
    }

    public User(Long id, String login, String password, UserRole role, String avatarUrl,
                String name, String about, Integer postCount, Boolean enabled, Boolean locked, List<Post> posts) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.about = about;
        this.postCount = postCount;
        this.enabled = enabled;
        this.locked = locked;
        this.posts = posts;
    }

    public User(String login, String password, UserRole role, String avatarUrl,
                String name, String about, Integer postCount, Boolean enabled, Boolean locked, List<Post> posts) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.about = about;
        this.postCount = postCount;
        this.enabled = enabled;
        this.locked = locked;
        this.posts = posts;
    }

    public User(String login, String password, UserRole role,
                String name, String about) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.about = about;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return ! locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
