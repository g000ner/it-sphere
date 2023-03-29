package edu.itsphere.back.post;

import edu.itsphere.back.post.postComment.PostComment;
import edu.itsphere.back.post.postComment.PostCommentService;
import edu.itsphere.back.user.User;
import edu.itsphere.back.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostCommentService postCommentService;

    @GetMapping
    public List<Post> getPosts() {
        return this.postService.getPosts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getPost(@PathVariable("id") Long id) {
        Post post = this.postService.getPostById(id);
        ResponseEntity<Post> response;
        if (post != null) {
            response = ResponseEntity.ok(post);
        } else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @PostMapping
    public void savePost(@RequestBody Post post) {
        User author = this.userService.getUserById(post.getAuthorId());
        post.setAuthor(author);
        this.postService.savePost(post);
    }

    @PostMapping("{id}/like")
    public void setLikeToPost(@PathVariable Long id) {
        this.postService.setLikeToPost(id);
    }

    @PostMapping("{id}/comment")
    public void setCommentToPost(@PathVariable("id") Long postId, @RequestBody PostComment comment) {
        this.postService.setCommentToPost(postId, comment);
    }

    @GetMapping("{id}/comment")
    public List<PostComment> getCommentsForPost(@PathVariable("id") Long postId) {
        List<PostComment> commentsForPost = this.postCommentService.getCommentsForPostById(postId);
        return commentsForPost;
    }

    @PutMapping("{id}")
    public void changePostStatus(@PathVariable("id") Long id,
                                 @RequestParam(required = false, name = "new_status") PostStatus newStatus) {
        this.postService.changePostStatus(id, newStatus);
    }
}
