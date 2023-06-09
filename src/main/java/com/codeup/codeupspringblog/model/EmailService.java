package com.codeup.codeupspringblog.model;

import com.codeup.codeupspringblog.model.Post;
import com.codeup.codeupspringblog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

//    public void prepareAndSend(Post post, String title, String body) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(from);
//        User user = post.getUser();
//        if (user != null) {
////            msg.setTo(user.getEmail());
//            msg.setTo(user.getEmail());
//            msg.setSubject(title);
//            msg.setText(body);
//
//            try{
//                this.emailSender.send(msg);
//            }
//            catch (MailException ex) {
//                // simply log it and go on...
//                System.err.println(ex.getMessage());
//            }
//        }
//    }
//}
public void prepareAndSend(Post post) {
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setFrom(from);
    User user = post.getUser();
    if (user != null) {
        msg.setTo(user.getEmail());
        msg.setSubject(post.getTitle());
        msg.setText(post.getBody());

        try {
            this.emailSender.send(msg);
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}
}