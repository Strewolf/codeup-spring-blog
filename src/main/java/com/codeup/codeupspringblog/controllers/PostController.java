package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.EmailService;
import com.codeup.codeupspringblog.model.Post;
import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.BlogRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private final BlogRepository adDao;
    private final UserRepository userDao;
    private final EmailService emailService;
    public PostController(BlogRepository adDao,UserRepository userDao, EmailService emailService) {
        this.adDao = adDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    @GetMapping("/posts/{id}/edit")
    public String EditPost(@PathVariable("id") Long id, Model model) {
        adDao.findById(id).ifPresent(post -> model.addAttribute("blog", post));
        if (!model.containsAttribute("blog")) {
            return "error/404"; // Replace with your 404 error page template
        }
        return "Posts/edit";
    }

    @GetMapping("/posts/create")
    public String returnPostCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "Posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.getOne(1L); // Replace with a valid user ID
        post.setUser(user);
        adDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/edit")
    public String saveEditedPost(@PathVariable("id") Long id, @ModelAttribute Post post) {
        User user = userDao.getOne(1L); // Replace with a valid user ID
        post.setUser(user);
        adDao.save(post);
        return "redirect:/posts";
    }

}
