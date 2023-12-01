package com.example.MiniSplitwise.repository;

import com.example.MiniSplitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods if needed
    @Query("SELECT u FROM USER u WHERE u.email = ?1")
    User findByEmail(String email);

    @Query("SELECT * FROM USER u")
    List<User> findAll();
}

