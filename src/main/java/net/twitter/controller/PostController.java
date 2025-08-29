package net.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.twitter.entity.Post;
import net.twitter.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestParam Long userId, @RequestBody Post post) {
        return postService.createPost(userId, post);
    }

    @GetMapping("/{id}")
    public Post getPostByID(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable Long id) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
