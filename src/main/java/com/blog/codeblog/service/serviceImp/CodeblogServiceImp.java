package com.blog.codeblog.service.serviceImp;

import com.blog.codeblog.model.Post;
import com.blog.codeblog.repositories.CodeBlogRepositoy;
import com.blog.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeblogServiceImp implements CodeblogService {

    @Autowired
    private CodeBlogRepositoy codeBlogRepositoy;

    @Override
    public List<Post> findAll() {
        return codeBlogRepositoy.findAll();
    }

    @Override
    public Post findById(Long id) {
        return codeBlogRepositoy.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeBlogRepositoy.save(post);
    }
}
