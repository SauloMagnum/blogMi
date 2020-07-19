package com.blog.codeblog.utils;

import com.blog.codeblog.model.Post;
import com.blog.codeblog.repositories.CodeBlogRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    private CodeBlogRepositoy codeBlogRepositoy;

//    @PostConstruct
    public void savePosts(){

        List<Post> postList = new ArrayList<>();

        postList.add(Post.builder().author("Jose").data(LocalDate.now()).title("Docker").text("O container docker").build());
        postList.add(Post.builder().author("Maria").data(LocalDate.now()).title("Kubernates").text("O orquestrador de container").build());

        postList.forEach(post -> codeBlogRepositoy.save(post));
        
    }
}
