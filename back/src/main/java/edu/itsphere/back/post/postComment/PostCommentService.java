package edu.itsphere.back.post.postComment;

import edu.itsphere.back.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentService {
    @Autowired
    PostCommentRepository postCommentRepository;

    public void saveComment(PostComment comment) {
        this.postCommentRepository.save(comment);
    }

    public List<PostComment> getCommentsForPostById(Long postId) {
        Post post = new Post();
        post.setId(postId);
        return this.postCommentRepository.findByPost(post);
    }
}
