package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.model.Post;
import com.codeup.codeupspringblog.model.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

import java.util.List;

public interface BlogRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);

}
