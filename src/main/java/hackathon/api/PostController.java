package hackathon.api;

import hackathon.models.dao.Post;
import hackathon.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
@Slf4j
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        Post post = postService.getPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        try {
            return ResponseEntity.ok(postService.updatePost(post));
        } catch (Exception e) {
            log.error("Error updating post", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        boolean deleted = postService.deletePost(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{postId}/star/{userId}")
    public ResponseEntity<Post> addStarToPost(
            @PathVariable String postId,
            @PathVariable String userId) {
        try {
            Post post = postService.addStarToPost(postId, userId);
            return ResponseEntity.ok(post);
        } catch (Exception e) {
            log.error("Error adding star to post", e);
            return ResponseEntity.badRequest().build();
        }
    }
}