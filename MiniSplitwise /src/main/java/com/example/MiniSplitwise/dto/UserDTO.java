package com.example.MiniSplitwise.dto;
import com.example.MiniSplitwise.model.User;
import lombok.Data;

import java.util.*;

@Data
public class UserDTO {
    private String name;
    private String accPassword;
    private String userID;
    private String personalEmail;
    private String contact;
    public User getUserFromDto(){
        User user = new User();

        user.setName(name);
        user.setAccPassword(accPassword);
        user.setRollNo(userId);
        user.setPersonalEmail(personalEmail);
        user.setContact(contact);

        return user;
    }
}
