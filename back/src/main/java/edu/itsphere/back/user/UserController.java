package edu.itsphere.back.user;

import edu.itsphere.back.exception.UserLoginTakenException;
import edu.itsphere.back.exception.UserNotFoundException;
import edu.itsphere.back.post.Post;
import edu.itsphere.back.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        try {
            User userById = this.userService.getUserById(id);
            return ResponseEntity.ok(userById);
        } catch (UserNotFoundException | UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}/post")
    public List<Post> getUserPosts(@PathVariable Long id) {
        return this.postService.getPostsForUserById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody User user)  {
        try {
            this.userService.updateUser(id, user.getLogin(), user.getPassword(), user.getRole(), user.getAvatarUrl(),
                    user.getName(), user.getAbout(), user.getPostCount());
            return ResponseEntity.ok().build();
        } catch (UserLoginTakenException | UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
