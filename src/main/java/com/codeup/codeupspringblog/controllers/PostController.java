package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Post;
import com.codeup.codeupspringblog.repositories.BlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private final BlogRepository adDao;
    public PostController(BlogRepository adDao) {
        this.adDao = adDao;
    }
    @GetMapping("/posts")
    public String returnPost(Model model){
        model.addAttribute("blogs", adDao.findAll());
        return "Posts/index";
    }
    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable("id") Long id, Model model) {
        adDao.findById(id).ifPresent(post -> model.addAttribute("blog", post));
        if (!model.containsAttribute("blog")) {
            return "error/404"; // Replace with your 404 error page template
        }
        return "Posts/show";
    }

    @GetMapping("/posts/create")
    public String returnPostcreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "Posts/create";
    }

    @PostMapping("/posts/create")
    public String createpost(@ModelAttribute Post post) {
        adDao.save(post);
        return "redirect:/posts";
    }

}
