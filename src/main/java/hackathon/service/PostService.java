package hackathon.service;

import hackathon.models.dao.Post;
import hackathon.models.enums.PostType;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post updatePost(Post post);
    boolean deletePost(String postId);
    List<Post> getAllPosts();
    Post getPostById(String id);
    List<Post> getPostsByType(PostType postType);
    Post addStarToPost(String postId, String userId);
}