package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PostRepository extends ReactiveCrudRepository<Post, Long> {
}
