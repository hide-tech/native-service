package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Flux<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Mono<Post> getPostById(Long postId) {
        return postRepository.findById(postId);
    }

    public Mono<Post> createPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Mono<Post> updatePost(Long postId, Post post) {
        return postRepository.findById(postId)
                .switchIfEmpty(Mono.error(new RuntimeException("Post not found")))
                .map(el -> {
                    return Post.of(el.id(), post.name(), post.content(), post.dateTime());
                }).flatMap(postRepository::save);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
