package com.techbellys.graphql.controllers;

import com.techbellys.graphql.entities.User;
import com.techbellys.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping(name = "createUser")
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password) {
        User user=new User();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers() {
        return userService.getallUser();
    }

    @QueryMapping(name = "getUser")
    public User getUser(@Argument int userId) {
        return userService.getUser(userId);
    }
    @MutationMapping(name = "deleteUser")
    public boolean deleteUser(@Argument int userId) {
        return userService.deleteUser(userId);

    }
}
