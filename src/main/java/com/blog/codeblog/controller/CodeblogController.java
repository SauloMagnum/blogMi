package com.blog.codeblog.controller;

import com.blog.codeblog.model.Post;
import com.blog.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeblogController {

    @Autowired
    private CodeblogService codeblogService;

    //@RequestMapping(value = "/posts", method = RequestMethod.GET)
    @GetMapping("/posts")
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping("/posts/{id}")
    public ModelAndView getPost(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("post");
        Post post = codeblogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @GetMapping("/newpost")
    public String getPostForm(){
        return "postForm";
    }

    @PostMapping("/newpost")
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/newpost";
        }

        post.setDate(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";
    }

}
