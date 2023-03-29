package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.model.Post;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

public interface BlogRepository extends JpaRepository<Post, Long> {

}
