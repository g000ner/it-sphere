package edu.itsphere.back.post.postComment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.itsphere.back.post.Post;
import edu.itsphere.back.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_comments")
@Getter
@Setter
public class PostComment {
    @Id
    @SequenceGenerator(name = "post_comment_sequence", sequenceName = "post_comment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_comments_sequence")
    private Long id;
    private String text;
    private Date created;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User author;

    @Transient
    private Long authorId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Post post;
}
