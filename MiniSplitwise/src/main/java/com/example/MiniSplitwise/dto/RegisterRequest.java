package com.example.MiniSplitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String personalEmail;
    private String accPassword;
    private String contact;

    public String getName(){
        return name;
    }
    public String getPersonalEmail(){
        return personalEmail;
    }
    public String getAccPassword(){
        return accPassword;
    }
    public String getContact(){
        return contact;
    }
}