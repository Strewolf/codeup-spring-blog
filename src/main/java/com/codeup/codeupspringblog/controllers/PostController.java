package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController<post> {

    @GetMapping("/posts")
    public String returnPost(Model model){
        List<Post> posts = new ArrayList<>(Arrays.asList(

        new Post("post title 1", "post body 1"),
        new Post("post title 2", "post body 2")
        ));

        model.addAttribute("posts", posts);
        return "Posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post = new Post((int) id, "Post Title", "Post body");
        model.addAttribute("post",post);
        return "Posts/show";
    }

    @GetMapping("/posts/create")
    public String returnPostcreateForm() {
        return "posts/create";
    }

    @PostMapping("/post/create")
    public String createpost() {
        // Logic to create a new post
        return "redirect:/post/index";
    }
}


//    @GetMapping("/posts")
//    @ResponseBody
//    public String returnPost(){
//        return "index";
//    }
//
//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String show(@PathVariable long id) {
//        return "index" + id;
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String returnPostcreateForm() {
//        return "viewing post create form";
//    }
//
//    @PostMapping("/post/create")
//    public String createpost() {
//        // Logic to create a new post
//        return "creating post....";
//    }
//}
//


//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/posts")
//public class PostController {
//
//    @GetMapping("")
//    public String index() {
//        return "viewing post";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable long id) {
//        return "posts/show";
//    }
//
//    @GetMapping("/create")
//    public String createForm() {
//        return "posts/create";
//    }
//
//    @PostMapping("/create")
//    public String create() {
//        // Logic to create a new post
//        return "redirect:/posts";
//    }
//}
