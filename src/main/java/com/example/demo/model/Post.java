package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("posts")
public record Post(
        @Id
        Long id,
        String name,
        String content,
        Instant dateTime
) {
        public static Post of(Long id, String name, String content, Instant dateTime){
                return new Post(id, name, content, dateTime);
        }
}
