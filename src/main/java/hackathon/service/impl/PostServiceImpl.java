package hackathon.service.impl;

import hackathon.exceptions.BadRequestException;
import hackathon.models.dao.Post;
import hackathon.models.dao.User;
import hackathon.models.enums.PostType;
import hackathon.repository.PostRepository;
import hackathon.repository.UserRepository;
import hackathon.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Post createPost(Post post) {
        post.setPostActive(true);

        if (post.getStars() == null) {
            post.setStars(List.of());
        }

        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        Post existingPost = postRepository.findById(post.getId())
                .orElseThrow(() -> new BadRequestException("Post not found"));

        post.setStars(existingPost.getStars());
        post.setPostActive(existingPost.isPostActive());

        return postRepository.save(post);
    }

    @Override
    public boolean deletePost(String postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setPostActive(false);
            postRepository.save(post);
            return true;
        }

        return false;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findByIsPostActiveTrue();
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findByIdAndIsPostActiveTrue(id);
    }

    @Override
    public List<Post> getPostsByType(PostType postType) {
        return postRepository.findByTypeAndIsPostActiveTrue(postType);
    }

    @Override
    public Post addStarToPost(String postId, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new BadRequestException("Post not found"));

        if (post.getStars().contains(userId)) {
            throw new BadRequestException("User already starred this post");
        }

        post.getStars().add(userId);
        return postRepository.save(post);
    }
}