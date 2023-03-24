package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String returnPost(){
        return "viewing post";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {
        return "viewing post with id of" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String returnPostcreateForm() {
        return "viewing post create form";
    }

    @PostMapping("/post/create")
    public String createpost() {
        // Logic to create a new post
        return "creating post....";
    }
}



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
