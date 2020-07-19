package com.blog.codeblog.repositories;

import com.blog.codeblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeBlogRepositoy extends JpaRepository<Post, Long> {
}
