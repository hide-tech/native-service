package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("native/v1")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Flux<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Mono<Post> getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @PostMapping("/posts")
    public Mono<Post> createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/posts/{id}")
    public Mono<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
    }
}
