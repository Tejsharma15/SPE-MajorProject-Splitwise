package com.example.MiniSplitwise.repository;

import com.example.MiniSplitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface UserRepository extends JpaRepository<User, UUID> {
    // You can add custom query methods if needed

}

