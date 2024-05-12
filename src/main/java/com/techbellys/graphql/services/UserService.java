package com.techbellys.graphql.services;

import com.techbellys.graphql.entities.User;
import com.techbellys.graphql.helper.ExceptionHelper;
import com.techbellys.graphql.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getallUser() {
        return userRepo.findAll();
    }

    public User getUser(int userId) {
        return userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResoureNotFoundException);
    }

    public boolean deleteUser(int userId) {
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResoureNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
