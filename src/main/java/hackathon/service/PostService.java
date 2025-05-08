package hackathon.service;

import hackathon.models.dao.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post updatePost(Post post);
    boolean deletePost(String postId);
    List<Post> getAllPosts();
    Post getPostById(String id);
    Post addStarToPost(String postId, String userId);
}