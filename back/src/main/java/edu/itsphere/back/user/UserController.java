package edu.itsphere.back.user;

import edu.itsphere.back.post.Post;
import edu.itsphere.back.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User userById = this.userService.getUserById(id);
        ResponseEntity<User> response;
        if (userById != null) {
            response = ResponseEntity.ok(userById);
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @GetMapping("{id}/post")
    public List<Post> getUserPosts(@PathVariable Long id) {
        List<Post> userPosts = this.postService.getPostsForUserById(id);
        return userPosts;
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        this.userService.registerNewUser(user);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        this.userService.updateUser(id, user.getLogin(), user.getPassword(), user.getRole(), user.getAvatarUrl(),
                user.getName(), user.getAbout(), user.getPostCount());
    }
}
