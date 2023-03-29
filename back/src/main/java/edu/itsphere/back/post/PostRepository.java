package edu.itsphere.back.post;

import edu.itsphere.back.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "SELECT p FROM Posts p WHERE p.author_id=?1", nativeQuery = true)
    List<Post> findPostsForUserById(Long userId);

    List<Post> findByAuthor(User author);

    @Transactional
    @Modifying
    @Query("UPDATE Post p SET p.likes=p.likes+1 WHERE p.id=:id")
    void setLikeToPost(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Post p SET p.status=:newStatus WHERE p.id=:postId")
    void changePostStatus(Long postId, PostStatus newStatus);
}
