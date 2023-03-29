package edu.itsphere.back.post;

import edu.itsphere.back.post.postComment.PostComment;
import edu.itsphere.back.post.postComment.PostCommentService;
import edu.itsphere.back.user.User;
import edu.itsphere.back.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostCommentService postCommentService;

    public List<Post> getPosts() {
        return this.postRepository.findAll();
    }


    public Post getPostById(Long id) {
        Optional<Post> postOptional = this.postRepository.findById(id);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            return null;
        }
    }

    public List<Post> getPostsForUserById(Long userId) {
        User author = new User();
        author.setId(userId);
        return this.postRepository.findByAuthor(author);
    }

    public void setLikeToPost(Long id) {
        this.postRepository.setLikeToPost(id);
    }

    public void savePost(Post post) {
        this.postRepository.save(post);
    }

    public void changePostStatus(Long postId, PostStatus newStatus){
        this.postRepository.changePostStatus(postId, newStatus);
    }

    public void setCommentToPost(Long postId, PostComment comment) {
        Post postToBeCommented;
        Optional<Post> optionalPostToBeCommented = this.postRepository.findById(postId);
        if (optionalPostToBeCommented.isEmpty()) {
            throw new IllegalStateException("post with id " + postId + "does not exists");
        }
        postToBeCommented = optionalPostToBeCommented.get();
        comment.setPost(postToBeCommented);

        User commentAuthor = this.userService.getUserById(comment.getAuthorId());
        comment.setAuthor(commentAuthor);

        this.postCommentService.saveComment(comment);
    }
}
