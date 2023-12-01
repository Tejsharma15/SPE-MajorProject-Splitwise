package com.example.MiniSplitwise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;

@Data
@Builder
@Getter
@Setter
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @Column(name="userId")
    private String id;

    @Column(name="acc_password")
    private string accPassword;

    @Column(name = "name")
    private String name;

    @Column(name = "contact", unique = true)
    private String contact;
    @Column(name = "personal_email", unique = true)
    private String personalEmail;

    
}