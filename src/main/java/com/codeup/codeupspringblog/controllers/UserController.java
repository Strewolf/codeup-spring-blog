package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.BlogRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;
private BlogRepository blogDao;
    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, BlogRepository blogDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.blogDao = blogDao;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "Posts/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        System.out.println(user.getPassword());
        userDao.save(user);
        return "redirect:/login";
    }
    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {
        if (principal != null) {
            User user = userDao.findByUsername(principal.getName());
            model.addAttribute("user", user);
            model.addAttribute("userPosts", blogDao.findByUser(user));
            return "Posts/profile";
        } else {
            return "redirect:/login";
        }
    }

}
